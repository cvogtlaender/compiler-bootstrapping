package visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import ast.BinaryExprNode;
import ast.BlockNode;
import ast.BoolLitNode;
import ast.CallNode;
import ast.ExprNode;
import ast.FieldNode;
import ast.IfNode;
import ast.IntLitNode;
import ast.LetNode;
import ast.NullLitNode;
import ast.StringLitNode;
import ast.TypeRef;
import ast.UnaryExprNode;
import ast.VarNode;
import codegen.EmitResult;
import codegen.JavaType;
import codegen.TempGen;
import environment.Builtin;
import environment.Builtins;
import typechecker.StructSig;

public class JavaTranspileVisitor implements AstVisitor<EmitResult> {

  private final TempGen temps;
  private final IdentityHashMap<ExprNode, TypeRef> types;
  private final Map<String, String> vars;
  private final Builtins builtins;
  private final Map<String, StructSig> structs;

  public JavaTranspileVisitor(TempGen temps, IdentityHashMap<ExprNode, TypeRef> types, Map<String, String> vars,
      Builtins builtins, Map<String, StructSig> structs) {
    this.temps = temps;
    this.types = types;
    this.vars = vars;
    this.builtins = builtins;
    this.structs = structs;
  }

  private TypeRef typeOf(ExprNode e) {
    TypeRef t = types.get(e);
    if (t == null)
      throw new RuntimeException("Missing type for expr: " + e.getClass().getSimpleName());
    return t;
  }

  private static List<String> indent(List<String> xs) {
    ArrayList<String> out = new ArrayList<>();
    for (String s : xs)
      out.add("    " + s);
    return out;
  }

  public EmitResult emit(ExprNode e) {
    return e.accept(this);
  }

  @Override
  public EmitResult visit(IntLitNode n) {
    EmitResult r = new EmitResult();
    r.value = Integer.toString(n.value);
    return r;
  }

  @Override
  public EmitResult visit(BoolLitNode n) {
    EmitResult r = new EmitResult();
    r.value = n.value ? "true" : "false";
    return r;
  }

  @Override
  public EmitResult visit(StringLitNode n) {
    EmitResult r = new EmitResult();
    r.value = "\"" + n.value.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    return r;
  }

  @Override
  public EmitResult visit(NullLitNode n) {
    EmitResult r = new EmitResult();
    r.value = "null";
    return r;
  }

  @Override
  public EmitResult visit(VarNode n) {
    EmitResult r = new EmitResult();
    r.value = vars.getOrDefault(n.name, n.name);
    return r;
  }

  @Override
  public EmitResult visit(UnaryExprNode n) {
    EmitResult e = emit(n.expr);
    EmitResult r = new EmitResult();
    r.javaStatements.addAll(e.javaStatements);

    String tmp = temps.next();
    String jt = JavaType.of(typeOf(n));
    r.javaStatements.add(jt + " " + tmp + " = (" + n.op + e.value + ");");
    r.value = tmp;
    return r;
  }

  @Override
  public EmitResult visit(BinaryExprNode n) {
    EmitResult l = emit(n.left);
    EmitResult rr = emit(n.right);

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(l.javaStatements);
    r.javaStatements.addAll(rr.javaStatements);

    String tmp = temps.next();
    String jt = JavaType.of(typeOf(n));
    r.javaStatements.add(jt + " " + tmp + " = (" + l.value + " " + n.op + " " + rr.value + ");");
    r.value = tmp;
    return r;
  }

  @Override
  public EmitResult visit(LetNode n) {
    EmitResult v = emit(n.value);

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(v.javaStatements);

    String javaName = n.name;
    Map<String, String> childMap = new HashMap<>(vars);
    childMap.put(n.name, javaName);

    r.javaStatements.add(JavaType.of(n.type) + " " + javaName + " = " + v.value + ";");

    EmitResult b = n.body.accept(new JavaTranspileVisitor(temps, types, childMap, builtins, structs));
    r.javaStatements.addAll(b.javaStatements);
    r.value = b.value;
    return r;
  }

  @Override
  public EmitResult visit(IfNode n) {
    EmitResult c = emit(n.cond);

    EmitResult r = new EmitResult();
    r.javaStatements.addAll(c.javaStatements);

    String tmp = temps.next();
    String jt = JavaType.of(typeOf(n));
    r.javaStatements.add(jt + " " + tmp + ";");

    EmitResult t = n.thenBranch.accept(new JavaTranspileVisitor(temps, types, new HashMap<>(vars), builtins, structs));
    EmitResult e = n.elseBranch.accept(new JavaTranspileVisitor(temps, types, new HashMap<>(vars), builtins, structs));

    r.javaStatements.add("if (" + c.value + ") {");
    r.javaStatements.addAll(indent(t.javaStatements));
    r.javaStatements.add("    " + tmp + " = " + t.value + ";");
    r.javaStatements.add("} else {");
    r.javaStatements.addAll(indent(e.javaStatements));
    r.javaStatements.add("    " + tmp + " = " + e.value + ";");
    r.javaStatements.add("}");
    r.value = tmp;

    return r;
  }

  @Override
  public EmitResult visit(BlockNode n) {
    EmitResult r = new EmitResult();
    if (n.exprs.isEmpty())
      throw new RuntimeException("Empty block not allowed");
    for (int i = 0; i < n.exprs.size(); i++) {
      EmitResult ei = emit(n.exprs.get(i));
      r.javaStatements.addAll(ei.javaStatements);
      if (i == n.exprs.size() - 1)
        r.value = ei.value;
    }
    return r;
  }

  @Override
  public EmitResult visit(CallNode n) {
    if (n.callee instanceof VarNode vn && builtins.has(vn.name)) {
      Builtin b = builtins.get(vn.name);
      return b.emit(this, n.args);
    }

    EmitResult cal = emit(n.callee);
    EmitResult r = new EmitResult();

    r.javaStatements.addAll(cal.javaStatements);

    List<String> argVals = new ArrayList<>();
    for (ExprNode a : n.args) {
      EmitResult ar = emit(a);
      r.javaStatements.addAll(ar.javaStatements);
      argVals.add(ar.value);
    }

    String tmp = temps.next();
    String jt = JavaType.of(typeOf(n));

    String temp = "";
    if (n.callee instanceof VarNode vn && structs.containsKey(vn.name)) {
      temp = "new ";
    }

    r.javaStatements.add(jt + " " + tmp + " = " + temp + cal.value + "("
        + String.join(", ", argVals) + ");");
    r.value = tmp;
    return r;
  }

  @Override
  public EmitResult visit(FieldNode n) {
    EmitResult r = emit(n.target);

    EmitResult s = new EmitResult();
    s.javaStatements.addAll(r.javaStatements);

    String temp = temps.next();
    String jt = JavaType.of(typeOf(n));

    s.javaStatements.add(jt + " " + temp + " = " + r.value + "." + n.field + ";");
    s.value = temp;
    return s;
  }

  public TempGen getTemps() {
    return temps;
  }
}

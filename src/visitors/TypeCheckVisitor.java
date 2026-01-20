package visitors;

import ast.*;
import environment.Builtin;
import environment.Builtins;
import typechecker.*;

import java.util.*;

public class TypeCheckVisitor implements AstVisitor<TypeRef> {

  private final Env env;
  private final Map<String, FunSig> funs;
  private final Map<String, StructSig> structs;
  private final IdentityHashMap<ExprNode, TypeRef> types;
  private final Builtins builtins;

  public TypeCheckVisitor(Env env, Map<String, FunSig> funs, Map<String, StructSig> structs,
      IdentityHashMap<ExprNode, TypeRef> types, Builtins b) {
    this.env = env;
    this.funs = funs;
    this.structs = structs;
    this.types = types;
    this.builtins = b;
  }

  public IdentityHashMap<ExprNode, TypeRef> getTypes() {
    return types;
  }

  private TypeRef mark(ExprNode n, TypeRef t) {
    types.put(n, t);
    return t;
  }

  public static boolean acceptsAny(TypeRef t) {
    return t.name.equals(TypeRef.ANY.name);
  }

  public static void requireSame(TypeRef a, TypeRef b, String msg) {
    if ((a.name.equals(b.name))) {
      return;
    }
    if (a.name.equals("null") && !TypeRef.isPrimitive(b)) {
      return;
    }
    if (b.name.equals("null") && !TypeRef.isPrimitive(a)) {
      return;
    }

    throw new TypeError(msg);
  }

  @Override
  public TypeRef visit(IntLitNode n) {
    return mark(n, TypeRef.INT);
  }

  @Override
  public TypeRef visit(BoolLitNode n) {
    return mark(n, TypeRef.BOOL);
  }

  @Override
  public TypeRef visit(StringLitNode n) {
    return mark(n, TypeRef.STRING);
  }

  @Override
  public TypeRef visit(NullLitNode n) {
    return mark(n, new TypeRef("null"));
  }

  @Override
  public TypeRef visit(VarNode n) {
    TypeRef t = env.get(n.name);
    if (t == null)
      throw new TypeError("Unknown variable: " + n.name);
    return mark(n, t);
  }

  @Override
  public TypeRef visit(UnaryExprNode n) {
    TypeRef t = n.expr.accept(this);
    switch (n.op) {
      case "-":
        requireSame(t, TypeRef.INT, "Unary '-' expects int, got " + t.name);
        return mark(n, TypeRef.INT);
      case "!":
        requireSame(t, TypeRef.BOOL, "Unary '!' expects bool, got " + t.name);
        return mark(n, TypeRef.BOOL);
      default:
        throw new TypeError("Unknown unary operator: " + n.op);
    }
  }

  @Override
  public TypeRef visit(BinaryExprNode n) {
    TypeRef lt = n.left.accept(this);
    TypeRef rt = n.right.accept(this);

    switch (n.op) {
      // int -> int
      case "+":
      case "-":
      case "*":
      case "/":
      case "%":
        requireSame(lt, TypeRef.INT, "Operator '" + n.op + "' expects int operands");
        requireSame(rt, TypeRef.INT, "Operator '" + n.op + "' expects int operands");
        return mark(n, TypeRef.INT);

      // int -> bool
      case "<":
      case ">":
      case "<=":
      case ">=":
        requireSame(lt, TypeRef.INT, "Operator '" + n.op + "' expects int operands");
        requireSame(rt, TypeRef.INT, "Operator '" + n.op + "' expects int operands");
        return mark(n, TypeRef.BOOL);

      // bool -> bool
      case "&&":
      case "||":
        requireSame(lt, TypeRef.BOOL, "Operator '" + n.op + "' expects bool operands");
        requireSame(rt, TypeRef.BOOL, "Operator '" + n.op + "' expects bool operands");
        return mark(n, TypeRef.BOOL);

      // eq
      case "==":
      case "!=":
        requireSame(lt, rt, "Operator '" + n.op + "' expects same types, got " + lt.name + " and " + rt.name);
        return mark(n, TypeRef.BOOL);

      default:
        throw new TypeError("Unknown binary operator: " + n.op);
    }
  }

  @Override
  public TypeRef visit(IfNode n) {
    TypeRef ct = n.cond.accept(this);
    requireSame(ct, TypeRef.BOOL, "If condition must be bool, got " + ct.name);

    TypeRef tt = n.thenBranch.accept(this);
    TypeRef et = n.elseBranch.accept(this);

    if (tt.name.equals("null"))
      return mark(n, et);
    if (et.name.equals("null"))
      return mark(n, tt);

    requireSame(tt, et, "If branches must have same type, got " + tt.name + " and " + et.name);
    return mark(n, tt);
  }

  @Override
  public TypeRef visit(LetNode n) {
    TypeRef vt = n.value.accept(this);
    requireSame(n.type, vt, "Let '" + n.name + "' declared " + n.type.name + " but got " + vt.name);

    Env child = env.child();
    child.put(n.name, n.type);

    TypeCheckVisitor scoped = new TypeCheckVisitor(child, funs, structs, types, builtins);
    TypeRef bt = n.body.accept(scoped);
    return mark(n, bt);
  }

  @Override
  public TypeRef visit(BlockNode n) {
    if (n.exprs.isEmpty())
      throw new TypeError("Empty block not allowed");
    TypeRef last = null;
    for (ExprNode e : n.exprs)
      last = e.accept(this);
    return mark(n, last);
  }

  @Override
  public TypeRef visit(CallNode n) {
    if (!(n.callee instanceof VarNode vn)) {
      throw new TypeError("Only direct function calls supported");
    }

    // Builtin functions
    if (builtins.has(vn.name)) {
      Builtin b = builtins.get(vn.name);
      FunSig sig = b.signature();

      if (n.args.size() != sig.paramTypes.size()) {
        throw new TypeError("Builtin '" + vn.name + "' expects " + sig.paramTypes.size()
            + " args, got " + n.args.size());
      }

      for (int i = 0; i < n.args.size(); i++) {
        TypeRef at = n.args.get(i).accept(this);
        TypeRef pt = sig.paramTypes.get(i);
        if (!acceptsAny(pt)) {
          requireSame(at, pt, "Arg " + (i + 1) + " of builtin '" + vn.name
              + "' expects " + pt.name + ", got " + at.name);
        }
      }

      return mark(n, sig.returnType);
    }

    if (structs.containsKey(vn.name)) {
      StructSig s = structs.get(vn.name);

      if (n.args.size() != s.paramTypes.size()) {
        throw new TypeError("Struct '" + vn.name + "'' expects " + s.paramTypes.size() + " args, got " + n.args.size());
      }

      for (int i = 0; i < n.args.size(); i++) {
        TypeRef at = n.args.get(i).accept(this);
        TypeRef pt = s.paramTypes.get(i);
        requireSame(at, pt, "Arg " + (i + 1) + " of struct '" + vn.name
            + "' expects " + pt.name + ", got " + at.name);
      }
      return mark(n, new TypeRef(vn.name));
    }

    FunSig sig = funs.get(vn.name);
    if (sig == null)
      throw new TypeError("Unknown function: " + vn.name);

    if (n.args.size() != sig.paramTypes.size()) {
      throw new TypeError("Function '" + vn.name + "' expects " + sig.paramTypes.size()
          + " args, got " + n.args.size());
    }

    for (int i = 0; i < n.args.size(); i++) {
      TypeRef at = n.args.get(i).accept(this);
      TypeRef pt = sig.paramTypes.get(i);
      requireSame(at, pt, "Arg " + (i + 1) + " of '" + vn.name + "' expects " + pt.name + ", got " + at.name);
    }

    return mark(n, sig.returnType);
  }

  @Override
  public TypeRef visit(FieldNode n) {
    TypeRef t = n.target.accept(this);

    if (!this.structs.containsKey(t.name)) {
      throw new TypeError("Unknown field type '" + t.name + "'");
    }
    StructSig s = this.structs.get(t.name);

    for (int i = 0; i < s.fieldNames.size(); i++) {
      if (s.fieldNames.get(i).equals(n.field)) {
        return mark(n, s.paramTypes.get(i));
      }
    }
    throw new TypeError("Field does not exist");
  }
}

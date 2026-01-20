package codegen;

import ast.*;
import environment.Builtins;
import typechecker.StructSig;
import visitors.JavaTranspileVisitor;

import java.util.*;

public class JavaTranspiler {

  public static String emitJava(Prog prog, IdentityHashMap<ExprNode, TypeRef> types, Builtins b,
      Map<String, StructSig> structs) {
    StringBuilder sb = new StringBuilder();
    sb.append("public class Out {\n");

    for (StructDef s : prog.structs) {
      sb.append("  static class ").append(s.name).append(" {\n");

      for (Param p : s.params) {
        sb.append("    public ").append(JavaType.of(p.type)).append(" ").append(p.name).append(";\n");
      }

      // constructor
      sb.append("    public " + s.name).append("(");
      for (int i = 0; i < s.params.size(); i++) {
        Param p = s.params.get(i);
        if (i > 0)
          sb.append(", ");
        sb.append(JavaType.of(p.type)).append(" ").append(p.name);
      }
      sb.append(") {\n");

      for (Param p : s.params) {
        sb.append("      this.").append(p.name).append(" = ").append(p.name).append(";\n");
      }
      sb.append("    }\n  }\n\n");
    }

    // functions
    for (FunDef f : prog.functions) {
      sb.append("  static ").append(JavaType.of(f.returnType)).append(" ").append(f.name).append("(");

      for (int i = 0; i < f.params.size(); i++) {
        Param p = f.params.get(i);
        if (i > 0)
          sb.append(", ");
        sb.append(JavaType.of(p.type)).append(" ").append(p.name);
      }
      sb.append(") {\n");

      TempGen temps = new TempGen();
      JavaTranspileVisitor ev = new JavaTranspileVisitor(temps, types, new HashMap<>(), b, structs);
      EmitResult res = f.body.accept(ev);

      for (String s : res.javaStatements)
        sb.append("    ").append(s).append("\n");
      sb.append("    return ").append(res.value).append(";\n");
      sb.append("  }\n\n");
    }

    // main
    sb.append("  public static void main(String[] args) {\n");
    sb.append("    main();\n");
    sb.append("  }\n");

    sb.append("}\n");
    return sb.toString();
  }
}

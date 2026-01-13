package transpiler;

import ast.*;
import environment.Builtins;
import visitors.JavaTranspileVisitor;

import java.util.*;

public class JavaTranspiler {

  public static String emitJava(Prog prog, IdentityHashMap<ExprNode, TypeRef> types, Builtins b) {
    StringBuilder sb = new StringBuilder();
    sb.append("public class Out {\n");

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
      JavaTranspileVisitor ev = new JavaTranspileVisitor(temps, types, new HashMap<>(), b);
      EmitResult res = f.body.accept(ev);

      for (String s : res.javaStatements)
        sb.append("    ").append(s).append("\n");
      sb.append("    return ").append(res.value).append(";\n");
      sb.append("  }\n\n");
    }

    sb.append("  public static void main(String[] args) {\n");
    sb.append("    main();\n");
    sb.append("  }\n");

    sb.append("}\n");
    return sb.toString();
  }
}

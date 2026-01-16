package visitors;

import ast.*;
import java.util.*;

import antlr.xminBaseVisitor;
import antlr.xminParser;

public class ASTBuildVisitor extends xminBaseVisitor<Object> {

  private static TypeRef typeFrom(xminParser.TypeContext ctx) {
    return new TypeRef(ctx.getText());
  }

  @Override
  public Prog visitProg(xminParser.ProgContext ctx) {
    List<FunDef> funs = new ArrayList<>();
    List<StructDef> structs = new ArrayList<>();

    for (var child : ctx.children) {
      if (child instanceof xminParser.FunctionContext fctx) {
        funs.add((FunDef) visitFunction(fctx));
      }
    }

    for (var child : ctx.children) {
      if (child instanceof xminParser.StructDeclContext fctx) {
        structs.add((StructDef) visitStructDecl(fctx));
      }
    }
    return new Prog(funs, structs);
  }

  @Override
  public StructDef visitStructDecl(xminParser.StructDeclContext ctx) {
    String name = ctx.ID().getText();
    List<Param> fields = new ArrayList<>();

    for (var f : ctx.structField()) {
      fields.add(new Param(typeFrom(f.type()), f.ID().getText()));
    }
    return new StructDef(name, fields);
  }

  @Override
  public Param visitStructField(xminParser.StructFieldContext ctx) {
    TypeRef t = typeFrom(ctx.type());
    String n = ctx.ID().getText();

    return new Param(t, n);
  }

  @Override
  public FunDef visitFunction(xminParser.FunctionContext ctx) {
    TypeRef ret = typeFrom(ctx.type());
    String name = ctx.ID().getText();

    List<Param> params = new ArrayList<>();
    if (ctx.paramList() != null) {
      for (var p : ctx.paramList().param()) {
        params.add(new Param(typeFrom(p.type()), p.ID().getText()));
      }
    }

    ExprNode body = (ExprNode) visit(ctx.expression());
    return new FunDef(ret, name, params, body);
  }

  @Override
  public ExprNode visitLetExpr(xminParser.LetExprContext ctx) {
    TypeRef t = typeFrom(ctx.type());
    String name = ctx.ID().getText();
    ExprNode value = (ExprNode) visit(ctx.expression(0));
    ExprNode body = (ExprNode) visit(ctx.expression(1));
    return new LetNode(t, name, value, body);
  }

  @Override
  public ExprNode visitIfExpr(xminParser.IfExprContext ctx) {
    ExprNode c = (ExprNode) visit(ctx.expression(0));
    ExprNode t = (ExprNode) visit(ctx.expression(1));
    ExprNode e = (ExprNode) visit(ctx.expression(2));
    return new IfNode(c, t, e);
  }

  @Override
  public ExprNode visitBlockExpr(xminParser.BlockExprContext ctx) {
    List<ExprNode> exprs = new ArrayList<>();
    for (var e : ctx.expression()) {
      exprs.add((ExprNode) visit(e));
    }
    return new BlockNode(exprs);
  }

  @Override
  public ExprNode visitLogicalOrExpr(xminParser.LogicalOrExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.logicalAndExpr(0));
    for (int i = 1; i < ctx.logicalAndExpr().size(); i++) {
      ExprNode right = (ExprNode) visit(ctx.logicalAndExpr(i));
      left = new BinaryExprNode("||", left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitLogicalAndExpr(xminParser.LogicalAndExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.equalityExpr(0));
    for (int i = 1; i < ctx.equalityExpr().size(); i++) {
      ExprNode right = (ExprNode) visit(ctx.equalityExpr(i));
      left = new BinaryExprNode("&&", left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitEqualityExpr(xminParser.EqualityExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.relationalExpr(0));
    for (int i = 1; i < ctx.relationalExpr().size(); i++) {
      String op = ctx.getChild(2 * i - 1).getText(); // '==' oder '!='
      ExprNode right = (ExprNode) visit(ctx.relationalExpr(i));
      left = new BinaryExprNode(op, left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitRelationalExpr(xminParser.RelationalExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.additiveExpr(0));
    for (int i = 1; i < ctx.additiveExpr().size(); i++) {
      String op = ctx.getChild(2 * i - 1).getText(); // <, >, <=, >=
      ExprNode right = (ExprNode) visit(ctx.additiveExpr(i));
      left = new BinaryExprNode(op, left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitAdditiveExpr(xminParser.AdditiveExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.multiplicativeExpr(0));
    for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
      String op = ctx.getChild(2 * i - 1).getText(); // + oder -
      ExprNode right = (ExprNode) visit(ctx.multiplicativeExpr(i));
      left = new BinaryExprNode(op, left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitMultiplicativeExpr(xminParser.MultiplicativeExprContext ctx) {
    ExprNode left = (ExprNode) visit(ctx.unaryExpr(0));
    for (int i = 1; i < ctx.unaryExpr().size(); i++) {
      String op = ctx.getChild(2 * i - 1).getText(); // *, /, %
      ExprNode right = (ExprNode) visit(ctx.unaryExpr(i));
      left = new BinaryExprNode(op, left, right);
    }
    return left;
  }

  @Override
  public ExprNode visitUnaryExpr(xminParser.UnaryExprContext ctx) {
    if (ctx.postfixExpr() != null) {
      return (ExprNode) visit(ctx.postfixExpr());
    }
    String op = ctx.getChild(0).getText();
    ExprNode inner = (ExprNode) visit(ctx.unaryExpr());
    return new UnaryExprNode(op, inner);
  }

  @Override
  public ExprNode visitPostfixExpr(xminParser.PostfixExprContext ctx) {
    ExprNode base = (ExprNode) visit(ctx.primary());
    ExprNode cur = base;

    for (var part : ctx.postfixPart()) {
      if (part.getText().startsWith("(")) {
        List<ExprNode> args = new ArrayList<>();
        if (part.argList() != null) {
          for (var e : part.argList().expression()) {
            args.add((ExprNode) visit(e));
          }
        }
        cur = new CallNode(cur, args);
      } else {
        String field = part.ID().getText();
        cur = new FieldNode(cur, field);
      }
    }
    return cur;
  }

  @Override
  public ExprNode visitPrimary(xminParser.PrimaryContext ctx) {
    if (ctx.literal() != null)
      return (ExprNode) visit(ctx.literal());
    if (ctx.ID() != null)
      return new VarNode(ctx.ID().getText());
    return (ExprNode) visit(ctx.expression());
  }

  @Override
  public ExprNode visitLiteral(xminParser.LiteralContext ctx) {
    if (ctx.INT_LITERAL() != null) {
      return new IntLitNode(Integer.parseInt(ctx.INT_LITERAL().getText()));
    }
    if (ctx.STRING_LITERAL() != null) {
      String raw = ctx.STRING_LITERAL().getText();
      String unquoted = raw.substring(1, raw.length() - 1);
      return new StringLitNode(unquoted);
    }
    String t = ctx.getText();
    if (t.equals("true"))
      return new BoolLitNode(true);
    if (t.equals("false"))
      return new BoolLitNode(false);
    return new NullLitNode();
  }
}

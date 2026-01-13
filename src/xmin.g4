grammar xmin;

/*
 * PARSER RULES
 */

prog
    : (function | structDecl)* EOF
    ;

/* --- DATA STRUCTURES --- */

structDecl
    : 'struct' ID '{' structField* '}' ';'
    ;

structField
    : type ID ';'
    ;

/* --- FUNCTIONS --- */
/* Funktionskörper ist genau 1 Expression (oder eine Block-Expression) */

function
    : type ID '(' paramList? ')' '=' expression ';'
    ;

paramList
    : param (',' param)*
    ;

param
    : type ID
    ;

/* --- EXPRESSIONS --- */

expression
    : letExpr
    | ifExpr
    | blockExpr
    | logicalOrExpr
    ;

/* let <type> <name> = <expr> in <expr>  */
letExpr
    : 'let' type ID '=' expression 'in' expression
    ;

/* if <cond> then <expr> else <expr> */
ifExpr
    : 'if' expression 'then' expression 'else' expression
    ;

/* { e1; e2; e3 }  -> Wert ist e3 (Sequencing als Expression) */
blockExpr
    : '{' expression (';' expression)* ';' '}'
    ;

logicalOrExpr
    : logicalAndExpr ('||' logicalAndExpr)*
    ;

logicalAndExpr
    : equalityExpr ('&&' equalityExpr)*
    ;

equalityExpr
    : relationalExpr (('==' | '!=') relationalExpr)*
    ;

relationalExpr
    : additiveExpr (('<' | '>' | '<=' | '>=') additiveExpr)*
    ;

additiveExpr
    : multiplicativeExpr (('+' | '-') multiplicativeExpr)*
    ;

multiplicativeExpr
    : unaryExpr (('*' | '/' | '%') unaryExpr)*
    ;

unaryExpr
    : ('-' | '!') unaryExpr
    | postfixExpr
    ;

/* Postfix-Chains: f(a)(b).x  */
postfixExpr
    : primary postfixPart*
    ;

postfixPart
    : '(' argList? ')'   // function call
    | '.' ID             // field access
    ;

primary
    : literal
    | ID
    | '(' expression ')'
    ;

argList
    : expression (',' expression)*
    ;

literal
    : INT_LITERAL
    | STRING_LITERAL
    | 'true'
    | 'false'
    | 'null'
    ;

/* --- TYPES --- */

type
    : 'int'
    | 'bool'
    | 'string'
    | ID
    ;

/*
 * LEXER RULES
 */

ID
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

INT_LITERAL
    : [0-9]+
    ;

STRING_LITERAL
    : '"' ( ~["\\] | '\\' . )* '"'
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

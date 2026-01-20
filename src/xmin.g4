grammar xmin;

prog
    : (function | structDecl)* EOF
    ;

structDecl
    : 'struct' ID '{' structField* '}' ';'
    ;

structField
    : type ID ';'
    ;

function
    : type ID '(' paramList? ')' '=' expression ';'
    ;

paramList
    : param (',' param)*
    ;

param
    : type ID
    ;

expression
    : letExpr
    | ifExpr
    | blockExpr
    | logicalOrExpr
    ;

letExpr
    : 'let' type ID '=' expression 'in' expression
    ;

ifExpr
    : 'if' expression 'then' expression 'else' expression
    ;

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

type
    : 'int'
    | 'bool'
    | 'string'
    | ID
    ;

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

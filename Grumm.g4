/** Grum is a statically-typed programming language for the JVM
 */
grammar Grumm;

file:   classDefinition;

classDefinition
	:
		'class' ID '{'
		(functionDecl | varDecl)+
		'}'
	;

varDecl
    :
    	ID ':' type ('=' expr)? ';'?
    ;
type
	:
		'float'	 |	// float
		'int'    |	// int
		'void'	 |	// void
		'string' |  // string
		('float' | 'int' | 'string') '[' INT ']'	|   // array
		('float' | 'int' | 'string') '<' INT? '>'		// list
	;

functionDecl
    :   ID '(' formalParameters? ')' (':' type)? block // "void f(int x) {...}"
    ;

formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   ID ':' type
    ;

block:  '{' stat* '}' ;   // possibly empty statement block

stat:   block
    |   varDecl
    |   'if' expr stat ('else' stat)?
    |   'return' expr? ';'? 
    |   expr '=' expr ';'? 	// assignment
    |   expr ';'?          	// func call
    ;

/* expr below becomes the following non-left recursive rule:
expr[int _p]
    :   ( '-' expr[6]
        | '!' expr[5]
        | ID
        | INT
        | '(' expr ')'
        )
        ( {8 >= $_p}? '*' expr[9]
        | {7 >= $_p}? ('+'|'-') expr[8]
        | {4 >= $_p}? '==' expr[5]
        | {10 >= $_p}? '[' expr ']'
        | {9 >= $_p}? '(' exprList? ')'
        )*
    ;
*/

expr:   ID '(' exprList? ')'    # Call
    |   expr '[' expr ']'       # Index
    |   '-' expr                # Negate
    |   '!' expr                # Not
    |   expr '*' expr           # Mult
    |   expr ('+'|'-') expr     # AddSub
    |   expr '==' expr          # Equal
    |   ID                      # Var
    |   INT                     # Int
    |	FLOAT					# Float
    |	STRING					# String
    |   '(' expr ')'            # Parens
    ;

exprList : expr (',' expr)* ;   // arg list

K_FLOAT : 'float';
K_INT   : 'int';
K_VOID  : 'void';
K_STRING	: 'string';
ID  :   (LETTER | '_') (LETTER | '_' | [0-9])* ;

fragment
LETTER : [a-zA-Z] ;

INT :   [0-9]+ ;

FLOAT :	[0-9]* '.' [0-9]+ ;

STRING :	'"' (ESC|.)*? '"' ;

fragment
ESC : '\\"' | '\\\\' ;

WS  :   [ \t\n\r]+ -> skip ;

SL_COMMENT
    :   '//' .*?  '|r'? '\n' -> skip
    ;

ML_COMMENT
	:	'/*' .*? '*/' -> skip
	;
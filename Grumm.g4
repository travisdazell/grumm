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
		primitiveType |
		objectType
	;
	
primitiveType
	:
		'float'	 |	// float
		'double' |  // double
		'int'    |	// int
		'void'	 |	// void
		'char'	 |	// char
		'byte'	 |  // byte
		'short'  |  // short
		'long'   |  // long
	;

objectType
	:
		object							  # ClassType
		|	'Array' '<' type '>' '[' INT ']'  # ArrayType
		|	'List' '<' type '>'				  # ListType
		|	'Map' '<' type ',' type '>'		  # MapType
	;

object
	:
		ID	('.' ID)*
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

expr:	ID '.' ID '(' exprList? ')' # CallOnObject
	|	ID '(' exprList? ')'    # Call
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
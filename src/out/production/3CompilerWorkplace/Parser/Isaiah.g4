grammar Isaiah;
program: declare* EOF;

declare
    :   ';'                                             #emptyDeclare
    |   varType Identifier '=' expression  ';'          #assignDeclare
    |   varType Identifier (',' Identifier)*  ';'       #listDeclare
    |   Class Identifier LeftBrace declare* RightBrace  #classDeclare
    |   retType Identifier parameterList block          #funcDeclare
    |   Identifier '('')' block                         #constrDeclare
    ;

digitType: Bool | Int | String | Identifier ;

arrayType
    : digitType '[' ']'
    | arrayType '[' ']'
    ;

varType: digitType | arrayType;

retType: varType | Void;

value : Identifier                                      #variVal
      | IntConst                                        #intVal
      | StringConst                                     #stringVal
      | True                                            #trueVal
      | False                                           #falseVal
      | Null                                            #nullVal
      | New digitType ('['']')+ ('['expression']')*                         #newWrong2
      | New digitType ('['expression']')+ ('['']')+ ('['expression']')+     #newWrong
      | New digitType ('['expression']')+ ('['']')*                         #newArray//static array
      | New Identifier ('('')')?                                            #newClass
      | Identifier expressionList                       #funcVal
      | '[&]'parameterList'->'block expressionList      #lambdaVal
      | This                                            #thisVal
      ;

parameterList: '('(varType Identifier(','varType Identifier)*)?')';

expressionList: '('(expression(','expression)*)?')';

block: LeftBrace statement* RightBrace ;

statement
    :   ';'                                             #emptyStmt
    |   varType Identifier '=' expression ';'           #assignStmt
    |   varType Identifier (',' Identifier)* ';'        #listStmt
    |   expression ';'                                  #exprStmt
    |   If '('expression')' statement (Else statement)? #condStmt
    |   While '('expression?')' statement               #whileStmt
    |   For '('forInit';'expression?';'expression?')' statement #forStmt
    |   Return expression? ';'                          #retStmt
    |   Break ';'                                       #breakStmt
    |   Continue ';'                                    #continStmt
    |   block                                           #blockStmt
    ;

expression
    :   value                                           #valueExpr
    |   '('expression')'                                #parenExpr
    |   expression '['expression']'                     #indexExpr
    |   expression '.' expression                       #binaryExpr
    |   <assoc=right> op=('!'|'~')   expression         #unaryExpr
    |   <assoc=right> op=('+'|'-')   expression         #unaryExpr
    |   <assoc=right> op=('++'|'--') expression         #prefixExpr
    |   <assoc=right> expression op=('++'|'--')         #suffixExpr
    |   expression op=('*'|'/'|'%')   expression        #binaryExpr
    |   expression op=('+'|'-')   expression            #binaryExpr
    |   expression op=('<<'|'>>') expression            #binaryExpr
    |   expression op=('<'|'>'|'<='|'>=') expression    #binaryExpr
    |   expression op=('=='|'!=') expression            #binaryExpr
    |   expression '&'  expression                      #binaryExpr
    |   expression '^'  expression                      #binaryExpr
    |   expression '|'  expression                      #binaryExpr
    |   expression '&&' expression                      #binaryExpr
    |   expression '||' expression                      #binaryExpr
    |   <assoc=right> expression '=' expression         #binaryExpr
    ;

forInit
    :   (expression(','expression)*)?       //maybe empty
    ;

Int: 'int';
Bool: 'bool';
String: 'string';
Null: 'null';
Void: 'void';
True: 'true';
False: 'false';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';
New: 'new';
Class: 'class';
This: 'this';

Dot : '.';
LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace: '{';
RightBrace: '}';
Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
SelfPlus : '++';
Minus : '-';
SelfMinus : '--';

Mul : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';

OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';
Equal : '==';
NotEqual : '!=';

BackSlash : '\\\\';
DbQuotation : '\\"';
BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;
BlankChar
    :   [ \r\n\t]
        -> skip
    ;
LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
Identifier: [a-zA-Z_][a-zA-Z0-9_]*;
IntConst: [1-9][0-9]* | '0';
StringConst: '"'([ -~]|([\\][\\])|[\\n]|([\\]["]))*'"';

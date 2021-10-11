grammar Isaiah;

program: declare* EOF;

declare
    :   ';'                                             #emptyDeclr
    |   varDeclare                                      #varDeclr
    |   classDeclare                                    #classDeclr
    |   funcDeclare                                     #funcDeclr
    |   constructDeclare                                #constrDeclare
    ;

digitType: Bool | Int | String | Identifier ;

arrayType
    : digitType '[' ']'
    | arrayType '[' ']'
    ;

varType: digitType | arrayType;                         //for declaration

value : Identifier                                      #variVal
      | constValue                                      #constVal
      | newExpr                                         #newVal
      | Identifier expressionList                       #funcVal
      | lambdaFunc                                      #lambdaVal
      | This                                            #thisVal
      ;

retType: varType | Void;

varDeclare
    :   varType Identifier('='expression)?(','Identifier('='expression)?)*    //mingled
    ;

classDeclare
    :   Class Identifier LeftBrace
            declare*
        RightBrace
    ;

constructDeclare
    :   Identifier '('')' block
    ;

funcDeclare
    :   retType Identifier parameterList block
    ;

parameterList: '('(varType Identifier(','varType Identifier)*)?')';

expressionList: '('(expression(','expression)*)?')';

block: LeftBrace statement* RightBrace ;

suite
    : block                                             #blkSuite
    | statement                                         #oneSuite
    ;

statement
    :   ';'                                             #emptyStmt
    |   varDeclare ';'                                  #declrStmt
    |   expression ';'                                  #exprStmt
    |   condition                                       #condStmt
    |   loop                                            #loopStmt
    |   jump ';'                                        #jumpStmt
    |   block                                           #blockStmt
    ;
    //👆若必加分号，则直接加
expression
    :   value                                           #valueExpr
    |   '('expression')'                                #parenExpr
//    |   expression ('['expression']')+ ('['']')*        #indexExpr
    |   expression '['expression']'                     #indexExpr
    |   expression '.' expression                       #binaryExpr
    |   <assoc=right> op=('!'|'~')   expression         #unaryExpr
    |   <assoc=right> op=('+'|'-')   expression         #unaryExpr
    |   <assoc=right> op=('++'|'--') expression         #unaryExpr
    |   <assoc=right> expression op=('++'|'--')         #unaryExpr
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

//TODO: 注意 int[3][0][3] 的解释与判错
//      添加 wrongTypeArray

constValue: IntConst | StringConst | True | False | Null;

newExpr
    :   New digitType ('['']')+ ('['expression']')*                         #newWrongArray2
    |   New digitType ('['expression']')+ ('['']')+ ('['expression']')+     #newWrongArray
    |   New digitType ('['expression']')+ ('['']')*                         #newArray//static array
    |   New Identifier ('('')')?                                            #newClass
    ;


lambdaFunc
    :   '[&]'parameterList'->'block expressionList
    ;

condition:  If '('expression')' suite (Else suite)? ;

loop
    :   While '('expression')' suite                            #whileLoop
    |   For '('forInit';'expression?';'expression?')' suite     #forLoop
    ;

forInit
//    :   varDeclare
    :   (expression(','expression)*)?       //maybe empty
    ;

jump
    :   Return expression?
    |   Break
    |   Continue
    ;

// 2 KEYWORDS
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
Identifier: [a-zA-Z][a-zA-Z0-9_]* ;
IntConst: [1-9][0-9]* | '0';
StringConst: '"'([ -~]|([\\][\\])|[\\n]|([\\]["]))*'"';

grammar Isaiah;

program: declare* EOF;

declare
    :   varDeclare ';'
    |   classDeclare ';'
    |   funcDeclare ';'
    ;

digitType: Bool | Int | String | Identifier ;

arrayType
    : digitType '[]'
    | arrayType '[]'
    ;

varType: digitType | arrayType;

retType: varType | Void;

varDeclare
    :   varType Identifier(initialPart)?(','Identifier(initialPart)?)*    //mingled
    ;

initialPart
    :   '['expression ']'                     //static init (array)
    |   '='expression                         //assign init (non-array)
    ;

classDeclare
    :   Class Identifier LeftBrace
            classIdentity*
        RightBrace
    ;

classIdentity
    :   varDeclare ';'
    |   funcDeclare ';'
    |   constructDeclare ';'
    ;

constructDeclare
    :   Identifier '()' LeftBrace
            statement*
        RightBrace
    ;

funcDeclare
    :   retType Identifier parameterList LeftBrace
            statement*
        RightBrace
    ;

parameterList: '(' (varType Identifier(','varType Identifier)*)? ')';
//TODO: init problem?

expressionList: '('(expression(','expression)*)?')';

block  : LeftBrace statement* RightBrace ;


statement
    :   varDeclare ';'
    |   expression ';'
    |   condition
    |   loop
    |   jump ';'
    ;

expression
    :   constVal                                        #constExpr
    |   Identifier                                      #idExpr
    |   This                                            #thisExpr
    |   newExpr                                         #newOpExpr
    |   lambdaFunc                                      #lambdaExpr     //TODO: MODIFY
    |   '('expression')'                                #parenExpr
    |   Identifier '.' Identifier                       #classCallExpr
    |   Identifier '[' expression ']'                   #arrayIndexExpr
    |   <assoc=right> op=('!'|'~')   expression         #unaryExpr
    |   <assoc=right> op=('+'|'-')   expression         #unaryExpr
    |   <assoc=right> op=('++'|'--') expression         #unaryExpr
    |   <assoc=right> expression op=('++'|'--')         #unaryExpr
    |   expression op=('*'|'/'|'%')   expression        #binaryExpr
    |   expression op=('+'|'-')   expression            #binaryExpr
    |   expression op=('<<'|'>>') expression            #binaryExpr
    |   <assoc=right> expression '=' expression         #assignExpr
    |   expression op=('<'|'>'|'<='|'>=') expression    #binaryExpr
    |   expression op=('=='|'!=') expression            #binaryExpr
    |   expression '&'  expression                      #binaryExpr
    |   expression '^'  expression                      #binaryExpr
    |   expression '|'  expression                      #binaryExpr
    |   expression '&&' expression                      #binaryExpr
    |   expression '||' expression                      #binaryExpr
    |   expression '='  expression                      #binaryExpr
    ;

constVal: IntConst | StringConst | BoolConst | NullConst;

newExpr
    :   New digitType                                 //static digit without assign
    |   New digitType '('expression')'                //static digit with assign
    |   New arrayType ('['expression']')+ ('[]')*     //static array
    |   New Identifier parameterList                  //custom class with parameter(s)
    ;

lambdaFunc
    :   '[&]'parameterList'->'LeftBrace
            statement*
        RightBrace expressionList
    ;

condition
    :   If '('expression')' LeftBrace
            statement*
        RightBrace Else LeftBrace
            statement*
        RightBrace
    ;

loop
    :   While '('expression')' LeftBrace
            statement*
        RightBrace
    |   For '('forInit';'expression?';'expression?')' LeftBrace
            statement*
        RightBrace
    ;
    //TODO: forInit:    declare, expr
    //                  none
    //                  expr

forInit
    :   varDeclare
    |   (expression(','expression)*)?       //maybe empty
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

LeftBrace: '{';
RightBrace: '}';

BlankChar
    :   [ \r\n\t]
        -> skip
    ;
LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
Identifier: [a-zA-Z][a-zA-Z0-9_]* ;
BoolConst: True | False;
IntConst: [1-9][0-9]* | '0';
StringConst: ["]([ -~]|([\\][\\])|[\\n]|([\\]["]))*["] ;
NullConst: Null;




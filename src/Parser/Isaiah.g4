grammar Isaiah;

program: declare* EOF;
declare
    :   ';'
    |   varDeclare
    |   classDeclare
    |   funcDeclare
    ;

digitType: Bool | Int | String | Identifier ;

arrayType
    : digitType '[' ']'
    | arrayType '[' ']'
    ;

varType: digitType | arrayType;                         //for declaration

varObj: Identifier
      | constVal
      | newExpr
      | Identifier expressionList
      | lambdaFunc
      | This
      ;

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
    :   ';'
    |   varDeclare
    |   funcDeclare
    |   constructDeclare
    ;

constructDeclare
    :   Identifier '('')' LeftBrace
            statement*
        RightBrace
    ;
    //int main()
//'()'
funcDeclare
    :   retType Identifier parameterList LeftBrace
            statement*
        RightBrace
    ;

parameterList: '('(varType Identifier(','varType Identifier)*)?')';

expressionList: '('(expression(','expression)*)?')';

block: LeftBrace statement* RightBrace ;

suite: block | statement ;

statement
    :   ';'
    |   varDeclare ';'
    |   expression ';'
    |   condition
    |   loop
    |   jump ';'
    |   block
    ;

expression
    :   varObj                                          #valueExpr
    |   '('expression')'                                #parenExpr
    |   expression ('['expression']')+ ('['']')*        #indexExpr
    |   expression '.' expression                       #callExpr
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
//    |   expression '='  expression                      #binaryExpr
    |   <assoc=right> expression '=' expression         #assignExpr
    ;

constVal: IntConst | StringConst | True | False | Null;

newExpr
    :   New digitType                                 #test1//static digit without assign
    |   New digitType '('expression')'                #test2//static digit with assign
    |   New digitType ('['expression']')+ ('['']')*   #test3//static array
    |   New Identifier parameterList                  #test4//custom class with parameter(s)
    ;


lambdaFunc
    :   '[&]'parameterList'->'LeftBrace
            statement*
        RightBrace expressionList
    ;

condition:  If '('expression')' suite (Else suite)? ;

loop
    :   While '('expression')' suite
    |   For '('forInit';'expression?';'expression?')' suite
    ;

forInit
    :   varDeclare
    |   (expression(','expression)*)?       //maybe empty
    ;
//TODO: if语句 => 一句话应该怎么写？

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

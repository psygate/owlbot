grammar OwlBotCommandGrammar;

fragment SINGLE_QUOTE
    :   '\''
    ;

fragment DOUBLE_QUOTE
    :   '"'
    ;

//SINGLE_STRING
//    : SINGLE_QUOTE ~('\'')* SINGLE_QUOTE
//    ;
//
//DOUBLE_STRING
//    : DOUBLE_QUOTE ~('"')* DOUBLE_QUOTE
//    ;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
//    | '\\' ([0-3]? [0-7])? [0-7]
//    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

SINGLE_QUOTE_STRING     :   '\'' (~['\\\r\n] | EscapeSequence)* '\'';

DOUBLE_QUOTE_STRING     :   '"' (~["\\\r\n] | EscapeSequence)* '"';


ANYTHING_EXCEPT_WHITESPACE
    :   ~[ \f\t\r\n]+
    ;

WS
    :   [ \t\r\n]+ -> skip
    ;

string
    : SINGLE_QUOTE_STRING
    | DOUBLE_QUOTE_STRING
    ;

nonWhiteSpace       :   ANYTHING_EXCEPT_WHITESPACE
                    ;

argument
                    :   string
                    |   nonWhiteSpace
                    ;

commandName
                    :   nonWhiteSpace
                    ;

parseCommand
                    : commandName argument*
                    ;
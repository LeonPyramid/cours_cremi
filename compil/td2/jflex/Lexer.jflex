import java.io.*;

%%

%public
%class Lexer
%type Token
%line
%column 
%state COMMENT COMMENT_DOC STRING

/* Définition des expressions régulières */

Entier = (0 | [1-9] [0-9])
Decimal = ({Entier} . [0-9] | . [0-9]+)
Reel = "-"?({Decimal} ([eE] [-+]? {Entier})? | {Entier} [eE] [-+]? {Entier})
Mots = [a-zA-Z_] [a-zA-Z0-9_]*

%%
<YYINITIAL>{
bool            {return new Token(Sym.BOOL,null,yyline,yycolumn);}
break           {return new Token(Sym.BREAK,null,yyline,yycolumn);}
case            {return new Token(Sym.CASE,null,yyline,yycolumn);}
catch           {return new Token(Sym.CATCH,null,yyline,yycolumn);}
char            {return new Token(Sym.CHAR,null,yyline,yycolumn);}
class           {return new Token(Sym.CLASS,null,yyline,yycolumn);}
const           {return new Token(Sym.CONST,null,yyline,yycolumn);}
continue        {return new Token(Sym.CONTINUE,null,yyline,yycolumn);}
default         {return new Token(Sym.DEFAULT,null,yyline,yycolumn);}
delete          {return new Token(Sym.DELETE,null,yyline,yycolumn);}
do              {return new Token(Sym.DO,null,yyline,yycolumn);}
double          {return new Token(Sym.DOUBLE,null,yyline,yycolumn);}
elseif          {return new Token(Sym.ELSEIF,null,yyline,yycolumn);}
else            {return new Token(Sym.ELSE,null,yyline,yycolumn);}
enum            {return new Token(Sym.ENUM,null,yyline,yycolumn);}
false           {return new Token(Sym.FALSE,null,yyline,yycolumn);}
float           {return new Token(Sym.FLOAT,null,yyline,yycolumn);}
for             {return new Token(Sym.FOR,null,yyline,yycolumn);}
friend          {return new Token(Sym.FRIEND,null,yyline,yycolumn);}
goto            {return new Token(Sym.GOTO,null,yyline,yycolumn);}
if              {return new Token(Sym.IF,null,yyline,yycolumn);}
inline          {return new Token(Sym.INLINE,null,yyline,yycolumn);}
int             {return new Token(Sym.INT,null,yyline,yycolumn);}
long            {return new Token(Sym.LONG,null,yyline,yycolumn);}
namespace       {return new Token(Sym.NAMESPACE,null,yyline,yycolumn);}
new             {return new Token(Sym.NEW,null,yyline,yycolumn);}
operator        {return new Token(Sym.OPERATOR,null,yyline,yycolumn);}
private         {return new Token(Sym.PRIVATE,null,yyline,yycolumn);}
protected       {return new Token(Sym.PROTECTED,null,yyline,yycolumn);}
public          {return new Token(Sym.PUBLIC,null,yyline,yycolumn);}
register        {return new Token(Sym.REGISTER,null,yyline,yycolumn);}
return          {return new Token(Sym.RETURN,null,yyline,yycolumn);}
short           {return new Token(Sym.SHORT,null,yyline,yycolumn);}
signed          {return new Token(Sym.SIGNED,null,yyline,yycolumn);}
sizeof          {return new Token(Sym.SIZEOF,null,yyline,yycolumn);}
static          {return new Token(Sym.STATIC,null,yyline,yycolumn);}
struct          {return new Token(Sym.STRUCT,null,yyline,yycolumn);}
switch          {return new Token(Sym.SWITCH,null,yyline,yycolumn);}
template        {return new Token(Sym.TEMPLATE,null,yyline,yycolumn);}
this            {return new Token(Sym.THIS,null,yyline,yycolumn);}
throw           {return new Token(Sym.THROW,null,yyline,yycolumn);}
true            {return new Token(Sym.TRUE,null,yyline,yycolumn);}
try             {return new Token(Sym.TRY,null,yyline,yycolumn);}
typedef         {return new Token(Sym.TYPEDEF,null,yyline,yycolumn);}
typeid          {return new Token(Sym.TYPEID,null,yyline,yycolumn);}
typename        {return new Token(Sym.TYPENAME,null,yyline,yycolumn);}
union           {return new Token(Sym.UNION,null,yyline,yycolumn);}
unsigned        {return new Token(Sym.UNSIGNED,null,yyline,yycolumn);}
using           {return new Token(Sym.USING,null,yyline,yycolumn);}
virtual         {return new Token(Sym.VIRTUAL,null,yyline,yycolumn);}
void            {return new Token(Sym.VOID,null,yyline,yycolumn);}
while           {return new Token(Sym.WHILE,null,yyline,yycolumn);}

/* Identifier */

    [a-zA-Z_] [a-zA-Z0-9_]* {return new Token(Sym.IDENTIFIER, yytext(),yyline,yycolumn);}

/* Comments */
    "//"[^\n]*  {return new Token(Sym.COMMENT,null,yyline,yycolumn);}
    "/*"        {yybegin(COMMENT);return new Token(Sym.COMMENT,null,yyline,yycolumn);}
//    "/**"       {yybegin(COMMENT_DOC);return new Token(Sym.COMMENT,null,yyline,yycolumn);}

    "#include" [^\n]*  {return new Token(Sym.INCLUDE,null,yyline,yycolumn);}

    \" {yybegin(STRING); return new Token(Sym.STRING,null,yyline,yycolumn);}

[^] {}

/* Numbers */

    {Entier}      {return new Token(Sym.INTEGER,(new Integer(yytext())),yyline,yycolumn);}
    {Decimal}     {return new Token(Sym.REAL,(new Float(yytext())),yyline,yycolumn);}
    //{Reel}        {return new Token(Sym.REAL,(new Float(yytext())),yyline,yycolumn);}

}

<COMMENT>{
	"*/" {yybegin(YYINITIAL);return new Token(Sym.ENDCOMMENT,null,yyline,yycolumn);}
    [^] {;}
}

<COMMENT_DOC>{
    "@author" {}
}

<STRING>{
    ([^\"]| \\ \" )* \" {yybegin(YYINITIAL);}
    [^] {}
}

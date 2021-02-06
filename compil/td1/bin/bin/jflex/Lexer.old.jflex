import java.io.*;

%%

%public
%class Lexer
%standalone
%8bit

%{
	int lineno = 0;
	int keywords = 0;
	int identifiers = 0;
	int operators = 0;
%}

%eof{
	System.out.printf("Lines: %d\nKeywords: %d\nIdentifiers: %d\nOperators: %d", 
		this.lineno, this.keywords, this.identifiers, this.operators);
%eof}


/* Définition des expressions régulières */

Entier = (0 | [1-9] [0-9])
Decimal = ({Entier} . [0-9] | . [0-9]+)
Reel = "-"?({Decimal} ([eE] [-+]? {Entier})? | {Entier} [eE] [-+]? {Entier})
Mots = [a-zA-Z_] [a-zA-Z0-9_]*

%%

/* Keywords */
bool    {++this.keywords;}
break    {++this.keywords;}
case    {++this.keywords;}
catch    {++this.keywords;}
char    {++this.keywords;}
class    {++this.keywords;}
const    {++this.keywords;}
continue    {++this.keywords;}
default    {++this.keywords;}
delete    {++this.keywords;}
do    {++this.keywords;}
double    {++this.keywords;}
else    {++this.keywords;}
enum    {++this.keywords;}
false    {++this.keywords;}
float    {++this.keywords;}
for    {++this.keywords;}
friend    {++this.keywords;}
goto    {++this.keywords;}
if    {++this.keywords;}
inline    {++this.keywords;}
int    {++this.keywords;}
long    {++this.keywords;}
namespace    {++this.keywords;}
new    {++this.keywords;}
operator    {++this.keywords;}
private    {++this.keywords;}
protected    {++this.keywords;}
public    {++this.keywords;}
register    {++this.keywords;}
return    {++this.keywords;}
short    {++this.keywords;}
signed    {++this.keywords;}
sizeof    {++this.keywords;}
static    {++this.keywords;}
struct    {++this.keywords;}
switch    {++this.keywords;}
template    {++this.keywords;}
this    {++this.keywords;}
throw    {++this.keywords;}
true    {++this.keywords;}
try    {++this.keywords;}
typedef    {++this.keywords;}
typeid    {++this.keywords;}
typename    {++this.keywords;}
union    {++this.keywords;}
unsigned    {++this.keywords;}
using    {++this.keywords;}
virtual    {++this.keywords;}
void    {++this.keywords;}
while    {++this.keywords;}
/* Identifier */
[Mots] {++this.identifiers;}
/* Integer */
[Entier] {}
/* Float */
[Decimal] {}
[Reel] {}
/* Operators (Attention d'utiliser les doubles quotes pour les caract`eres UTF8) */
"*"        {++this.operators;}
"+"     {++this.operators;}
"++"     {++this.operators;}
"-"     {++this.operators;}
"--"     {++this.operators;}
"~"     {++this.operators;}
"!"     {++this.operators;}
"/"     {++this.operators;}
"%"     {++this.operators;}
"<<"     {++this.operators;}
"<"     {++this.operators;}
">>"     {++this.operators;}
">"     {++this.operators;}
">="     {++this.operators;}
"<="     {++this.operators;}
"=="     {++this.operators;}
"!="     {++this.operators;}
"^"     {++this.operators;}
"|"     {++this.operators;}
"||"     {++this.operators;}
"&&"     {++this.operators;}
"="     {++this.operators;}
"*="     {++this.operators;}
"/="     {++this.operators;}
"%="     {++this.operators;}
"+="     {++this.operators;}
"-="     {++this.operators;}
"<<="     {++this.operators;}
">>="     {++this.operators;}
"&="     {++this.operators;}
"^="     {++this.operators;}
"|="     {++this.operators;}
 


/* Separators */

\, {}
\; {}
\: {}
\( {}
\) {}
\[ {}
\] {}
\. {}
\{ {}
\} {}
/* Strings */
\" ([^\"]| \\ \" )* \" {}
/* Comments */
"//"[^\n]*        {}
"/*"([^*]|"*"[^/])*"*"?"*/"        {}

/* Include */
"/#include"[^\n]* {}
/* Attention d'utiliser [^] plut^ot que . pour l'encodage des caractères unicodes */
\n  {++this.lineno;}
[^] {}

import java.io.*;

%%

%public
%class Lexer
%type Token
%line
%column 


/* Définition des expressions régulières */

Entier = (0 | [1-9] [0-9])
Decimal = ({Entier} . [0-9] | . [0-9]+)
Reel = "-"?({Decimal} ([eE] [-+]? {Entier})? | {Entier} [eE] [-+]? {Entier})
Mots = [a-zA-Z_] [a-zA-Z0-9_]*

%%
bool            {return new Token(Sym.BOOL,null,yyline,yycolumn);}
break           {}
case            {}
catch           {}
char            {}
class           {}
const           {}
continue        {}
default         {}
delete          {}
do              {}
double          {}
else            {}
enum            {}
false           {}
float           {}
for             {}
friend          {}
goto            {}
if              {}
inline          {}
int             {}
long            {}
namespace       {}
new             {}
operator        {}
private         {}
protected       {}
public          {}
register        {}
return          {}
short           {}
signed          {}
sizeof          {}
static          {}
struct          {}
switch          {}
template        {}
this            {}
throw           {}
true            {}
try             {}
typedef         {}
typeid          {}
typename        {}
union           {}
unsigned        {}
using           {}
virtual         {}
void            {}
while           {}



[^] {}
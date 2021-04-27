%language "Java"

%define api.parser.public
%define api.parser.class {Parser}
%define parse.error custom
%locations

//arithmetic operators
%token
	PLUS 	"+"
	MINUS 	"-"
	UMINUS
	PROD	"*"
	DIV		"/";
//Comparison operators
%token
	EQ		"="
	SSUP	">"
	SINF	"<"
	SUP		">="
	INF		"<="
	DIFF	"!=";

//Logic Operator
%token
	AND		"&&"
	OR		"||"
	NOT		"!";

%token<Integer>
	INTEGER;

%token<Boolean>
	BOOL;

%nterm<Boolean> exprComp exprLog;

%nterm<Integer> exprArith;


%right NOT UMINUS
%left PLUS MINUS
%left PROD DIV
%left OR
%left AND
%nonassoc EQ SSUP SINF SUP INF UP DIFF
%right ")"

%%

lines:
	lines line
	|line 		
	;

line:
	exprLog '\n'	{System.out.println($1);}
	|exprArith '\n'	{System.out.println($1);}
	;

exprArith:
	INTEGER	{$$=$1;}
	| exprArith PLUS exprArith		{if($1 == null || $3 == null){$$ = null;}else $$ = $1 + $3;}
	| exprArith MINUS exprArith		{if($1 == null || $3 == null){$$ = null;}else $$ = $1 - $3;}
	| exprArith PROD exprArith		{if($1 == null || $3 == null){$$ = null;}else $$ = $1 * $3;}
	| exprArith DIV exprArith		{if($1 == null || $3 == null){$$ = null;}else try{$$ = $1 / $3;}catch(ArithmeticException e){System.err.println("Error "+ e); $$ = null;}}
	| MINUS exprArith %prec UMINUS 	{if($2 == null){$$ = null;}else $$ = -$2;}
	|'(' exprArith ')'				{$$=$2;}		
	;

exprComp:
	BOOL {$$=$1;}
	| exprArith EQ exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = ($1.equals($3));}		
	| exprArith SSUP exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = ($1 > $3);}	
	| exprArith SINF exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = ($1 < $3);}	
	| exprArith SUP exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = ($1 >= $3);}
	| exprArith INF exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = ($1 <= $3);}
	| exprArith DIFF exprArith	{if($1 == null || $3 == null){$$ = null;}else $$ = !($1.equals($3));}
	;

exprLog:
	exprComp {$$ = $1;}
	| exprLog AND exprLog	{if($1 == null || $3 == null){$$ = null;}else $$ = $1 && $3;}
	| exprLog OR exprLog	{if($1 == null || $3 == null){$$ = null;}else $$ = $1 || $3;}
	| NOT exprLog 			{if($2 == null){$$ = null;}else $$ = !$2;}
	|'(' exprLog ')'		{$$=$2;}
	; 

%%

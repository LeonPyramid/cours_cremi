import java.io.*;

%%

// Création de
// public class ParserLexer implements Parser.Lexer {
//...
//	public int yylex() throws java.io.IOException {
//...
// 	}
//...
// }
%public
%class ParserLexer
%implements Parser.Lexer
%int
%function yylex
%yylexthrow java.io.IOException

// ajoutons le code nécessaire à l'interface Parser.Lexer:
%{
  private Position startPos;
  private Position endPos;
  private Object lVal;

    /**
     * Method to retrieve the beginning position of the last scanned token.
     * @return the position at which the last scanned token starts.
     */
    public Position getStartPos(){
 	   return startPos;
    }

    /**
     * Method to retrieve the ending position of the last scanned token.
     * @return the first position beyond the last scanned token.
     */
    public Position getEndPos(){
    	   return endPos;
    }

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    public Object getLVal(){
        return lVal;
    }
    

  /**
   * Build and emit a syntax error message.
   */
  public void reportSyntaxError(Parser.Context context) {
    System.err.print("*** Erreur de syntaxe " + context.getLocation().begin);

      Parser.SymbolKind lookahead = context.getToken();
      if (lookahead != null)
        System.err.print(" (" + lookahead.getName() + ") incorrect");
	  
      final int NOMBRE_TOKENS_AFFICHES = 32;
      Parser.SymbolKind[] arg = new Parser.SymbolKind[NOMBRE_TOKENS_AFFICHES];
      int nombre_tokens_attendus = context.getExpectedTokens(arg, NOMBRE_TOKENS_AFFICHES);
      for (int i = 0; i < nombre_tokens_attendus; ++i) {
      	System.err.print((i == 0 ? ", tokens attendus: " : ", ")
                         + arg[i].getName());
      }
    
    System.err.println("");
    
  }

  public void yyerror(Parser.Location loc, String msg) {
    if (loc == null)
      System.err.println(msg);
    else
      System.err.println("*** Erreur " + loc.toString() + ": " + msg);
  }

  public int token(int yytype){
	return yytype;
  }

  public int token(int yytype, Object lVal){
  	this.lVal = lVal;
  	return token(yytype);
  }

%}
Integer = [0-9]+

%%

"+"		{return token(PLUS);}
"-"		{return token(MINUS);}
"*"		{return token(PROD);}
"/"		{return token(DIV);}
"!"		{return token(NOT);}
"&&"	{return token(AND);}
"||"	{return token(OR);}
"="		{return token(EQ);}
"<="	{return token(INF);}
">="	{return token(SUP);}
">"		{return token(SSUP);}
"<"		{return token(SINF);}
"!="	{return token(DIFF);}
"("		{return '(';}
")"		{return ')';}
"true" 	{return token(BOOL, new Boolean(true));}
"false"	{return token(BOOL, new Boolean(false));}

{Integer}	{return token(INTEGER, new Integer(yytext()));}
\n  {return token('\n');}
. {}

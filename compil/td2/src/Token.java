public class Token {
    private Sym sym;
    private Object value;
    private int lineno;
    private int colno;

    public Token(Sym sym ,Object obj ,int linen ,int coln){
        this.sym = sym;
        this.value = obj;
        this.lineno = linen;
        this.colno = coln;
    }
}

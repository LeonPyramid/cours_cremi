

public enum Sym {
    
    BOOL        ("Bool"),
    BREAK       ("Break"),
    CASE        ("Case"), 
    CATCHCHAR   ("Catchchar"), 
    CLASS       ("Class"), 
    CONST       ("Const"), 
    CONTINUE    ("Continue"), 
    DEFAULT     ("Default"),
    DELETE      ("Delete"), 
    DO          ("Do"), 
    DOUBLE      ("Double"), 
    ELSE        ("Else"), 
    ENUMFALSE   ("Enumfalse"), 
    FLOAT       ("Float"), 
    FOR         ("For"), 
    FRIEND      ("Friend"), 
    GOTO        ("Goto"), 
    IF          ("If"), 
    INLINE      ("Inline"), 
    INT         ("Integer"), 
    LONG        ("Long"),
    NAMESPACE   ("Namespace"), 
    NEW         ("New"), 
    OPERATOR    ("Operator"), 
    PRIVATE     ("Private"),
    PROTECTED   ("Protected"), 
    PUBLIC      ("Public"), 
    REGISTER    ("Register"), 
    RETURN      ("Return"), 
    SHORTSIGNED ("Shortsigned"), 
    SIZEOF      ("Sizeof"), 
    STATIC      ("Static"), 
    STRUCT      ("Struct"), 
    SWITCH      ("Switch"), 
    TEMPLATE    ("Template"),
    THIS        ("This"), 
    THROW       ("Throw"), 
    TRUE        ("True"), 
    TRY         ("Try"), 
    TYPEDEF     ("Typedef"), 
    TYPEID      ("Typeid"), 
    TYPENAME    ("Typename"), 
    UNION       ("Union"), 
    UNSIGNED    ("Unsigned");
    
    private String name;
    
    Sym(String nom){
        this.name = nom;
    }

    public String toString(){
        return name;
    }
}



public enum Sym {
    
    BOOL        ("Bool"),
    BREAK       ("Break"),
    CASE        ("Case"),
    CATCH       ("Catch"),
    CHAR        ("Char"),
    CLASS       ("Class"),
    CONST       ("Const"),
    CONTINUE    ("Continue"),
    DEFAULT     ("Default"),
    DELETE      ("Delete"),
    DO          ("Do"),
    DOUBLE      ("Double"),
    ELSE        ("Else"),
    ELSEIF      ("Elseif"),
    ENUM        ("Enum"),
    FALSE       ("False"),
    FLOAT       ("Float"),
    FOR         ("For"),
    FRIEND      ("Friend"),
    GOTO        ("Goto"),
    IF          ("If"),
    INLINE      ("Inline"),
    INT         ("Int"),
    LONG        ("Long"),
    NAMESPACE   ("Namespace"),
    NEW         ("New"),
    OPERATOR    ("Operator"),
    PRIVATE     ("Private"),
    PROTECTED   ("Protected"),
    PUBLIC      ("Public"),
    REGISTER    ("Register"),
    RETURN      ("Return"),
    SHORT       ("Short"),
    SIGNED      ("Signed"),
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
    UNSIGNED    ("Unsigned"),
    USING       ("Using"),
    VIRTUAL     ("Virtual"),
    VOID        ("Void"),
    WHILE       ("While"),

    IDENTIFIER  ("Identifier"),

    COMMENT     ("Comment"),
    ENDCOMMENT  ("Endcomment"),
    
    INCLUDE     ("Include"),
    
    INTEGER     ("Integer"),
    REAL        ("Real"),

    STRING      ("String");

    private String name;
    
    Sym(String nom){
        this.name = nom;
    }

    public String toString(){
        return name;
    }
}

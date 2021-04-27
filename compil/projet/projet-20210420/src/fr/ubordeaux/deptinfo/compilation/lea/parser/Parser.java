/* A Bison parser, made by GNU Bison 3.7.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2020 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package fr.ubordeaux.deptinfo.compilation.lea.parser;



import java.text.MessageFormat;
/* "%code imports" blocks.  */
/* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":17  */

	import fr.ubordeaux.deptinfo.compilation.lea.type.*;
	import fr.ubordeaux.deptinfo.compilation.lea.environment.*;
	import fr.ubordeaux.deptinfo.compilation.lea.stree.*;

/* "/home/leon/travail/cremi/compil/projet/projet-20210420/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":50  */

/**
 * A Bison parser, automatically generated from <tt>/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Parser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.7";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  /**
   * A class defining a pair of positions.  Positions, defined by the
   * <code>Position</code> class, denote a point in the input.
   * Locations represent a part of the input through the beginning
   * and ending positions.
   */
  public static class Location {
    /**
     * The first, inclusive, position in the range.
     */
    public Position begin;

    /**
     * The first position beyond the range.
     */
    public Position end;

    /**
     * Create a <code>Location</code> denoting an empty range located at
     * a given point.
     * @param loc The position at which the range is anchored.
     */
    public Location (Position loc) {
      this.begin = this.end = loc;
    }

    /**
     * Create a <code>Location</code> from the endpoints of the range.
     * @param begin The first position included in the range.
     * @param end   The first position beyond the range.
     */
    public Location (Position begin, Position end) {
      this.begin = begin;
      this.end = end;
    }

    /**
     * Print a representation of the location.  For this to be correct,
     * <code>Position</code> should override the <code>equals</code>
     * method.
     */
    public String toString () {
      if (begin.equals (end))
        return begin.toString ();
      else
        return begin.toString () + "-" + end.toString ();
    }
  }

  private Location yylloc(YYStack rhs, int n)
  {
    if (0 < n)
      return new Location(rhs.locationAt(n-1).begin, rhs.locationAt(0).end);
    else
      return new Location(rhs.locationAt(0).end);
  }

  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_ASSIGN(3),                   /* ":="  */
    S_PLUSE(4),                    /* "+="  */
    S_MINUSE(5),                   /* "-="  */
    S_TIMESE(6),                   /* "*="  */
    S_DIVE(7),                     /* "/="  */
    S_PERCE(8),                    /* "%="  */
    S_ORE(9),                      /* "||="  */
    S_ANDE(10),                    /* "&&="  */
    S_AMPE(11),                    /* "&="  */
    S_PIPEE(12),                   /* "|="  */
    S_LSHIFTE(13),                 /* "<<="  */
    S_RSHIFTE(14),                 /* ">>="  */
    S_SUCC(15),                    /* "++"  */
    S_DEC(16),                     /* "--"  */
    S_AND(17),                     /* "&&"  */
    S_OR(18),                      /* "||"  */
    S_LSHIFT(19),                  /* "<<"  */
    S_RSHIFT(20),                  /* ">>"  */
    S_DOTS(21),                    /* ".."  */
    S_EQ(22),                      /* "=="  */
    S_LE(23),                      /* "<="  */
    S_GE(24),                      /* ">="  */
    S_NE(25),                      /* "!="  */
    S_BOOLEAN(26),                 /* "boolean"  */
    S_BREAK(27),                   /* "break"  */
    S_CASE(28),                    /* "case"  */
    S_CHAR(29),                    /* "char"  */
    S_CLASS(30),                   /* "class"  */
    S_COMPARABLE(31),              /* "comparable"  */
    S_CONST(32),                   /* "const"  */
    S_CONTINUE(33),                /* "continue"  */
    S_DEFAULT(34),                 /* "default"  */
    S_DO(35),                      /* "do"  */
    S_ELSE(36),                    /* "else"  */
    S_ENUM(37),                    /* "enum"  */
    S_EQUIVALENT(38),              /* "equivalent"  */
    S_EXTENDS(39),                 /* "extends"  */
    S_FINAL(40),                   /* "final"  */
    S_FLOAT(41),                   /* "float"  */
    S_FOR(42),                     /* "for"  */
    S_FOREACH(43),                 /* "foreach"  */
    S_FUNCTION(44),                /* "function"  */
    S_IF(45),                      /* "if"  */
    S_IMPLEMENTS(46),              /* "implements"  */
    S_IMPORT(47),                  /* "import"  */
    S_IN(48),                      /* "in"  */
    S_INTEGER(49),                 /* "integer"  */
    S_INTERFACE(50),               /* "interface"  */
    S_LIST(51),                    /* "list"  */
    S_MAP(52),                     /* "map"  */
    S_MAIN(53),                    /* "main"  */
    S_NEW(54),                     /* "new"  */
    S_NULL(55),                    /* "null"  */
    S_PRIVATE(56),                 /* "private"  */
    S_PROTECTED(57),               /* "protected"  */
    S_PUBLIC(58),                  /* "public"  */
    S_PROCEDURE(59),               /* "procedure"  */
    S_RANGE(60),                   /* "range"  */
    S_READLN(61),                  /* "readln"  */
    S_RETURN(62),                  /* "return"  */
    S_SET(63),                     /* "set"  */
    S_STRING(64),                  /* "string"  */
    S_SWITCH(65),                  /* "switch"  */
    S_THIS(66),                    /* "this"  */
    S_TYPE(67),                    /* "type"  */
    S_VIRTUAL(68),                 /* "virtual"  */
    S_WRITE(69),                   /* "write"  */
    S_WRITELN(70),                 /* "writeln"  */
    S_WHILE(71),                   /* "while"  */
    S_IDENTIFIER(72),              /* IDENTIFIER  */
    S_CONSTANT_STRING(73),         /* CONSTANT_STRING  */
    S_CONSTANT_INTEGER(74),        /* CONSTANT_INTEGER  */
    S_CONSTANT_CHAR(75),           /* CONSTANT_CHAR  */
    S_CONSTANT_FLOAT(76),          /* CONSTANT_FLOAT  */
    S_ASSIGNED_VARIABLE(77),       /* ASSIGNED_VARIABLE  */
    S_78_(78),                     /* ':'  */
    S_WITHOUT_ELSE(79),            /* WITHOUT_ELSE  */
    S_DETERMINER(80),              /* DETERMINER  */
    S_SPECIFIER(81),               /* SPECIFIER  */
    S_82_(82),                     /* '!'  */
    S_83_(83),                     /* '<'  */
    S_84_(84),                     /* '>'  */
    S_85_(85),                     /* '+'  */
    S_86_(86),                     /* '-'  */
    S_87_(87),                     /* '*'  */
    S_88_(88),                     /* '/'  */
    S_89_(89),                     /* '%'  */
    S_LEFTPLUSPLUS(90),            /* LEFTPLUSPLUS  */
    S_LEFTMINUSMINUS(91),          /* LEFTMINUSMINUS  */
    S_UMINUS(92),                  /* UMINUS  */
    S_93_(93),                     /* '|'  */
    S_94_(94),                     /* '&'  */
    S_95_(95),                     /* '{'  */
    S_96_(96),                     /* '}'  */
    S_97_(97),                     /* ','  */
    S_98_(98),                     /* ';'  */
    S_99_(99),                     /* '('  */
    S_100_(100),                   /* ')'  */
    S_101_(101),                   /* '['  */
    S_102_(102),                   /* ']'  */
    S_103_(103),                   /* '.'  */
    S_YYACCEPT(104),               /* $accept  */
    S_type_expressions(105),       /* type_expressions  */
    S_type_expression(106),        /* type_expression  */
    S_type_expression_class(107),  /* type_expression_class  */
    S_type_names(108),             /* type_names  */
    S_type_name(109),              /* type_name  */
    S_args_definition(110),        /* args_definition  */
    S_arg_definition(111),         /* arg_definition  */
    S_interface_definition(112),   /* interface_definition  */
    S_interface_definition_head(113), /* interface_definition_head  */
    S_class_definition(114),       /* class_definition  */
    S_class_definition_head(115),  /* class_definition_head  */
    S_const_definition(116),       /* const_definition  */
    S_attribute_definition(117),   /* attribute_definition  */
    S_method_definition(118),      /* method_definition  */
    S_const_expression(119),       /* const_expression  */
    S_expression(120),             /* expression  */
    S_assigned_variable(121),      /* assigned_variable  */
    S_args(122),                   /* args  */
    S_args_opt(123),               /* args_opt  */
    S_method_name(124),            /* method_name  */
    S_block(125),                  /* block  */
    S_stms(126),                   /* stms  */
    S_stm(127),                    /* stm  */
    S_simple_stm(128),             /* simple_stm  */
    S_assignment_stm(129),         /* assignment_stm  */
    S_case_stms(130),              /* case_stms  */
    S_case_stm(131),               /* case_stm  */
    S_default_stm(132),            /* default_stm  */
    S_S(133),                      /* S  */
    S_imports(134),                /* imports  */
    S_import(135),                 /* import  */
    S_declarations(136),           /* declarations  */
    S_declaration(137),            /* declaration  */
    S_implements(138),             /* implements  */
    S_extends(139),                /* extends  */
    S_extends_public(140),         /* extends_public  */
    S_class_names(141),            /* class_names  */
    S_class_name(142),             /* class_name  */
    S_type_definition(143),        /* type_definition  */
    S_push_environment(144),       /* push_environment  */
    S_pop_environment(145),        /* pop_environment  */
    S_146_1(146),                  /* $@1  */
    S_147_2(147),                  /* $@2  */
    S_148_3(148),                  /* $@3  */
    S_149_4(149),                  /* $@4  */
    S_150_5(150),                  /* $@5  */
    S_151_6(151),                  /* $@6  */
    S_152_7(152),                  /* $@7  */
    S_153_8(153),                  /* $@8  */
    S_154_9(154),                  /* $@9  */
    S_155_10(155),                 /* $@10  */
    S_156_11(156),                 /* $@11  */
    S_157_12(157),                 /* $@12  */
    S_158_13(158),                 /* $@13  */
    S_159_14(159),                 /* $@14  */
    S_determiner(160),             /* determiner  */
    S_specifier(161),              /* specifier  */
    S_var_definitions(162),        /* var_definitions  */
    S_var_definition(163);         /* var_definition  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_ASSIGN,
      SymbolKind.S_PLUSE,
      SymbolKind.S_MINUSE,
      SymbolKind.S_TIMESE,
      SymbolKind.S_DIVE,
      SymbolKind.S_PERCE,
      SymbolKind.S_ORE,
      SymbolKind.S_ANDE,
      SymbolKind.S_AMPE,
      SymbolKind.S_PIPEE,
      SymbolKind.S_LSHIFTE,
      SymbolKind.S_RSHIFTE,
      SymbolKind.S_SUCC,
      SymbolKind.S_DEC,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_LSHIFT,
      SymbolKind.S_RSHIFT,
      SymbolKind.S_DOTS,
      SymbolKind.S_EQ,
      SymbolKind.S_LE,
      SymbolKind.S_GE,
      SymbolKind.S_NE,
      SymbolKind.S_BOOLEAN,
      SymbolKind.S_BREAK,
      SymbolKind.S_CASE,
      SymbolKind.S_CHAR,
      SymbolKind.S_CLASS,
      SymbolKind.S_COMPARABLE,
      SymbolKind.S_CONST,
      SymbolKind.S_CONTINUE,
      SymbolKind.S_DEFAULT,
      SymbolKind.S_DO,
      SymbolKind.S_ELSE,
      SymbolKind.S_ENUM,
      SymbolKind.S_EQUIVALENT,
      SymbolKind.S_EXTENDS,
      SymbolKind.S_FINAL,
      SymbolKind.S_FLOAT,
      SymbolKind.S_FOR,
      SymbolKind.S_FOREACH,
      SymbolKind.S_FUNCTION,
      SymbolKind.S_IF,
      SymbolKind.S_IMPLEMENTS,
      SymbolKind.S_IMPORT,
      SymbolKind.S_IN,
      SymbolKind.S_INTEGER,
      SymbolKind.S_INTERFACE,
      SymbolKind.S_LIST,
      SymbolKind.S_MAP,
      SymbolKind.S_MAIN,
      SymbolKind.S_NEW,
      SymbolKind.S_NULL,
      SymbolKind.S_PRIVATE,
      SymbolKind.S_PROTECTED,
      SymbolKind.S_PUBLIC,
      SymbolKind.S_PROCEDURE,
      SymbolKind.S_RANGE,
      SymbolKind.S_READLN,
      SymbolKind.S_RETURN,
      SymbolKind.S_SET,
      SymbolKind.S_STRING,
      SymbolKind.S_SWITCH,
      SymbolKind.S_THIS,
      SymbolKind.S_TYPE,
      SymbolKind.S_VIRTUAL,
      SymbolKind.S_WRITE,
      SymbolKind.S_WRITELN,
      SymbolKind.S_WHILE,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_CONSTANT_STRING,
      SymbolKind.S_CONSTANT_INTEGER,
      SymbolKind.S_CONSTANT_CHAR,
      SymbolKind.S_CONSTANT_FLOAT,
      SymbolKind.S_ASSIGNED_VARIABLE,
      SymbolKind.S_78_,
      SymbolKind.S_WITHOUT_ELSE,
      SymbolKind.S_DETERMINER,
      SymbolKind.S_SPECIFIER,
      SymbolKind.S_82_,
      SymbolKind.S_83_,
      SymbolKind.S_84_,
      SymbolKind.S_85_,
      SymbolKind.S_86_,
      SymbolKind.S_87_,
      SymbolKind.S_88_,
      SymbolKind.S_89_,
      SymbolKind.S_LEFTPLUSPLUS,
      SymbolKind.S_LEFTMINUSMINUS,
      SymbolKind.S_UMINUS,
      SymbolKind.S_93_,
      SymbolKind.S_94_,
      SymbolKind.S_95_,
      SymbolKind.S_96_,
      SymbolKind.S_97_,
      SymbolKind.S_98_,
      SymbolKind.S_99_,
      SymbolKind.S_100_,
      SymbolKind.S_101_,
      SymbolKind.S_102_,
      SymbolKind.S_103_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_type_expressions,
      SymbolKind.S_type_expression,
      SymbolKind.S_type_expression_class,
      SymbolKind.S_type_names,
      SymbolKind.S_type_name,
      SymbolKind.S_args_definition,
      SymbolKind.S_arg_definition,
      SymbolKind.S_interface_definition,
      SymbolKind.S_interface_definition_head,
      SymbolKind.S_class_definition,
      SymbolKind.S_class_definition_head,
      SymbolKind.S_const_definition,
      SymbolKind.S_attribute_definition,
      SymbolKind.S_method_definition,
      SymbolKind.S_const_expression,
      SymbolKind.S_expression,
      SymbolKind.S_assigned_variable,
      SymbolKind.S_args,
      SymbolKind.S_args_opt,
      SymbolKind.S_method_name,
      SymbolKind.S_block,
      SymbolKind.S_stms,
      SymbolKind.S_stm,
      SymbolKind.S_simple_stm,
      SymbolKind.S_assignment_stm,
      SymbolKind.S_case_stms,
      SymbolKind.S_case_stm,
      SymbolKind.S_default_stm,
      SymbolKind.S_S,
      SymbolKind.S_imports,
      SymbolKind.S_import,
      SymbolKind.S_declarations,
      SymbolKind.S_declaration,
      SymbolKind.S_implements,
      SymbolKind.S_extends,
      SymbolKind.S_extends_public,
      SymbolKind.S_class_names,
      SymbolKind.S_class_name,
      SymbolKind.S_type_definition,
      SymbolKind.S_push_environment,
      SymbolKind.S_pop_environment,
      SymbolKind.S_146_1,
      SymbolKind.S_147_2,
      SymbolKind.S_148_3,
      SymbolKind.S_149_4,
      SymbolKind.S_150_5,
      SymbolKind.S_151_6,
      SymbolKind.S_152_7,
      SymbolKind.S_153_8,
      SymbolKind.S_154_9,
      SymbolKind.S_155_10,
      SymbolKind.S_156_11,
      SymbolKind.S_157_12,
      SymbolKind.S_158_13,
      SymbolKind.S_159_14,
      SymbolKind.S_determiner,
      SymbolKind.S_specifier,
      SymbolKind.S_var_definitions,
      SymbolKind.S_var_definition
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* YYNAMES_[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yynames_ = yynames_init();
  private static final String[] yynames_init()
  {
    return new String[]
    {
  "end of file", "error", "invalid token", ":=", "+=", "-=", "*=", "/=",
  "%=", "||=", "&&=", "&=", "|=", "<<=", ">>=", "++", "--", "&&", "||",
  "<<", ">>", "..", "==", "<=", ">=", "!=", "boolean", "break", "case",
  "char", "class", "comparable", "const", "continue", "default", "do",
  "else", "enum", "equivalent", "extends", "final", "float", "for",
  "foreach", "function", "if", "implements", "import", "in", "integer",
  "interface", "list", "map", "main", "new", "null", "private",
  "protected", "public", "procedure", "range", "readln", "return", "set",
  "string", "switch", "this", "type", "virtual", "write", "writeln",
  "while", "IDENTIFIER", "CONSTANT_STRING", "CONSTANT_INTEGER",
  "CONSTANT_CHAR", "CONSTANT_FLOAT", "ASSIGNED_VARIABLE", "':'",
  "WITHOUT_ELSE", "DETERMINER", "SPECIFIER", "'!'", "'<'", "'>'", "'+'",
  "'-'", "'*'", "'/'", "'%'", "LEFTPLUSPLUS", "LEFTMINUSMINUS", "UMINUS",
  "'|'", "'&'", "'{'", "'}'", "','", "';'", "'('", "')'", "'['", "']'",
  "'.'", "$accept", "type_expressions", "type_expression",
  "type_expression_class", "type_names", "type_name", "args_definition",
  "arg_definition", "interface_definition", "interface_definition_head",
  "class_definition", "class_definition_head", "const_definition",
  "attribute_definition", "method_definition", "const_expression",
  "expression", "assigned_variable", "args", "args_opt", "method_name",
  "block", "stms", "stm", "simple_stm", "assignment_stm", "case_stms",
  "case_stm", "default_stm", "S", "imports", "import", "declarations",
  "declaration", "implements", "extends", "extends_public", "class_names",
  "class_name", "type_definition", "push_environment", "pop_environment",
  "$@1", "$@2", "$@3", "$@4", "$@5", "$@6", "$@7", "$@8", "$@9", "$@10",
  "$@11", "$@12", "$@13", "$@14", "determiner", "specifier",
  "var_definitions", "var_definition", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yynames_[yycode_];
    }
  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Parser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token ":=", to be returned by the scanner.  */
    static final int ASSIGN = 258;
    /** Token "+=", to be returned by the scanner.  */
    static final int PLUSE = 259;
    /** Token "-=", to be returned by the scanner.  */
    static final int MINUSE = 260;
    /** Token "*=", to be returned by the scanner.  */
    static final int TIMESE = 261;
    /** Token "/=", to be returned by the scanner.  */
    static final int DIVE = 262;
    /** Token "%=", to be returned by the scanner.  */
    static final int PERCE = 263;
    /** Token "||=", to be returned by the scanner.  */
    static final int ORE = 264;
    /** Token "&&=", to be returned by the scanner.  */
    static final int ANDE = 265;
    /** Token "&=", to be returned by the scanner.  */
    static final int AMPE = 266;
    /** Token "|=", to be returned by the scanner.  */
    static final int PIPEE = 267;
    /** Token "<<=", to be returned by the scanner.  */
    static final int LSHIFTE = 268;
    /** Token ">>=", to be returned by the scanner.  */
    static final int RSHIFTE = 269;
    /** Token "++", to be returned by the scanner.  */
    static final int SUCC = 270;
    /** Token "--", to be returned by the scanner.  */
    static final int DEC = 271;
    /** Token "&&", to be returned by the scanner.  */
    static final int AND = 272;
    /** Token "||", to be returned by the scanner.  */
    static final int OR = 273;
    /** Token "<<", to be returned by the scanner.  */
    static final int LSHIFT = 274;
    /** Token ">>", to be returned by the scanner.  */
    static final int RSHIFT = 275;
    /** Token "..", to be returned by the scanner.  */
    static final int DOTS = 276;
    /** Token "==", to be returned by the scanner.  */
    static final int EQ = 277;
    /** Token "<=", to be returned by the scanner.  */
    static final int LE = 278;
    /** Token ">=", to be returned by the scanner.  */
    static final int GE = 279;
    /** Token "!=", to be returned by the scanner.  */
    static final int NE = 280;
    /** Token "boolean", to be returned by the scanner.  */
    static final int BOOLEAN = 281;
    /** Token "break", to be returned by the scanner.  */
    static final int BREAK = 282;
    /** Token "case", to be returned by the scanner.  */
    static final int CASE = 283;
    /** Token "char", to be returned by the scanner.  */
    static final int CHAR = 284;
    /** Token "class", to be returned by the scanner.  */
    static final int CLASS = 285;
    /** Token "comparable", to be returned by the scanner.  */
    static final int COMPARABLE = 286;
    /** Token "const", to be returned by the scanner.  */
    static final int CONST = 287;
    /** Token "continue", to be returned by the scanner.  */
    static final int CONTINUE = 288;
    /** Token "default", to be returned by the scanner.  */
    static final int DEFAULT = 289;
    /** Token "do", to be returned by the scanner.  */
    static final int DO = 290;
    /** Token "else", to be returned by the scanner.  */
    static final int ELSE = 291;
    /** Token "enum", to be returned by the scanner.  */
    static final int ENUM = 292;
    /** Token "equivalent", to be returned by the scanner.  */
    static final int EQUIVALENT = 293;
    /** Token "extends", to be returned by the scanner.  */
    static final int EXTENDS = 294;
    /** Token "final", to be returned by the scanner.  */
    static final int FINAL = 295;
    /** Token "float", to be returned by the scanner.  */
    static final int FLOAT = 296;
    /** Token "for", to be returned by the scanner.  */
    static final int FOR = 297;
    /** Token "foreach", to be returned by the scanner.  */
    static final int FOREACH = 298;
    /** Token "function", to be returned by the scanner.  */
    static final int FUNCTION = 299;
    /** Token "if", to be returned by the scanner.  */
    static final int IF = 300;
    /** Token "implements", to be returned by the scanner.  */
    static final int IMPLEMENTS = 301;
    /** Token "import", to be returned by the scanner.  */
    static final int IMPORT = 302;
    /** Token "in", to be returned by the scanner.  */
    static final int IN = 303;
    /** Token "integer", to be returned by the scanner.  */
    static final int INTEGER = 304;
    /** Token "interface", to be returned by the scanner.  */
    static final int INTERFACE = 305;
    /** Token "list", to be returned by the scanner.  */
    static final int LIST = 306;
    /** Token "map", to be returned by the scanner.  */
    static final int MAP = 307;
    /** Token "main", to be returned by the scanner.  */
    static final int MAIN = 308;
    /** Token "new", to be returned by the scanner.  */
    static final int NEW = 309;
    /** Token "null", to be returned by the scanner.  */
    static final int NULL = 310;
    /** Token "private", to be returned by the scanner.  */
    static final int PRIVATE = 311;
    /** Token "protected", to be returned by the scanner.  */
    static final int PROTECTED = 312;
    /** Token "public", to be returned by the scanner.  */
    static final int PUBLIC = 313;
    /** Token "procedure", to be returned by the scanner.  */
    static final int PROCEDURE = 314;
    /** Token "range", to be returned by the scanner.  */
    static final int RANGE = 315;
    /** Token "readln", to be returned by the scanner.  */
    static final int READLN = 316;
    /** Token "return", to be returned by the scanner.  */
    static final int RETURN = 317;
    /** Token "set", to be returned by the scanner.  */
    static final int SET = 318;
    /** Token "string", to be returned by the scanner.  */
    static final int STRING = 319;
    /** Token "switch", to be returned by the scanner.  */
    static final int SWITCH = 320;
    /** Token "this", to be returned by the scanner.  */
    static final int THIS = 321;
    /** Token "type", to be returned by the scanner.  */
    static final int TYPE = 322;
    /** Token "virtual", to be returned by the scanner.  */
    static final int VIRTUAL = 323;
    /** Token "write", to be returned by the scanner.  */
    static final int WRITE = 324;
    /** Token "writeln", to be returned by the scanner.  */
    static final int WRITELN = 325;
    /** Token "while", to be returned by the scanner.  */
    static final int WHILE = 326;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 327;
    /** Token CONSTANT_STRING, to be returned by the scanner.  */
    static final int CONSTANT_STRING = 328;
    /** Token CONSTANT_INTEGER, to be returned by the scanner.  */
    static final int CONSTANT_INTEGER = 329;
    /** Token CONSTANT_CHAR, to be returned by the scanner.  */
    static final int CONSTANT_CHAR = 330;
    /** Token CONSTANT_FLOAT, to be returned by the scanner.  */
    static final int CONSTANT_FLOAT = 331;
    /** Token ASSIGNED_VARIABLE, to be returned by the scanner.  */
    static final int ASSIGNED_VARIABLE = 332;
    /** Token WITHOUT_ELSE, to be returned by the scanner.  */
    static final int WITHOUT_ELSE = 333;
    /** Token DETERMINER, to be returned by the scanner.  */
    static final int DETERMINER = 334;
    /** Token SPECIFIER, to be returned by the scanner.  */
    static final int SPECIFIER = 335;
    /** Token LEFTPLUSPLUS, to be returned by the scanner.  */
    static final int LEFTPLUSPLUS = 336;
    /** Token LEFTMINUSMINUS, to be returned by the scanner.  */
    static final int LEFTMINUSMINUS = 337;
    /** Token UMINUS, to be returned by the scanner.  */
    static final int UMINUS = 338;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;

    /**
     * Method to retrieve the beginning position of the last scanned token.
     * @return the position at which the last scanned token starts.
     */
    Position getStartPos();

    /**
     * Method to retrieve the ending position of the last scanned token.
     * @return the first position beyond the last scanned token.
     */
    Position getEndPos();

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * and beginning/ending positions of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an error referring to the given locationin a user-defined way.
     *
     * @param loc The location of the element to which the
     *                error message is related.
     * @param msg The string for the error message.
     */
     void yyerror(Location loc, String msg);


    /**
     * Build and emit a "syntax error" message in a user-defined way.
     *
     * @param ctx  The context of the error.
     */
     void reportSyntaxError (Context ctx);

  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Parser (Lexer yylexer)
  {

    this.yylexer = yylexer;

  }


  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * The <tt>PrintStream</tt> on which the debugging output is printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream (java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel () { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel (int level) { yydebug = level; }


  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors () { return yynerrs; }

  /**
   * Print an error message via the lexer.
   * Use a <code>null</code> location.
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror((Location)null, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param loc The location associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Location loc, String msg) {
      yylexer.yyerror(loc, msg);
  }

  /**
   * Print an error message via the lexer.
   * @param pos The position associated with the message.
   * @param msg The error message.
   */
  public final void yyerror(Position pos, String msg) {
      yylexer.yyerror(new Location (pos), msg);
  }

  protected final void yycdebug (String s) {
    if (0 < yydebug)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    private Location[] locStack = new Location[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value, Location loc) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          Location[] newLocStack = new Location[size * 2];
          System.arraycopy (locStack, 0, newLocStack, 0, height);
          locStack = newLocStack;

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      locStack[height] = loc;
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        java.util.Arrays.fill (locStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }


    public final Location locationAt (int i) {
      return locStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen) throws EnvironmentException, TypeException, StreeException
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);
    Location yyloc = yylloc(yystack, yylen);

    yyReducePrint(yyn, yystack);

    switch (yyn)
      {
          case 8: /* declaration: "class" IDENTIFIER implements extends '{' push_environment class_definition pop_environment '}'  */
  if (yyn == 8)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":170  */
                                                                                                        { classEnvironment.put(((String)(yystack.valueAt (7))), ((Type)(yystack.valueAt (2)))); };
  break;


  case 9: /* declaration: "class" "main" '{' push_environment class_definition pop_environment '}'  */
  if (yyn == 9)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":171  */
                                                                                   { classEnvironment.put("main", ((Type)(yystack.valueAt (2)))); };
  break;


  case 10: /* declaration: "interface" IDENTIFIER extends_public '{' push_environment interface_definition pop_environment '}'  */
  if (yyn == 10)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":172  */
                                                                                                              { interfaceEnvironment.put(((String)(yystack.valueAt (6))), ((Type)(yystack.valueAt (2)))); };
  break;


  case 21: /* class_definition: %empty  */
  if (yyn == 21)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":201  */
               {yyval = null;};
  break;


  case 22: /* class_definition: class_definition_head class_definition  */
  if (yyn == 22)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":203  */
        {
		if (((Type)(yystack.valueAt (1))) == null)
			yyval = ((Type)(yystack.valueAt (0)));
		else {
			if (((Type)(yystack.valueAt (0))) == null) 
				yyval = ((Type)(yystack.valueAt (1))); 
			else 
				yyval = new TypeExpression(Tag.PRODUCT, ((Type)(yystack.valueAt (1))), ((Type)(yystack.valueAt (0)))); 
		}
	};
  break;


  case 23: /* class_definition_head: type_definition  */
  if (yyn == 23)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":216  */
                        {yyval = null;};
  break;


  case 24: /* class_definition_head: const_definition  */
  if (yyn == 24)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":217  */
                           {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 25: /* class_definition_head: attribute_definition  */
  if (yyn == 25)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":218  */
                               {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 26: /* class_definition_head: method_definition  */
  if (yyn == 26)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":219  */
                            {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 27: /* type_definition: "type" IDENTIFIER ":=" type_expression  */
  if (yyn == 27)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":224  */
        {
		typeEnvironment.put(((String)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));
	};
  break;


  case 28: /* const_definition: "const" IDENTIFIER ":=" const_expression  */
  if (yyn == 28)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":231  */
        {
	};
  break;


  case 29: /* attribute_definition: determiner IDENTIFIER ':' type_expression ';'  */
  if (yyn == 29)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":237  */
        {
		localVarEnvironment.put(((String)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));
		yyval = new TypeExpression(Tag.FIELD, ((Type)(yystack.valueAt (1))), ((String)(yystack.valueAt (3))));
	};
  break;


  case 30: /* push_environment: %empty  */
  if (yyn == 30)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":244  */
               { 
		localVarEnvironment.push(new MapEnvironment<Type>(localVarEnvironment.getName() + '(' + localVarEnvironment.size() + ')', true)); };
  break;


  case 31: /* pop_environment: %empty  */
  if (yyn == 31)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":249  */
               { localVarEnvironment.pop(); };
  break;


  case 32: /* $@1: %empty  */
  if (yyn == 32)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":255  */
        { 
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpression(Tag.VOID));
		localVarEnvironment.put("main", type);
	};
  break;


  case 33: /* $@2: %empty  */
  if (yyn == 33)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":259  */
                         {localVarEnvironment.put(((Type)(yystack.valueAt (3))));};
  break;


  case 34: /* method_definition: "main" '(' args_definition ')' $@1 push_environment $@2 block pop_environment  */
  if (yyn == 34)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":260  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, "main"); 
		try {
			System.out.println(((Stree)(yystack.valueAt (1))).getStm());
			((Stree)(yystack.valueAt (1))).getStm().toDotFile("data/" + yystack.locationAt (8).toString() + "_main.dot");
		}
		catch (StreeException e) {
			yyerror(yystack.locationAt (8), e.getMessage());
		}
		//yyerror(@8, $8.toString());
	};
  break;


  case 35: /* $@3: %empty  */
  if (yyn == 35)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":274  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpression(Tag.VOID));
		localVarEnvironment.put(((String)(yystack.valueAt (3))), type);
	};
  break;


  case 36: /* $@4: %empty  */
  if (yyn == 36)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":278  */
                         {localVarEnvironment.put(((Type)(yystack.valueAt (3))));};
  break;


  case 37: /* method_definition: determiner IDENTIFIER '(' args_definition ')' $@3 push_environment $@4 block pop_environment  */
  if (yyn == 37)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":279  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, ((String)(yystack.valueAt (8)))); 
		try {
			System.out.println(((Stree)(yystack.valueAt (1))).getStm());
			((Stree)(yystack.valueAt (1))).getStm().toDotFile("data/" + yystack.locationAt (8).toString() + '_' + ((String)(yystack.valueAt (8))) + ".dot");
		}
		catch (StreeException e) {
			yyerror(yystack.locationAt (9), e.getMessage());
		}
		//yyerror(@9, $9.toString());
	};
  break;


  case 38: /* $@5: %empty  */
  if (yyn == 38)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":293  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpression(Tag.VOID));
		localVarEnvironment.put(((String)(yystack.valueAt (3))), type);
	};
  break;


  case 39: /* $@6: %empty  */
  if (yyn == 39)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":297  */
                         {};
  break;


  case 40: /* method_definition: determiner IDENTIFIER '(' args_definition ')' $@5 push_environment $@6 ';' pop_environment  */
  if (yyn == 40)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":298  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, ((String)(yystack.valueAt (8)))); 
	};
  break;


  case 41: /* $@7: %empty  */
  if (yyn == 41)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":304  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpression(Tag.VOID));
		localVarEnvironment.put(((String)(yystack.valueAt (3))), type);
	};
  break;


  case 42: /* $@8: %empty  */
  if (yyn == 42)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":308  */
                         {localVarEnvironment.put(((Type)(yystack.valueAt (3))));};
  break;


  case 43: /* method_definition: determiner specifier "procedure" IDENTIFIER '(' args_definition ')' $@7 push_environment $@8 block pop_environment  */
  if (yyn == 43)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":309  */
        { 
		yyval = new TypeExpression(Tag.PRODUCT, type, ((String)(yystack.valueAt (8)))); 
		try {
			System.out.println(((Stree)(yystack.valueAt (1))).getStm());
			((Stree)(yystack.valueAt (1))).getStm().toDotFile("data/" + yystack.locationAt (8).toString() + '_' + ((String)(yystack.valueAt (8))) + ".dot");
		}
		catch (StreeException e) {
			yyerror(yystack.locationAt (11), e.getMessage());
		}
		//yyerror(@11, $11.toString());
	};
  break;


  case 44: /* $@9: %empty  */
  if (yyn == 44)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":323  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (1))), new TypeExpression(Tag.VOID));
		localVarEnvironment.put(((String)(yystack.valueAt (3))), type);
	};
  break;


  case 45: /* $@10: %empty  */
  if (yyn == 45)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":327  */
                         {};
  break;


  case 46: /* method_definition: determiner specifier "procedure" IDENTIFIER '(' args_definition ')' $@9 push_environment $@10 ';' pop_environment  */
  if (yyn == 46)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":328  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, ((String)(yystack.valueAt (8)))); 
	};
  break;


  case 47: /* $@11: %empty  */
  if (yyn == 47)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":334  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0))));
		localVarEnvironment.put(((String)(yystack.valueAt (5))), type);
	};
  break;


  case 48: /* $@12: %empty  */
  if (yyn == 48)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":338  */
                         {localVarEnvironment.put(((Type)(yystack.valueAt (5))));};
  break;


  case 49: /* method_definition: determiner specifier "function" IDENTIFIER '(' args_definition ')' ':' type_expression $@11 push_environment $@12 block pop_environment  */
  if (yyn == 49)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":339  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, ((String)(yystack.valueAt (10)))); 
		try {
			System.out.println(((Stree)(yystack.valueAt (1))).getStm());
			((Stree)(yystack.valueAt (1))).getStm().toDotFile("data/" + yystack.locationAt (10).toString() + '_' + ((String)(yystack.valueAt (10))) + ".dot");
		}
		catch (StreeException e) {
			yyerror(yystack.locationAt (13), e.getMessage());
		}
		//yyerror(@13, $13.toString());
	};
  break;


  case 50: /* $@13: %empty  */
  if (yyn == 50)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":353  */
        {
		type = new TypeExpression(Tag.FUNCTION, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (0))));
		localVarEnvironment.put(((String)(yystack.valueAt (5))), type);
	};
  break;


  case 51: /* $@14: %empty  */
  if (yyn == 51)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":357  */
                         {};
  break;


  case 52: /* method_definition: determiner specifier "function" IDENTIFIER '(' args_definition ')' ':' type_expression $@13 push_environment $@14 ';' pop_environment  */
  if (yyn == 52)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":358  */
        { 
		yyval = new TypeExpression(Tag.FIELD, type, ((String)(yystack.valueAt (10)))); 
	};
  break;


  case 60: /* interface_definition: %empty  */
  if (yyn == 60)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":377  */
               {yyval = null;};
  break;


  case 61: /* interface_definition: interface_definition_head interface_definition  */
  if (yyn == 61)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":379  */
        {
		if (((Type)(yystack.valueAt (0))) == null) 
			yyval = ((Type)(yystack.valueAt (1))); 
		else 
			yyval = new TypeExpression(Tag.PRODUCT, ((Type)(yystack.valueAt (1))), ((Type)(yystack.valueAt (0)))); };
  break;


  case 62: /* interface_definition_head: "procedure" IDENTIFIER '(' args_definition ')' ';'  */
  if (yyn == 62)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":387  */
                                                           { yyval = new TypeExpression(Tag.FUNCTION); };
  break;


  case 63: /* interface_definition_head: "function" IDENTIFIER '(' args_definition ')' ':' type_expression ';'  */
  if (yyn == 63)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":388  */
                                                                                { yyval = new TypeExpression(Tag.FUNCTION); };
  break;


  case 64: /* type_expression: "char"  */
  if (yyn == 64)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":392  */
                                                                                                {yyval = new TypeExpression(Tag.CHAR);};
  break;


  case 65: /* type_expression: "integer"  */
  if (yyn == 65)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":393  */
                                                                                        {yyval = new TypeExpression(Tag.INTEGER);};
  break;


  case 66: /* type_expression: "float"  */
  if (yyn == 66)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":394  */
                                                                                                {yyval = new TypeExpression(Tag.FLOAT);};
  break;


  case 67: /* type_expression: "boolean"  */
  if (yyn == 67)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":395  */
                                                                                        {yyval = new TypeExpression(Tag.BOOLEAN);};
  break;


  case 68: /* type_expression: "string"  */
  if (yyn == 68)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":396  */
                                                                                                {yyval = new TypeExpression(Tag.STRING);};
  break;


  case 69: /* type_expression: "enum" '<' type_names '>'  */
  if (yyn == 69)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":397  */
                                                                                {yyval = new TypeExpression(Tag.ENUM, ((Type)(yystack.valueAt (1))));};
  break;


  case 70: /* type_expression: "range" '<' type_expression '>'  */
  if (yyn == 70)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":398  */
                                                                                        {yyval = new TypeExpression(Tag.RANGE, ((Type)(yystack.valueAt (1))));};
  break;


  case 71: /* type_expression: "list" '<' type_expression '>'  */
  if (yyn == 71)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":399  */
                                                                        {yyval = new TypeExpression(Tag.LIST, ((Type)(yystack.valueAt (1))));};
  break;


  case 72: /* type_expression: "set" '<' type_expression '>'  */
  if (yyn == 72)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":400  */
                                                                {yyval = new TypeExpression(Tag.SET, ((Type)(yystack.valueAt (1))));};
  break;


  case 73: /* type_expression: "map" '<' type_expression ',' type_expression '>'  */
  if (yyn == 73)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":401  */
                                                                {yyval = new TypeExpression(Tag.MAP, ((Type)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1))));};
  break;


  case 74: /* type_expression: type_expression_class  */
  if (yyn == 74)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":402  */
                                                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 75: /* type_expression_class: IDENTIFIER '<' type_expressions '>'  */
  if (yyn == 75)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":406  */
                                                        {yyval = new TypeExpression(Tag.CLASS, ((Type)(yystack.valueAt (1))), ((String)(yystack.valueAt (3))));};
  break;


  case 76: /* type_expression_class: IDENTIFIER  */
  if (yyn == 76)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":407  */
                                                                        {yyval = new TypeExpression(Tag.CLASS, ((String)(yystack.valueAt (0))));};
  break;


  case 77: /* type_expressions: type_expressions ',' type_expression  */
  if (yyn == 77)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":411  */
                                                                                        {yyval = new TypeExpression(Tag.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 78: /* type_expressions: type_expression  */
  if (yyn == 78)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":412  */
                                                                                                {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 79: /* type_names: type_names ',' type_name  */
  if (yyn == 79)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":416  */
                                                                                {yyval = new TypeExpression(Tag.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 80: /* type_names: type_name  */
  if (yyn == 80)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":417  */
                                                                                        {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 81: /* type_name: IDENTIFIER  */
  if (yyn == 81)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":421  */
                                                                                        {yyval = new TypeExpression(Tag.NAME, ((String)(yystack.valueAt (0))));};
  break;


  case 82: /* args_definition: args_definition ',' arg_definition  */
  if (yyn == 82)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":425  */
                                           {yyval = new TypeExpression(Tag.PRODUCT, ((Type)(yystack.valueAt (2))), ((Type)(yystack.valueAt (0))));};
  break;


  case 83: /* args_definition: arg_definition  */
  if (yyn == 83)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":426  */
                         {yyval = ((Type)(yystack.valueAt (0)));};
  break;


  case 84: /* arg_definition: IDENTIFIER ':' type_expression  */
  if (yyn == 84)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":431  */
        {
		yyval = new TypeExpression(Tag.FIELD, ((Type)(yystack.valueAt (0))), ((String)(yystack.valueAt (2))));
	};
  break;


  case 85: /* block: '{' var_definitions stms '}'  */
  if (yyn == 85)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":437  */
                                     { yyval = ((Stree)(yystack.valueAt (1))); };
  break;


  case 88: /* var_definition: IDENTIFIER ':' type_expression ';'  */
  if (yyn == 88)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":446  */
                                           { localVarEnvironment.put(((String)(yystack.valueAt (3))), ((Type)(yystack.valueAt (1)))); };
  break;


  case 89: /* stms: stms stm  */
  if (yyn == 89)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":450  */
                 { yyval = new StreeSEQ(((Stree)(yystack.valueAt (1))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 90: /* stms: stm  */
  if (yyn == 90)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":451  */
              { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 91: /* stm: simple_stm ';'  */
  if (yyn == 91)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":455  */
                       { yyval = ((Stree)(yystack.valueAt (1))); };
  break;


  case 92: /* stm: "if" '(' expression ')' stm  */
  if (yyn == 92)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":456  */
                                                         { yyval = new StreeIF(((Stree)(yystack.valueAt (2))), new StreeTHENELSE(((Stree)(yystack.valueAt (0))))); };
  break;


  case 93: /* stm: "if" '(' expression ')' stm "else" stm  */
  if (yyn == 93)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":457  */
                                                 { yyval = new StreeIF(((Stree)(yystack.valueAt (4))), new StreeTHENELSE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0))))); };
  break;


  case 94: /* stm: "while" '(' expression ')' stm  */
  if (yyn == 94)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":458  */
                                         { yyval = new StreeWHILE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 95: /* stm: "do" stm "while" '(' expression ')' ';'  */
  if (yyn == 95)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":459  */
                                                { yyval = new StreeDO(((Stree)(yystack.valueAt (5))), ((Stree)(yystack.valueAt (2)))); };
  break;


  case 96: /* stm: "for" '(' assigned_variable ':' expression ')' stm  */
  if (yyn == 96)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":460  */
                                                             { yyval = new StreeFOR(((Stree)(yystack.valueAt (4))), ((Stree)(yystack.valueAt (2)))); };
  break;


  case 97: /* stm: "for" '(' assignment_stm ';' expression ';' simple_stm ')' stm  */
  if (yyn == 97)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":461  */
                                                                         { yyval = new StreeFOR(((Stree)(yystack.valueAt (6))), new StreeFORCONT(((Stree)(yystack.valueAt (4))), ((Stree)(yystack.valueAt (2))))); };
  break;


  case 98: /* stm: "foreach" assigned_variable "in" expression stm  */
  if (yyn == 98)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":462  */
                                                          { yyval = new StreeFOREACH(((Stree)(yystack.valueAt (3))), new StreeFOREACHCONT(((Stree)(yystack.valueAt (1))), ((Stree)(yystack.valueAt (0))))); };
  break;


  case 99: /* stm: "switch" '(' expression ')' '{' case_stms '}'  */
  if (yyn == 99)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":463  */
                                                        { yyval = new StreeSWITCH(((Stree)(yystack.valueAt (4))), ((Stree)(yystack.valueAt (1)))); };
  break;


  case 100: /* stm: block  */
  if (yyn == 100)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":464  */
                { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 101: /* case_stms: case_stm case_stms  */
  if (yyn == 101)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":468  */
                            { yyval = new StreePRODUCT(((Stree)(yystack.valueAt (1))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 102: /* case_stms: case_stm  */
  if (yyn == 102)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":469  */
                   { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 103: /* case_stms: default_stm  */
  if (yyn == 103)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":470  */
                      { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 104: /* case_stm: "case" expression ':' stm  */
  if (yyn == 104)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":474  */
                                   { yyval = new StreeCASE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0))));  };
  break;


  case 105: /* default_stm: "default" ':' stm  */
  if (yyn == 105)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":478  */
                           { yyval = new StreeDEFAULT(((Stree)(yystack.valueAt (0))));  };
  break;


  case 106: /* assignment_stm: assigned_variable ":=" expression  */
  if (yyn == 106)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":482  */
                                          { yyval = new StreeAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 107: /* assignment_stm: IDENTIFIER ':' type_expression ":=" expression  */
  if (yyn == 107)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":483  */
                                                         { localVarEnvironment.put(((String)(yystack.valueAt (4))), ((Type)(yystack.valueAt (2)))); yyval = new StreeAFF(new StreeVARIABLE(((String)(yystack.valueAt (4))), ((Type)(yystack.valueAt (2)))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 108: /* simple_stm: assignment_stm  */
  if (yyn == 108)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":487  */
                       { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 109: /* simple_stm: assigned_variable "++"  */
  if (yyn == 109)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":488  */
                                 { yyval = new StreeSUCC(((Stree)(yystack.valueAt (1))), StreeSUCC.RIGHT); };
  break;


  case 110: /* simple_stm: assigned_variable "--"  */
  if (yyn == 110)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":489  */
                                 { yyval = new StreeDEC(((Stree)(yystack.valueAt (1))), StreeDEC.RIGHT); };
  break;


  case 111: /* simple_stm: assigned_variable "+=" expression  */
  if (yyn == 111)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":490  */
                                            { yyval = new StreePLUSAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 112: /* simple_stm: assigned_variable "-=" expression  */
  if (yyn == 112)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":491  */
                                            { yyval = new StreeMINUSAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 113: /* simple_stm: assigned_variable "*=" expression  */
  if (yyn == 113)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":492  */
                                            { yyval = new StreeTIMESAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 114: /* simple_stm: assigned_variable "/=" expression  */
  if (yyn == 114)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":493  */
                                            { yyval = new StreeDIVAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 115: /* simple_stm: assigned_variable "||=" expression  */
  if (yyn == 115)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":494  */
                                             { yyval = new StreeORAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 116: /* simple_stm: assigned_variable "&&=" expression  */
  if (yyn == 116)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":495  */
                                             { yyval = new StreeANDAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 117: /* simple_stm: assigned_variable "&=" expression  */
  if (yyn == 117)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":496  */
                                            { yyval = new StreeBANDAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 118: /* simple_stm: assigned_variable "|=" expression  */
  if (yyn == 118)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":497  */
                                            { yyval = new StreeBORAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 119: /* simple_stm: assigned_variable "<<=" expression  */
  if (yyn == 119)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":498  */
                                             { yyval = new StreeLSHIFTAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 120: /* simple_stm: assigned_variable ">>=" expression  */
  if (yyn == 120)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":499  */
                                             { yyval = new StreeRSHIFTAFF(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 121: /* simple_stm: method_name '(' args ')'  */
  if (yyn == 121)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":500  */
                                   { yyval = new StreeCALL(((Stree)(yystack.valueAt (3))), ((Stree)(yystack.valueAt (1)))); };
  break;


  case 122: /* simple_stm: "readln" '(' expression ')'  */
  if (yyn == 122)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":501  */
                                      { yyval = new StreeCALL(new StreeMETHOD("readln"), new StreeARGS(((Stree)(yystack.valueAt (1))))); };
  break;


  case 123: /* simple_stm: "write" '(' expression ')'  */
  if (yyn == 123)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":502  */
                                     { yyval = new StreeCALL(new StreeMETHOD("write"), new StreeARGS(((Stree)(yystack.valueAt (1))))); };
  break;


  case 124: /* simple_stm: "writeln" '(' expression ')'  */
  if (yyn == 124)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":503  */
                                       { yyval = new StreeCALL(new StreeMETHOD("writeln"), new StreeARGS(((Stree)(yystack.valueAt (1))))); };
  break;


  case 125: /* simple_stm: "break"  */
  if (yyn == 125)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":504  */
                  { yyval = new StreeBREAK(); };
  break;


  case 126: /* simple_stm: "continue"  */
  if (yyn == 126)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":505  */
                     { yyval = new StreeCONTINUE(); };
  break;


  case 127: /* simple_stm: "return" expression  */
  if (yyn == 127)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":506  */
                              { yyval = new StreeRETURN(((Stree)(yystack.valueAt (0)))); };
  break;


  case 128: /* assigned_variable: IDENTIFIER  */
  if (yyn == 128)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":513  */
        {
		try {
			Type localType = localVarEnvironment.get(((String)(yystack.valueAt (0))));
			if (localType == null)
				localType = varEnvironment.get(((String)(yystack.valueAt (0))));
			if (localType == null)
				throw new EnvironmentException("unknown variable " + ((String)(yystack.valueAt (0))));
			yyval = new StreeVARIABLE(((String)(yystack.valueAt (0))), localType);
		}
		catch (EnvironmentException environmentException) {
			yyerror ("*** unknown variable: " + ((String)(yystack.valueAt (0))) + " " + environmentException.getMessage());
			yyval = null;
		}
	};
  break;


  case 129: /* assigned_variable: IDENTIFIER '[' args ']'  */
  if (yyn == 129)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":529  */
        {
		yyval = null;
		yyerror(yystack.locationAt (3), "not yet implemented");
	};
  break;


  case 130: /* assigned_variable: assigned_variable '.' IDENTIFIER  */
  if (yyn == 130)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":535  */
        {
		yyval = new StreeSLOT(((Stree)(yystack.valueAt (2))), ((String)(yystack.valueAt (0))));
		yyerror(yystack.locationAt (2), "not yet implemented");
	};
  break;


  case 131: /* assigned_variable: "this"  */
  if (yyn == 131)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":541  */
        {
		yyval = new StreeTHIS();
		yyerror(yystack.locationAt (0), "not yet implemented");
	};
  break;


  case 132: /* method_name: IDENTIFIER  */
  if (yyn == 132)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":549  */
        {
		type = localVarEnvironment.get(((String)(yystack.valueAt (0))));
		if (type == null)
			type = varEnvironment.get(((String)(yystack.valueAt (0))));
		if (type == null)
			throw new EnvironmentException("unknown variable " + ((String)(yystack.valueAt (0))));
		yyval = new StreeMETHOD(((String)(yystack.valueAt (0))), type);
	};
  break;


  case 133: /* method_name: assigned_variable '.' IDENTIFIER  */
  if (yyn == 133)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":557  */
                                           { yyval = new StreeSLOT(((Stree)(yystack.valueAt (2))), ((String)(yystack.valueAt (0)))); };
  break;


  case 134: /* args: args ',' expression  */
  if (yyn == 134)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":561  */
                            {yyval = new StreeARGS(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0))));};
  break;


  case 135: /* args: expression  */
  if (yyn == 135)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":562  */
                     { yyval = yyval = new StreeARGS(((Stree)(yystack.valueAt (0))), null);};
  break;


  case 136: /* const_expression: "null"  */
  if (yyn == 136)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":566  */
               {yyval = new StreeNULL(); };
  break;


  case 137: /* const_expression: CONSTANT_INTEGER  */
  if (yyn == 137)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":567  */
                           {yyval = new StreeINTEGER(((Integer)(yystack.valueAt (0)))); };
  break;


  case 138: /* const_expression: CONSTANT_FLOAT  */
  if (yyn == 138)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":568  */
                         {yyval = new StreeFLOAT(((Float)(yystack.valueAt (0)))); };
  break;


  case 139: /* const_expression: CONSTANT_CHAR  */
  if (yyn == 139)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":569  */
                         {yyval = new StreeCHAR(((Integer)(yystack.valueAt (0)))); };
  break;


  case 140: /* const_expression: CONSTANT_STRING  */
  if (yyn == 140)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":570  */
                           {yyval = new StreeSTRING(((String)(yystack.valueAt (0)))); };
  break;


  case 141: /* const_expression: '[' const_expression ".." const_expression ']'  */
  if (yyn == 141)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":571  */
                                                         {yyval = new StreeRANGE(((Stree)(yystack.valueAt (3))), ((Stree)(yystack.valueAt (1)))); };
  break;


  case 142: /* expression: const_expression  */
  if (yyn == 142)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":575  */
                                                                { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 143: /* expression: assigned_variable  */
  if (yyn == 143)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":576  */
                                                { yyval = ((Stree)(yystack.valueAt (0))); };
  break;


  case 144: /* expression: method_name '(' args ')'  */
  if (yyn == 144)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":577  */
                                        { yyval = new StreeCALL(((Stree)(yystack.valueAt (3))), ((Stree)(yystack.valueAt (1)))); };
  break;


  case 145: /* expression: "new" type_expression_class '(' args_opt ')'  */
  if (yyn == 145)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":578  */
                                                                        { yyval = new StreeNEW(((Type)(yystack.valueAt (3))), ((Stree)(yystack.valueAt (1)))); };
  break;


  case 146: /* expression: expression "&&" expression  */
  if (yyn == 146)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":579  */
                                                                { yyval = new StreeAND(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 147: /* expression: expression "||" expression  */
  if (yyn == 147)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":580  */
                                                                { yyval = new StreeOR(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 148: /* expression: '!' expression  */
  if (yyn == 148)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":581  */
                                                                { yyval = new StreeNOT(((Stree)(yystack.valueAt (0)))); };
  break;


  case 149: /* expression: expression '<' expression  */
  if (yyn == 149)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":582  */
                                                                { yyval = new StreeLT(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 150: /* expression: expression "<=" expression  */
  if (yyn == 150)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":583  */
                                                        { yyval = new StreeLE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 151: /* expression: expression '>' expression  */
  if (yyn == 151)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":584  */
                                                                { yyval = new StreeGT(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 152: /* expression: expression ">=" expression  */
  if (yyn == 152)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":585  */
                                                        { yyval = new StreeGE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 153: /* expression: expression "==" expression  */
  if (yyn == 153)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":586  */
                                                        { yyval = new StreeEQ(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 154: /* expression: expression "!=" expression  */
  if (yyn == 154)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":587  */
                                                        { yyval = new StreeNE(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 155: /* expression: expression '+' expression  */
  if (yyn == 155)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":588  */
                                                        { yyval = new StreePLUS(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 156: /* expression: expression '-' expression  */
  if (yyn == 156)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":589  */
                                                            { yyval = new StreeMINUS(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 157: /* expression: '-' expression  */
  if (yyn == 157)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":590  */
                                                { yyval = new StreeMINUS(((Stree)(yystack.valueAt (0)))); };
  break;


  case 158: /* expression: expression '*' expression  */
  if (yyn == 158)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":591  */
                                                        { yyval = new StreeTIMES(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 159: /* expression: expression '/' expression  */
  if (yyn == 159)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":592  */
                                                            { yyval = new StreeDIV(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 160: /* expression: expression "++"  */
  if (yyn == 160)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":593  */
                                                        { yyval = new StreeSUCC(((Stree)(yystack.valueAt (1))), StreeSUCC.RIGHT); };
  break;


  case 161: /* expression: expression "--"  */
  if (yyn == 161)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":594  */
                                                                { yyval = new StreeDEC(((Stree)(yystack.valueAt (1))), StreeDEC.RIGHT); };
  break;


  case 162: /* expression: "++" expression  */
  if (yyn == 162)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":595  */
                                                                { yyval = new StreeSUCC(((Stree)(yystack.valueAt (0))), StreeSUCC.LEFT); };
  break;


  case 163: /* expression: "--" expression  */
  if (yyn == 163)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":596  */
                                                        { yyval = new StreeDEC(((Stree)(yystack.valueAt (0))), StreeDEC.LEFT); };
  break;


  case 164: /* expression: expression '&' expression  */
  if (yyn == 164)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":597  */
                                                        { yyval = new StreeAND(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 165: /* expression: expression '|' expression  */
  if (yyn == 165)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":598  */
                                                        { yyval = new StreeOR(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 166: /* expression: expression "<<" expression  */
  if (yyn == 166)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":599  */
                                                { yyval = new StreeLSHIFT(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 167: /* expression: expression ">>" expression  */
  if (yyn == 167)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":600  */
                                                { yyval = new StreeRSHIFT(((Stree)(yystack.valueAt (2))), ((Stree)(yystack.valueAt (0)))); };
  break;


  case 168: /* expression: '(' expression ')'  */
  if (yyn == 168)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":601  */
                                                {yyval = ((Stree)(yystack.valueAt (1)));};
  break;


  case 169: /* args_opt: %empty  */
  if (yyn == 169)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":605  */
               {yyval = null;};
  break;


  case 170: /* args_opt: args  */
  if (yyn == 170)
    /* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":606  */
               {yyval = ((Stree)(yystack.valueAt (0)));};
  break;



/* "/home/leon/travail/cremi/compil/projet/projet-20210420/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":2102  */

        default: break;
      }

    yySymbolPrint("-> $$ =", SymbolKind.get(yyr1_[yyn]), yyval, yyloc);

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval, yyloc);
    return YYNEWSTATE;
  }


  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yySymbolPrint(String s, SymbolKind yykind,
                             Object yyvalue, Location yylocation) {
      if (0 < yydebug) {
          yycdebug(s
                   + (yykind.getCode() < YYNTOKENS_ ? " token " : " nterm ")
                   + yykind.getName() + " ("
                   + yylocation + ": "
                   + (yyvalue == null ? "(null)" : yyvalue.toString()) + ")");
      }
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException, EnvironmentException, TypeException, StreeException

  {
    /* @$.  */
    Location yyloc;


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;


    /* The location where the error started.  */
    Location yyerrloc = null;

    /* Location. */
    Location yylloc = new Location (null, null);

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse");
    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval, yylloc);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate);
        if (0 < yydebug)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yycdebug ("Reading a token");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();
            yylloc = new Location(yylexer.getStartPos(),
                                          yylexer.getEndPos());

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);
        yySymbolPrint("Next token is", yytoken,
                      yylval, yylloc);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            yyerrloc = yylloc;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
              label = YYDEFAULT;

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError (yyn))
                  label = YYERRLAB;
                else
                  {
                    yyn = -yyn;
                    label = YYREDUCE;
                  }
              }

            else
              {
                /* Shift the lookahead token.  */
                yySymbolPrint("Shifting", yytoken,
                              yylval, yylloc);

                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push (yystate, yylval, yylloc);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError (new Context (yystack, yytoken, yylloc));
          }

        yyerrloc = yylloc;
        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        yyerrloc = yystack.locationAt (yylen - 1);
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yyerrloc = yystack.locationAt (0);
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (0 < yydebug)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;


        /* Muck with the stack to setup for yylloc.  */
        yystack.push (0, null, yylloc);
        yystack.push (0, null, yyerrloc);
        yyloc = yylloc (yystack, 2);
        yystack.pop (2);

        /* Shift the error token.  */
        yySymbolPrint("Shifting", SymbolKind.get(yystos_[yyn]),
                      yylval, yyloc);

        yystate = yyn;
        yystack.push (yyn, yylval, yyloc);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context
  {
    Context (YYStack stack, SymbolKind token, Location loc)
    {
      yystack = stack;
      yytoken = token;
      yylocation = loc;
    }

    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken ()
    {
      return yytoken;
    }

    private SymbolKind yytoken;

    /**
     * The location of the lookahead.
     */
    public final Location getLocation ()
    {
      return yylocation;
    }

    private Location yylocation;
    static final int NTOKENS = Parser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens (SymbolKind yyarg[], int yyargn)
    {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens (SymbolKind yyarg[], int yyoffset, int yyargn)
    {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt (0)];
      if (!yyPactValueIsDefault (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }



  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      yylexer.reportSyntaxError(yyctx);
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -201;
  private static final short yytable_ninf_ = -134;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
    -201,    86,    73,  -201,   -44,   -38,    45,  -201,    95,  -201,
      52,   117,  -201,   128,  -201,  -201,    97,   135,    97,    99,
      74,    96,   106,  -201,   168,   109,  -201,  -201,   136,   111,
    -201,  -201,  -201,   139,  -201,    74,  -201,  -201,  -201,  -201,
       8,    97,    97,    97,  -201,   -18,   212,   144,   217,   125,
    -201,  -201,  -201,   -53,    67,   -39,  -201,  -201,    74,   155,
     156,  -201,   -18,   -19,   151,    64,  -201,   937,  -201,   937,
     144,   158,   159,  -201,  -201,   137,   138,   145,  -201,  -201,
    -201,  -201,  -201,  -201,   -19,  -201,   937,   144,  -201,  -201,
    -201,   160,  -201,  -201,   161,   166,   167,   180,  -201,   181,
    -201,  -201,   164,    71,   143,   174,   169,   144,   144,  -201,
     245,  -201,  -201,  -201,   207,   937,   937,   937,   937,   937,
    -201,   182,   144,   144,  -201,    76,    78,   -19,  -201,  -201,
      55,  -201,   199,   187,   203,   228,    58,  -201,  -201,  -201,
      83,    84,   239,   220,   218,   224,  -201,   207,  -201,   937,
    -201,  -201,  -201,   937,  -201,  -201,   243,   225,   937,  -201,
    -201,  -201,  -201,  -201,   238,  -201,   224,   226,   937,  -201,
    -201,   227,   865,  -201,  -201,  -201,  -201,   229,  -201,  -201,
    -201,  -201,  -201,   911,   230,     9,   231,   232,    23,   242,
    -201,   244,   248,   249,    34,    56,   250,  -201,   852,  -201,
     246,  -201,  -201,  -201,  -201,  -201,  -201,   224,   253,    35,
     255,    44,   241,   -29,    23,    23,    23,    23,   256,    39,
      23,    23,    23,  -201,   736,   247,   257,    23,    23,    23,
      23,   937,    23,    23,    23,    23,    23,    23,    23,    23,
      23,    23,    23,    23,  -201,  -201,   283,    23,  -201,  -201,
    -201,  -201,  -201,  -201,  -201,   937,   258,   -70,     1,   260,
      23,   289,   252,   291,    -9,    -9,   264,   778,    -9,   377,
    -201,  -201,    23,    23,    23,    23,    23,    23,    23,    23,
      23,    23,    23,    23,    23,    23,    23,    23,    23,   395,
     413,   431,   517,     2,   736,    60,   736,   736,   736,   736,
     736,   736,   736,   736,   736,   736,   736,   267,    90,   224,
     269,  -201,  -201,   362,    23,    23,    23,   655,  -201,   911,
    -201,    23,  -201,   778,   766,   179,   179,   790,   790,   790,
     790,   790,   790,   266,   266,    14,    14,    -4,   179,    91,
     273,  -201,  -201,   911,    23,  -201,    23,  -201,  -201,  -201,
    -201,   535,   553,   571,  -201,   333,   274,   270,  -201,   126,
    -201,   736,   736,  -201,  -201,   275,   911,   942,   911,  -201,
      23,   294,   284,   126,  -201,  -201,  -201,   281,  -201,   686,
     911,  -201,  -201,   911,   911,  -201,  -201,  -201
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final short[] yydefact_ = yydefact_init();
  private static final short[] yydefact_init()
  {
    return new short[]
    {
       3,     0,     0,     1,     0,     0,     0,     4,     2,     7,
       0,    11,     5,    15,     6,    30,     0,    13,     0,     0,
      53,    19,    12,    18,    53,     0,    16,    30,     0,     0,
      54,    56,    55,     0,    31,    53,    24,    25,    26,    23,
      57,     0,     0,     0,    30,    60,     0,     0,     0,     0,
      22,    59,    58,     0,     0,     0,    17,    14,    53,     0,
       0,    31,    60,     0,     0,     0,    83,     0,     9,     0,
       0,     0,     0,    20,    31,     0,     0,     0,    61,   136,
     140,   137,   139,   138,     0,    28,     0,     0,    32,    67,
      64,     0,    66,    65,     0,     0,     0,     0,    68,    76,
      27,    74,     0,     0,     0,     0,     0,     0,     0,    10,
       0,    84,    82,    30,     0,     0,     0,     0,     0,     0,
      29,    35,     0,     0,     8,     0,     0,     0,    33,    81,
       0,    80,     0,     0,     0,     0,     0,    78,    30,    30,
       0,     0,     0,     0,     0,     0,    69,     0,    71,     0,
      70,    72,    75,     0,    36,    39,     0,    41,     0,    62,
     141,    86,    31,    79,     0,    77,     0,     0,     0,    30,
      30,     0,     0,    34,    73,    31,    31,    47,    42,    45,
      63,   125,   126,     0,     0,     0,     0,     0,     0,     0,
     131,     0,     0,     0,   128,     0,     0,   100,     0,    90,
       0,   108,    87,    37,    40,    30,    30,     0,     0,   128,
       0,     0,   128,     0,     0,     0,     0,     0,     0,   128,
       0,     0,     0,   142,   127,   143,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,   109,   110,     0,     0,    85,    89,
      91,    48,    51,    31,    31,     0,     0,   128,     0,     0,
       0,     0,     0,     0,   162,   163,     0,   148,   157,     0,
     160,   161,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,   135,     0,   106,   111,   112,   113,
     114,   115,   116,   117,   118,   119,   120,   130,     0,     0,
       0,    43,    46,     0,     0,     0,     0,     0,   130,     0,
     122,   169,   168,   146,   147,   166,   167,   153,   150,   152,
     154,   149,   151,   155,   156,   158,   159,   165,   164,     0,
       0,   123,   124,     0,     0,    88,     0,   129,   121,    31,
      31,     0,     0,     0,    98,    92,   170,     0,   144,     0,
      94,   107,   134,    49,    52,     0,     0,     0,     0,   145,
       0,     0,     0,   102,   103,    95,    96,     0,    93,     0,
       0,    99,   101,     0,     0,   105,    97,   104
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -201,  -201,   -66,   165,  -201,   235,    21,   299,   325,  -201,
     -14,  -201,  -201,  -201,  -201,    10,    18,  -171,  -200,  -201,
    -166,  -143,  -201,  -161,    22,   192,    17,  -201,  -201,  -201,
    -201,  -201,  -201,   390,  -201,  -201,  -201,   363,     0,  -201,
     -20,   -61,  -201,  -201,  -201,  -201,  -201,  -201,  -201,  -201,
    -201,  -201,  -201,  -201,  -201,  -201,   381,  -201,  -201,  -201
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short[] yydefgoto_ = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,   136,   100,   101,   130,   131,    65,    66,    61,    62,
      34,    35,    36,    37,    38,   223,   294,   225,   295,   357,
     226,   197,   198,   199,   200,   201,   372,   373,   374,     1,
       2,     7,     8,     9,    17,    25,    19,    22,    23,    39,
      20,    49,   113,   145,   138,   166,   139,   167,   169,   207,
     170,   208,   205,   309,   206,   310,    40,    54,   172,   202
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      77,   195,   162,   102,   233,   344,   196,    45,   255,    10,
     274,   275,   195,   106,   213,   274,   275,   196,    26,   260,
     111,    50,   210,   175,    58,    69,    59,   195,    11,   270,
     271,   232,   196,   274,   275,    12,    79,   249,   216,   217,
     258,    60,    56,    57,    74,    73,    70,   308,    51,   132,
     133,   134,   135,   137,    80,    81,    82,    83,    42,   233,
     234,   235,   236,   237,   253,   238,   239,   240,   241,   242,
     243,   244,   245,    85,   261,   190,    52,   218,    79,   315,
      53,   212,    84,   164,   286,   287,     3,   165,   339,   190,
     287,   103,   171,   128,   110,   219,    80,    81,    82,    83,
     345,   173,   177,     4,   261,   220,    28,   286,   287,   221,
     190,    71,   231,   255,   203,   204,   257,    13,   154,   155,
       5,   356,   222,     6,    84,     4,    72,    29,   125,   126,
      30,    31,    32,  -132,  -132,   232,   232,   144,  -132,   146,
     232,    33,   152,   140,   141,     6,   195,    15,   195,   178,
     179,   196,   147,   196,   370,   153,   354,   346,   355,   246,
     371,    87,   347,    16,    88,   293,   349,    18,    87,    21,
     -21,   121,   195,    87,    24,    87,   142,   196,   143,    41,
      87,    87,   360,   156,   157,   251,   252,   346,   346,   313,
     348,   358,   311,   312,    27,   195,   195,   195,   274,   275,
     196,   196,   196,    42,    44,   376,   224,   378,    46,   195,
      47,    48,   195,   195,   196,    63,    64,   196,   196,   385,
      67,    68,   386,   387,    30,    31,    32,    75,    76,    86,
     104,   105,   262,   263,   264,   265,   107,   108,   267,   268,
     269,   109,   122,   114,   115,   289,   290,   291,   292,   116,
     117,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   120,   118,   119,   124,   127,   270,   271,   272,
     273,   274,   275,   123,   276,   277,   278,   279,   317,   129,
     -38,   270,   271,   148,   149,   274,   275,   150,   363,   364,
     323,   324,   325,   326,   327,   328,   329,   330,   331,   332,
     333,   334,   335,   336,   337,   338,   270,   271,   272,   273,
     274,   275,   151,   276,   277,   278,   279,   158,   159,   161,
     160,   168,   174,   -44,   176,   180,   256,   -50,    99,   211,
     214,   215,   351,   352,   353,   280,   281,   282,   283,   284,
     285,   227,   232,   228,   250,   286,   287,   229,   230,   247,
     246,   254,   319,   284,   285,   307,   288,   314,   316,   286,
     287,   318,   361,   321,   362,   344,  -133,   350,   359,   368,
     369,   346,   380,   375,   280,   281,   282,   283,   284,   285,
     381,   383,   163,   266,   286,   287,   112,    78,   379,   377,
     382,   320,   270,   271,   272,   273,   274,   275,    14,   276,
     277,   278,   279,   259,    55,    43,     0,     0,     0,     0,
     270,   271,   272,   273,   274,   275,     0,   276,   277,   278,
     279,     0,     0,     0,     0,     0,     0,     0,   270,   271,
     272,   273,   274,   275,     0,   276,   277,   278,   279,     0,
       0,     0,     0,     0,     0,     0,   270,   271,   272,   273,
     274,   275,     0,   276,   277,   278,   279,     0,     0,     0,
     280,   281,   282,   283,   284,   285,     0,     0,     0,     0,
     286,   287,     0,     0,     0,     0,     0,   322,   280,   281,
     282,   283,   284,   285,     0,     0,     0,     0,   286,   287,
       0,     0,     0,     0,     0,   340,   280,   281,   282,   283,
     284,   285,     0,     0,     0,     0,   286,   287,     0,     0,
       0,     0,     0,   341,   280,   281,   282,   283,   284,   285,
       0,     0,     0,     0,   286,   287,     0,     0,     0,     0,
       0,   342,   270,   271,   272,   273,   274,   275,     0,   276,
     277,   278,   279,     0,     0,     0,     0,     0,     0,     0,
     270,   271,   272,   273,   274,   275,     0,   276,   277,   278,
     279,     0,     0,     0,     0,     0,     0,     0,   270,   271,
     272,   273,   274,   275,     0,   276,   277,   278,   279,     0,
       0,     0,     0,     0,     0,     0,   270,   271,   272,   273,
     274,   275,     0,   276,   277,   278,   279,     0,     0,     0,
     280,   281,   282,   283,   284,   285,     0,     0,     0,     0,
     286,   287,     0,     0,     0,     0,     0,   343,   280,   281,
     282,   283,   284,   285,     0,     0,     0,     0,   286,   287,
       0,     0,     0,     0,     0,   365,   280,   281,   282,   283,
     284,   285,     0,     0,     0,     0,   286,   287,     0,     0,
       0,     0,     0,   366,   280,   281,   282,   283,   284,   285,
       0,     0,     0,     0,   286,   287,     0,     0,     0,   367,
     270,   271,   272,   273,   274,   275,     0,   276,   277,   278,
     279,     0,   181,     0,     0,     0,     0,     0,   182,     0,
     183,     0,     0,     0,     0,     0,     0,   184,   185,     0,
     186,   270,   271,   272,   273,   274,   275,     0,   276,   277,
     278,   279,     0,     0,     0,     0,   187,   188,     0,     0,
     189,   190,     0,     0,   191,   192,   193,   209,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,   280,   281,
     282,   283,   284,   285,     0,     0,     0,     0,   286,   287,
     161,   270,   271,   272,   273,   274,   275,     0,   276,   277,
     278,   279,     0,     0,   384,     0,     0,     0,     0,   280,
     281,   282,   283,   284,   285,     0,     0,     0,     0,   286,
     287,   270,   271,   272,     0,   274,   275,     0,   276,   277,
     278,   279,     0,   270,   271,     0,     0,   274,   275,     0,
     276,   277,   278,   279,     0,   270,   271,     0,     0,   274,
     275,     0,  -134,  -134,  -134,  -134,     0,     0,     0,   280,
     281,   282,   283,   284,   285,     0,     0,     0,     0,   286,
     287,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,   280,
     281,   282,   283,   284,   285,     0,     0,     0,     0,   286,
     287,   280,   281,   282,   283,   284,   285,     0,     0,     0,
       0,   286,   287,  -134,  -134,   282,   283,   284,   285,   181,
       0,     0,     0,   286,   287,   182,     0,   183,     0,     0,
       0,     0,   181,     0,   184,   185,     0,   186,   182,     0,
     183,     0,     0,     0,     0,     0,     0,   184,   185,     0,
     186,     0,     0,   187,   188,     0,     0,   189,   190,     0,
       0,   191,   192,   193,   209,     0,   187,   188,     0,     0,
     189,   190,     0,     0,   191,   192,   193,   194,   181,     0,
       0,     0,     0,     0,   182,     0,   183,   161,   248,     0,
       0,     0,     0,   184,   185,     0,   186,     0,     0,     0,
     161,     0,     0,    89,     0,     0,    90,     0,     0,   181,
       0,     0,   187,   188,    91,   182,   189,   190,    92,     0,
     191,   192,   193,   209,     0,     0,    93,     0,    94,    95,
       0,     0,     0,     0,     0,     0,     0,    96,     0,     0,
      97,    98,     0,   187,   188,     0,   161,     0,   190,    99,
       0,   191,   192,     0,   209
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      61,   172,   145,    69,     3,     3,   172,    27,    78,    53,
      19,    20,   183,    74,   185,    19,    20,   183,    18,    48,
      86,    35,   183,   166,    44,    78,    44,   198,    72,    15,
      16,   101,   198,    19,    20,    73,    55,   198,    15,    16,
     211,    59,    42,    43,    58,    84,    99,   247,    40,   115,
     116,   117,   118,   119,    73,    74,    75,    76,    97,     3,
       4,     5,     6,     7,   207,     9,    10,    11,    12,    13,
      14,    15,    16,    63,   103,    66,    68,    54,    55,    78,
      72,    72,   101,   149,    93,    94,     0,   153,   288,    66,
      94,    70,   158,   113,    84,    72,    73,    74,    75,    76,
      98,   162,   168,    30,   103,    82,    32,    93,    94,    86,
      66,    44,    78,    78,   175,   176,    72,    72,   138,   139,
      47,   321,    99,    50,   101,    30,    59,    53,   107,   108,
      56,    57,    58,    99,    99,   101,   101,   127,    99,    84,
     101,    67,    84,   122,   123,    50,   317,    95,   319,   169,
     170,   317,    97,   319,    28,    97,   317,    97,   319,   103,
      34,    97,   102,    46,   100,   231,   309,    39,    97,    72,
      96,   100,   343,    97,    39,    97,   100,   343,   100,    83,
      97,    97,   343,   100,   100,   205,   206,    97,    97,   255,
     100,   100,   253,   254,    95,   366,   367,   368,    19,    20,
     366,   367,   368,    97,    95,   366,   188,   368,    72,   380,
      99,    72,   383,   384,   380,     3,    72,   383,   384,   380,
       3,    96,   383,   384,    56,    57,    58,    72,    72,    78,
      72,    72,   214,   215,   216,   217,    99,    99,   220,   221,
     222,    96,    99,    83,    83,   227,   228,   229,   230,    83,
      83,   233,   234,   235,   236,   237,   238,   239,   240,   241,
     242,   243,    98,    83,    83,    96,    21,    15,    16,    17,
      18,    19,    20,    99,    22,    23,    24,    25,   260,    72,
      98,    15,    16,    84,    97,    19,    20,    84,   349,   350,
     272,   273,   274,   275,   276,   277,   278,   279,   280,   281,
     282,   283,   284,   285,   286,   287,    15,    16,    17,    18,
      19,    20,    84,    22,    23,    24,    25,    78,    98,    95,
     102,    78,    84,    98,    98,    98,    71,    98,    72,    99,
      99,    99,   314,   315,   316,    83,    84,    85,    86,    87,
      88,    99,   101,    99,    98,    93,    94,    99,    99,    99,
     103,    98,   100,    87,    88,    72,    99,    99,    98,    93,
      94,    72,   344,    99,   346,     3,    99,    98,    95,    36,
     100,    97,    78,    98,    83,    84,    85,    86,    87,    88,
      96,   100,   147,   218,    93,    94,    87,    62,   370,   367,
     373,   100,    15,    16,    17,    18,    19,    20,     8,    22,
      23,    24,    25,   211,    41,    24,    -1,    -1,    -1,    -1,
      15,    16,    17,    18,    19,    20,    -1,    22,    23,    24,
      25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    15,    16,
      17,    18,    19,    20,    -1,    22,    23,    24,    25,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    15,    16,    17,    18,
      19,    20,    -1,    22,    23,    24,    25,    -1,    -1,    -1,
      83,    84,    85,    86,    87,    88,    -1,    -1,    -1,    -1,
      93,    94,    -1,    -1,    -1,    -1,    -1,   100,    83,    84,
      85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,    94,
      -1,    -1,    -1,    -1,    -1,   100,    83,    84,    85,    86,
      87,    88,    -1,    -1,    -1,    -1,    93,    94,    -1,    -1,
      -1,    -1,    -1,   100,    83,    84,    85,    86,    87,    88,
      -1,    -1,    -1,    -1,    93,    94,    -1,    -1,    -1,    -1,
      -1,   100,    15,    16,    17,    18,    19,    20,    -1,    22,
      23,    24,    25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      15,    16,    17,    18,    19,    20,    -1,    22,    23,    24,
      25,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    15,    16,
      17,    18,    19,    20,    -1,    22,    23,    24,    25,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    15,    16,    17,    18,
      19,    20,    -1,    22,    23,    24,    25,    -1,    -1,    -1,
      83,    84,    85,    86,    87,    88,    -1,    -1,    -1,    -1,
      93,    94,    -1,    -1,    -1,    -1,    -1,   100,    83,    84,
      85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,    94,
      -1,    -1,    -1,    -1,    -1,   100,    83,    84,    85,    86,
      87,    88,    -1,    -1,    -1,    -1,    93,    94,    -1,    -1,
      -1,    -1,    -1,   100,    83,    84,    85,    86,    87,    88,
      -1,    -1,    -1,    -1,    93,    94,    -1,    -1,    -1,    98,
      15,    16,    17,    18,    19,    20,    -1,    22,    23,    24,
      25,    -1,    27,    -1,    -1,    -1,    -1,    -1,    33,    -1,
      35,    -1,    -1,    -1,    -1,    -1,    -1,    42,    43,    -1,
      45,    15,    16,    17,    18,    19,    20,    -1,    22,    23,
      24,    25,    -1,    -1,    -1,    -1,    61,    62,    -1,    -1,
      65,    66,    -1,    -1,    69,    70,    71,    72,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    83,    84,
      85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,    94,
      95,    15,    16,    17,    18,    19,    20,    -1,    22,    23,
      24,    25,    -1,    -1,    78,    -1,    -1,    -1,    -1,    83,
      84,    85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,
      94,    15,    16,    17,    -1,    19,    20,    -1,    22,    23,
      24,    25,    -1,    15,    16,    -1,    -1,    19,    20,    -1,
      22,    23,    24,    25,    -1,    15,    16,    -1,    -1,    19,
      20,    -1,    22,    23,    24,    25,    -1,    -1,    -1,    83,
      84,    85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,
      94,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    83,
      84,    85,    86,    87,    88,    -1,    -1,    -1,    -1,    93,
      94,    83,    84,    85,    86,    87,    88,    -1,    -1,    -1,
      -1,    93,    94,    83,    84,    85,    86,    87,    88,    27,
      -1,    -1,    -1,    93,    94,    33,    -1,    35,    -1,    -1,
      -1,    -1,    27,    -1,    42,    43,    -1,    45,    33,    -1,
      35,    -1,    -1,    -1,    -1,    -1,    -1,    42,    43,    -1,
      45,    -1,    -1,    61,    62,    -1,    -1,    65,    66,    -1,
      -1,    69,    70,    71,    72,    -1,    61,    62,    -1,    -1,
      65,    66,    -1,    -1,    69,    70,    71,    72,    27,    -1,
      -1,    -1,    -1,    -1,    33,    -1,    35,    95,    96,    -1,
      -1,    -1,    -1,    42,    43,    -1,    45,    -1,    -1,    -1,
      95,    -1,    -1,    26,    -1,    -1,    29,    -1,    -1,    27,
      -1,    -1,    61,    62,    37,    33,    65,    66,    41,    -1,
      69,    70,    71,    72,    -1,    -1,    49,    -1,    51,    52,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    60,    -1,    -1,
      63,    64,    -1,    61,    62,    -1,    95,    -1,    66,    72,
      -1,    69,    70,    -1,    72
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final short[] yystos_ = yystos_init();
  private static final short[] yystos_init()
  {
    return new short[]
    {
       0,   133,   134,     0,    30,    47,    50,   135,   136,   137,
      53,    72,    73,    72,   137,    95,    46,   138,    39,   140,
     144,    72,   141,   142,    39,   139,   142,    95,    32,    53,
      56,    57,    58,    67,   114,   115,   116,   117,   118,   143,
     160,    83,    97,   160,    95,   144,    72,    99,    72,   145,
     114,    40,    68,    72,   161,   141,   142,   142,   144,    44,
      59,   112,   113,     3,    72,   110,   111,     3,    96,    78,
      99,    44,    59,    84,   114,    72,    72,   145,   112,    55,
      73,    74,    75,    76,   101,   119,    78,    97,   100,    26,
      29,    37,    41,    49,    51,    52,    60,    63,    64,    72,
     106,   107,   106,   110,    72,    72,   145,    99,    99,    96,
     119,   106,   111,   146,    83,    83,    83,    83,    83,    83,
      98,   100,    99,    99,    96,   110,   110,    21,   144,    72,
     108,   109,   106,   106,   106,   106,   105,   106,   148,   150,
     110,   110,   100,   100,   119,   147,    84,    97,    84,    97,
      84,    84,    84,    97,   144,   144,   100,   100,    78,    98,
     102,    95,   125,   109,   106,   106,   149,   151,    78,   152,
     154,   106,   162,   145,    84,   125,    98,   106,   144,   144,
      98,    27,    33,    35,    42,    43,    45,    61,    62,    65,
      66,    69,    70,    71,    72,   121,   124,   125,   126,   127,
     128,   129,   163,   145,   145,   156,   158,   153,   155,    72,
     127,    99,    72,   121,    99,    99,    15,    16,    54,    72,
      82,    86,    99,   119,   120,   121,   124,    99,    99,    99,
      99,    78,   101,     3,     4,     5,     6,     7,     9,    10,
      11,    12,    13,    14,    15,    16,   103,    99,    96,   127,
      98,   144,   144,   125,    98,    78,    71,    72,   121,   129,
      48,   103,   120,   120,   120,   120,   107,   120,   120,   120,
      15,    16,    17,    18,    19,    20,    22,    23,    24,    25,
      83,    84,    85,    86,    87,    88,    93,    94,    99,   120,
     120,   120,   120,   106,   120,   122,   120,   120,   120,   120,
     120,   120,   120,   120,   120,   120,   120,    72,   122,   157,
     159,   145,   145,   106,    99,    78,    98,   120,    72,   100,
     100,    99,   100,   120,   120,   120,   120,   120,   120,   120,
     120,   120,   120,   120,   120,   120,   120,   120,   120,   122,
     100,   100,   100,   100,     3,    98,    97,   102,   100,   125,
      98,   120,   120,   120,   127,   127,   122,   123,   100,    95,
     127,   120,   120,   145,   145,   100,   100,    98,    36,   100,
      28,    34,   130,   131,   132,    98,   127,   128,   127,   120,
      78,    96,   130,   100,    78,   127,   127,   127
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final short[] yyr1_ = yyr1_init();
  private static final short[] yyr1_init()
  {
    return new short[]
    {
       0,   104,   133,   134,   134,   135,   136,   136,   137,   137,
     137,   138,   138,   139,   139,   140,   140,   141,   141,   142,
     142,   114,   114,   115,   115,   115,   115,   143,   116,   117,
     144,   145,   146,   147,   118,   148,   149,   118,   150,   151,
     118,   152,   153,   118,   154,   155,   118,   156,   157,   118,
     158,   159,   118,   160,   160,   160,   160,   161,   161,   161,
     112,   112,   113,   113,   106,   106,   106,   106,   106,   106,
     106,   106,   106,   106,   106,   107,   107,   105,   105,   108,
     108,   109,   110,   110,   111,   125,   162,   162,   163,   126,
     126,   127,   127,   127,   127,   127,   127,   127,   127,   127,
     127,   130,   130,   130,   131,   132,   129,   129,   128,   128,
     128,   128,   128,   128,   128,   128,   128,   128,   128,   128,
     128,   128,   128,   128,   128,   128,   128,   128,   121,   121,
     121,   121,   124,   124,   122,   122,   119,   119,   119,   119,
     119,   119,   120,   120,   120,   120,   120,   120,   120,   120,
     120,   120,   120,   120,   120,   120,   120,   120,   120,   120,
     120,   120,   120,   120,   120,   120,   120,   120,   120,   123,
     123
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     0,     2,     2,     2,     1,     9,     7,
       8,     0,     2,     0,     3,     0,     2,     3,     1,     1,
       4,     0,     2,     1,     1,     1,     1,     4,     4,     5,
       0,     0,     0,     0,     9,     0,     0,    10,     0,     0,
      10,     0,     0,    12,     0,     0,    12,     0,     0,    14,
       0,     0,    14,     0,     1,     1,     1,     0,     1,     1,
       0,     2,     6,     8,     1,     1,     1,     1,     1,     4,
       4,     4,     4,     6,     1,     4,     1,     3,     1,     3,
       1,     1,     3,     1,     3,     4,     0,     2,     4,     2,
       1,     2,     5,     7,     5,     7,     7,     9,     5,     7,
       1,     2,     1,     1,     4,     3,     3,     5,     1,     2,
       2,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     4,     4,     4,     4,     1,     1,     2,     1,     4,
       3,     1,     1,     3,     3,     1,     1,     1,     1,     1,
       1,     5,     1,     1,     4,     5,     3,     3,     2,     3,
       3,     3,     3,     3,     3,     3,     3,     2,     3,     3,
       2,     2,     2,     2,     3,     3,     3,     3,     3,     0,
       1
    };
  }



  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short[] yyrline_ = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,   151,   151,   156,   157,   161,   165,   166,   170,   171,
     172,   176,   177,   181,   182,   186,   187,   191,   192,   196,
     197,   201,   202,   216,   217,   218,   219,   223,   230,   236,
     244,   249,   255,   259,   254,   274,   278,   273,   293,   297,
     292,   304,   308,   303,   323,   327,   322,   334,   338,   333,
     353,   357,   352,   364,   365,   366,   367,   371,   372,   373,
     377,   378,   387,   388,   392,   393,   394,   395,   396,   397,
     398,   399,   400,   401,   402,   406,   407,   411,   412,   416,
     417,   421,   425,   426,   430,   437,   441,   442,   446,   450,
     451,   455,   456,   457,   458,   459,   460,   461,   462,   463,
     464,   468,   469,   470,   474,   478,   482,   483,   487,   488,
     489,   490,   491,   492,   493,   494,   495,   496,   497,   498,
     499,   500,   501,   502,   503,   504,   505,   506,   512,   528,
     534,   540,   548,   557,   561,   562,   566,   567,   568,   569,
     570,   571,   575,   576,   577,   578,   579,   580,   581,   582,
     583,   584,   585,   586,   587,   588,   589,   590,   591,   592,
     593,   594,   595,   596,   597,   598,   599,   600,   601,   605,
     606
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yyReducePrint (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "):");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yySymbolPrint("   $" + (yyi + 1) + " =",
                    SymbolKind.get(yystos_[yystack.stateAt (yynrhs - (yyi + 1))]),
                    yystack.valueAt ((yynrhs) - (yyi + 1)),
                    yystack.locationAt ((yynrhs) - (yyi + 1)));
  }

  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 338;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    82,     2,     2,     2,    89,    94,     2,
      99,   100,    87,    85,    97,    86,   103,    88,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,    78,    98,
      83,     2,    84,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,   101,     2,   102,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    95,    93,    96,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60,    61,    62,    63,    64,
      65,    66,    67,    68,    69,    70,    71,    72,    73,    74,
      75,    76,    77,    79,    80,    81,    90,    91,    92
    };
  }


  private static final int YYLAST_ = 1014;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 3;
  private static final int YYNTOKENS_ = 104;

/* Unqualified %code blocks.  */
/* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":23  */

	private Environment<Type> typeEnvironment = new MapEnvironment<Type>("TYPES", true);
	private Environment<Type> varEnvironment = new MapEnvironment<Type>("VARIABLES", true);
	private Environment<Type> interfaceEnvironment = new MapEnvironment<Type>("INTERFACE", true);
	private Environment<Type> classEnvironment = new MapEnvironment<Type>("CLASSE", true);
	private StackEnvironment<Type> localVarEnvironment = new StackEnvironment<Type>("STACK", true);
	private Type type;

/* "/home/leon/travail/cremi/compil/projet/projet-20210420/src/fr/ubordeaux/deptinfo/compilation/lea/parser/Parser.java":3094  */

}
/* "/home/leon/travail/cremi/compil/projet/projet-20210420/parser/Parser.y":610  */


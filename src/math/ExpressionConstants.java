/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;


/**
 * Contains all constants and symbols for expression classes.
 * @author fabio
 */
public final class ExpressionConstants {
    
    public static final String SUM = "+";
    public static final String SUB = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";
    public static final String POW = "^";
    public static final String RADQ = "RADQ";
    public static final String RADN = "RADN";
    public static final String BRA_O = "(";
    public static final String BRA_C = ")";
    public static final String SQBRA_O = "[";
    public static final String SQBRA_C = "]";
    public static final String CBRA_O = "{";
    public static final String CBRA_C = "}";     
/** 
 * Contains all of the math operators.
 * This array is already sorted
 */
    public static final String[] OPERATORS = {MUL,SUM,SUB,DIV,RADN,RADQ,POW};     
/**
 * Contains all of the parenthesis.
 * This array is already sorted
 */
    public static final String[] PARENTHESIS = {BRA_O,BRA_C,SQBRA_O,SQBRA_C,CBRA_O,CBRA_C};
/**
 * Contains, according to the standard math order, all of the operators.
 */    
    public static final String[][] PRIORITY_OPERATORS = {
        {RADQ,POW},
        {MUL,DIV},
        {SUM,SUB}
    };
/**
 * Contains, according to the standard math order, all of the parenthesis.
 */    
    public static final String[][] PRIORITY_PARENTHESIS = {
        {BRA_O,BRA_C},
        {SQBRA_O,SQBRA_C},
        {CBRA_O,CBRA_C}
    };    
}

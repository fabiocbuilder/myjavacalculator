/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 * Creates a math expression using real numbers
 * @author fabio
 */
public class DecExpression extends Expression {
    
    public DecExpression(){
        super();
    }
    
    public DecExpression(DecExpression expression){
        super(expression);
    }
    
    public static Expression toHexExpression(DecExpression expression){
        HexExpression hexExp = new HexExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            if(Character.isDigit(last)){
                long dec = Double.valueOf(value).longValue();
                value = Long.toHexString(dec).toUpperCase();
            }
            hexExp.add(value);
        }
        return hexExp;
    }
    
    public static BinExpression toBinExpression(DecExpression expression){
        BinExpression binExp = new BinExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            if(Character.isDigit(last)){
                long dec = Double.valueOf(value).longValue();
                value = Long.toBinaryString(dec);
            }
            binExp.add(value);
        }
        return binExp;
    }      

    @Override
    public String computation(String op1, String op2, String operator) {
        switch(operator){
            case "*":
                return Double.toString(Double.parseDouble(op1)*Double.parseDouble(op2)); 
            case "/":
                return Double.toString(Double.parseDouble(op1)/Double.parseDouble(op2));   
            case "^":
                return Double.toString(Math.pow(Double.parseDouble(op1),Double.parseDouble(op2)));
            case "RADQ":
                return Double.toString(Math.sqrt(Double.parseDouble(op2)));
            case "+":
                return Double.toString(Double.parseDouble(op1)+Double.parseDouble(op2));
            case "-":
                return Double.toString(Double.parseDouble(op1)-Double.parseDouble(op2));
            default:
                return "";
        }
    }
}
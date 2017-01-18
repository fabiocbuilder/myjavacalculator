/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 * Creates a binary math expression
 * @author fabio
 */
public class BinExpression extends Expression {
       
    public BinExpression(){
        super();
    }
    
    public BinExpression(BinExpression expression){
        super(expression);
    }

    public static Expression toHexExpression(BinExpression expression){
        HexExpression hexExp = new HexExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            if(Character.isDigit(last)){
                long bin = Long.parseLong(value, 2);
                value = Long.toHexString(bin).toUpperCase();
            }
            hexExp.add(value);
        }
        return hexExp;
    }
    
    public static Expression toDecExpression(BinExpression expression){
        DecExpression decExp = new DecExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            if(Character.isDigit(last)){
                long bin = Long.parseLong(value, 2);
                value = ""+bin;
            }
            decExp.add(value);
        }
        return decExp;
    }     

    @Override
    public String computation(String op1, String op2, String operator) {
        switch(operator){
            case "*":
                return Long.toBinaryString(Long.parseLong(op1,2)*Long.parseLong(op2,2)); 
            case "/":
                return Long.toBinaryString(Long.parseLong(op1,2)/Long.parseLong(op2,2));   
            case "^":
                return Long.toBinaryString((int) Math.pow(Long.parseLong(op1,2),Long.parseLong(op2,2)));
            case "RADQ":
                return Long.toBinaryString((int) Math.sqrt(Long.parseLong(op2,2)));
            case "+":
                return Long.toBinaryString(Long.parseLong(op1,2)+Long.parseLong(op2,2));
            case "-":
                return Long.toBinaryString(Long.parseLong(op1,2)-Long.parseLong(op2,2));
            default:
                return "";
        }
    }    
}

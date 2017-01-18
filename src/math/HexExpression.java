/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 * Creates an hexadecimal math expression
 * @author fabio
 */
public class HexExpression extends Expression {
    
    public HexExpression(){
        super();
    }
    
    public HexExpression(HexExpression expression){
        super(expression);
    }

    public static BinExpression toBinExpression(HexExpression expression){
        BinExpression binExp = new BinExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            try { 
                long hex = Long.parseLong(value,16);
                value = Long.toBinaryString(hex);
            } catch (NumberFormatException ex){}
            binExp.add(value);
        }
        return binExp;
    }
    
    public static Expression toDecExpression(HexExpression expression){
        DecExpression decExp = new DecExpression();
        for (String value : expression) {
            char last = value.charAt(value.length()-1);
            try { 
                long hex = Long.parseLong(value,16);
                value = ""+hex;
            } catch (NumberFormatException ex){}
            decExp.add(value);
        }
        return decExp;
    }           
    
    @Override
    public String computation(String op1, String op2, String operator) {
        switch(operator){
            case "*":
                return Long.toHexString(Long.parseLong(op1,16)*Long.parseLong(op2,16)); 
            case "/":
                return Long.toHexString(Long.parseLong(op1,16)/Long.parseLong(op2,16));   
            case "^":
                return Long.toHexString((int) Math.pow(Long.parseLong(op1,16),Long.parseLong(op2,16)));
            case "RADQ":
                return Long.toHexString((int) Math.sqrt(Long.parseLong(op2,16)));
            case "+":
                return Long.toHexString(Long.parseLong(op1,16)+Long.parseLong(op2,16));
            case "-":
                return Long.toHexString(Long.parseLong(op1,16)-Long.parseLong(op2,16));
            default:
                return "";
        }
    }
}    

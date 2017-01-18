/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 * Lets classes to performs a simple computation
 * @author fabio
 */
public interface Computable {
    
/**
 * Performs a generic computation between two operands and one operator
 * @param op1
 * @param op2
 * @param operator
 * @return the result of this computation
 */
    public String computation(String op1, String op2, String operator); 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.Arrays;
import java.util.NoSuchElementException;
import math.exc.ExpressionException;
import java.util.Vector;

/**
 * Creates a generic standard math expression.
 * This class lets you to write, change, read and compute math expression.
 * Computation is only available for expressions containing the following specifications:
 * - Range limit for numbers are:
 *      - double primitive type for decimal expressions.
 *      - long primitive type for other expressions.
 * - Accepted operators are: +,-,*,/,^,RADQ. 
 * - Accepted brackets are: (, ), [, ], {, }.
 * It is permitted to use a type of brackets inside the same brackets argument.
 * For example: (2*(8-5))^2
 * Instead of the previous example it is recommended to use the this form:
 * [2*(8-5)]^2.
 * It is computable this expression form:
 * [2*(8-5)+(6*2)]^2.
 * In case of omitted brackets, computations will be solved with the standard
 * math priority rules of operators.
 * For example: 
 * 2+3*5^2*RADQ4 will be solved as:
 * 2+3*25*RADQ4; 2+3*50; 2+150; 152;
 * @see ExpressionConstants class
 * @author fabio
 */
public abstract class Expression extends Vector<String> implements Comparable<Expression>, Computable {
    
    protected String ris;
    
    public Expression(){
        super();
        ris = "";
    }
    
    public Expression(Expression expression){
        super(expression);
        ris = "";
    }    

/**
 * Returns the result of this expression
 * @see calculte(); genericCalc(); methods
 * @return 
 */
    public String getRis(){
        return ris;
    }

/**
 * Sets a new value to the result of this expression
 * @param ris 
 */    
    public void setRis(String ris){
        this.ris = ris;
    }
    
/**
 * Calculates this expression according to the 
 * priority order of computations in standard math rules.
 * This methods return the result of the computation as a String object.
 * Result is also saved in the global field of this object
 * @return the computation of this expression
 * @throws math.exc.ExpressionException
 */ 
    public String calculate() throws ExpressionException {
        Expression exp = (Expression) this.clone();
        try {
            while(exp.size()>1){ //finche l'espressione non sarà risolta
                int startIndex = 0;
                int endIndex = exp.size();
                for(String[] pars : ExpressionConstants.PRIORITY_PARENTHESIS){ //Guardo se contiene parentesi
                    if(exp.contains(pars[0])){ //se le contiene, il vettore ha nuovi indici di inizio e fine
                        startIndex = exp.lastIndexOf(pars[0]);
                        exp.removeElementAt(startIndex);
                        endIndex = exp.indexOf(pars[1]);
                        exp.removeElementAt(endIndex);
                        break;
                    }
                }
                for(String[] ops : ExpressionConstants.PRIORITY_OPERATORS){ //per ogni array di operatori prioritari (in ordine)
                    for(int i=startIndex;i<endIndex;i++){ //dall'indice di inzio all'indice di fine attuale
                        String value = exp.elementAt(i); //mi ricavo l'elemento corrente
                        int index = Arrays.binarySearch(ops, value);
                        if(index>=0){ //se è un operatore che rientra tra gli l'array di operatori prioritari attuale
                            String operator = exp.elementAt(i); //mi ricavo operatori e operandi
                            String op1, op2;
                            int start = i-1, end = i+1;                                
                            switch(operator){ 
                                case ExpressionConstants.RADQ:
                                    op1 = "";
                                    start = i;
                                    break;
                                default:
                                    op1 = exp.elementAt(start);
                                    break;
                                }
                            op2 = exp.elementAt(end);  
                            String subtot = this.computation(op1, op2, operator); //eseguo l'operazione
                            for(int count=start;count<=end;count++){ //elimino gli elementi dell'operazione dal vettore
                                exp.removeElementAt(start);
                            }
                            exp.add(start, subtot); //aggiungo il risultato al vettore
                            i--;
                            endIndex = endIndex-2;
                        }
                    }
                }
            }     
            ris = exp.firstElement();
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException ex){
            throw new ExpressionException(ex.getMessage());
        }
        catch(NoSuchElementException e){
            ris = "";
        }
        return ris;
    }


    public static String genericCalc(Expression exp) throws ExpressionException{
        return exp.calculate();
    }      

/**
 * Compares two expressions for their result:
 * Returns:
 * * 1 if this expression has a higher result then the other
 * * -1 if this expression has a lower result then the other
 * * 0 if the two expression gives both the same result.
 * @param expression
 * @return
 */
    @Override
    public int compareTo(Expression expression){
        return (ris.compareTo(expression.ris));
    }
    
/**
 * Returns true if the two expression are the exactly the same.
 * Which it means that every element of this expression has the same value
 * of the expression specified by parameter
 * @param expression
 * @return 
 */
    public boolean equals(Expression expression){
        return super.equals(expression);
    }    
    
/**
 * Returns a string representation of the expression.
 * The string representation is composed by each element of the expression
 * @return 
 */
    @Override
    public String toString(){
        String output="";
        for(String value : this){
          output+=value;
        }
        return output;
    }
}

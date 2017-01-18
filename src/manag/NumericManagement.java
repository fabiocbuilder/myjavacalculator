/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manag;

import calc.AbstractStdCalc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ListIterator;
import math.Expression;
import math.ExpressionConstants;

/**
 * Manages the numeric events
 * @author fabio
 */
public class NumericManagement implements ActionListener {       

    private final AbstractStdCalc calc;
    
    public NumericManagement(AbstractStdCalc calc){
        this.calc = calc;
    }
        
/**
 * Adds in the expression the number or letter which generates the event
 * @param ae 
 */
        @Override
        public void actionPerformed(ActionEvent ae) {
            Expression exp = calc.getExpression();
            ListIterator<String> iter = exp.listIterator(exp.size());
            String num = ae.getActionCommand();  
            String output = calc.getDisplayText()+num;
            if(iter.hasPrevious()){
                String prev = iter.previous();
                int i1 = Arrays.binarySearch(ExpressionConstants.OPERATORS,prev);
                int i2 = Arrays.binarySearch(ExpressionConstants.PARENTHESIS,prev);
                if(i1>=0||i2>=0) { 
                    switch(prev){
                        case ExpressionConstants.SUB:
                                if(iter.hasPrevious()){
                                    String elem = iter.previous();
                                    i1 = Arrays.binarySearch(ExpressionConstants.OPERATORS,elem);
                                    i2 = Arrays.binarySearch(ExpressionConstants.PARENTHESIS,elem);
                                    iter.next();
                                    String val = iter.next();
                                    if(i1>=0||i2>=0)        
                                        iter.set(val+num);
                                    else
                                        iter.add(num);
                                    break;
                            }
                            iter.set(iter.next()+num);
                            break;
                        default: 
                            iter.next();
                            iter.add(num);
                            break;
                    }
                }
                else {
                    iter.set(iter.next()+num);
                }
            }
            else {
                iter.add(num);
            }         
            calc.setDisplayText(output);
        }        
    }

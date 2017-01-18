/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manag;

import calc.AbstractStdCalc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import math.Expression;
import math.ExpressionConstants;

/**
 * Manages the events of the operators
 * @author fabio
 */
public class OperatorsManagement implements ActionListener {

    private final AbstractStdCalc calc;
    
    public OperatorsManagement(AbstractStdCalc calc){
        this.calc = calc;
    }
    
/**
 * Adds the operator which generates the event
 * @param ae 
 */
        @Override
        public void actionPerformed(ActionEvent ae) {
            Expression exp = calc.getExpression();
            ListIterator<String> iter = exp.listIterator(exp.size());
            String operator = ae.getActionCommand();
            String output = calc.getDisplayText()+operator;
            switch(operator){
                case "\u221A":
                    if(exp.size()==1&&!(exp.getRis().isEmpty())){
                        iter.previous();
                        output = operator + calc.getDisplayText();
                    }
                case "\u03C0": 
                    operator = ""+Math.PI;
                case "(":
                    if(iter.hasPrevious()) {
                        String prev = iter.previous();
                        if(exp.size()>=1){
                            iter.next();
                            if(Character.isDigit(prev.charAt(prev.length()-1)))
                                iter.add(ExpressionConstants.MUL);   
                        }
                    }
                    switch(operator){
                        case "\u221A": 
                            iter.add(ExpressionConstants.RADQ);
                            break;
                        default: 
                            iter.add(operator); 
                            break;  
                    }
                    break;
                case "x":
                    iter.add(ExpressionConstants.MUL);
                    break;
                case "\u00F7":
                    iter.add(ExpressionConstants.DIV);
                    break;
                default:                        
                    iter.add(operator);
                    break;               
            }
            calc.setDisplayText(output);
        }
    }

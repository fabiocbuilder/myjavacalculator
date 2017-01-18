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
 * Manages the events of the deleting components: C, CE and backspace
 * @author fabio
 */
public class DeletingManagement implements ActionListener {

    private final AbstractStdCalc calc;
    
    public DeletingManagement(AbstractStdCalc calc){
        this.calc = calc;
    }
    
/**
 * Modifies the expression switching to the specific element:
 * in case of C: keeps the first number and deletes the rest; in case of a 
 * subtotal C keeps the subtotal
 * in case of backspace: deletes the last element
 * in case of CE: deletes all 
 * @param ae 
 */
        @Override
        public void actionPerformed(ActionEvent ae) {
            Expression exp = calc.getExpression();
            String output = calc.getDisplayText();
            switch(ae.getActionCommand()){
                case "C": 
                    exp.setSize(1);
                    output = exp.firstElement();
                    break;
                case "\u21E6": 
                    ListIterator<String> iter = exp.listIterator(exp.size());
                    if(iter.hasPrevious()){                    
                        String elem = iter.previous();
                        if(elem.equals(ExpressionConstants.RADQ)||elem.length()==1){
                            iter.remove();
                        }
                        else{
                            elem = elem.substring(0, elem.length()-1);
                            iter.next();
                            iter.set(elem);
                        }
                        output = output.substring(0, output.length()-1);
                    }
                    break;
                case "CE": 
                    exp.removeAllElements();
                    exp.setRis("");
                    output = "";
                    break;
            }
            calc.setDisplayText(output);
        }  
    }



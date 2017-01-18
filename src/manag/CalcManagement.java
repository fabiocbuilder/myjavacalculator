/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manag;

import calc.AbstractStdCalc;
import math.exc.ExpressionException;
import math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manages the calculation processes for this calculator
 * @author fabio
 */
public class CalcManagement implements ActionListener {

    private final AbstractStdCalc calc;
        
    public CalcManagement(AbstractStdCalc calc){
        this.calc = calc;
    }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String output;
            Expression exp = calc.getExpression();
            try {
                String ris = exp.calculate();
                if(exp instanceof DecExpression){
                    Number value = Double.valueOf(ris);
                    if(value.longValue() == value.doubleValue())
                        value = value.longValue();                    
                    if(value.toString().length()>10)
                        output=String.format("%G",value.doubleValue());           
                    else
                        output=""+value;
                }
                else {
                    if(exp instanceof HexExpression) {
                        Number value = Long.parseLong(ris,16);
                        output = String.format("%X",value.longValue());
                    }
                    else {
                        Number value = Long.valueOf(ris);
                        output=String.format("%d",value.longValue());
                    }
                }
                exp.removeAllElements();
                exp.add(output); //bivio aggiungere l'output formattato o il risultato reale?
            } catch (ExpressionException ex) {
                output="Syntax Error";
                exp.removeAllElements();
            } catch (NumberFormatException ex){
                output = "";
            }
            calc.setDisplayText(output);
        }
        
    }

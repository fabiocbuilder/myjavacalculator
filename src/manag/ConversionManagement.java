/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manag;

import calc.ConvCalculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import math.*;

/**
 * Manages the events of the conversion elements: hex - bin - decimal
 * @author fabio
 */
public class ConversionManagement implements ActionListener {

    private final ConvCalculator calc;
    
    public ConversionManagement(ConvCalculator calc){
        this.calc = calc; 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Expression exp = calc.getExpression();
        switch(ae.getActionCommand()){
            case "hex": 
                if(exp instanceof BinExpression)
                    exp = BinExpression.toHexExpression((BinExpression) exp);
                if(exp instanceof DecExpression)
                    exp = DecExpression.toHexExpression((DecExpression) exp);
                break;
            case "bin": 
                if(exp instanceof HexExpression)
                    exp = HexExpression.toBinExpression((HexExpression) exp);
                if(exp instanceof DecExpression)
                    exp = DecExpression.toBinExpression((DecExpression) exp);
                break;
            case "dec": 
                if(exp instanceof HexExpression)
                    exp = HexExpression.toDecExpression((HexExpression) exp);
                if(exp instanceof BinExpression)
                    exp = BinExpression.toDecExpression((BinExpression) exp);
                break;
        }
        calc.setExpression(exp);
        calc.toHexMode();
        calc.setDisplayText(calc.toString()); 
    }
}

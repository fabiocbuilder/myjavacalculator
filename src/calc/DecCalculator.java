/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Container;
import math.DecExpression;

/**
 *
 * @author fabio
 */
public class DecCalculator extends AbstractStdCalc {
        
    public DecCalculator(){
        super("Decimal Calculator");
        setSize(280,300);
        expression = new DecExpression();    
        menuFileItems[0].setSelected(true);
        Container contentPane = this.getContentPane();
        contentPane.add(display,"North");
        contentPane.add(center,"Center");
        this.setVisible(true);
    }
    
    public DecCalculator(DecExpression expression){
        this();
        this.expression = expression;
    }
    
}

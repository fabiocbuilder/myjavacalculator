/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Container;
import math.BinExpression;

/**
 *
 * @author fabio
 */
public class BinCalculator extends AbstractStdCalc {
    
    public BinCalculator() {
        super("Binary Calculator");
        setSize(280,300);
        expression = new BinExpression();
        menuFileItems[1].setSelected(true);
        for(int i=2;i<numbers.length;i++){
            numbers[i].setEnabled(false);
        }
        Container contentPane = this.getContentPane();
        contentPane.add(display,"North");
        contentPane.add(center,"Center");
        this.setVisible(true);
    }
    
    public BinCalculator(BinExpression expression){
        this();
        this.expression = expression;
    }
    
}

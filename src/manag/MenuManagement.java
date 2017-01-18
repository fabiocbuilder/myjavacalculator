/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manag;

import calc.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Manages the events of the File menu
 * @author fabio
 */
public class MenuManagement implements ActionListener {

    private AbstractStdCalc calc;
    
    public MenuManagement(AbstractStdCalc calc){
        this.calc = calc;
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        String menuItem = ae.getActionCommand();
        switch(menuItem){
            case "Decimal Calculator": 
                calc.dispose();
                calc = new DecCalculator();
                break;
            case "Binary Calculator":
                calc.dispose();
                calc = new BinCalculator();
                break;
            case "Hexadecimal Calculator":
                calc.dispose();
                calc = new HexCalculator();
                break;
            case "Conversions Calculator":
                calc.dispose();
                calc = new ConvCalculator();
                break; 
            case "Exit..":
                calc.dispose();
                break;
        }
    }
    
}

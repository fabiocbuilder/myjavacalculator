/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import manag.NumericManagement;
import math.HexExpression;

/**
 *
 * @author fabio
 */
public class HexCalculator extends AbstractStdCalc {

    private final JButton[] letters;
    
    public HexCalculator() {
        super("Hexadecimal Calculator");
        setSize(280,350);
        expression = new HexExpression();
        menuFileItems[2].setSelected(true);
        //Layout per le cifre esadecimali - pannello sud
        south.setLayout(new GridLayout(1,6));        
        //inizializzazione delle lettere esadecimali
        letters = new JButton[]{
            new JButton("A"), new JButton("B"),new JButton("C"), 
            new JButton("D"), new JButton("E"), new JButton("F")
        };
        //Aggiunta delle lettere esadecimali al pannello sud + disabilitazione
        for(JButton letter : letters){
            letter.addActionListener(new NumericManagement(this));
            south.add(letter);
        }
        //Aggiunta del bordo al pannello sud
        south.setBorder(new TitledBorder(new EtchedBorder(5),"Hex Letters"));
        //Aggiunta degli elementi al form principale
        Container contentPane = this.getContentPane();
        contentPane.add(display,"North");
        contentPane.add(center,"Center");
        contentPane.add(south,"South");
        this.setVisible(true);
    }
    
    
    
}

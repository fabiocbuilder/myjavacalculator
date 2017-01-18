/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import manag.*;
import math.*;

/**
 * Creates a calculator
 * @author fabio
 */
public class ConvCalculator extends AbstractStdCalc {
    
    private final JRadioButton[] conversions;
    private final JButton[] letters;

/**
 * Constructs graphically this calculator
 */    
    public ConvCalculator(){
        super("Conversions Calculator");
        this.setSize(280,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        expression = new DecExpression();
        menuFileItems[3].setSelected(true);
        //Layout per le cifre esadecimali - pannello sud
        south.setLayout(new GridLayout(1,6));
        //Creazione dei pulsanti di opzione e aggiunta delle gestioni evento
        conversions = new JRadioButton[] {
            new JRadioButton("hex"), new JRadioButton("bin"), new JRadioButton("dec")
        };
        for(JRadioButton conv : conversions){
            conv.addActionListener(new ConversionManagement(this));
        }
        conversions[2].setSelected(true);
        //Aggiunta dei pulsanti di opzioni a un gruppo di pulsanti opzione
        ButtonGroup conv = new ButtonGroup();
        conv.add(conversions[0]); //hex
        conv.add(conversions[1]); //bin
        conv.add(conversions[2]); //dec
        //Creazione dei pulsanti numerici e aggiunta delle gestioni evento
        letters = new JButton[]{
            new JButton("A"), new JButton("B"),new JButton("C"), 
            new JButton("D"), new JButton("E"), new JButton("F")
        };
        //Aggiunta delle lettere esadecimali al pannello sud + disabilitazione
        for(JButton letter : letters){
            letter.addActionListener(new NumericManagement(this));
            letter.setEnabled(false);
            south.add(letter);
        }
        //Modifica del pannello centrale
        Component[] compC = this.center.getComponents();
        compC[0] = conversions[0];
        compC[1] = conversions[1];
        compC[2] = conversions[2];
        center.removeAll();
        for(Component c : compC){
            center.add(c);
        }
        //Aggiunta del bordo al pannello sud
        south.setBorder(new TitledBorder(new EtchedBorder(5),"Hex Letters"));
        //Aggiunta dei componenti al form principale
        Container contentPane = this.getContentPane();
        contentPane.add(display,"North");
        contentPane.add(center,"Center");
        contentPane.add(south,"South");
        //apri la finestra calcolatrice
        this.setVisible(true);
    }

/**
 * Constructs graphically this calculator with a given expression
 * @param exp 
 */    
    public ConvCalculator(Expression exp){
        this();
        this.expression = exp;
    }

/**
 * Repaints this calculator to binary mode
 */
    public void toBinMode(){
        for(int i=2;i<numbers.length;i++){
            numbers[i].setEnabled(false);
        }
        for(JButton letter : letters){
            letter.setEnabled(false);
        }
        this.revalidate();
        this.repaint();
    }

/**    
 * Repaints this calculator to hexadecimal mode
 */
    public void toHexMode(){
        for(int i=2;i<numbers.length;i++){
            numbers[i].setEnabled(true);
        }
        for(JButton letter : letters){
            letter.setEnabled(true);
        }
        this.revalidate();
        this.repaint();
    }

/**
 * Repaints this calculator to decimal mode
 */    
    public void toDecMode(){
        for(int i=2;i<numbers.length;i++){
            numbers[i].setEnabled(true);
        }
        for(JButton letter : letters){
            letter.setEnabled(false);
        }
        this.revalidate();
        this.repaint();
    }   
}
    

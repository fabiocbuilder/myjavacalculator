/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import manag.*;
import math.Expression;

/**
 * Creates a standard GUI calculator
 * @author fabio
 */
public abstract class AbstractStdCalc extends CalcFrame {
       
    protected final JButton[] numbers;
    protected final JButton[] operators;
    protected final JButton[] deletingOp;
    protected final JMenuBar menuBar;
    protected JMenu menuFile;
    protected JMenuItem[] menuFileItems;

/**
 * Constructs graphically a standard calculator
 * @param name 
 */
    public AbstractStdCalc(String name) {
        super(name);
        /* Creazione della barra dei menu, dei vari menu e degli elementi di ogni menu */
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);    
        menuFileItems = new JMenuItem[]{
            new JRadioButtonMenuItem("Decimal Calculator"), new JRadioButtonMenuItem("Binary Calculator"),
            new JRadioButtonMenuItem("Hexadecimal Calculator"), new JRadioButtonMenuItem("Conversions Calculator"),
            new JMenuItem("Exit..")
        };
        ButtonGroup group = new ButtonGroup();
        for(JMenuItem item : menuFileItems){
            group.add(item);
            item.addActionListener(new MenuManagement(this));
            menuFile.add(item);
        }
        //layout per le calcolatrici standard semplici
        center.setLayout(new GridLayout(5,5));
        /*Creazione dei pulsanti numerici e aggiunta delle gestioni evento */
        numbers = new JButton[] {
            new JButton("0"), new JButton("1"), new JButton("2"),
            new JButton("3"), new JButton("4"), new JButton("5"), 
            new JButton("6"), new JButton("7"), new JButton("8"), 
            new JButton("9"), new JButton(".") 
        };
        for(JButton digit : numbers){
            digit.addActionListener(new NumericManagement(this));
        }
        /* Creazione dei pulsanti di operazione e aggiunta delle gestioni evento
        * \u221A : SQRT
        * \u00F7 : diviso
        */
        operators = new JButton[] {
            new JButton("="), new JButton("\u221A"), new JButton("^"),  
            new JButton("+"), new JButton("-"),new JButton("x"), new JButton("\u00F7"),
            new JButton("("), new JButton(")"), new JButton("%"), new JButton("\u03C0")
        };
        for(int i=1;i<operators.length;i++){
            operators[i].addActionListener(new OperatorsManagement(this));
        }
        operators[0].addActionListener(new CalcManagement(this)); //per l'uguale c'è un management apposito
        /* Creazione dei pulsanti di cancellazione e aggiunta delle gestioni evento
        * \u21E6 : backspace
        */
        deletingOp = new JButton[] {
            new JButton("\u21E6"), new JButton("CE"), new JButton("C")
        };
        for(JButton del : deletingOp){
            del.addActionListener(new DeletingManagement(this));
        }
        /* Aggiunta dei componenti al pannello centrale */
        center.add(operators[7]);
        center.add(operators[8]);
        center.add(operators[9]);
        center.add(deletingOp[1]);
        center.add(deletingOp[0]);
        center.add(numbers[7]);
        center.add(numbers[8]);
        center.add(numbers[9]);
        center.add(operators[1]);
        center.add(operators[2]);
        center.add(numbers[4]);
        center.add(numbers[5]);
        center.add(numbers[6]);
        center.add(operators[5]);
        center.add(operators[6]);
        center.add(numbers[1]);
        center.add(numbers[2]);
        center.add(numbers[3]);
        center.add(operators[3]);
        center.add(operators[4]);
        center.add(numbers[0]);
        center.add(numbers[10]);
        center.add(operators[10]);
        center.add(deletingOp[2]);
        center.add(operators[0]);
    }
    
    public AbstractStdCalc(String name, Expression expression){
        this(name);
        this.expression = expression;
    }
 
/**
 * Sets a new File menu
 * @param menu 
 */    
    public void setJMenuFile(JMenu menu){
        this.menuFile = menu;
    }

/**
 * Sets a new item at the specified index on the menu File
 * @param item
 * @param i 
 */
    public void setJMenuFileItem(JMenuItem item, int i){
        Component[] comps = menuFile.getComponents();
        comps[i] = item;
        menuFile.removeAll();
        for(Component comp : comps){
            menuFile.add(comp);
        }
    }
   
/**
 * Sets a specified element of the central panel with a new one
 * @param c
 * @param i 
 */
    public void setCenterPanelElem(JComponent c, int i){
        Component[] comps = center.getComponents();
        comps[i] = c;
        center.removeAll();
        for(Component comp : comps){
            center.add(comp);
        }
    }  
}

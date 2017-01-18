/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import math.Expression;

/**
 *
 * @author fabio
 */
public abstract class CalcFrame extends JFrame {
    
    protected final JTextField display;
    protected final JPanel south;
    protected JPanel center;
    protected Expression expression;
        
    public CalcFrame(String name){
        super(name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        display = new JTextField();
        display.setName("Display");
        display.setFont(new Font("SansSerif",Font.PLAIN,25));
        display.setEditable(false);
        center = new JPanel();
        center.setName("Center Panel");
        south = new JPanel();
        south.setName("South Panel");   
    }
    
    public CalcFrame(String name, Expression expression){
        this(name);
        this.expression = expression;
    }  
    
/**
 * Returns the expression written with this calculator
 * @return 
 */
    public Expression getExpression(){
        return expression;
    }

/**
 * Changes the value of this expression as specified by parameter
 * @param expression 
 */
    public void setExpression(Expression expression){
        this.expression = expression;
    } 

/**
 * Gets the current text on the display
 * @return 
 */    
    public String getDisplayText(){
        return display.getText();
    }
    
/**
 * Displays a specified output to this calculator
 * @param output
 */
    public void setDisplayText(String output){
        display.setText(output);
    }  

/**
 * Sets the central panel
 * @param center 
 */
    public void setCentralPanel(JPanel center){
        this.center = center;
    }

/**
 * Returns the central panel
 * @return 
 */    
    public JPanel getCentralPanel(){
        return this.center;
    }
    
/**
 * Returns a string representation of this calculator which is composed by
 * the string representation of the expression
 * @return 
 */
    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<expression.size();i++) {
            String val = expression.elementAt(i);
            switch(val){
                case "*": output+="x"; break;
                case "RADQ": output+="\u221A"; break;
                case "/": output+="\u00F7"; break;
                default: output+=val; break;
            }
        }
        return output;
    }
}

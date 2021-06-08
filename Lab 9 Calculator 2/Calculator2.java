package solution;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calculator 2 Lab09.
 * 
 * @author GregRapp
 * @version 1.0
 */
public class Calculator2 extends JFrame implements ActionListener
{
    final static int JFRAME_WIDTH = 400;
    final static int JFRAME_LENGTH = 150;
    final static int JLABEL_WIDTH = 300;
    final static int JLABEL_LENGTH = 100;

    private JFrame myFrame;
    private JTextField infixExpression;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton clearButton;
    private JPanel buttonPanel;
    private JPanel resultPanel;
    private JPanel textPanel;
    
    /**
     * constructor for calculator.
     */
    public Calculator2()
    {
        myFrame = new JFrame("Calculator");
        myFrame.setSize(JFRAME_WIDTH, JFRAME_LENGTH);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        resultPanel = new JPanel();
        buttonPanel.setSize(JLABEL_WIDTH, JLABEL_LENGTH);
        textPanel.setSize(JLABEL_WIDTH, JLABEL_LENGTH);
        resultPanel.setSize(JLABEL_WIDTH, JLABEL_LENGTH);
        
        infixExpression = new JTextField(15);
        infixExpression.setName("infixExpression");
        textPanel.add(infixExpression);
        
        resultLabel = new JLabel();
        resultLabel.setName("resultLabel");
        resultLabel.setText("Result =");
        resultPanel.add(resultLabel);
        
        calculateButton = new JButton("Calculate");
        calculateButton.setName("calculateButton");
        calculateButton.setSize(50, 50);
        calculateButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setName("clearButton");
        clearButton.setSize(50, 50);
        clearButton.addActionListener(this);

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        
        myFrame.setLayout(new BorderLayout(15, 15));
        myFrame.add(buttonPanel, BorderLayout.PAGE_END);
        myFrame.add(resultPanel, BorderLayout.WEST);
        myFrame.add(textPanel, BorderLayout.PAGE_START);
        
        myFrame.setVisible(true);
    }
    
    /**
     * Accessor for myFrame.
     * @return JFrame 
     */
    public JFrame getFrame()
    {
        return myFrame;
    }
    
    /**
     * performs actions.
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {   
        try
        {
            String str1 = infixExpression.getText();
            double result = 0;
            if (e.getSource().equals(calculateButton))
            {
                String str2 = ExpressionEvaluator.toPostfix(str1);
                result = ExpressionEvaluator.evaluate(str2);
            }
            else if (e.getSource().equals(clearButton))
            {
                infixExpression.setText("");
            }
            resultLabel.setText("Result = " + result);
        }
        catch (Exception ex)
        {
            resultLabel.setText("Result = Error");
        }
    }
    
    /**
     * creates a new calculator.
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
        Calculator2 calc = new Calculator2();
    }
}

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
 * Makes a simple Calculator.
 * 
 * @author GregRapp
 *
 */
public class Calculator extends JFrame implements ActionListener
{

    private JFrame myframe;
    private JPanel buttonPanel;
    private JPanel resultPanel;
    private JPanel textPanel;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JLabel resultLabel;
    private JTextField leftOperand;
    private JTextField rightOperand;

    /**
     * Constructor for Calculator.
     */
    public Calculator()
    {
        myframe = new JFrame("Calculator");
        myframe.setSize(400, 150);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        textPanel = new JPanel();
        resultPanel = new JPanel();
        buttonPanel.setSize(300, 100);
        textPanel.setSize(300,100);
        resultPanel.setSize(300,100);

        addButton = new JButton("ADD");
        addButton.setName("addButton");
        addButton.setSize(50,50);
        addButton.addActionListener(this);

        subButton = new JButton("SUB");
        subButton.setName("subButton");
        subButton.setSize(50,50);
        subButton.addActionListener(this);
        
        mulButton = new JButton("MULT");
        mulButton.setName("multButton");
        mulButton.setSize(50,50);
        mulButton.addActionListener(this);
        
        divButton = new JButton("DIV");
        divButton.setName("divButton");
        divButton.setSize(50,50);
        divButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        
        resultLabel = new JLabel();
        resultLabel.setName("resultLabel");
        resultLabel.setText("Result =");
        
        resultPanel.add(resultLabel);

        leftOperand= new JTextField(15);
        rightOperand = new JTextField(15);
        leftOperand.setName("leftOperand");
        rightOperand.setName("rightOperand");
        
        textPanel.setSize(50, 300);
        textPanel.add(leftOperand);
        textPanel.add(rightOperand);
        
        myframe.setLayout(new BorderLayout(15,15));
        myframe.add(buttonPanel, BorderLayout.PAGE_END);
        myframe.add(resultPanel, BorderLayout.WEST);
        myframe.add(textPanel, BorderLayout.PAGE_START);
        
        myframe.setVisible(true);
    }
    
    /**
     * accessor for JFrame.
     * 
     * @return JFrame 
     */
    public JFrame getFrame()
    {
        return myframe;
    }

    /**
     * performs actions.
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {   
        try
        {
            String str1 = leftOperand.getText();
            String str2 = rightOperand.getText();
            double num1 = Double.parseDouble(str1);
            double num2 = Double.parseDouble(str2);
            double answer = 0;
            if (str1 != null && str2 != null)
            {
                if (e.getSource().equals(addButton))
                    answer = num1 + num2;
                else if (e.getSource().equals(subButton))
                    answer = num1 - num2;
                else if (e.getSource().equals(mulButton))
                    answer = num1 * num2;
                else if (e.getSource().equals(divButton))
                    answer = num1 / num2;
                
                if (e.getSource().equals(divButton) && num2 == 0)
                    resultLabel.setText("Result = Error");
                else
                    resultLabel.setText("Result = " + (int) answer);
            }
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
        Calculator calc = new Calculator();
    }


}

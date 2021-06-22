package solution;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Stack;
/**
 * Evaluates expressions.
 * 
 * @author Greg Rapp
 * @version 1.0
 * 
 */
public class ExpressionEvaluator
{

    public static final Pattern UNSIGNED_DOUBLE =
        Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    /**
     * Takes an infix expression and converts it to postfix.
     * 
     * @param expression
     *            The infix expression.
     * @return the postfix expression.
     */
    public static String toPostfix(String expression)
    {
        Scanner input = new Scanner(expression);
        String next;
        char symbol;
        String postfixExpression = "";
        Stack<Character> stk = new Stack<Character>();

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);
                if (symbol == '(')
                {
                    stk.push(symbol);
                }
                else if (symbol == '+' || symbol == '*' 
                    || symbol == '-' || symbol == '/')
                {
                    while (!stk.isEmpty() && stk.peek() != '(' 
                        && checkPrecedence(symbol) 
                        <= checkPrecedence(stk.peek()))
                    {
                        postfixExpression += stk.pop() + " ";
                    }
                    stk.push(symbol);
                }
                else if (symbol == ')')
                {
                    while (!stk.isEmpty() && stk.peek() != '(')
                    {
                        postfixExpression += stk.pop() + " ";
                    }
                    stk.pop();
                }
                else
                {
                    throw new IllegalArgumentException();
                }
            }
        }
        while (!stk.isEmpty())
        {
            postfixExpression += stk.pop() + " ";
        }
        input.close();
        return postfixExpression;
    }

    /**
     * returns precedence of operator.
     * @return precedence 
     * @param character 
     */
    public static int checkPrecedence(Character character)
    {
        int precedence;
        if (character == '+' || character == '-')
        {
            precedence = 1;
        }
        else if (character == '*' || character == '/')
        {
            precedence = 2;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        return precedence;
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpression
     *            The postfix expression.
     * @return The result of the expression.
     */
    public static double evaluate(String postfixExpression)
    {
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = Double.NaN;
        Stack<Double> stk = new Stack<Double>();

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                stk.push(Double.parseDouble(next));
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);
                double a = stk.pop();
                double b = stk.pop();
                if (operator == '+')
                {
                    stk.push(b + a);
                }
                else if (operator == '-')
                {
                    stk.push(b - a);
                }
                else if (operator == '*')
                {
                    stk.push(b * a);
                }
                else if (operator == '/')
                {
                    stk.push(b / a);
                }
            }
        }
        input.close();
        answer = stk.peek();
        return answer;
    }
    public static void main(String [] args)
    {
        System.out.println(ExpressionEvaluator.toPostfix("1 * 2 + 16 + (12 + 1 + 16 )* 3 ")+ "\n" + ExpressionEvaluator.evaluate(ExpressionEvaluator.toPostfix("12 + 1 + (12 + 16 * 2 + 1) * 3\n")));
    }
}

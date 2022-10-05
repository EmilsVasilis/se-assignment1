import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcInterface {
    calc calculator;
    calcInterface() {
        calculator = new calc();
    }
    public void draw () {
        Frame f = new Frame("Calculator");
        JLabel ans = new JLabel();
        // Placeholder text  https://stackoverflow.com/a/40516250
        JTextField t1 = new JTextField(); // make placeholder
        TextPrompt tp1 = new TextPrompt("Enter Calculation",t1);
        JLabel header = new JLabel("Calculator");
        Button submit = new Button("Submit");
        t1.setBounds(80, 100, 200, 30);
        header.setBounds(80,50,200,30);
        submit.setBounds(80, 150, 200, 30);
        ans.setBounds(80,200,200,30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(isValidExpression(t1.getText()));
                if(t1.getText().trim() == "" || !isValidExpression(t1.getText()))
                {
                    ans.setText("Please enter a valid expression");
                    ans.setForeground(Color.red);
                }
                else {
                    ans.setForeground(Color.black);
                    ans.setText(t1.getText());//calc function
                }
            }
        });
        f.add(ans);
        f.add(t1);
        f.add(header);
        f.add(submit);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    //Error checking https://codereview.stackexchange.com/a/181663
    /**
     * Utility function to check if a given character is an arithmetic operator
     * @param c
     * @return true if operator, false if not
     */
    public static boolean isAnOperator(char c){
        return (c == '*' || c == '+' || c == '-' );
    }
    /**
     * Checks position and placement of (, ), and operators in a string
     * to make sure it is a valid arithmetic expression
     * @param expression
     * @return true if the string is a valid arithmetic expression, false if not
     */
    public static boolean isValidExpression(String expression){
        //check if expression is only numbers and operators
        for(int i = 0; i < expression.length();i++)
        {
            Character s = expression.charAt(i);
            if(!isAnOperator(s) && !s.toString().matches("[0-9]")) return false;
        }
        //remove unnecessary whitespaces
        expression = expression.replaceAll("\\s+", "");
        //TEST 1: False if expression starts or ends with an operator
        if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length()-1)))
            return false;
        //System.out.println("Does not start or end with operator");


        //TEST 2: False if test has mismatching number of opening and closing parantheses

        int unclosedParenthesis = 0;
        //System.out.println("Parentheses counter initialized to 0");

        for (int i = 0; i < expression.length(); i++){
            //System.out.println("For loop count: " + i);
            if (expression.charAt(i) == '('){
                //System.out.println("( found");
                unclosedParenthesis++;

                //SUBTEST: False if expression ends with '('
                if (i == expression.length()-1) return false;
            }
            if (expression.charAt(i) == ')'){
                unclosedParenthesis--;
                //System.out.println(") found");
                //SUBTEST: False if expression starts with ')'
                if (i == 0) return false;

            }
            if (isAnOperator(expression.charAt(i))){

                //System.out.println("Found an Operator");
                //TEST 3: False if operator is preceded by an operator or opening paranthesis
                //or followed by closing paranthesis
                if (expression.charAt(i-1) == '(' || expression.charAt(i+1) == ')' || isAnOperator(expression.charAt(i+1))){
                    //System.out.println("Found wrongly preceding or following parenthesis to operator");
                    //System.out.println("or Found an operator following another operator");
                    return false;
                }

            }

        }
        return (unclosedParenthesis == 0);
    }
}

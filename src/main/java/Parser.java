import java.util.*;
public class Parser {

    /**
     * Old parser, couldnt handle operator precedence
     * Adapted my C code from last year for calculating infix expression by converting to postfix
    static int parseString(String exp){
        String[] expression = exp.split("((?<=[+*-])|(?=[+*-]))");
        int start;
        int res = 0;
        if(expression[0].equalsIgnoreCase("-")){
            res -= Integer.parseInt(expression[1]);
            start = 2;
        }else {
            res = Integer.parseInt(expression[0]);
            start = 1;
        }
        for(int i = start; i < expression.length;i++) {

            if (expression[i].equalsIgnoreCase("+")) {
                if(expression[i+1].equalsIgnoreCase("-")){
                    res += ((Integer.parseInt(expression[i+2])) * -1);
                    i += 2;
                }else {
                    res += Integer.parseInt(expression[i + 1]);
                    i++;
                }
            } else if (expression[i].equalsIgnoreCase("-")) {
                if(expression[i+1].equalsIgnoreCase("-")){
                    res -= ((Integer.parseInt(expression[i+2])) * -1);
                    i += 2;
                }else {
                    res -= Integer.parseInt(expression[i + 1]);
                    i++;
                }
            } else {
                if(expression[i+1].equalsIgnoreCase("-")){
                    res *= ((Integer.parseInt(expression[i+2])) * -1);
                    i += 2;
                }else {
                    res *= Integer.parseInt(expression[i + 1]);
                    i++;
                }
            }

        }
        return res;
    }
     **/

    /**
     * Takes in a string and converts it to postfix notation
     * Then passes it to the evaluatePostfix to be calculated
     * @param exp string expression to be calculated
     * @return int
     */
    static int evaluateExp(String exp){
        String[] expression = exp.split("((?<=[+)*(-])|(?=[+)*(-]))");
        Stack<String> stack = new Stack<String>();
        ArrayList<String> output = new ArrayList();
        int r = 0;
        for(int i = 0; i < expression.length; i++){
            if(!isOp(expression[i]) && !expression[i].equalsIgnoreCase("(") && !expression[i].equalsIgnoreCase(")")){
                output.add(expression[i]);
                r++;
            }else if(expression[i].equalsIgnoreCase("(")){
                stack.push(expression[i]);
            }else if(isOp(expression[i])){
                if(!stack.isEmpty()) {
                    while (isOp(stack.peek()) && precedence(stack.peek()) >= precedence(expression[i])) {
                        output.add(stack.pop());
                        r++;
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                stack.push(expression[i]);
            }else if (expression[i].equalsIgnoreCase(")")){
                if(!stack.isEmpty()) {
                    while (!stack.peek().equalsIgnoreCase("(")) {
                        output.add(stack.pop());
                        r++;
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            output.add( stack.pop());
            r++;
        }
        String[] out = new String[output.size()];
        out = output.toArray(out);
        return evaluatePostfix(out);
    }

    /**
     * Takes in a postfix expression and uses the stack and helper functions to calculate
     * @param expression original string in postfix notation
     * @return int from postfix expression
     */
    static int evaluatePostfix(String[] expression){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i= 0; i < expression.length; i++){
            if(!isOp(expression[i])){
                stack.push(Integer.parseInt(expression[i]));
            }else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                if((expression[i]).equalsIgnoreCase("+")){
                    stack.push(val2 + val1);
                }
                if((expression[i]).equalsIgnoreCase("-")){
                    stack.push(val2 - val1);
                }
                if((expression[i]).equalsIgnoreCase("*")){
                    stack.push(val2 * val1);
                }
            }
        }
        return stack.pop();
    }

    /**
     *
     * @param token operator
     * @return true if an operator false otherwise
     */
    static boolean isOp(String token){
        return token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-")
                || token.equalsIgnoreCase("*");
    }

    /**
     *
     * @param token
     * @return precedence level of operator
     */
    static int precedence(String token){
        if(token.equalsIgnoreCase("*")){
            return 2;
        }else if(token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-")){
            return 1;
        }
        return 0;
    }
}

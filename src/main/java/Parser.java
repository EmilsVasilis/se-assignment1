
public class Parser {

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
}

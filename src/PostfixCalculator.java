import java.util.*;


public class PostfixCalculator{
     public static double evaluate(String postfix){
        List<String> parsed;
        char[] check = postfix.toCharArray();
        parsed =ParserHelper.parse(check);
        double answer = 0.0;


        ArrayStack<Double> stack = new ArrayStack<>();
        for (String token : parsed){
            if (isNumber(token)){
                stack.push(Double.parseDouble(token));
            }
            else{
                double b = stack.pop();
                double a = stack.pop();
                if (token.equals("+")){
                    answer = a+b;
                    stack.push(answer);
                }
                else if (token.equals("-")){
                    answer = a-b;
                    stack.push(answer);
                }
                else if (token.equals("*")){
                    answer = a*b;
                    stack.push(answer);
                }
                else if (token.equals("/")){
                    answer = a/b;
                    stack.push(answer);
                }
                else if (token.equals("^")){
                    answer = Math.pow(a, b);
                    stack.push(answer);
                }
            }
        }        
        return answer;
     }

     public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
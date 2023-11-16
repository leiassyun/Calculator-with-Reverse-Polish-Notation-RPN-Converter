import java.util.*;

public class Converter{
    List<String> parsed;

    public Converter(String expression){
        char[] check = expression.toCharArray();
        parsed =ParserHelper.parse(check);
       
    }

    public String toPostFix(){
        
        ArrayStack<String> arrayStack = new ArrayStack<>();
        String output = "";

        int i = 0;

        while(i<parsed.size()){
            String a = parsed.get(i);
            if (isNumber(a)){
                output += a + " ";
                i++;
            }
            else if (a.equals("(")){
                arrayStack.push(a);
                i++;
            }
            else if (a.equals(")")){
                while (!arrayStack.isEmpty()){
                    if (arrayStack.top().equals("(")){
                        arrayStack.pop();
                        break;
                    }
                    output += arrayStack.pop() + " ";
                }
                i++;
            }
            else{
                if (arrayStack.isEmpty()){
                    arrayStack.push(a);
                }
                else {
                    if (precedence(a) > precedence(arrayStack.top())){
                        arrayStack.push(a);
                    }
                    else {
                        while (!arrayStack.isEmpty() && precedence(a) <= precedence(arrayStack.top())){
                            output += arrayStack.pop() + " ";
                        }
                        arrayStack.push(a);

                    }
                }
                i++;
            }
        }
        while (!arrayStack.isEmpty()){
            output += arrayStack.pop() + " ";
        }
        return output;      
    }

    
    public static int precedence(String c){
        if (c.equals("*") || c.equals("/")){
            return 1;
        }
        else if (c.equals("+") || c.equals("-")){
            return 0;
        }
        else if (c.equals("^")){
            return 2;
        }
        return -1;
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


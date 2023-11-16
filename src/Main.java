import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        while (true){
            System.out.println("Type your expression:");
            String input = scn.nextLine();
            if (input.equals("end")){
                break;
            }
            System.out.println("");
            
            ExpressionTree expression = new ExpressionTree(input);

            System.out.print("Prefix: " );
            expression.prefix();
            System.out.print("Infix: " );
            expression.infix();
            System.out.print("Postfix: " );
            expression.postfix();
            System.out.println("");

            Converter converter = new Converter(input);
            String postfix = converter.toPostFix();
            double answer = PostfixCalculator.evaluate(postfix);
            System.out.println("Answer is " + String.format("%.2f", answer));
           System.out.println();
        }
        scn.close();
    }
    
}
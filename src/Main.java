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
            
            ExpressionTree expression = new ExpressionTree(input);

            System.out.print("Prefix: " );
            expression.prefix();
            System.out.print("Infix: " );
            expression.infix();
            System.out.print("Postfix: " );
            expression.postfix();
            
        }
        scn.close();
    }
    
}
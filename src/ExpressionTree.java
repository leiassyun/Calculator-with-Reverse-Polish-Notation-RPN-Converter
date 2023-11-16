
public class ExpressionTree{
    private Node root;
    
    public ExpressionTree(String expression){
        String postfix = new Converter(expression).toPostFix();
        buildTree(postfix);
    }

    public void buildTree(String postfix){
        Stack<Node> stack = new ArrayStack<>();
        
   
        String[] array = postfix.split(" ");

        for (String token : array) {
            if (Character.isDigit(token.charAt(0))){
                stack.push(new Node(token));
            }
            else if (!Character.isDigit(token.charAt(0)) && token != " "){
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }
                else{
                    Node right = stack.pop();
                    Node left = stack.pop();
                    root = new Node(token, left, right);
                    stack.push(root);
                }
            }
        }


    }

   
    public void prefix(){
        prefix(root);
        System.out.println();
    }
    private void prefix(Node t){
        if (t !=null){
            System.out.print(t + " ");
            prefix(t.leftChild);
            prefix(t.rightChild);
        }
    }
     

    public void infix(){
        System.out.print("(");
        infix(root);
        System.out.print(")");
        System.out.println();

    }
    private void infix(Node t) {
        if (t.leftChild != null) {
            System.out.print("(");
            infix(t.leftChild);
            System.out.print(")");

        }
        System.out.print(t);
        if (t.rightChild != null) {
            System.out.print("(");

            infix(t.rightChild);
            System.out.print(")");
        }
    }


    public void postfix(){
        postfix(root);
        System.out.println();
    }
    private void postfix(Node t){
        if(t != null){
			postfix(t.leftChild);
			postfix(t.rightChild);
			System.out.print(t + " ");
		}
    }
    
   
    public int evaluate(Node t){
        if (t.leftChild == null){
            return(((Character)t.element).charValue()) -'0';
        }
        else{
            int leftChild = evaluate(t.leftChild);
            int rightChild = evaluate(t.rightChild);
            switch (((Character)t.element).charValue()){
                case '+':
                    return leftChild + rightChild;
                case '-':
                    return leftChild - rightChild;
                case '*':
                    return leftChild * rightChild;
                case '/':
                    return leftChild / rightChild;
            }
        }
        return 0;
    }
}
    

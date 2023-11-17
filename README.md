# Calvulator with Reverse Polish Notation (RPN) Converter
This calculator consists of two fundamental steps: firstly, converting an infix expression to a post expression, and secondly, evaluating the resultant postfix expression.

In simple terms, an infix expression is the conventional way we write mathematical expressions, where operators like +,-,*, and / are placed between the operands (e.g., 3 + 4 * 5). 
On the other hand, a postfix expression, also known as Reverse Polish Notation (RPN), places operators after the operands (e.g., 3 4 5 * + ). 

The significant advantage of postfix notation is the elimination of parenthesis and the ambiguity regarding the order of operations, making it a streamlined approach for computer evaluation.

# Steps for the algorithm for converting a postfix expression into an expression tree:
1. Create an empty stack. Each element in the stack is going to be an expression tree node, so set the generic type accordingly.
2. Loop through each token in the postfix expression created by your converter.
a. If the token is a number, create a new expression tree node that represents just that number and push it onto the stack
b. If the token is an operator, create a new operator expression node. Pop two expression nodes off the top of the stack, and set them as children of this new node. Then push this operator node onto the stack
3. Once all the tokens in the postfix expression have been processed, the stack will contain only one expression tree node. Pop it out, and return it.

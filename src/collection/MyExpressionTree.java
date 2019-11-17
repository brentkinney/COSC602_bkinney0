/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Brent
 */
public class MyExpressionTree extends MyBinaryTree {
    
    private
             MyStack stack = new MyStack();
             MyDeque deque = new MyDeque();
    /**
	 * Default Constructor
	 */
	public MyExpressionTree()
	{
		root = null;
	}
        
        
        /**
         * Constructor that takes a MyBinaryTreeNode as a parameter
         * @param rt is the node that becomes the root of the tree
         */
        public MyExpressionTree(MyBinaryTreeNode rt)
        {
            root = rt;
        }
        
        
        /**
         * method that evaluates the BinaryTreeExpression
     * @param rt root of tree expression to be evaluated
     * @return result of expression tree evaluation
         */
        public static int evaluate(MyBinaryTreeNode rt)
        {
            if(rt == null)
            {
                return -1;
            }
            
            if(rt.left ==  null && rt.right == null)
            {
                return Character.getNumericValue((Character)rt.data);
            }
            
            switch((Character)rt.data)
            {
                case '-':
                    return evaluate(rt.left) - evaluate(rt.right);
                    
                case '+':
                    return evaluate(rt.left) + evaluate(rt.right);
                    
                case '*':
                    return evaluate(rt.left) * evaluate(rt.right);
                    
                case '/':
                    return evaluate(rt.left) / evaluate(rt.right);
                    
                case '%':
                    return evaluate(rt.left) % evaluate(rt.right);
            }
            return -1;
        }
        
        
        
        /**
         * method to traverse a tree in preorder method
         * @return returns string of expression tree in preorder notation
         */
        @Override
        public String preorderTraversal()
        {
            return preorderHelper(root) + "\n";
        }
        
        /**
         * private helper method for preorderTraversal()
         */
        private String preorderHelper(MyBinaryTreeNode rt)
        {
            if(rt == null)
                return "";
            
            return rt.data + " " + preorderHelper(rt.left) + " " + preorderHelper(rt.right);
        }
        
        
        /**
         * method to traverse a tree in inorder notation
         * @return string of expression tree in inorder notation
         */
        @Override
        public String inorderTraversal()
        {
            return inorderHelper(root) + "\n";
        }
        
        /**
         * private helper method for inorderTraversal()
         */
        private String inorderHelper(MyBinaryTreeNode rt)
        {
            if(rt == null)
                return "";
            
            return inorderHelper(rt.left) + " " + rt.data + " " + inorderHelper(rt.right);
        }
        
        
        /**
         * method to traverse a tree in postorder notation
         * @return string of expression tree in postorder notation
         */
        @Override
        public String postorderTraversal()
        {
            return postorderHelper(root) + "\n";
        }
        
        /**
         * private helper method for postorderTraversal()
         */
        private String postorderHelper(MyBinaryTreeNode rt)
        {
            if(rt == null)
                return "";
            
            return postorderHelper(rt.left) + " " + postorderHelper(rt.right) + " " + rt.data;
        }
        
        
        /**
       * method the converts a given string from an infix expression to a
       * postfix expression.
       * @param exp is the string of an infix expression
       * @throws NumberFormatException 
       */
       public void convertInfix(String exp) throws NumberFormatException
    {
            stack.clear();
            deque.clear();

       //step 1 read input line and do as much checking as possible on validity of 
       //exp
       
        for (int i = 0; i<exp.length(); ++i){
            char c = exp.charAt(i);           
            if(i > 0)
            {
                char previous = exp.charAt(i-1);
                if((isNumber(c) && isNumber(previous)) || isBalanced(exp) == false)
                {
                    throw new NumberFormatException("**Invalid Expression**");
                }
            }
       
       //step 2 read first char and if number, put into tree node and put in deque
       // if char is operand, check top of stack of any other operands and if higher
       //precedence then top of stack push onto stack , if not, pop two numbers from
       //back of deque and hang onto operand
       //if char is open parenthesis, push onto the stack
            if (isNumber(c))
            {
                MyBinaryTreeNode node = new MyBinaryTreeNode(c);
                deque.insertBack(node);
            }
            else if (c == '(')
            {
                MyBinaryTreeNode node = new MyBinaryTreeNode(c);
                stack.push(node);
            }
            else if ( c == ')')
            {
                
                while ((char)stack.top() != '(')
                {
                    //write code that handles the operands from the close to open parenthesis
                    MyBinaryTreeNode node = new MyBinaryTreeNode(stack.pop());
                    node.right = (MyBinaryTreeNode) deque.removeBack();
                    node.left = (MyBinaryTreeNode) deque.removeBack();
                    deque.insertBack(node);
                }
            }
            else
            {
                if (Precedence(c) > Precedence((char) stack.top()))
                {
                   MyBinaryTreeNode node = new MyBinaryTreeNode(c);
                   stack.push(node); 
                }
            }
        }
       
       //step 3 continue adding to deque and stack for numbers and operands respectively
       //***note***if open parenthesis has not been closed, continue adding to deque
       //and stack until it closes, then place values into tree expression
       
       
       //step4 if it is time to pop values, take the operand off top of stack
       //and temporarily hold, pop last number value from deque, hang onto operand
       //as right child, pop another number value from back of deque and hang as
       //left child to operand.  now insert tree into back of deque.
       //**note**if close parenthese is reached, you need to pop any operators and
       //hang them with the corresponding numbers fromt he deque.  Once operators
       // handled, the top of stack should be
       //the open parenthesis as you should have handled any operators in between.
       //if so, pop the open parenthesis and keep going
       
       
       //step 5 this pattern repeats until the entire line is read and dealt with
       //at the end the stack should be empty and there should only be one value in
       //the deque, it should be an expression tree
    }
        
        
        
        
        /**
        * Method to read the input file, execute all methods and store result
        * in the output file
        * @throws FileNotFoundException 
        */
        public void convertInputToOutput() throws FileNotFoundException {
           PrintWriter outputFile = null;
           Scanner input = null;
           int eval = 0;
           String post = "";
        try {
            File file = new File("..\\COSC602_P4_Input.txt");
            outputFile = new PrintWriter("..\\COSC602_P4_Output_bkinney0.txt");
            input = new Scanner(file);
        }
        catch(FileNotFoundException ex){
         System.out.println("Error openeing files");
         throw ex;
        }
                while (input.hasNextLine()) {
                    
                    String line = input.nextLine();
                    String exp = line.replaceAll("\\s", "");                   
                    if (!exp.isEmpty()){
                        outputFile.println("Original Infix:            " + line);
                        try{
                            this.convertInfix(exp);                        
                        }
                        catch(NumberFormatException numberException){
                            outputFile.println("**Invalid Expression** \n\n");
                            continue; 
                        }
                        outputFile.println("Preorder Traversal:         " + this.preorderTraversal());
                        outputFile.println("Inorder Traversal:          " + this.inorderTraversal());
                        outputFile.println("Postorder Traversal:        " + this.postorderTraversal());
                        try
                        {
                            eval = evaluate((MyBinaryTreeNode) deque.removeBack());
                        }
                        catch(NullPointerException nullException){
                            outputFile.println("**Invalid Expression** \n\n");
                            continue;                        
                        }  
                        
                        //outputFile.println("Corresponding Postfix:     " + post );                   
                        outputFile.println("Evaluation Result:        =" +eval+ " \n\n");
                    }
                }                 
                
                input.close();
                outputFile.close();
            } 
        
        
        /**
     * 
     * @param ch the char to be checked
     * @return the rank of the operator precedence in terms of mathmatical operations
     */        
    static int Precedence(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/':
        case '%':
            return 2; 
        } 
        return -1; 
    }
    
    
    
    /**
         * method that checks if a char is an operator
         * @param c the char to check
         * @return true if given char matches one from set of operands below
         */ 
      public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' 
        || c == '(' || c == ')';
      } 
      
      
       /**
        * this method checks if a char is a numerical number
        * @param c the char to check
        * @return true if the given char is a number
        */
       private boolean isNumber(char c){
           if(c >= 48 && c < 58)
               return true;
           else{
               return false;
           }
       }
       
       
       /**
        * this method checks if a given string has a balanced number of parenthesis
        * @param str is the string to check
        * @return true if the left amount of brackets matches the right amount
        * of brackets.
        */
      public static boolean isBalanced(String str) {
    int count = 0;

    for (int i = 0; i < str.length() && count >= 0; i++) {
        if (str.charAt(i) == '(')
            count++;
        else if (str.charAt(i) == ')')
            count--;
    }

    return count == 0;
}
}

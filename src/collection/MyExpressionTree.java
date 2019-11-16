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
        public void convertInfix (String exp)
        {
            
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
                            post = this.convertInfix(exp);                        
                        }
                        catch(NumberFormatException numberException){
                            outputFile.println("**Invalid Expression** \n\n");
                            continue; 
                        }
                        try{
                            eval = this.evalPostfix(post);
                        }
                        catch(NullPointerException nullException){
                            outputFile.println("**Invalid Expression** \n\n");
                            continue;                        
                        }  
                        
                        outputFile.println("Corresponding Postfix:     " + post );                   
                        outputFile.println("Evaluation Result:        ="+eval +" \n\n");
                    }
                }                 
                
                input.close();
                outputFile.close();
            } 
}

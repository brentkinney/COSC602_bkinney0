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
public class InfixToPostfix {
    private
            MyQueue queue = new MyQueue();
            MyStack initStack = new MyStack();
            MyStack finalStack = new MyStack();
            String postfixExp;
    
            
            
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
            File file = new File("..\\COSC602_P3_Input.txt");
            outputFile = new PrintWriter("..\\COSC602_P3_Output_bkinney0.txt");
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
       * method the converts a given string from an infix expression to a
       * postfix expression.
       * @param exp is the string of an infix expression
       * @return the string of the associated postfix expression
       * @throws NumberFormatException 
       */
       public String convertInfix (String exp) throws NumberFormatException 
       {
           
           initStack.clear();
           queue.clear();
           finalStack.clear();
           postfixExp = "";
           
          for (int i = 0; i<exp.length(); ++i){
            char c = exp.charAt(i);           
            if(i > 0){
                char previous = exp.charAt(i-1);
                if((isNumber(c) && isNumber(previous)) || isBalanced(exp) == false){
                    throw new NumberFormatException("**Invalid Expression**");
                }
            }
            
            if (Precedence(c) > 0)
            {
                while(initStack.isEmpty() == false && Precedence((char) initStack.top()) >= Precedence(c))
                {
                    queue.insertBack(initStack.pop());
                }
                initStack.push(c);
            }
            else if (c ==')')
            {
                char x = (char) initStack.pop();
                while(x!= '(')
                {
                    queue.insertBack(x);
                    x = (char) initStack.pop();
                }
            }
            else if (c == '(')
            {
                initStack.push(c);
            }
            else
            {
                queue.insertBack(c);
            }
          }
          while (!initStack.isEmpty()) 
          {
              queue.insertBack(initStack.pop());
          }
          postfixExp = queue.postFixString();
          postfixExp = postfixExp.replaceAll("\\s","");
          return postfixExp;
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
       
        
     
   /**
    * method that evaluates a string given in postfix notation
    * @param exp is the postfix notation string that is given
    * @return returns the int value of the expression
    */   
  public int evalPostfix(String exp) 
    { 
        exp = exp.replaceAll("\\s", "");
        
        if (exp == "**Invalid Expression**")
            return 0;
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            finalStack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                try{
                    int val1 = (int) finalStack.pop(); 
                    int val2 = (int) finalStack.pop(); 

                    switch(c) 
                    { 
                        case '+': 
                        finalStack.push(val2+val1); 
                        break; 

                        case '-': 
                        finalStack.push(val2- val1); 
                        break; 

                        case '/': 
                        finalStack.push(val2/val1); 
                        break; 

                        case '*': 
                        finalStack.push(val2*val1); 
                        break;

                        case '%':
                        finalStack.push(val2%val1);
                        break;
                    } 
                }
                catch(NullPointerException nullException){
                    postfixExp = "**Invalid Expression**";
                    throw nullException;
                    
                }
            } 
        } 
        return (int) finalStack.pop();     
    }     
}

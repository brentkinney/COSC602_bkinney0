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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brent
 */
public class InfixToPostfix {
    private
            //MyQueue queue = new MyQueue();
            //MyStack initStack = new MyStack();
            //MyStack finalStack = new MyStack();
            //String postfixExp;
            
    static int Prec(char ch) 
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
            
            
    
       public void convertInputToOutput() {
           PrintWriter outputFile = null;
        try {
            File file = new File("..\\COSC602_P3_Input.txt");
            outputFile = new PrintWriter("..\\COSC602_P3_Output_bkinney0.txt");
            try {
                Scanner input = new Scanner(file);
                while (input.hasNextLine()) {
                    
                    String exp = input.nextLine();
                    exp = exp.replaceAll("\\s", "");
                    if (!exp.isEmpty()){
                    String post = this.convertInfixToPostfix(exp);                    
                    outputFile.println("Original Infix:            " + exp);
                    outputFile.println("Corresponding Postfix:     " + post );
                    if (!post.equalsIgnoreCase("Invalid Expression")){
                    int eval = this.evaluatePostfix(post);
                    outputFile.println("Evaluation Result:        =" + eval );}
                    outputFile.println();
                    outputFile.println();
                    }
                    
                }
                input.close();
                outputFile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InfixToPostfix.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            outputFile.close();
        }
    }
            
            
            
      public String convertInfixToPostfix (String exp) 
      {
          String postfix = new String("");
          MyStack stack = new MyStack();
          
         for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) 
                postfix += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')')
            {
                while (!stack.isEmpty() && !stack.top().equals('(')) 
                    postfix += stack.pop(); 
                  
                if (!stack.isEmpty() && !stack.top().equals('(')) 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            }
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec((char) stack.top())){ 
                    if(stack.top().equals('('))
                        return "Invalid Expression"; 
                    postfix += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.top().equals('(')) 
                return "Invalid Expression"; 
            postfix += stack.pop(); 
         }
        //postfixExp = postfix;
        return postfix; 
    } 
     
      
  public int evaluatePostfix(String exp) 
    { 
        //create a stack 
        MyStack stack=new MyStack(); 
        if (exp == "Invalid Expression")
            return 0;
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = (int) stack.pop(); 
                int val2 = (int) stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break;
                    
                    case '%':
                    stack.push(val2%val1);
                    break;
              } 
            } 
        } 
        return (int) stack.pop();     
    }     
      
      
}

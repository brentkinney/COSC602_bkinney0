/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import collection.*;

/**
 *
 * @author Brent
 */
public class Project3 {
    
    public static void test()
    {
       
       String exp1 = "3+4*5";
       String exp2 = "((3+4))*5";
       String exp3 = "((3+4) * 5";
       String exp4 = "3*((4+5)%6)-7/8";
       InfixToPostfix conversion = new InfixToPostfix();
       /**
       String postfix1 = conversion.infixToPostfix(exp1);
       String postfix2 = conversion.infixToPostfix(exp2);
       String postfix3 = conversion.infixToPostfix(exp3);
       String postfix4 = conversion.infixToPostfix(exp4);
       System.out.println(conversion.infixToPostfix(exp1));
       System.out.println(conversion.evaluatePostfix(postfix1));
       System.out.println(conversion.infixToPostfix(exp2));
       System.out.println(conversion.evaluatePostfix(postfix2));
       System.out.println(conversion.infixToPostfix(exp3));
       System.out.println(conversion.evaluatePostfix(postfix3));
       System.out.println(conversion.infixToPostfix(exp4));
       System.out.println(conversion.evaluatePostfix(postfix4));
       
       System.out.println("Input file has been converted, check output file for results");
       System.out.println(conversion.convertInfix(exp1));
       **/
       conversion.convertInputToOutput();
       
    }
}

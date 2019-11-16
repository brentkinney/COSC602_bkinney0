/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import collection.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Brent
 */
public class Project4 {
     public static void test() throws FileNotFoundException
    {
       
       MyExpressionTree tree = new MyExpressionTree();
      
       try
       {
       tree.convertInputToOutput();
       }
       catch(FileNotFoundException exception)
       {
           throw exception;
       }
       
    }
    
}

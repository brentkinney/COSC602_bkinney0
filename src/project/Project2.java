/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import collection.*;
import java.util.Scanner;

/**
 *
 * @author Brent
 */
public class Project2 
{
    
     public static void test() 
     {
         char choice = 'y';
         Scanner in = new Scanner(System.in);
         String temp;
         int [] phoneGiven;
         
         do
         {
             char innerChoice = 'y';
             
             do
             {
                 System.out.println("Please enter a 7 digit phone number: ");
                 temp = in.nextLine();
                 phoneGiven = new int[temp.length()];
                 if (temp.length() != 7)
                {
                    System.out.println("Phone must be 7 digits, please try again: ");
                    System.out.println();
                }
                 else if (temp.contains("0") == true || temp.contains("1") == true)
                 {
                     System.out.println("Phone must not contain '0' or '1', please try again: ");
                     System.out.println();
                 }
                 else
                 {
                     System.out.println("You entered: "+temp);
                     System.out.println();
                     innerChoice = 'n';
                 }
             } while (innerChoice == 'y' || innerChoice == 'Y'); 
            
            for (int i =0; i < temp.length(); i++)
            {
                phoneGiven[i] = temp.charAt(i) - '0';
            }
            
           
         } while (choice == 'y' || choice == 'Y'); 
     }
}

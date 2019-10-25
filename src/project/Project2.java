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
         String wordList = "";
         
         
         do
         {
             char innerChoice = 'y';
             
             do
             {
                 System.out.println("Please enter a 7 digit phone number: ");
                 temp = in.nextLine();
                 
                 if (temp.length() != 7)
                {
                    System.out.println("Phone must be 7 digits, please try again!");
                    System.out.println();
                }
                 else if (temp.contains("0") == true || temp.contains("1") == true)
                 {
                     System.out.println("Phone must not contain '0' or '1', please try again!");
                     System.out.println();
                 }
                 else
                 {
                     System.out.println("You entered: "+temp);
                     System.out.println();
                     innerChoice = 'n';
                 }
             } while (innerChoice == 'y' || innerChoice == 'Y'); 
            
            
            PhoneNumberNumerator numerator1 = new PhoneNumberNumerator();
            numerator1.printAllWordsFromPrefixAndPhoneNumber(wordList, temp);
            numerator1.compareWords();
            numerator1.printComparedList(temp);
            System.out.println();
            System.out.println();
            System.out.println("Would you like to check another phone number? (Y/N): ");
            choice = in.next().charAt(0);
            in.nextLine();
            System.out.println();
            System.out.println();
         } while (choice == 'y' || choice == 'Y'); 
     }
}

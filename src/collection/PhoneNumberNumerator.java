/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;


/**
 *
 * @author Brent
 */
public class PhoneNumberNumerator {
    private
    MyVector numeratorList = new MyVector();
    MyVector wordList = new MyVector();
    MyVector comparedList = new MyVector();
    
    
    
       public void printAllWordsFromPhoneNumber(String phonenumber)
	{
		printAllWordsFromPrefixAndPhoneNumber("", phonenumber);
	}   
        
        String getLettersForNumber(char digit)
	{
                String[] table = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		Boolean valid = ((digit >= '2') && (digit <= '9'));
		return valid ? table[digit - '0'] : table[1];
	}
            
      /**
       * This method adds all possible word combinations for a phone number to 
       * MyVecotor numeratorList
       * @param prefix empty string
       * @param remaining the numbers remaining for the phone number
       */
       public void printAllWordsFromPrefixAndPhoneNumber(String prefix, String remaining)
	{
		if ((remaining == "") || (remaining.length() == 0))
		{
			numeratorList.append(prefix.trim());
		}
		else
		{
			char currentChar = remaining.charAt(0);
			if ((currentChar >= '2') && (currentChar <= '9'))
			{
				String chars_in_digit = getLettersForNumber(remaining.charAt(0));

				for (int i = 0; i < chars_in_digit.length(); i++)
				{
					String newprefix = " " + prefix + chars_in_digit.charAt(i);
					String newremaining = remaining.substring(1);
					printAllWordsFromPrefixAndPhoneNumber(newprefix, newremaining);
				}
			}
			else
			{
				String newprefix = prefix + currentChar;
				String newremaining = remaining.substring(1);
				printAllWordsFromPrefixAndPhoneNumber(newprefix, newremaining);
			}
		}
	}
       
      /**
       * Used to make sure numeratorList contains all the combinations of letters
       * a Phone number can have
       * @param phonenum is the given phone number 
       */ 
      public void printList(String phonenum)
	{
		for (int i = 0; i < numeratorList.size(); i++)
                {	
		System.out.println((i + 1) + "." + numeratorList.data[i] + " ");
		}
                
		if (numeratorList.size() == 1)
			System.out.println("\n\nFor phone number " + phonenum + " there is " + numeratorList.size() + " possible word.");
		else
			System.out.println("\n\nFor phone number " + phonenum + " there are " + numeratorList.size() + " possible words.");

	}
      
      
      /**
       * print the list of real words that match a phone number
       * @param phonenum the phone number used
       */
      public void printComparedList(String phonenum)
	{
		for (int i = 0; i < comparedList.size(); i++)
                    {
                       System.out.println((i + 1) + "." + comparedList.data[i] + " "); 
                    }
                System.out.println();
                System.out.println("\n\nFor phone number " + phonenum + " there are " + comparedList.size() + " possible words.");
        }
      
      
      
      /**
       * compare the raw combinations of letters a phone number can have with 
       * the words list and store all matches found.
       */
      public void compareWords()
      {
          File file = new File("..\\COSC602_P2_EnglishWordList.txt");
          try{
          Scanner input = new Scanner(file);
          while (input.hasNextLine())
          {
              
              wordList.append(input.nextLine());
          }
          input.close();
          }
          catch (FileNotFoundException e)
          {
              e.printStackTrace();
          }
                    
          for (int i = 0; i < numeratorList.size(); i++)
          {
              if (MySearch.binarySearch(wordList, (Comparable) numeratorList.data[i]) != -1)
                      {
                          comparedList.append(numeratorList.data[i]);
                      }                  
          }
      }
}

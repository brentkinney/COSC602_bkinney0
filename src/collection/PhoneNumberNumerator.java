/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


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
		//MyVector table = new MyVector();
                //table.append("");
                //table.append("");
                //table.append("ABC");
                //table.append("DEF");
                //table.append("GHI");
                //table.append("JKL");
                //table.append("MNO");
                //table.append("PQRS");
                //table.append("TUV");
                //table.append("WXYZ");
                String[] table = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
		Boolean valid = ((digit >= '2') && (digit <= '9'));
		return valid ? table[digit - '0'] : table[1];
	}
            
      public void printAllWordsFromPrefixAndPhoneNumber(String prefix, String remaining)
	{
		if ((remaining == "") || (remaining.length() == 0))
		{
			numeratorList.append(prefix);
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
       
       
      public void printList(String phonenum)
	{
		for (int i = 0; i < numeratorList.size(); i++)
		{

			if (i % 4 == 0) {
				System.out.println();
			}

			if (i < 10)
			{
				System.out.println((i + 1) + "." + numeratorList.data[i] + " ");
			}
			else
			{
				System.out.println(" " + "\b\b" + (i + 1) + "." + numeratorList.data[i] + "  ");
			}



		}


		if (numeratorList.size() == 1)
			System.out.println("\n\nFor phone number " + phonenum + " there is " + numeratorList.size() + " possible word.");
		else
			System.out.println("\n\nFor phone number " + phonenum + " there are " + numeratorList.size() + " possible words.");

	}
      
      
      
      public void printComparedList(String phonenum)
	{
		for (int i = 0; i < comparedList.size(); i++)
                    if (i % 4 == 0) {
				System.out.println();
			}
                else
                    {
                       System.out.println((i + 1) + "." + comparedList.data[i] + " "); 
                    }
                System.out.println();
                System.out.println();
                System.out.println("\n\nFor phone number " + phonenum + " there are " + comparedList.size() + " possible words.");
        }
      
      
      
      
      public void compareWords()
      {
          File file = new File("..\\COSC602_P2_EnglishWordList.txt");
          //System.out.println(file.getAbsolutePath());
          //String file = new File("").getAbsolutePath();
          //file.concat("./COSC602_P2_EnglishWordList.txt");
          try{
          Scanner input = new Scanner(file);
          while (input.hasNextLine())
          {
              //if (input.nextLine().length() == 7)
              wordList.append(input.nextLine());
          }
          input.close();
          }
          catch (FileNotFoundException e)
          {
              e.printStackTrace();
          }
          for (int i = 0; i < wordList.size(); i++)
                    if (i % 4 == 0) {
				System.out.println();
			}
                else
                    {
                       System.out.println((i + 1) + "." + wordList.data[i] + " "); 
                    }
          /**
          for (int i = 0; i < numeratorList.size(); i++)
          {
              if (MySearch.binarySearch(wordList, numeratorList.data[i]) != -1)
                      {
                          comparedList.append(numeratorList.data[i]);
                      }
              
                  
          }**/
      }
}

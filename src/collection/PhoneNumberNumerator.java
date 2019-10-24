/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Brent
 */
public class PhoneNumberNumerator {
    private
    MyVector numeratorList = new MyVector();
    
    
    
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
}

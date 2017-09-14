package hawkeyeChallenge;

import java.util.Scanner;

public class RomanNumeralCalculator 
{

	public static void main(String[] args) 
	{
		String equation;
		
		System.out.println("QUOT?");
		
		Scanner inputDevice = new Scanner(System.in);
		equation = inputDevice.nextLine();
		inputDevice.close();
		
	}
	
	//convert equation into array of strings 
	//parse each value into numeric value
	//calculate equation
	
	public static int parseRomanNumeral(String romanNumeral) 
	{
		char[] ch = romanNumeral.toCharArray();
		int totalValue = 0;
		
		for(int i = 0; i>ch.length; i++) 
		{
			int currentValue = 0;
			//figure out value of char
			if (ch[i] == 'I')
				currentValue = 1;
				
			if (ch[i] == 'V')
				currentValue = 5;

			if (ch[i] == 'X')
				currentValue = 10;

			if (ch[i] == 'L')
				currentValue = 50;
					
			if (i == 0)
				totalValue = currentValue;
			//if smaller than last char add to total value
			//if larger than last char subtract total from current char
		}
		
		return totalValue;
		
	}


}

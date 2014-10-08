/*
 * Author: Ryan Peacock
 * Project: Roman Numerals
 * Filename: P03_RomanNumerals.java
 * Purpose: Print a given number in roman numerals
 * Pseudocode:
 * 
 * 	string roman(int num)
 * 	{
 * 		if (num = 1000)
 * 			return "M";
 * 
 * 		string result = "";
 * 
 * 		int buffer = num;
 * 
 * 		int hundreds = 0;
 * 		while (buffer > 100)
 * 		{
 * 			hundreds++;
 * 			buffer -= 100;
 * 		}
 * 
 * 		int tens = 0;
 * 		while (buffer > 10)
 * 		{
 * 			tens++;
 * 			buffer -= 10;
 * 		}
 * 
 * 		int ones = buffer;
 * 		for (int i = 0; i < hundreds; ++i)
 *  	{
 *  		result += "C";
 *  	}		
 *  	for (int i = 0; i < tens; ++i)
 *  	{
 *  		result += "X";
 *  	}		
 *  	for (int i = 0; i < ones; ++i)
 *  	{
 *  		result += "I";
 *  	}
 *  	
 *  	result.replace("CCCCC", "D");
 *  	result.replace("DCCCC", "CM");
 *  	result.replace("CCCC", "CD");
 *  	
 *  	result.replace("XXXXX", "L");
 *  	result.replace("LXXXX", "XC");
 *  	result.replace("XXXX", "XL");
 *  	
 *  	result.replace("IIIII", "V");
 *  	result.replace("VIIII", "IX");
 *  	result.replace("IIII", "IV");
 *  
 *  	return result;
 *  }
 */

package net.einsteinsci.apcompsci.p03_strings;

import net.einsteinsci.apcompsci.Start;

public class P03_RomanNumerals
{
	public static final int MAXVALUE = 1000;
	
	public static void main(int num)
	{
		Start.println("" + num + " = " + roman(num));
	}
	
	private static String roman(int num)
	{
		if (num > MAXVALUE)
		{
			throw new IllegalArgumentException("Value is greater than maximum of " + MAXVALUE + ": " + num);
		}
		else if (num <= 0)
		{
			throw new IllegalArgumentException("There are no zeroes or negative numbers in Rome. Your input: " + num);
		}
		else if (num == 1000)
		{
			return "M";
		}
		
		String translated = "";
		
		int total = num;
		
		int hundreds = 0;
		while (total > 100)
		{
			total -= 100;
			hundreds++;
		}
		
		int tens = 0;
		while (total > 10)
		{
			total -= 10;
			tens++;
		}
		
		int ones = total;
		
		for (int i = 0; i < hundreds; ++i)
		{
			translated += "C";
		}		
		for (int i = 0; i < tens; ++i)
		{
			translated += "X";
		}		
		for (int i = 0; i < ones; ++i)
		{
			translated += "I";
		}
		
		translated = translated.replace("CCCCC", "D");
		translated = translated.replace("DCCCC", "CM");
		translated = translated.replace("CCCC",  "CD");
		translated = translated.replace("XXXXX", "L");
		translated = translated.replace("LXXXX", "XC");
		translated = translated.replace("XXXX", "XL");
		translated = translated.replace("IIIII", "V");
		translated = translated.replace("VIIII", "IX");
		translated = translated.replace("IIII", "IV");
		
		return translated;
	}
}

/*
 * Author: Ryan Peacock
 * Project: Replicator Project (Week 3)
 * Filename: P03_Replicator.java
 * Purpose: Repeat the same string a given number of times
 * Pseudocode:
 * 
 * 	string repl(string repeated, int times)
 * 	{
 * 		string temp = "";
 * 		if (n > 0)
 * 		{
 * 			foreach (int n until times)
 * 			{
 * 				temp.append(repeated);
 * 			}
 * 		}
 * 		return temp;
 * 	}
 */

package net.einsteinsci.apcompsci.p03_strings;

import net.einsteinsci.apcompsci.Start;

public class P03_Replicator
{
	
	public static void main(String repl, int n)
	{
		Start.println(repl(repl, n));
	}
	
	private static String repl(String str, int n)
	{
		String buffer = "";
		if (n > 0)
		{
			for (int i = 0; i < n; ++i)
			{
				buffer += str;
			}
		}
		
		return buffer;
	}
}

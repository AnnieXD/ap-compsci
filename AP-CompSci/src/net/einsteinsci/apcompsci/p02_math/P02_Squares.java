/*
 * Author: Ryan Peacock
 * Project: Square Numbers
 * Filename: P02_Squares.java
 * Purpose: Output the first n square integers
 * Pseudocode:
 * 
 * 	void main(int n)
 * 	{
 * 		foreach (int i until squareTo)
 * 		{
 * 			print(square(i));
 * 		}
 * 	}
 * 
 * 	int square(int x)
 * 	{
 * 		int cumulative = 0;
 * 		foreach (int i until x)
 * 		{
 * 			cumulative += x;
 * 		}
 * 
 * 		return cumulative;
 * 	}
 */

package net.einsteinsci.apcompsci.p02_math;

import net.einsteinsci.apcompsci.Start;

public class P02_Squares 
{
	public static void main(int squareTo)
	{
		Start.println("First " + squareTo + " squares: ");
		for (int i = 1; i <= squareTo; ++i)
		{
			Start.println(square(i));
		}
	}
	
	// Without multiplication or power functions
	private static int square(int squared)
	{
		int cumulative = 0;
		for (int i = 0; i < squared; ++i)
		{
			cumulative += squared;
		}
		return cumulative;
	}
}

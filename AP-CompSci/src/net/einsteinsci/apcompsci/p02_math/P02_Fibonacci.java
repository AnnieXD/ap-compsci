/*
 * Author: Ryan Peacock
 * Project: Fibonacci Numbers
 * Filename: P02_Fibonacci.java
 * Purpose: Output the first n numbers of the fibonacci sequence
 * Pseudocode:
 * 
 * void main(int depth)
 * {
 * 		foreach(int n until depth)
 * 		{
 * 			print(eval(n));
 * 		}
 * }
 * 
 * void eval(int val)
 * {
 * 		if (val == 1 OR 2)
 * 			return 1;
 * 		else
 *			return eval(val - 2) + eval(val - 1);
 * } 
 */

package net.einsteinsci.apcompsci.p02_math;

import net.einsteinsci.apcompsci.Start;

public class P02_Fibonacci
{
	public static long iterations = 0;
	
	public static void main(int depth)
	{
		Start.println("First " + depth + " numbers of the Fibonacci Sequence: ");
		iterations = 0;
		for (int i = 1; i <= depth; ++i)
		{
			Start.println(fibonacciEval(i));
		}
	}
	public static void main(int depth, boolean showIterations)
	{
		main(depth);
		
		if (showIterations)
		{
			Start.println("\nIterations: " + iterations);
		}
	}
	
	private static int fibonacciEval(int depth)
	{
		iterations++;
		if (depth == 1 || depth == 2)
		{
			return 1;
		}
		else
		{
			return fibonacciEval(depth - 2) + fibonacciEval(depth - 1);
		}
	}
}

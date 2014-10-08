/*
 * Author: Ryan Peacock
 * Project: Starter for week 2 'math' programs
 * Filename: P02_Start.java
 * Purpose: Launch the week 2 'math' programs from a centralized place
 * Pseudocode:
 * 
 *  void main()
 *  {
 *  	print("=========== Fibonacci ============");
 *  	Fibonacci.main();
 *  	print("============ Squares =============");
 *  	Squares.main();
 *  	print("=========== Quadratic ============");
 *  	Quadratic.main();
 *  	print("===========  Triangle ============");
 *  	Triangle.main();
 *  }
 */

package net.einsteinsci.apcompsci.p02_math;

import net.einsteinsci.apcompsci.Start;

public class P02_Start
{
	public static void main()
	{
		Start.println("====================================================\nFIBONACCI:");
		P02_Fibonacci.main(Start.getInt("First n Fibonacci numbers: "), false);
		Start.println("====================================================\nSQUARES:");
		P02_Squares.main(Start.getInt("First n square numbers: "));
		Start.println("====================================================\nQUADRATIC:");
		P02_Quadratic.main(Start.getFloat("Ax^2 + Bx + C\nA = "), Start.getFloat("B = "), Start.getFloat("C = "));
		Start.println("====================================================\nTRIANGLE:");
		P02_Triangle.main(Start.getFloat("Side A: "), Start.getFloat("Side B: "), Start.getFloat("Side C: "));
	}
}

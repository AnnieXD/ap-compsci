/*
 * Author: Ryan Peacock
 * Project: Starter for week 2 'math' programs
 * Filename: P02_Console.java
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

package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.Console;
import net.einsteinsci.apcompsci.p02_math.*;

public class P02_Start implements IStartable
{
	public void main()
	{
		Console.println("====================================================\nFIBONACCI:");
		P02_Fibonacci.main(Console.getInt("First n Fibonacci numbers: "), false);
		Console.println("====================================================\nSQUARES:");
		P02_Squares.main(Console.getInt("First n square numbers: "));
		Console.println("====================================================\nQUADRATIC:");
		P02_Quadratic.main(Console.getFloat("Ax^2 + Bx + C\nA = "), Console.getFloat("B = "), Console.getFloat("C = "));
		Console.println("====================================================\nTRIANGLE:");
		P02_Triangle.main(Console.getFloat("Side A: "), Console.getFloat("Side B: "), Console.getFloat("Side C: "));
	}
}

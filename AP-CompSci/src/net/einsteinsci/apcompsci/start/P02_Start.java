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

import net.einsteinsci.apcompsci.ConsoleUtils;
import net.einsteinsci.apcompsci.p02_math.*;

public class P02_Start implements IStartable
{
	public void main()
	{
		ConsoleUtils.println("====================================================\nFIBONACCI:");
		P02_Fibonacci.main(ConsoleUtils.getInt("First n Fibonacci numbers: "), false);
		ConsoleUtils.println("====================================================\nSQUARES:");
		P02_Squares.main(ConsoleUtils.getInt("First n square numbers: "));
		ConsoleUtils.println("====================================================\nQUADRATIC:");
		P02_Quadratic.main(ConsoleUtils.getFloat("Ax^2 + Bx + C\nA = "), ConsoleUtils.getFloat("B = "), ConsoleUtils
				.getFloat("C = "));
		ConsoleUtils.println("====================================================\nTRIANGLE:");
		P02_Triangle.main(
				ConsoleUtils.getFloat("Side A: "), ConsoleUtils.getFloat("Side B: "), ConsoleUtils.getFloat("Side C: "));
	}
}

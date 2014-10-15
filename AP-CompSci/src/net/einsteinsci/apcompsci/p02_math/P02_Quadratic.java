/*
 * Author: Ryan peacock
 * Project: Quadratic Numbers Project
 * Filename: P02_Quadratic.java
 * Purpose: Output the roots of a quadratic equation
 * Pseudocode:
 * 
 * void main(double a, double b, double c)
 * {
 * 		print("Roots: {0} and {1}", quadraticPlus(a, b, c), quadraticMinus(a, b, c));
 * }
 * 
 * double quadraticPlus(double a, double b, double c)
 * {
 * 		return (-b + sqrt(b^2 - 4 * a * c)) / (2a);
 * }
 * 
 * double quadraticMinus(double a, double b, double c)
 * {
 * 		return (-b - sqrt(b^2 - 4 * a * c)) / (2a);
 * }
 */

package net.einsteinsci.apcompsci.p02_math;

import net.einsteinsci.apcompsci.Console;

public class P02_Quadratic 
{
	public static void main(double a, double b, double c)
	{
		Console.println("> " + a + "x^2 + " + b + "x + " + c + " = 0");
		Console.println("Roots: " + quadraticPlus(a, b, c) + " and " + quadraticMinus(a, b, c));
	}
	
	private static double quadraticPlus(double a, double b, double c)
	{
		// ax^2 + bx + c
		//             _________
		// x = (-b + -/ b^2-4ac ) / (2a)
		
		double root = (b * b) - (4 * a * c);
		double top = -b + Math.sqrt(root);
		double bottom = 2 * a;
		
		if (root < 0)
		{
			throw new IllegalArgumentException("Complex number types are not permitted.");
		}
		
		return top / bottom;
	}
	
	private static double quadraticMinus(double a, double b, double c)
	{
		// ax^2 + bx + c
		//             _________
		// x = (-b - -/ b^2-4ac ) / (2a)
		
		double root = (b * b) - (4 * a * c);
		double top = -b - Math.sqrt(root);
		double bottom = 2 * a;
		
		if (root < 0)
		{
			throw new IllegalArgumentException("Complex number types are not permitted.");
		}
		
		return top / bottom;
	}
}

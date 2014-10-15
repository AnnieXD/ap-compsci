/*
 * Author: Ryan Peacock
 * Project: Triangle Angles
 * Filename: P02_Triangles.java
 * Purpose: Print the angles of a triangle, given the side lengths
 * Pseudocode:
 * 
 * void main(a, b, c)
 * {
 * 		print("A: " + angleA(a, b, c));
 * 		print("B: " + angleB(a, b, c));
 * 		print("C: " + angleB(a, b, c));
 * }
 * 
 * double angleA(a, b, c)
 * {
 * 		return ArcCos((b^2 + c^2 - a^2) / (2 * b * c));
 * }
 * 
 * double angleB(a, b, c)
 * {
 * 		return ArcCos((a^2 + c^2 - b^2) / (2 * a * c));
 * }
 * 
 * double angleC(a, b, c)
 * {
 * 		return ArcCos((a^2 + b^2 - c^2) / (2 * a * b));
 * }
 */

package net.einsteinsci.apcompsci.p02_math;

import net.einsteinsci.apcompsci.Console;

public class P02_Triangle
{	
	public static void main(double a, double b, double c)
	{
		Console.println("Side lengths of " + a + ", " + b + ", " + c + ".");
		
		Console.println("Angle A: " + angleA(a, b, c));
		Console.println("Angle B: " + angleB(a, b, c));
		Console.println("Angle C: " + angleC(a, b, c));
	}
	
	// c2 = a2 + b2 -2abcos(angleA);
	// c2 - a2 - b2 = -2abcos(angleA);
	// (a2 + b2 - c2) / (2ab) = cos(angleA);
	// angleA = arcCos((a^2 + b^2 - c^2) / (2ab));
	
	private static double angleA(double a, double b, double c)
	{
		double top = (b * b) + (c * c) - (a * a);
		double bottom = 2 * b * c;
		return Math.acos(top / bottom);
	}
	
	private static double angleB(double a, double b, double c)
	{
		double top = (a * a) + (c * c) - (b * b);
		double bottom = 2 * a * c;
		return Math.acos(top / bottom);
	}
	
	private static double angleC(double a, double b, double c)
	{
		double top = (a * a) + (b * b) - (c * c);
		double bottom = 2 * a * b;
		return Math.acos(top / bottom);
	}
}

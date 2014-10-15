/*
 * Author: Ryan Peacock
 * Project: Starter program to launch week 3 projects
 * Filename: P03_Console.java
 * Purpose: To provide a centralized place to launch week 3 projects
 * Pseudocode:
 * 
 *  void main()
 *  {
 *  	println("============== Replicator ==============");
 *		Replicator.main();
 *		println("============== PrintRange ==============");
 *		PrintRange.main();
 *		println("============ Roman Numerals ============");
 *		RomanNumerals.main();
 *		println("============== Word Count ==============");
 *		WordCount.main();
 *	}
 */

package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.Console;
import net.einsteinsci.apcompsci.p03_strings.*;

public class P03_Start
{
	public static void main()
	{		
		Console.println("============== Replicator ==============");
		P03_Replicator.main(Console.getLine("String: "), Console.getInt("Times: "));
		Console.println("============== PrintRange ==============");
		P03_PrintRange.main(Console.getInt("Num A: "), Console.getInt("Num B: "));
		Console.println("============ Roman Numerals ============");
		P03_RomanNumerals.main(Console.getInt("Number: "));
		Console.println("============== Word Count ==============");
		boolean file = Console.getBooleanSafe("Is File Path: ", false);
		String data = Console.getLine(file ? "Path: " : "Document: ");
		P03_WordCount.main(data, file);
	}
}
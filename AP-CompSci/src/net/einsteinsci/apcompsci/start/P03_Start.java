/*
 * Author: Ryan Peacock
 * Project: Starter program to launch week 3 projects
 * Filename: P03_Start.java
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

import net.einsteinsci.apcompsci.Start;
import net.einsteinsci.apcompsci.p03_strings.*;

public class P03_Start
{
	public static void main()
	{		
		Start.println("============== Replicator ==============");
		P03_Replicator.main(Start.getLine("String: "), Start.getInt("Times: "));
		Start.println("============== PrintRange ==============");
		P03_PrintRange.main(Start.getInt("Num A: "), Start.getInt("Num B: "));
		Start.println("============ Roman Numerals ============");
		P03_RomanNumerals.main(Start.getInt("Number: "));
		Start.println("============== Word Count ==============");
		boolean file = Start.getBooleanSafe("Is File Path: ", false);
		String data = Start.getLine(file ? "Path: " : "Document: ");
		P03_WordCount.main(data, file);
	}
}
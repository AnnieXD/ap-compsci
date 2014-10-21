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

import net.einsteinsci.apcompsci.ConsoleUtils;
import net.einsteinsci.apcompsci.p03_strings.*;

public class P03_Start implements IStartable
{
	public void main()
	{		
		ConsoleUtils.println("============== Replicator ==============");
		P03_Replicator.main(ConsoleUtils.getLine("[n] String: "), ConsoleUtils.getInt("[n] Times: "));
		ConsoleUtils.println("============== PrintRange ==============");
		P03_PrintRange.main(ConsoleUtils.getInt("[n] Num A: "), ConsoleUtils.getInt("[n] Num B: "));
		ConsoleUtils.println("============ Roman Numerals ============");
		P03_RomanNumerals.main(ConsoleUtils.getInt("[n] Number: "));
		ConsoleUtils.println("============== Word Count ==============");
		boolean file = ConsoleUtils.getBooleanSafe("[b] Is File Path: ", false);
		String data = ConsoleUtils.getLine(file ? "[s] Path: " : "[s] Document: ");
		P03_WordCount.main(data, file);
	}
}
/*
 * Author: Ryan Peacock
 * Project: All AP Computer Science projects will be started from here.
 * Purpose: To provide a centralized place to start projects, and provide a 
 * 			way to easily change how the program acts in different environments.
 * Filename: Start.java
 * Pseudocode:
 * 
 * void main(params String[] args)
 * {
 * 		PID_ProjectName.main();
 * }
 * 
 * void print(String printed)
 * {
 * 		Console.print(printed);
 * }
 * 
 * void println(Object printed)
 * {
 * 		print(printed + NEWLINE);
 * }
 * void println()
 * {
 * 		print(NEWLINE);
 * }
 * 
 * void printErr(Exception e)
 * {
 * 		Console.printErr(e.message);
 * 		Console.printErr(e.cause);
 * 		Console.printErr("at " + e.stacktrace[0]);
 * 		for (int i = 1; i < e.stacktrace.size; i++)
 * 		{
 * 			Console.printErr(TAB + "at " + e.stacktrace[i]);
 * 		} 
 * }
 * 
 * int getInt()
 * {
 * 		return console.readInt();
 * }
 * 
 * float getFloat()
 * {
 * 		return console.readFloat();
 * }
 * 
 * string getLine()
 * {
 * 		return console.readLine();
 * }
 * 
 * bool getBool()
 * {
 * 		string s = getLine();
 * 
 * 		return s == "true";
 * }
 */

package net.einsteinsci.apcompsci;

import net.einsteinsci.apcompsci.start.IStartable;
import net.einsteinsci.apcompsci.start.P04_Start;

public final class Start 
{
	public static final IStartable program = new P04_Start();

	public static void main(String[] args) 
	{
		//=====================//
		// Launch Section Here //
		//=====================//

		program.main();
	}
}






























//.
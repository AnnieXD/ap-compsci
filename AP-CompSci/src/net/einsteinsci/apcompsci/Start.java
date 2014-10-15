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

import net.einsteinsci.apcompsci.start.P04_Start;

import java.util.Scanner;

public final class Start 
{
	private static final Scanner IN = new Scanner(System.in);

	public static void main(String[] args) 
	{
		//=====================//
		// Launch Section Here //
		//=====================//

		P04_Start.main();
	}

	public static void print(Object output)
	{
		System.out.print(output);
	}
	public static void print(int output)
	{
		print("" + output);
	}

	public static void println(Object output)
	{
		print("" + output + "\n");
	}
	public static void println()
	{
		print("\n");
	}
	
	private static void printErr(String s)
	{
		System.err.print(s);
	}
	
	public static void printErr(Throwable e)
	{
		println();
		printErr("An Exception Occurred!\n\n");
		printErr(e.getLocalizedMessage() + "\n");
		if (e.getCause() != null)
		{
			printErr("\nCaused By: " + e.getCause().getLocalizedMessage() + "\n");
			printErrStackTrace(e.getCause());
		}
		
		printErr("\n\nStacktrace:\n");
		printErrStackTrace(e);
		
		printErr("\n");
	}
	
	public static void printErrStackTrace(Throwable e)
	{
		printErr("at " + e.getStackTrace()[0].toString());
		for (int i = 1; i < e.getStackTrace().length; ++i)
		{
			printErr("\n\tat " + e.getStackTrace()[i].toString());
		}
	}
	
	public static int getInt(String prompt, boolean newLineBefore)
	{
		if (newLineBefore)
		{
			print("\n");
		}
		print(prompt);
		
		return IN.nextInt(); 		
	}
	public static int getInt(String prompt)
	{
		return getInt(prompt, false);
	}
	
	public static float getFloat(String prompt, boolean newLineBefore)
	{
		if (newLineBefore)
		{
			print("\n");
		}
		print(prompt);
		
		return IN.nextFloat(); 		
	}
	public static float getFloat(String prompt)
	{
		return getFloat(prompt, false);
	}
	
	public static String getLine(String prompt, boolean newLineBefore)
	{
		if (newLineBefore)
		{
			print("\n");
		}
		print(prompt);
		
		IN.reset();
		return IN.nextLine(); 		
	}
	public static String getLine(String prompt)
	{
		return getLine(prompt, false);
	}
	
	public static boolean getBoolean(String prompt, boolean newLineBefore)
	{
		getLine("", false);
		String s = getLine(prompt, newLineBefore);
		s = s.trim();
		
		if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("1"))
		{
			return true;
		}
		else if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("no") || s.equalsIgnoreCase("0"))
		{
			return false;
		}
		else
		{
			throw new IllegalArgumentException("Could not get boolean value from '" + s + "'");
		}
	}
	public static boolean getBoolean(String prompt)
	{
		return getBoolean(prompt, false);
	}
	public static boolean getBooleanSafe(String prompt, boolean nlBefore)
	{
		boolean result = false;
		try
		{
			result = Start.getBoolean(prompt, nlBefore);
		}
		catch (IllegalArgumentException e)
		{
			Start.printErr(e);
			return false;
		}
		
		return result;
	}

	public static void clearConsole()
	{
		//System.out.
	}

	public static void sleep(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}






























//.
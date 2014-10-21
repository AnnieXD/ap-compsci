package net.einsteinsci.apcompsci;

import java.util.Scanner;

public class ConsoleUtils
{
	public static final boolean FALSE_BREAK_ON_ERROR = true;

	private static final Scanner IN = new Scanner(System.in);

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

	public static void falseBreak()
	{
		String input = "";

		while (!input.equalsIgnoreCase("continue"))
		{
			input = getLine("Breaking on error. Typing 'continue' will continue the program with the error.");
		}
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

		if (FALSE_BREAK_ON_ERROR)
		{
			falseBreak();
		}
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
			result = getBoolean(prompt, nlBefore);
		}
		catch (IllegalArgumentException e)
		{
			printErr(e);
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

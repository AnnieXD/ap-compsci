package net.einsteinsci.apcompsci.magpie.activity2;

import net.einsteinsci.apcompsci.ConsoleUtils;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{
	public static final String USERNAME = "user";

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie2 maggie = new Magpie2();
		
		ConsoleUtils.println(maggie.getGreeting());
		String statement = ConsoleUtils.getLine(USERNAME + "> ");
		
		while (!statement.equalsIgnoreCase("Bye"))
		{
			ConsoleUtils.println(maggie.getResponse(statement));
			statement = ConsoleUtils.getLine(USERNAME + "> ");
		}
	}

}

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
package net.einsteinsci.apcompsci.magpie.activity2;

/*
 * Question: Words within other words
 * ==================================
 * Words like "know" and "smother" contain other keywords that Magpie notices, in this case "no" and "mother". This
 * causes Magpie to trigger on the wrong word, thinking you said the trigger word. The trouble here is that in order to
 * tell if the trigger word is not contains, the coder cannot simply check for whitespace on either side, there might be
 * punctuation there instead. So, the coder must check to make sure letters are clear of each side, and if so, the
 * keyword is isolated.
 */
public class Magpie2
{
	public static final String MAGPIENAME = "Magpie";

	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String input)
	{
		String statement = input.toLowerCase();

		String response = "";
		if (statement.trim() == "")
		{
			response = "The silence is loud.";
		}
		else if (statement.contains("miyoshi"))
		{
			response = "Mr. Miyoshi is awesome.";
		}
		else if (statement.contains("no"))
		{
			response = "Why not?";
		}
		else if (statement.contains("mother") ||
				statement.contains("father") ||
				statement.contains("sister") ||
				statement.contains("brother"))
		{
			response = "Tell me more about your family.";
		}
		else if (statement.contains("dog") ||
				statement.contains("cat"))
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.contains("magpie"))
		{
			response = "That's my name.";
		}
		else if (statement.contains("car"))
		{
			response = "Weston likes cars.";
		}
		else
		{
			response = getRandomResponse();
		}

		return MAGPIENAME + "> " + response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "So then what?";
		}
		else if (whichResponse == 5)
		{
			response = "Ooooh. Interesting.";
		}

		return response;
	}
}

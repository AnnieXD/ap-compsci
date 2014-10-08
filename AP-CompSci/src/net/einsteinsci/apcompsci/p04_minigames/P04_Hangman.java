package net.einsteinsci.apcompsci.p04_minigames;

import net.einsteinsci.apcompsci.Start;

import java.util.Random;

public class P04_Hangman
{
	public static void main()
	{
		HangmanGame game = new HangmanGame();
        game.playGame();
	}
	
	public static class HangmanGame
	{
		final Random rand = new Random();
		char[] word;
		char[] renderedWord;
		char[] guessedLetters;
        int guessedLetterCount;
		String[] validWords = potentialWords();
		int fails;
		
		public HangmanGame()
		{
			word = validWords[rand.nextInt(validWords.length)].toCharArray();
            guessedLetterCount = 0;
			fails = 0;
			guessedLetters = new char[32];
		}
		
		public void playGame()
		{
			Start.println("Word loaded.\n");
			render();
			
			while (true)
			{
				String s = Start.getLine("Guess a letter: ").trim();
				
				if (s.length() > 1)
				{
					Start.println("One letter at a time, please.\n");
					continue;
				}
				
				if ((int)s.charAt(0) < (int)'A' || (int)s.charAt(0) > (int)'z')
				{
					Start.println("That's not a letter.\n");
					continue;
				}

				Start.clearConsole();

				char c = s.charAt(0);

				if (charArrayContains(guessedLetters, c))
				{
					Start.println("You already guessed that.\n");
					continue;
				}
				
				boolean correct = false;

				for (char l : word)
				{
                    if (charEqualsIgnoreCase(l, c))
                    {
	                    correct = true;
                    }
				}

                guessedLetters[guessedLetterCount] = c;
				guessedLetterCount++;
				
				if (correct)
				{
					Start.println("Letter found!");
				}
				else
				{
					Start.println("Incorrect.");
					fails++;
				}

				render();

				if (fails > 5)
				{
					Start.println("You lose. The word was: " + new String(word));
					break;
				}

				if (hasWon())
				{
					Start.println("You won!");
					break;
				}
			}
		}

		public void render()
		{
			Start.println("\nMissed guesses:");
			Start.println(getWrongLettersRendered());

			Start.println("\n" + getRenderedMan());

			Start.println("\n" + getRenderedWord());
		}

		public boolean hasWon()
		{
			return !charArrayContains(renderedWord, '_');
		}

		public char[] getWrongLetters()
		{
			char[] wrong = new char[guessedLetters.length];

			for (int i = 0; i < guessedLetters.length; ++i)
			{
				char c = guessedLetters[i];

				if (!charArrayContains(word, c))
				{
					wrong[i] = c;
				}
			}

			return wrong;
		}

		public String getWrongLettersRendered()
		{
			String result = "[ ";

			boolean flag = true;
			char[] wrong = getWrongLetters();
			for (char c : wrong)
			{
				if (c != '\0')
				{
					if (!flag)
					{
						result += ", ";
					}
					else
					{
						flag = false;
					}

					result += c;
				}
			}

			result += " ]";

			if (result == "[  ]")
			{
				result = "[ none ]";
			}

			return result;
		}

		public char[] getShown()
		{
			renderedWord = word.clone();

			for (int i = 0; i < word.length; ++i)
			{
				if (!charArrayContains(guessedLetters, word[i]))
				{
					renderedWord[i] = '_';
				}
			}

			return renderedWord;
		}

		public String getRenderedWord()
		{
			char[] shown = getShown();
			String result = "";

			for (char c : shown)
			{
				result += c + " ";
			}

			return result.trim();
		}

		/*    +---+
		 *    0   |
		 *   /|\  |
		 *   / \  |
		 *        |
		 * -------+
		 */
		public String getRenderedMan()
		{
			String result = "   +---+\n";
			if (fails >= 1)
			{
				result += "   0   |\n";
			}
			else
			{
				result += "       |\n";
			}

			if (fails < 2)
			{
				result += "       |\n";
			}
			else if (fails == 2)
			{
				result += "   |   |\n";
			}
			else if (fails == 3)
			{
				result += "  /|   |\n";
			}
			else if (fails >= 4)
			{
				result += "  /|\\  |\n";
			}

			if (fails == 5)
			{
				result += "  /    |\n";
			}
			else if (fails >= 6)
			{
				result += "  / \\  |\n";
			}

			result += "       |\n";
			result += "-------+";

			return result;
		}

		public static String[] potentialWords()
		{
			return new String[] { 
				"geography", 
				"cat", 
				"yesterday", 
				"java", 
				"truck", 
				"opportunity", 
				"fish", 
				"token", 
				"transportation", 
				"bottom", 
				"apple", 
				"cake", 
				"remote", 
				"pocket", 
				"terminology", 
				"arm", 
				"cranberry", 
				"caterpillar",
				"spoon", 
				"watermelon", 
				"laptop", 
				"toe", 
				"toad", 
				"fundamental", 
				"capitol", 
				"garbage", 
				"anticipate", 
				"apple" 
			};
		}
	}

    public static boolean charEqualsIgnoreCase(char a, char b)
    {
	    String sA = String.valueOf(a);
	    String sB = String.valueOf(b);
	    if (sA.equalsIgnoreCase(sB))
	    {
		    return true;
	    }

	    return false;
    }

	public static boolean charArrayContains(char[] array, char test)
	{
		for (char c : array)
		{
			if (charEqualsIgnoreCase(c, test))
			{
				return true;
			}
		}

		return false;
	}
}

package net.einsteinsci.apcompsci;

import net.einsteinsci.apcompsci.elevens.CardGameGUI;
import net.einsteinsci.apcompsci.elevens.ElevensBoard;

import java.util.ArrayList;
import java.util.List;

public abstract class Simulator
{
	public CardGameGUI game;
	public ElevensBoard board;

	public static final boolean DO_PAUSES = true;
	public static final int PAUSE_TIME = 10;
	public static final int GAME_COUNT = 100;

	public int wins;
	public int losses;

	public List<Boolean> gameResults;

	public Simulator()
	{
		gameResults = new ArrayList<>();
		board = new ElevensBoard();
		game = new CardGameGUI(board, true);
		wins = 0;
		losses = 0;
	}

	public void runGame()
	{
		resetStats();
		game.clickRestart();

		for (int i = 0; i < GAME_COUNT; ++i)
		{
			boolean round = oneGame();
			gameResults.add(round);

			if (round)
			{
				ConsoleUtils.println("Game " + (i + 1 >= 10 ? "" : "0") + (i + 1) + ": WIN");
				wins++;
			}
			else
			{
				ConsoleUtils.println("Game " + (i + 1 >= 10 ? "" : "0") + (i + 1) + ": LOSS");
				losses++;
			}

			wait(3 * PAUSE_TIME);
			game.clickRestart();
		}

		ConsoleUtils.println("\nCOMPLETE!");
	}

	private void resetStats()
	{
		wins = 0;
		losses = 0;
	}

	public abstract List<Integer> getNextMatch();

	public boolean oneGame()
	{
		while (!board.hasWon())
		{
			List<Integer> match = getNextMatch();
			if (match == null)
			{
				return false;
			}

			for (Integer n : match)
			{
				game.clickCard(n);
				wait(PAUSE_TIME);
			}

			wait(PAUSE_TIME);
			game.clickReplace();
			wait(PAUSE_TIME);
		}

		return true;
	}

	public CardGameGUI getGUI()
	{
		return game;
	}

	public ElevensBoard getBoard()
	{
		return board;
	}

	void wait(int relativePauseTime)
	{
		if (DO_PAUSES)
		{
			ConsoleUtils.sleep(relativePauseTime);
		}
	}
}

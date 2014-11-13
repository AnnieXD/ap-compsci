package net.einsteinsci.apcompsci;

import net.einsteinsci.apcompsci.elevens.Board;
import net.einsteinsci.apcompsci.elevens.CardGameGUI;

import java.util.ArrayList;
import java.util.List;

public abstract class Simulator
{
	public CardGameGUI game;
	public Board board;

	public static final boolean DO_PAUSES = false;
	public static final int PAUSE_TIME = 1;
	public static final int GAME_COUNT = 100;

	public int wins;
	public int losses;

	public List<Boolean> gameResults;

	public Simulator(Board gameboard)
	{
		gameResults = new ArrayList<>();
		board = gameboard;
		game = new CardGameGUI(board, true);
		wins = 0;
		losses = 0;
	}

	public void runGame()
	{
		long start = System.nanoTime();
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

		ConsoleUtils.println();
		ConsoleUtils.println("COMPLETE!");

		ConsoleUtils.println();
		double rate = (double)wins / (double)GAME_COUNT;
		int pct = (int)(rate * 100.0f);
		ConsoleUtils.println("Wins: " + wins + " out of " + GAME_COUNT + " (" + pct + "%)");

		long end = System.nanoTime();
		double time = ((double)(end - start)) / (long)1000000000;
		ConsoleUtils.println("Time Elapsed: " + time + " sec");
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

	public Board getBoard()
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

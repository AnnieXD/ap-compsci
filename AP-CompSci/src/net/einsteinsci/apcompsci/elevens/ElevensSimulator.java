package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.ConsoleUtils;

import java.util.ArrayList;
import java.util.List;

public class ElevensSimulator
{
	CardGameGUI game;
	ElevensBoard board;

	public static final boolean DO_PAUSES = true;
	public static final int PAUSE_TIME = 100;

	public ElevensSimulator()
	{
		board = new ElevensBoard();
		game = new CardGameGUI(board, true);
	}

	public void runGame()
	{
		game.clickRestart();

		while (!board.hasWon())
		{
			List<Integer> match = getNextMatch();
			if (match == null)
			{
				wait(5 * PAUSE_TIME);
				game.clickRestart();
				continue;
			}

			for (Integer n : match)
			{
				game.clickCard(n);
				wait(PAUSE_TIME);
			}

			wait(PAUSE_TIME);
			game.clickReplace();
		}

		ConsoleUtils.println("COMPLETE!");
	}

	public CardGameGUI getGUI()
	{
		return game;
	}

	public ElevensBoard getBoard()
	{
		return board;
	}

	List<Integer> getNextMatch()
	{
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < board.getDeckSize(); ++i)
		{
			for (int j = 0; j < board.getDeckSize(); ++j)
			{
				if (i == j)
				{
					continue;
				}

				res = new ArrayList<>();
				res.add(i);
				res.add(j);

				if (board.containsPairSumEleven(res))
				{
					return res;
				}
			}
		}

		for (int i = 0; i < board.getDeckSize(); ++i)
		{
			for (int j = 0; j < board.getDeckSize(); ++j)
			{
				for (int k = 0; k < board.getDeckSize(); ++k)
				{
					if (i == j || j == k || i == k)
					{
						continue;
					}

					res = new ArrayList<>();
					res.add(i);
					res.add(j);
					res.add(k);

					if (board.consistsOfJQK(res))
					{
						return res;
					}
				}
			}
		}

		return null;
	}

	void wait(int relativePauseTime)
	{
		if (DO_PAUSES)
		{
			ConsoleUtils.sleep(relativePauseTime);
		}
	}
}

package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.Simulator;

import java.util.ArrayList;
import java.util.List;

public class ThirteensSimulator extends Simulator
{
	public ThirteensBoard tBoard;

	public ThirteensSimulator()
	{
		super(new ThirteensBoard());
		tBoard = (ThirteensBoard)board;
	}

	@Override
	public List<Integer> getNextMatch()
	{
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < board.size(); ++i)
		{
			for (int j = 0; j < board.size(); ++j)
			{
				if (i == j)
				{
					continue;
				}

				res = new ArrayList<>();
				res.add(i);
				res.add(j);

				boolean isThirteen = tBoard.isThirteenPair(res);
				if (isThirteen)
				{
					return res;
				}
			}
		}

		for (int i = 0; i < board.size(); ++i)
		{
			res = new ArrayList<>();
			res.add(i);

			if (tBoard.isKing(res))
			{
				return res;
			}
		}

		return null;
	}
}

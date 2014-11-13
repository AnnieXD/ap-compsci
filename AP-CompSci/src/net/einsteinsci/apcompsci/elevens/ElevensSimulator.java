package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.Simulator;

import java.util.ArrayList;
import java.util.List;

public class ElevensSimulator extends Simulator
{
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

				boolean isEleven = board.containsPairSumEleven(res);
				if (isEleven)
				{
					return res;
				}
			}
		}

		for (int i = 0; i < board.size(); ++i)
		{
			for (int j = 0; j < board.size(); ++j)
			{
				for (int k = 0; k < board.size(); ++k)
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
}

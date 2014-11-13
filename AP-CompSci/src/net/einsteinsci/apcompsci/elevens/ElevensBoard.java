package net.einsteinsci.apcompsci.elevens;

import java.util.ArrayList;
import java.util.List;

public class ElevensBoard extends Board
{
	@Override
	public int size()
	{
		return 9;
	}

	public ElevensBoard()
	{
		super();
	}

	@Override
	public boolean isLegal(List<Integer> cards)
	{
		return containsPairSumEleven(cards) || consistsOfJQK(cards);
	}

	@Override
	public boolean isAnotherPlayPossible()
	{
		for (int i = 0; i < size(); ++i)
		{
			for (int j = 0; j < size(); ++j)
			{
				List<Integer> ids = new ArrayList<>();
				ids.add(i);
				ids.add(j);

				if (containsPairSumEleven(ids))
				{
					return true;
				}
			}
		}

		for (int i = 0; i < size(); ++i)
		{
			for (int j = 0; j < size(); ++j)
			{
				for (int k = 0; k < size(); ++k)
				{
					List<Integer> ids = new ArrayList<>();
					ids.add(i);
					ids.add(j);
					ids.add(k);

					if (consistsOfJQK(ids))
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean containsPairSumEleven(List<Integer> selected)
	{
		if (selected.size() != 2)
		{
			return false;
		}

		Card ca = cards[selected.get(0)];
		Card cb = cards[selected.get(1)];

		if (ca == null || cb == null)
		{
			return false;
		}

		int a = cards[selected.get(0)].getValue();
		int b = cards[selected.get(1)].getValue();

		return a + b == 11;
	}

	public boolean consistsOfJQK(List<Integer> selected)
	{
		if (selected.size() != 3)
		{
			return false;
		}

		List<String> ranks = new ArrayList<>();

		for (Integer n : selected)
		{
			if (cards[n] == null)
			{
				return false;
			}

			ranks.add(cards[n].getRank().toLowerCase());
		}

		return ranks.contains("jack") && ranks.contains("queen") && ranks.contains("king");
	}
}

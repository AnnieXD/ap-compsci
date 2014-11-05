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

		int a = VALUES[cards[selected.get(0)].getValue() - 1];
		int b = VALUES[cards[selected.get(1)].getValue() - 1];

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
			ranks.add(cards[n].getRank().toLowerCase());
		}

		return ranks.contains("jack") && ranks.contains("queen") && ranks.contains("king");
	}
}

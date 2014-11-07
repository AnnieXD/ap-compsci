package net.einsteinsci.apcompsci.elevens;

import java.util.ArrayList;
import java.util.List;

public class ThirteensBoard extends Board
{
	@Override
	public int size()
	{
		return 10;
	}

	@Override
	public boolean isLegal(List<Integer> cards)
	{
		return isThirteenPair(cards) || isKing(cards);
	}

	@Override
	public boolean isAnotherPlayPossible()
	{
		for (int i = 0; i < size(); ++i)
		{
			List<Integer> id = new ArrayList<>();
			id.add(i);

			if (isKing(id))
			{
				return true;
			}
		}

		for (int i = 0; i < size(); ++i)
		{
			for (int j = 0; j < size(); ++j)
			{
				List<Integer> ids = new ArrayList<>();
				ids.add(i);
				ids.add(j);

				if (isThirteenPair(ids))
				{
					return true;
				}
			}
		}

		return false;
	}

	public boolean isThirteenPair(List<Integer> cards)
	{
		if (cards.size() != 2)
		{
			return false;
		}

		Card a = getCardDealt(cards.get(0));
		Card b = getCardDealt(cards.get(1));

		if (a == null || b == null)
		{
			return false;
		}

		return a.getValue() + b.getValue() == 13;
	}

	public boolean isKing(List<Integer> cards)
	{
		if (cards.size() != 1)
		{
			return false;
		}

		Card card = getCardDealt(cards.get(0));

		if (card == null)
		{
			return false;
		}

		return card.getValue() == 13;
	}
}

package net.einsteinsci.apcompsci.elevens;

import java.util.*;

public class Deck
{
	private List<Card> cards;
	private int size;

	public Deck()
	{
		cards = new ArrayList<>();
		size = cards.size();
	}

	public Deck(Card[] startingCards)
	{
		cards = new ArrayList<>();
		Collections.addAll(cards, startingCards);
		size = cards.size();
	}

	public Deck(String[] suits, String[] ranks, int[] values, boolean shuffle)
	{
		cards = new ArrayList<>();
		for (int i = 0; i < ranks.length; ++i)
		{
			Card card = new Card(suits[i], ranks[i], values[i]);
			cards.add(card);
		}

		if (shuffle)
		{
			shuffle();
		}
		size = cards.size();
	}

	public List<Card> getCards()
	{
		return cards;
	}

	public int size()
	{
		return size;
	}

	public void shuffle()
	{
		Object[] deck = cards.toArray();
		Random rand = new Random();

		for (int k = deck.length - 1; k >= 0; --k)
		{
			int r = rand.nextInt(k + 1);

			assert (deck[r] instanceof Card) : "deck[" + r + "] (r) is not a Card.\n\ttoString() = " + deck[r].toString();
			assert (deck[k] instanceof Card) : "deck[" + k + "] (k) is not a Card.\n\ttoString() = " + deck[k].toString();

			if (!(deck[r] instanceof Card && deck[k] instanceof Card))
			{
				throw new IllegalStateException("Something in this deck isn't a card.");
			}

			Card one = (Card)deck[r];
			Card two = (Card)deck[k];
			deck[k] = one;
			deck[r] = two;
		}

		cards = new ArrayList<>();
		//Collections.addAll(cards, deck);
		for (Object obj : deck)
		{
			if (obj instanceof Card)
			{
				cards.add((Card) obj);
			}
		}
		size = deck.length;
	}

	public Card deal()
	{
		if (isEmpty())
		{
			return null;
		}

		Card drawn = cards.get(size - 1);
		size--;
		return drawn;
	}

	public void add(Card c)
	{
		cards.add(c);
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public boolean matches(Deck deck)
	{
		return this.equals(deck);
	}

	@Override
	public Deck clone()
	{
		Deck res = new Deck();

		for (Card c : getCards())
		{
			res.getCards().add(c.clone());
		}

		return res;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Deck)
		{
			Deck d = (Deck)obj;

			if (d.size() != size())
			{
				return false;
			}

			for (int i = 0; i < size(); i++)
			{
				if (!d.getCards().get(i).matches(getCards().get(i)))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		String result = "size = " + size + "\nUndealt cards: \n";

		for (int i = size - 1; i >= 0; --i)
		{
			result += cards.get(i).toString();
			if (i != 0)
			{
				result += ", ";
			}
			if ((size - i) % 2 == 0)
			{
				result += "\n";
			}
		}

		result += "\nDealt cards: \n";
		for (int i = cards.size() - 1; i >= size; --i)
		{
			result += cards.get(i).toString();
			if (i != size)
			{
				result += ", ";
			}
			if ((i - cards.size()) % 2 == 0)
			{
				result += "\n";
			}
		}

		result += "\n";
		return result;
	}
}

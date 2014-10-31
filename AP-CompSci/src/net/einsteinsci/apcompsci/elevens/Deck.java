package net.einsteinsci.apcompsci.elevens;

import java.util.*;

public class Deck
{
	List<Card> cards;
	int size;

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
		Card[] deck = (Card[])cards.toArray();
		Random rand = new Random();

		for (int k = deck.length - 1; k >= 0; --k)
		{
			int r = rand.nextInt(k);
			Card one = deck[r];
			Card two = deck[k];
			deck[k] = one;
			deck[r] = two;
		}

		cards = new ArrayList<>();
		Collections.addAll(cards, deck);
		size = deck.length;
	}

	public Card deal()
	{
		if (size == 0)
		{
			return null;
		}

		Card drawn = cards.get(size - 1);
		size--;
		return drawn;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
}

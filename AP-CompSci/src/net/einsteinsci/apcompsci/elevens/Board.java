package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.ConsoleUtils;

import java.util.*;

public abstract class Board
{
	protected static final boolean DEBUG = true;

	public static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
	public static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	public static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

	protected Card[] cards;
	protected Deck deck;

	public abstract int size();
	public abstract boolean isLegal(List<Integer> cards);
	public abstract boolean isAnotherPlayPossible();

	public Board()
	{
		cards = new Card[size()];
		deck = makeShuffledDeck();

		deal();

		if (DEBUG)
		{
			ConsoleUtils.println(deck);
		}
	}

	public void restart()
	{
		deck.shuffle();
		deal();
	}

	public boolean hasWon()
	{
		if (deck.isEmpty())
		{
			for (Card c : cards)
			{
				if (c != null)
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void deal()
	{
		for (int i = 0; i < size(); ++i)
		{
			cards[i] = deck.deal();
		}
	}

	public void replace(List<Integer> selected)
	{
		for (Integer n : selected)
		{
			cards[n] = deck.deal();
		}
	}

	public List<Integer> getIndexes()
	{
		List<Integer> selected = new ArrayList<>();

		for (int i = 0; i < size(); ++i)
		{
			if (cards[i] != null)
			{
				selected.add(i);
			}
		}

		return selected;
	}

	public int getDeckSize()
	{
		return deck.size();
	}

	public Card getCardDealt(int index)
	{
		return cards[index];
	}
	public Card cardAt(int index)
	{
		return getCardDealt(index);
	}

	public String toString()
	{
		String result = "";
		for (int i = 0; i < size(); ++i)
		{
			result += i + ": " + cards[i].toString() + "\n";
		}
		return result;
	}

	public static void printCards(Board board)
	{
		ConsoleUtils.println("Selected Cards:");

		String printed = "";
		for (Integer n : board.getIndexes())
		{
			printed += "\t" + board.cards[n].toString() + "\n";
		}

		ConsoleUtils.println(printed);
	}

	public static Deck makeFullDeck()
	{
		Deck deck = new Deck();

		for (String suit : SUITS)
		{
			for (String rank : RANKS)
			{
				Card c = new Card(suit, rank);
				deck.add(c);
			}
		}

		return deck;
	}

	public static Deck makeShuffledDeck()
	{
		Deck deck = makeFullDeck();

		Random rand = new Random();

		int max = rand.nextInt(5); // Not going to shuffle more than five times.
		for (int i = 0; i < max; ++i)
		{
			deck.shuffle();
		}

		return deck;
	}
}

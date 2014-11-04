package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.ConsoleUtils;

import java.util.*;

public class Board
{
	public static final boolean DEBUG = true;

	public static final int CARD_COUNT = 9;

	public static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
	public static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	public static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	public Card[] cards;
	public Deck deck;

	public Board()
	{
		cards = new Card[CARD_COUNT];
		deck = makeShuffledDeck();

		if (DEBUG)
		{
			ConsoleUtils.println(deck);
		}
	}

	public void restart()
	{
		deck.shuffle();
	}

	public void deal()
	{
		for (int i = 0; i < CARD_COUNT; ++i)
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

	public List<Integer> getIndexes()
	{
		List<Integer> selected = new ArrayList<>();

		for (int i = 0; i < CARD_COUNT; ++i)
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

	public String toString()
	{
		String result = "";
		for (int i = 0; i < CARD_COUNT; ++i)
		{
			result += i + ": " + cards[i].toString() + "\n";
		}
		return result;
	}

	public static void printCards(Board board)
	{
		List<Integer> indexes = board.getIndexes();

		ConsoleUtils.println("Selected Cards:");

		// YOU ARE HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

		int max = rand.nextInt(5);
		for (int i = 0; i < max; ++i)
		{
			deck.shuffle();
		}

		return deck;
	}
}

package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.ConsoleUtils;

public class Card
{
	String suit;
	String rank;
	int value;

	public Card(String suit, String rank, int value)
	{
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	public Card(String suit, String rank)
	{
		switch (suit.toLowerCase())
		{
			case "spades":
			case "hearts":
			case "diamonds":
			case "clubs":
				this.suit = suit;
				break;
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("No such suit as " + suit));
				break;
		}

		switch (rank.toLowerCase())
		{
			case "a":
			case "ace":
				value = 1;
				break;
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "10":
				value = Integer.parseInt(rank);
				break;
			case "j":
			case "jack":
				value = 11;
				break;
			case "q":
			case "queen":
				value = 12;
				break;
			case "k":
			case "king":
				value = 13;
				break;
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("No such rank as " + rank));
				break;
		}
		this.rank = rank;
	}
	public Card(String suit, int value)
	{
		switch (suit.toLowerCase())
		{
			case "spades":
			case "hearts":
			case "diamonds":
			case "clubs":
				this.suit = suit;
				break;
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("No such suit as " + suit));
				break;
		}

		this.value = value;
		switch (value)
		{
			case 1:
				rank = "A";
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				rank = "" + value;
				break;
			case 11:
				rank = "J";
				break;
			case 12:
				rank = "Q";
				break;
			case 13:
				rank = "K";
				break;
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("Unusual card value: " + value));
				rank = "" + value;
				break;
		}
	}

	public String getSuit()
	{
		return suit;
	}
	public int getValue()
	{
		return value;
	}
	public String getRank()
	{
		switch (value)
		{
			case 1:
				return "Ace";
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return "" + value;
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("Unusual card value: " + value));
				return "ERROR";
		}
	}
	public String getRankLetter()
	{
		switch (value)
		{
			case 1:
				return "A";
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return "" + value;
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("Unusual card value: " + value));
				return "ERROR";
		}
	}

	public boolean isRed()
	{
		return getSuit().equalsIgnoreCase("hearts") || getSuit().equalsIgnoreCase("diamonds");
	}

	public boolean matches(Card c)
	{
		return this.equals(c);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Card)
		{
			Card c = (Card)obj;
			return c.getValue() == getValue() && c.getSuit() == getSuit();
		}
		else
		{
			return false;
		}
	}

	@Override
	public Card clone()
	{
		return new Card(getSuit(), getRank());
	}

	@Override
	public String toString()
	{
		return getRank() + " of " + getSuit() + "[value: " + getValue() + "]";
	}
}

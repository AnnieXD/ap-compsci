package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.ConsoleUtils;

public class Card
{
	String suit;
	int value;

	public Card(String suit, String rank)
	{
		switch (suit)
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

		switch (rank)
		{
			case "A":
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
			case "J":
				value = 11;
				break;
			case "Q":
				value = 12;
				break;
			case "K":
				value = 13;
				break;
			default:
				ConsoleUtils.printErr(new IllegalArgumentException("No such rank as " + rank));
				break;
		}
	}
	public Card(String suit, int value)
	{
		switch (suit)
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

	@Override
	public String toString()
	{
		return getRank() + " of " + getSuit() + "[value: " + getValue() + "]";
	}
}

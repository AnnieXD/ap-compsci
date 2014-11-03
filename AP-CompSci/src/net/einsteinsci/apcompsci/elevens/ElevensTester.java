package net.einsteinsci.apcompsci.elevens;

import net.einsteinsci.apcompsci.start.IStartable;

public class ElevensTester implements IStartable
{
	@Override
	public void main()
	{

	}

	void test1cardDeck()
	{
		Deck one = new Deck();
		Card c = new Card("spades", 1);
		one.getCards().add(c);

		assert c.getRank() == "A" : "Rank does not check out: " + c.getRank();
		assert c.getSuit() == "spades" : "Suit does not check out: " + c.getSuit();
		assert c.getValue() == 1 : "Value does not check out: " + c.getValue();
	}

	void test2cardDeck()
	{
		Deck two = new Deck();
		Card c1 = new Card("clubs", 7);
		Card c2 = new Card("hearts", "Q");
		Card _c1 = new Card("clubs", "7");
		two.getCards().add(c1);
		two.getCards().add(c2);
		two.getCards().add(_c1);

		assert !c1.matches(c2) : "Cards should not be the same.";
		assert c1.matches(_c1) : "Cards should be the same.";
	}

	void testShuffle()
	{
		Deck shfl = new Deck();

		for (int i = 1; i <= 13; ++i)
		{
			shfl.getCards().add(new Card("spades", i));
		}
		for (int i = 1; i <= 13; ++i)
		{
			shfl.getCards().add(new Card("hearts", i));
		}
		for (int i = 1; i <= 13; ++i)
		{
			shfl.getCards().add(new Card("diamonds", i));
		}
		for (int i = 1; i <= 13; ++i)
		{
			shfl.getCards().add(new Card("clubs", i));
		}

		Deck base = shfl.clone();

		shfl.shuffle();

		assert !shfl.matches(base) : "There's no way that deck got shuffled into the same exact order.";
	}
}

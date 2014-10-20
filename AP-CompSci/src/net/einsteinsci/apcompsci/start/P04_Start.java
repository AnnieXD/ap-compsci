package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.p04_minigames.P04_Mastermind;

public class P04_Start implements IStartable
{
	public static final IStartable program = new P04_Mastermind();

	public void main()
	{
		program.main();
	}
}

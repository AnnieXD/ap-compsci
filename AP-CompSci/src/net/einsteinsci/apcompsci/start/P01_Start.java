package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.p01_oldlady.P01_OldLady;

public class P01_Start implements IStartable
{
	public static final IStartable program = new P01_OldLady();
	public void main()
	{
		program.main();
	}
}

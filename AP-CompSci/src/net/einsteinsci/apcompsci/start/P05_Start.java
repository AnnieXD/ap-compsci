package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.p05_inheritance.P05_3DShapes;

public class P05_Start implements IStartable
{
	public static final IStartable program = new P05_3DShapes();
	public void main()
	{
		program.main();
	}
}

package net.einsteinsci.apcompsci.start;

import net.einsteinsci.apcompsci.p06_lists.P06_FileReverse;

public class P06_Start implements IStartable
{
	public static final IStartable program = new P06_FileReverse();

	public void main()
	{
		program.main();
	}
}

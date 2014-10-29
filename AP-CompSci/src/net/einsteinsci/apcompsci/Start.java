/*
 * Author: Ryan Peacock
 * Project: All AP Computer Science projects will be started from here.
 * Purpose: To provide a centralized place to start projects, and provide a 
 * 			way to easily change how the program acts in different environments.
 * Filename: Start.java
 * Pseudocode:
 * 
 * void main(params String[] args)
 * {
 * 		PID_ProjectName.main();
 * }
 *
 */

package net.einsteinsci.apcompsci;

import net.einsteinsci.apcompsci.start.Elevens_Start;
import net.einsteinsci.apcompsci.start.IStartable;

public final class Start 
{
	public static final IStartable program = new Elevens_Start();

	public static void main(String[] args) 
	{
		program.main();
	}
}






























//.
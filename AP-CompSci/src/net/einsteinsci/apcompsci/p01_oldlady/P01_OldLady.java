/* Author: Ryan Peacock
 * Project: Old lady song
 * Purpose: Output the lyrics of "There was an old lady who swallowed a fly".
 * Filename: P01_OldLady.java ("P01" to keep projects sorted)
 * Pseudocode:
 * 
 * 	void main()
 * 	{
 * 		printAnimal("fly");
 * 		printAnimal("spider");
 * 		printAnimal("bird");
 * 		printAnimal("cat");
 * 		printAnimal("dog");
 * 		printAnimal("horse");
 * 	}
 * 
 * 	void printAnimal(String arg)
 * 	{
 * 		if (arg == "fly")
 * 		{
 * 			wasAnOldLady("fly");
 * 			iDontKnowWhy();
 * 			perhapsShellDie();
 * 		}
 * 		else if (arg == "spider" OR "bird" OR "cat" OR "dog")
 * 		{
 * 			wasAnOldLady(arg);
 * 			miscComment(arg);
 * 			sheSwallowedThe(arg);
 * 			perhapsShellDie();
 * 		}
 * 		else
 * 		{
 * 			wasAnOldLady("horse");
 * 			println("She died of course");
 * 		}
 *  }
 *  
 *  void wasAnOldLady(String arg)
 *  {
 *  	println("There was an old lady who swallowed a {0},", arg);
 *  }
 *  
 *  void iDontKnowWhy()
 *  {
 *  	println("I don't know why she swallowed the fly.");
 *  }
 *  
 *  void perhapsShellDie()
 *  {
 *  	println("Perhaps she'll die.");
 *  }
 *  
 *  void miscComment(String arg)
 *  {
 *  	if (arg == "spider")
 *  		println("That wriggled and iggled and jiggled insider her.");
 *  	else if (arg == "bird")
 *  		println("How absurd to swallow a bird.");
 *  	else if (arg == "cat")
 *  		println("Imagine that, to swallow a cat.");
 *  	else if (arg == "dog")
 *  		println("What a hog to swallow a dog."); 
 *  }
 *  
 *  void sheSwallowedThe(arg)
 *  {
 *  	if (arg == "spider")
 *  		println("She swallowed the spider to catch the fly,");
 *  	else if (arg == "bird")
 *  	{
 *  		println("She swallowed the bird to catch the spider,");
 *  		sheSwallowedThe("spider");
 *  	}
 *  	else if (arg == "cat")
 *  	{
 *  		println("She swallowed the cat to catch the bird,");
 *  		sheSwallowedThe("bird");
 *  	}
 *  	else if (arg == "dog")
 *  	{
 *  		println("She swallowed the dog to catch the cat,");
 *  		sheSwallowedThe("cat");
 *  	}
 *  }
 */

package net.einsteinsci.apcompsci.p01_oldlady;

import net.einsteinsci.apcompsci.Start;

public final class P01_OldLady 
{
	private static final String[] ANIMALS = {"fly", "spider", "bird", "cat", "dog", "horse"};
	
	public static void main()
	{	
		for (int i = 0; i < ANIMALS.length; ++i)
		{
			printAnimal(i);
			Start.print("\n");
		}
	}
	
	private static void wasAnOldLady(String animal)
	{
		Start.println("There was an old lady who swallowed a " + animal + ",");
	}
	private static void perhaps()
	{
		Start.println("Perhaps she'll die.");
	}
	
	private static String purpose(int swallowedIndex)
	{
		return "She swallowed the " + ANIMALS[swallowedIndex] + " to catch the " + ANIMALS[swallowedIndex - 1] + ",";
	}
	
	private static void printAnimal(int index)
	{
		wasAnOldLady(ANIMALS[index]);
		switch (index)
		{
		case 0:
			Start.println(reasons(index));
			perhaps();
			break;
		case 5: //ANIMALS[5] == "horse". Must explicitly state a value here, no dynamic expressions
			Start.println(specific(ANIMALS[index]));
			break;
		default:
			Start.println(specific(ANIMALS[index]));
			Start.println(reasons(index));
			perhaps();
			break;
		}
	}
	
	private static String reasons(int index)
	{
		switch (index)
		{
		case 0:
			return "I don't know why she swallowed that fly,";
		case 10:
			return purpose(index);
		case 5: // "horse"
			return "";
		default:
			return purpose(index) + "\n" + reasons(index - 1);
		}
	}
	
	private static String specific(String animal)
	{
		switch (animal)
		{
		case "fly":
			return "I don't know why she swallowed that fly,";
		case "spider":
			return "That wriggled and iggled and jiggled insider her.";
		case "bird":
			return "How absurd to swallow a bird.";
		case "cat":
			return "Imagine that to swallow a cat.";
		case "dog":
			return "What a hog to swallow a dog.";
		case "horse":
			return "She died of course.";
		default:
			return "NULL";
		}
	}
}

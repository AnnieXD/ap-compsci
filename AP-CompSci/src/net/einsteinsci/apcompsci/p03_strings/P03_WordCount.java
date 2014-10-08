/*
 * Author: Ryan Peacock
 * Project: Word Count
 * Filename: P03_WordCount.java
 * Pseudocode:
 * 
 * 	void main(string str, bool isFile)
 * 	{
 * 		string doc = "";
 * 		if (isFile)
 * 		{
 * 			doc = readFile(str);
 * 		}
 * 		else
 * 		{
 * 			doc = str;
 * 		}
 * 
 * 		println("Words: {0}", wordCount(doc));
 * 		println("Lines: {0}", lineCount(doc));
 * 		println("Chars: {0}", charCount(doc));
 * 	}
 * 
 * 	int wordCount(string doc)
 * 	{
 * 		int n = 0;
 * 
 * 		foreach (char c in doc)
 * 		{
 * 			if (c = NEWLINE OR c = ' ' OR c = TAB)
 * 			{
 * 				n++;
 * 			}
 * 		}
 * 
 * 		return n + 1;
 * 	}
 * 
 * 	int lineCount(string doc)
 * 	{
 * 		int n = 0;
 * 
 * 		foreach (char c in doc)
 * 		{
 * 			if (c = NEWLINE)
 * 			{
 * 				n++;
 * 			}
 * 		}
 * 
 * 		return n + 1;
 * 	}
 * 
 * 	int charCount(string doc)
 * 	{
 * 		int n = 0;
 * 
 * 		foreach (char c in doc)
 * 		{
 * 			if (NOT (c = NEWLINE OR c = ' ' OR c = TAB))
 * 			{
 * 				n++;
 * 			}
 * 		}
 * 
 * 		return n;
 * 	}
 */

package net.einsteinsci.apcompsci.p03_strings;

import java.io.*;

import net.einsteinsci.apcompsci.Start;

public class P03_WordCount
{
	public static void main(String document, boolean filePath)
	{
		String analyze = "";
		
		if (filePath)
		{			
			try (BufferedReader br = new BufferedReader(new FileReader(document)))
			{
				String currentline = "";
				
				while ((currentline = br.readLine()) != null)
				{
					analyze += currentline + "\n"; 
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			analyze = document;
		}
		
		Start.println("----- Document: ------");
		Start.println(analyze);
		Start.println("----------------------");
		Start.println("Word Count: " + getWordCount(analyze));
		Start.println("Line Count: " + getLineCount(analyze));
		Start.println("Character Count (Excluding Whitespace): " + getCharCount(analyze));
	}
	
	private static int getWordCount(String doc)
	{		
		int total = 0;
		for (char c : doc.toCharArray())
		{
			if (c == '\n' || c == ' ' || c == '\t')
			{
				total++;
			}
		}
		
		return total + 1;
	}
	
	private static int getLineCount(String doc)
	{
		int total = 0;
		for (char c : doc.toCharArray())
		{
			if (c == '\n')
			{
				total++;
			}
		}
		
		return total + 1;
	}
	
	private static int getCharCount(String doc)
	{
		int total = 0;
		for (char c : doc.toCharArray())
		{
			if (c != ' ' && c != '\n' && c != '\t')
			{
				total++;
			}
		}
		
		return total;
	}
}

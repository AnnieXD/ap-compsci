package net.einsteinsci.apcompsci.p06_lists;

import net.einsteinsci.apcompsci.ConsoleUtils;
import net.einsteinsci.apcompsci.FileUtils;
import net.einsteinsci.apcompsci.start.IStartable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P06_FileReverse implements IStartable
{
	static final String PATH = "C:\\TEST\\words.txt";

	public void main()
	{
		LineSet file = new LineSet(PATH);

		String normal = file.toString();
		String reversedLines = file.reverseLines().toString();
		String reversedWords = file.reverseWordsInLines().toString();
		String reversedBoth = file.reverseLines().reverseWordsInLines().toString();

		ConsoleUtils.println("=== NORMAL ===\n" + normal);
		ConsoleUtils.println("=== LINES ===\n" + reversedLines);
		ConsoleUtils.println("=== WORDS ===\n" + reversedWords);
		ConsoleUtils.println("=== BOTH ===\n" + reversedBoth);
	}

	public static class LineSet
	{
		List<Line> lines;

		public LineSet(String filePath)
		{
			lines = new ArrayList<>();
			List<String> lineStrings = null;
			try
			{
				lineStrings = FileUtils.getFileLinesList(filePath);
			}
			catch (IOException e)
			{
				ConsoleUtils.printErr(e);
			}

			if (lineStrings != null)
			{
				for (String s : lineStrings)
				{
					lines.add(new Line(s));
				}
			}
		}
		public LineSet(List<Line> stuff)
		{
			lines = stuff;
		}

		public List<Line> getLines()
		{
			return lines;
		}

		@Override
		public String toString()
		{
			String result = "";

			for (Line l : lines)
			{
				result += l.toString() + "\n";
			}

			return result;
		}

		public LineSet reverseLines()
		{
			List<Line> replacement = new ArrayList<>();

			for (int i = lines.size() - 1; i >= 0; --i)
			{
				replacement.add(lines.get(i));
			}

			return new LineSet(replacement);
		}

		public LineSet reverseWordsInLines()
		{
			List<Line> stuff = new ArrayList<>();
			for (Line l : lines)
			{
				if (l.toString() != "")
				{
					stuff.add(l.reverseWords());
				}
			}

			return new LineSet(stuff);
		}
	}

	public static class Line
	{
		List<String> words;

		public Line(String line)
		{
			words = new ArrayList<String>();

			String currentWord = "";
			for (char c : line.toCharArray())
			{
				if (c == ' ')
				{
					words.add(currentWord);
					currentWord = "";
				}
				else
				{
					currentWord += c;
				}
			}

			words.add(currentWord);
		}
		public Line(List<String> stuff)
		{
			words = stuff;
		}

		public List<String> getWords()
		{
			return words;
		}

		@Override
		public String toString()
		{
			String result = "";

			for (String s : words)
			{
				result += s + " ";
			}

			return result.trim();
		}

		public Line reverseWords()
		{
			List<String> replacement = new ArrayList<>();
			for (int i = words.size() - 1; i >= 0; --i)
			{
				replacement.add(words.get(i));
			}

			return new Line(replacement);
		}
	}
}

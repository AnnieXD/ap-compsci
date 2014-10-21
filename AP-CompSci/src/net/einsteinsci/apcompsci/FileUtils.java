package net.einsteinsci.apcompsci;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
	public static String getFile(String path) throws IOException
	{
		String result = "";

		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String currentline = "";

			while ((currentline = br.readLine()) != null)
			{
				result += currentline + "\n";
			}
		}
		catch (IOException e)
		{
			throw new IOException(e);
		}

		return result;
	}

	public static String[] getFileLines(String path) throws IOException
	{
		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String currentline = "";

			while ((currentline = br.readLine()) != null)
			{
				result.add(currentline);
			}
		}
		catch (IOException e)
		{
			throw new IOException(e);
		}

		return (String[])result.toArray();
	}

	public static List<String> getFileLinesList(String path) throws IOException
	{
		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String currentline = "";

			while ((currentline = br.readLine()) != null)
			{
				result.add(currentline);
			}
		}
		catch (IOException e)
		{
			throw new IOException(e);
		}

		return result;
	}
}

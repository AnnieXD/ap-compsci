package net.einsteinsci.apcompsci.p05_inheritance;

import net.einsteinsci.apcompsci.Console;
import net.einsteinsci.apcompsci.start.IStartable;

public class P05_2DShapes implements IStartable
{
	public void main()
	{
		for (int i = 0; i < 1; ++i)
		{
			String shape = Console.getLine("Enter shape to create. Valid entries are 'circle', 'rect', and 'square'.\n> ");

			IShape created = null;

			if (shape.equalsIgnoreCase("circle"))
			{
				float r = Console.getFloat("Radius: ");
				created = new Circle(r);
			}
			else if (shape.equalsIgnoreCase("rect"))
			{
				float w = Console.getFloat("Width: ");
				float h = Console.getFloat("Height: ");
				created = new Rectangle(w, h);
			}
			else if (shape.equalsIgnoreCase("square"))
			{
				float s = Console.getFloat("Side length: ");
				created = new Square(s);
			}

			if (created == null)
			{
				Console.println("Invalid shape");
				Console.println();
				return;
			}

			Console.println();

			Console.println("Area: " + created.getArea());
			Console.println("Perimeter: " + created.getPerimeter());

			Console.sleep(500);
		}
	}

	public static abstract interface IShape
	{
		public float getPerimeter();
		public float getArea();
	}

	public static class Circle implements IShape
	{
		public float radius;
		public static final float PI = 3.1415926539f;

		public Circle(float r)
		{
			radius = r;
		}

		@Override
		public float getPerimeter()
		{
			return 2 * PI * radius;
		}

		@Override
		public float getArea()
		{
			return PI * radius * radius;
		}
	}

	public static class Rectangle implements IShape
	{
		public float width;
		public float height;

		public Rectangle(float w, float h)
		{
			width = w;
			height = h;
		}

		@Override
		public float getPerimeter()
		{
			return 2 * width + 2 * height;
		}

		@Override
		public float getArea()
		{
			return width * height;
		}
	}

	public static class Square extends Rectangle
	{
		public Square(float s)
		{
			super(s, s);
		}
	}
}

package net.einsteinsci.apcompsci.p04_minigames;

import net.einsteinsci.apcompsci.ConsoleUtils;
import net.einsteinsci.apcompsci.start.IStartable;

public class P04_AreaPerimeter implements IStartable
{
	public void main()
	{
		String shape = ConsoleUtils
				.getLine("Enter shape to create. Valid entries are 'circle', 'rect', and 'square'.\n> ");

		IShape created = null;

		if (shape.equalsIgnoreCase("circle"))
		{
			float r = ConsoleUtils.getFloat("Radius: ");
			created = new Circle(r);
		}
		else if (shape.equalsIgnoreCase("rect"))
		{
			float w = ConsoleUtils.getFloat("Width: ");
			float h = ConsoleUtils.getFloat("Height: ");
			created = new Rectangle(w, h);
		}
		else if (shape.equalsIgnoreCase("square"))
		{
			float s = ConsoleUtils.getFloat("Side length: ");
			created = new Square(s);
		}

		if (created == null)
		{
			ConsoleUtils.println("Invalid shape");
			ConsoleUtils.println();
			return;
		}

		ConsoleUtils.println();

		ConsoleUtils.println("Area: " + created.getArea());
		ConsoleUtils.println("Perimeter: " + created.getPerimeter());

		ConsoleUtils.sleep(500);
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

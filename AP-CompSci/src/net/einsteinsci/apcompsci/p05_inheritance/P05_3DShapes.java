package net.einsteinsci.apcompsci.p05_inheritance;

import com.sun.javaws.exceptions.InvalidArgumentException;
import net.einsteinsci.apcompsci.Start;

public class P05_3DShapes
{
	public static void main()
	{

	}

	public static interface IShape
	{
		public float getVolume();
		public float getSurfaceArea();
	}

	public static abstract class Shapeoid
	{

	}

	public static abstract class Prismid extends Shapeoid
	{

	}

	public static abstract class Spheroid extends Shapeoid implements IShape
	{
		public static final float PI = (float)Math.PI;

		public static double asinh(double x)
		{
			return Math.log(x + Math.sqrt(x * x + 1));
		}

		public static double acosh(double x)
		{
			return Math.log(x + Math.sqrt(x * x - 1));
		}

		public static double atanh(double x)
		{
			return 0.5 * Math.log((x + 1) / (x - 1));
		}

		public float a; // equatorial radius
		public float c; // polar radius

		public Spheroid(float polarRadius, float lateralRadius)
		{
			a = lateralRadius;
			c = polarRadius;
		}

		public float getVolume()
		{
			final float fourPiOverThree = (4 * PI) / 3;
			return fourPiOverThree * a * a * c;
		}

		public float getSurfaceArea()
		{
			if (isSphere())
			{
				Sphere sphere = new Sphere(this);
				return sphere.getSurfaceArea();
			}

			float twoPiASquared = 2 * PI * a * a;

			if (isOblate())
			{
				float e = (float)Math.sqrt(1 - (c * c) / (a * a));
				float div = (1 - e * e) / e;
				return twoPiASquared * (1 + div * (float)atanh(e));
			}
		}

		public boolean isOblate()
		{
			return a > c;
		}

		public boolean isSphere()
		{
			return a == c;
		}
	}

	public static class Sphere extends Spheroid implements IShape
	{
		public Sphere(Spheroid oid)
		{
			super(oid.a, oid.a);

			if (oid.a != oid.c)
			{
				Start.printErr(new InvalidArgumentException(
						new String[] {"Spheroid is not a sphere. a = " + oid.a + ", c = " + oid.c}));
			}
		}
	}
}

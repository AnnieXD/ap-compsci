package net.einsteinsci.apcompsci.p05_inheritance;

import com.sun.javaws.exceptions.InvalidArgumentException;
import net.einsteinsci.apcompsci.Start;

public class P05_3DShapes
{
	public static void main()
	{
		Shapeoid oid = null;

		boolean recognized = true;
		do
		{
			String type = Start.getLine("Enter shapeoid type. Valid types are:" +
												"\n\tCylinder, Cuboid, Cube, TriPrism," +
												"\n\tSquarePyramid, Cone, TriPyramid, Tetrahedron" +
												"\n\tSpheroid, and Sphere." +
												"\nTYPE> ");
			if (type.equalsIgnoreCase("cylinder"))
			{
				float r = Start.getFloat("Radius: ");
				float h = Start.getFloat("Height: ");

				oid = new Cylinder(r, h);
			}
			else if (type.equalsIgnoreCase("cuboid"))
			{
				float l = Start.getFloat("Length: ");
				float w = Start.getFloat("Width: ");
				float h = Start.getFloat("Height: ");

				oid = new Cuboid(w, l, h);
			}
			else if (type.equalsIgnoreCase("cube"))
			{
				float s = Start.getFloat("Side Length: ");

				oid = new Cube(s);
			}
			else if (type.equalsIgnoreCase("triprism"))
			{
				float s = Start.getFloat("Base Side Length: ");
				float h = Start.getFloat("Height: ");

				oid = new EquilateralTriangularPrism(s, h);
			}
			else if (type.equalsIgnoreCase("squarepyramid"))
			{
				float s = Start.getFloat("Base Side Length: ");
				float h = Start.getFloat("Height: ");

				oid = new SquarePyramid(s, h);
			}
			else if (type.equalsIgnoreCase("cone"))
			{
				float r = Start.getFloat("Radius: ");
				float h = Start.getFloat("Height: ");

				oid = new Cone(r, h);
			}
			else if (type.equalsIgnoreCase("tripyramid"))
			{
				float s = Start.getFloat("Side Length: ");
				float h = Start.getFloat("Height: ");

				oid = new EquilateralTriangularPyramid(s, h);
			}
			else if (type.equalsIgnoreCase("tetrahedron"))
			{
				float s = Start.getFloat("Side Length: ");

				oid = new Tetrahedron(s);
			}
			else if (type.equalsIgnoreCase("spheroid"))
			{
				float a = Start.getFloat("Equatorial Radius: ");
				float b = Start.getFloat("Polar Radius: ");

				oid = new Spheroid(b, a);
			}
			else if (type.equalsIgnoreCase("sphere"))
			{
				float r = Start.getFloat("Radius: ");

				oid = new Sphere(r);
			}
			else
			{
				recognized = false;
			}
		} while (!recognized);

		float v = oid.getVolume();
		float a = oid.getSurfaceArea();

		Start.println();
		Start.println("Volume: " + v);
		Start.println("Surface Area: " + a);

		Start.sleep(50);
	}

	public static interface IShapeoid
	{
		public float getVolume();
		public float getSurfaceArea();
	}

	public static abstract class Shapeoid implements IShapeoid
	{
		public static final float PI = (float)Math.PI;
		public static final float ROOTTHREEOVERTWO = ((float)Math.sqrt(3)) / 2;
	}

	// Prismids

	public static abstract class Prismid extends Shapeoid implements IShapeoid
	{
		protected float height;

		public Prismid(float h)
		{
			height = h;
		}

		public float getVolume()
		{
			return getBase() * height;
		}

		public float getSurfaceArea()
		{
			return (getBasePerimeter() * height) + 2 * getBase();
		}

		public abstract float getBase();
		public abstract float getBasePerimeter();

		public float getHeight()
		{
			return height;
		}
	}

	public static class Cylinder extends Prismid implements IShapeoid
	{
		protected float radius;

		public Cylinder(float r, float h)
		{
			super(h);
			radius = r;
		}

		@Override
		public float getBase()
		{
			return PI * radius * radius;
		}

		@Override
		public float getBasePerimeter()
		{
			return 2 * PI * radius;
		}

		public float getRadius()
		{
			return radius;
		}
	}

	public static class Cuboid extends Prismid implements IShapeoid
	{
		protected float width;
		protected float length;

		public Cuboid(float w, float l, float h)
		{
			super(h);
			width = w;
			length = l;
		}

		@Override
		public float getBase()
		{
			return width * length;
		}

		@Override
		public float getBasePerimeter()
		{
			return 2 * (width + length);
		}

		public float getWidth()
		{
			return width;
		}
		public float getLength()
		{
			return length;
		}
	}

	public static class Cube extends Cuboid implements IShapeoid
	{
		public Cube(float s)
		{
			super(s, s, s);
		}

		public float getSide()
		{
			return width;
		}
	}

	public static class EquilateralTriangularPrism extends Prismid implements IShapeoid
	{
		protected float side;

		public EquilateralTriangularPrism(float s, float h)
		{
			super(h);

			side = s;
		}

		@Override
		public float getBase()
		{
			float altitude = ROOTTHREEOVERTWO * side;
			return altitude * (side / 2);
		}

		@Override
		public float getBasePerimeter()
		{
			return 3 * side;
		}

		public float getSide()
		{
			return side;
		}
	}

	// Pyramids

	public static abstract class Pyramid extends Shapeoid implements IShapeoid
	{
		public float height;

		public Pyramid(float h)
		{
			height = h;
		}

		public float getVolume()
		{
			final float ONETHIRD = (float)(1.0 / 3.0);
			return ONETHIRD * getBase() * height;
		}

		public float getSurfaceArea()
		{
			return getBase() + (getPerimeter() * getSlantHeight()) / 2;
		}

		public float getSlantHeight()
		{
			return (float)Math.sqrt(height * height + getInradius() * getInradius());
		}

		public abstract float getBase();
		public abstract float getPerimeter();
		protected abstract float getInradius();
	}

	public static class SquarePyramid extends Pyramid implements IShapeoid
	{
		public float baseLength;

		public SquarePyramid(float s, float h)
		{
			super(h);
			baseLength = s;
		}

		public float getBase()
		{
			return baseLength * baseLength;
		}
		public float getPerimeter()
		{
			return baseLength * 4;
		}
		protected float getInradius()
		{
			return baseLength / 2;
		}

		public float getBaseLength()
		{
			return baseLength;
		}
	}

	public static class Cone extends Pyramid implements IShapeoid
	{
		public float radius;

		public Cone(float r, float h)
		{
			super(h);
			radius = r;
		}

		public float getBase()
		{
			return PI * radius * radius;
		}
		public float getPerimeter()
		{
			return 2 * PI * radius;
		}
		protected float getInradius()
		{
			return radius;
		}

		public float getRadius()
		{
			return radius;
		}
	}

	public static class EquilateralTriangularPyramid extends Pyramid implements IShapeoid
	{
		protected float side;

		public EquilateralTriangularPyramid(float s, float h)
		{
			super(h);
			side = s;
		}

		public float getBase()
		{
			float baseAlt = ROOTTHREEOVERTWO * side;
			return baseAlt * (side / 2);
		}
		public float getPerimeter()
		{
			return 3 * side;
		}
		protected float getInradius()
		{
			return (ROOTTHREEOVERTWO / 3) * side;
		}

		public float getSide()
		{
			return side;
		}
	}

	public static class Tetrahedron extends EquilateralTriangularPyramid implements IShapeoid
	{
		public Tetrahedron(float s)
		{
			super(s, ((float)Math.sqrt(2 / 3)) * s);
		}
	}

	// Spheroids

	public static class Spheroid extends Shapeoid implements IShapeoid
	{
		public static double asinh(double x)
		{
			return Math.log(x + Math.sqrt(x * x + 1.0));
		}
		public static double acosh(double x)
		{
			return Math.log(x + Math.sqrt(x * x - 1.0));
		}
		public static double atanh(double x)
		{
			return 0.5 * Math.log((x + 1.0) / (x - 1.0));
		}

		protected float a; // equatorial radius
		protected float c; // polar radius

		public Spheroid(float polarRadius, float equatorialRadius)
		{
			a = equatorialRadius;
			c = polarRadius;
		}

		public float getVolume()
		{
			final float fourPiOverThree = (float)((4.0 * PI) / 3.0);
			return fourPiOverThree * a * a * c;
		}

		public float getSurfaceArea()
		{
			if (isSphere())
			{
				Sphere sphere = new Sphere(this);
				return sphere.getSurfaceArea();
			}

			float twoPiASquared = (float) (2.0 * PI * a * a);

			if (isOblate())
			{
				Start.printErr(new ArithmeticException("Calculating the surface area of an oblate spheroid requires \n" +
															   "using the inverse hyperbolic tangent. Such a function is \n" +
															   "difficult to implement currently. Results will be inaccurate."));

				float under = (float) (1.0 - (c * c) / (a * a));
				float e = (float) Math.sqrt(under);
				float div = (float) ((1.0 - e * e) / e);
				float atanhe = (float) atanh(e);
				return (float) (twoPiASquared * (1.0 + div * atanhe));
			}
			else
			{
				float under = (float) (1.0 - (a * a) / (c * c));
				float e = (float) Math.sqrt(under);
				float div = c / (a * e);
				return (float) (twoPiASquared * (1.0 + div * (float) (Math.asin(e))));
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

		public float getPolarRadius()
		{
			return c;
		}

		public float getEquatorialRadius()
		{
			return a;
		}
	}

	public static class Sphere extends Spheroid implements IShapeoid
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

		public Sphere(float r)
		{
			super(r, r);
		}

		public float getRadius()
		{
			return a;
		}

		@Override
		public float getVolume()
		{
			float fourThirdsPi = (float)(4.0 / 3.0) * PI;
			return fourThirdsPi * getRadius() * getRadius() * getRadius();
		}

		@Override
		public float getSurfaceArea()
		{
			float fourPi = (float)(4.0 * PI);
			return fourPi * getRadius() * getRadius();
		}
	}
}

package net.einsteinsci.apcompsci.p06_lists;

import net.einsteinsci.apcompsci.ConsoleUtils;
import net.einsteinsci.apcompsci.start.IStartable;

import java.util.ArrayList;
import java.util.List;

public class P06_Windows implements IStartable
{
	WindowManager dwm;

	public void main()
	{
		dwm = new WindowManager();
		boolean beingStupid = false;

		while (true)
		{
			//ConsoleUtils.skip();
			String action = "";
			if (!beingStupid)
			{
				ConsoleUtils.println("Enter action. Valid entries are: 'open', 'close',\n" +
											 "'select', 'resize', 'move', 'list', 'exit'");
				action = ConsoleUtils.getLine("> ");
				beingStupid = false;
			}

			action = action.toLowerCase();

			switch (action)
			{
				case "open":
					addWindow();
					break;
				case "close":
					removeWindow();
					break;
				case "select":
					click();
					break;
				case "resize":
					resize();
					break;
				case "move":
					move();
					break;
				case "list":
					dwm.listWindows();
					break;
				case "exit":
					return;
				default:
					ConsoleUtils.println("Invalid input '" + action + "'. Try again");
					beingStupid = true;
					break;
			}
		}
	}

	void addWindow()
	{
		String name = ConsoleUtils.getLine("Enter Window name: ");
		int x = ConsoleUtils.getInt("X Position: ");
		int y = ConsoleUtils.getInt("Y Position: ");
		int w = ConsoleUtils.getInt("Width: ");
		int h = ConsoleUtils.getInt("Height: ");

		Window win = new Window(name, x, y, w, h);
		dwm.open(win);
	}

	void removeWindow()
	{
		dwm.listWindows();

		int z = ConsoleUtils.getInt("Enter Window z-order to remove: ");

		dwm.close(z);
		dwm.listWindows();
	}

	void click()
	{
		dwm.listWindows();

		ConsoleUtils.println("Click Location:");
		int x = ConsoleUtils.getInt("x = ");
		int y = ConsoleUtils.getInt("y = ");

		dwm.click(x, y);
		dwm.listWindows();
	}

	void resize()
	{
		dwm.listWindows();

		int z = ConsoleUtils.getInt("Enter Window z-order to resize: ");
		int dx = ConsoleUtils.getInt("New width: ");
		int dy = ConsoleUtils.getInt("New height: ");

		Window w = dwm.getWindow(z);
		w.x = dx;
		w.y = dy;
	}

	void move()
	{
		dwm.listWindows();

		int z = ConsoleUtils.getInt("Enter window z-order to move: ");
		int x = ConsoleUtils.getInt("New x location: ");
		int y = ConsoleUtils.getInt("New y location: ");

		Window w = dwm.getWindow(z); // wxyz
		w.x = x;
		w.y = y;
	}

	public static class WindowManager
	{
		List<Window> windows;

		public WindowManager()
		{
			windows = new ArrayList<>();
		}

		public void click(int x, int y)
		{
			Window result = null;

			for (int i = 0; i < windows.size(); ++i)
			{
				Window w = windows.get(i);

				if (w.contains(x, y))
				{
					result = w;
					break;
				}
			}

			if (result != null)
			{
				select(result);
			}
		}

		public void open(Window window)
		{
			windows.add(0, window); // Windows (almost) always open on top.
		}
		public void close(int zOrder)
		{
			windows.remove(zOrder);
		}
		public void close(Window closed)
		{
			windows.remove(closed);
		}

		public int getWindowIndex(Window window)
		{
			return windows.indexOf(window);
		}
		public Window getWindow(int zOrder)
		{
			return windows.get(zOrder);
		}

		public void reposition(int zOrder, int x, int y)
		{
			windows.get(zOrder).x = x;
			windows.get(zOrder).y = y;
		}
		public void resize(int zOrder, int width, int height)
		{
			windows.get(zOrder).width = width;
			windows.get(zOrder).height = height;
		}

		public void select(Window window)
		{
			windows.remove(window);
			windows.add(0, window);
		}
		public void select(int zOrder)
		{
			select(getWindow(zOrder));
		}

		public void listWindows()
		{
			ConsoleUtils.println("\n=== WINDOWS ===");

			for (int i = 0; i < windows.size(); ++i)
			{
				Window w = windows.get(i);

				ConsoleUtils.println("" + i + ": " + w.toString());
			}

			ConsoleUtils.println();
		}
	}

	public static class Window
	{
		public String title;

		public int x, y;
		public int width, height;

		public Window(String title, int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.title = title;
		}

		public boolean contains(int pointX, int pointY)
		{
			return x < pointX && x + width > pointX &&
				y < pointY && y + height > pointY;
		}

		@Override
		public String toString()
		{
			return title + " [x=" + x + ", y=" + y + ", w=" + width + ", h=" + height + "]";
		}
	}
}

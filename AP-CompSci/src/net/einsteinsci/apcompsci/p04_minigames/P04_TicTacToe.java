package net.einsteinsci.apcompsci.p04_minigames;

import net.einsteinsci.apcompsci.Console;
import net.einsteinsci.apcompsci.start.IStartable;

import java.awt.*;
import java.util.Random;

public class P04_TicTacToe implements IStartable
{
	public void main()
	{
		TicTacToeGame game = new TicTacToeGame();
		game.play();
	}

	public static class TicTacToeGame
	{
		public TTTPiece[][] board;

		public static final TTTPiece player = TTTPiece.O;
		public static final TTTPiece ai = player.not();

		public TicTacToeGame()
		{
			board = new TTTPiece[3][3];
			for (int i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					board[i][j] = TTTPiece.EMPTY;
				}
			}
		}

		public void play()
		{
			showHelp();

			boolean playerTurn = true;
			
			while (getWinner() == TTTPiece.EMPTY && !isTied())
			{
				renderBoard();

				if (playerTurn)
				{
					playerTurn();
				}
				else
				{
					Console.sleep(500);

					setSpot(getAISpot(), ai);
				}

				playerTurn = !playerTurn;
			}

			renderBoard();

			Console.println();
			
			if (getWinner() == ai)
			{
				Console.println("You lose.");
			}
			else if (getWinner() == player)
			{
				Console.println("You win!");
			}
			else if (isTied())
			{
				Console.println("Tie.");
			}
			else
			{
				Console.println("Error. Wierdness happened.");
			}

			Console.println();
		}
		
		public void playerTurn()
		{
			Point spot = null;

			boolean occupied = true;

			do
			{
				int x = Console.getInt("Row: ");
				int y = Console.getInt("Column: ");

				if (x > 3 || x < 1 || y > 3 || y < 1)
				{
					Console.println("No such space.");
					continue;
				}
				
				spot = new Point(x - 1, y - 1);
				
				occupied = getSpot(spot) != TTTPiece.EMPTY;
				
				if (occupied)
				{
					Console.println("Space occupied.");
				}
			} while (occupied);
			
			setSpot(spot, player);
		}
		
		public void renderBoard()
		{
			Console.println();

			for (int i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 3; ++j)
				{
					Console.print(board[i][j].getRender());
				}
				
				Console.println();
			}
		}

		public void showHelp()
		{
			Console.println("Enter row first, then column. You are " + player.toString() + "'s. Don't mess up.");
		}

		public TTTPiece getSpot(Point spot)
		{
			return board[spot.x][spot.y];
		}
		public TTTPiece getSpot(int x, int y)
		{
			return board[x][y];
		}

		public void setSpot(Point spot, TTTPiece piece)
		{
			board[spot.x][spot.y] = piece;
		}
		public void setSpot(int x, int y, TTTPiece piece)
		{
			board[x][y] = piece;
		}

		public Point getAISpot()
		{
			if (canWin(ai))
			{
				return getWinningSpot(ai);
			}

			if (canBlock(ai))
			{
				return getBlockingSpot(ai);
			}

			Random rand = new Random();
			Point spot = null;

			do
			{
				spot = new Point(rand.nextInt(3), rand.nextInt(3));
			} while (getSpot(spot) != TTTPiece.EMPTY);

			return spot;
		}
		public TTTPiece getWinner()
		{
			if (hasWon(TTTPiece.X))
			{
				return TTTPiece.X;
			}
			else if (hasWon(TTTPiece.O))
			{
				return TTTPiece.O;
			}
			else
			{
				return TTTPiece.EMPTY;
			}
		}
		public boolean hasWon(TTTPiece tested)
		{
			boolean b = false;

			for (int i = 0; i < 3; ++i)
			{
				b = b || testWin(new Point(0, i), new Point(1, i), new Point(2, i)) == tested;
			}
			for (int i = 0; i < 3; ++i)
			{
				b = b || testWin(new Point(i, 0), new Point(i, 1), new Point(i, 2)) == tested;
			}
			b = b || testWin(new Point(0, 0), new Point(1, 1), new Point(2, 2)) == tested;
			b = b || testWin(new Point(2, 0), new Point(1, 1), new Point(0, 2)) == tested;

			return b;
		}
		public Point getWinInRow(Point aPoint, Point bPoint, Point cPoint, TTTPiece side)
		{
			TTTPiece a = getSpot(aPoint);
			TTTPiece b = getSpot(bPoint);
			TTTPiece c = getSpot(cPoint);

			if (a == side && b == side && c == TTTPiece.EMPTY)
			{
				return cPoint;
			}
			else if	(a == side && c == side && b == TTTPiece.EMPTY)
			{
				return bPoint;
			}
			else if (b == side && c == side && a == TTTPiece.EMPTY)
			{
				return aPoint;
			}
			else
			{
				return null;
			}
		}
		
		public boolean isTied()
		{
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (getSpot(new Point(i, j)) == TTTPiece.EMPTY)
					{
						return false;
					}
				}
			}
			
			return true;
		}

		public TTTPiece testWin(Point a, Point b, Point c)
		{
			if (getSpot(a) == getSpot(b) && getSpot(b) == getSpot(c))
			{
				return getSpot(a);
			}
			else
			{
				return TTTPiece.EMPTY;
			}
		}

		public boolean canWin(TTTPiece side)
		{
			return getWinningSpot(side) != null;
		}
		public Point getWinningSpot(TTTPiece side)
		{
			if (side == TTTPiece.EMPTY)
			{
				return null;
			}

			Point spot;

			for (int i = 0; i < 3; ++i)
			{
				spot = getWinInRow(new Point(0, i), new Point(1, i), new Point(2, i), side);
				if (spot != null)
				{
					return spot;
				}
			}

			for (int i = 0; i < 3; ++i)
			{
				spot = getWinInRow(new Point(i, 0), new Point(i, 1), new Point(i, 2), side);
				if (spot != null)
				{
					return spot;
				}
			}

			spot = getWinInRow(new Point(0, 0), new Point(1, 1), new Point(2, 2), side);
			if (spot != null)
			{
				return spot;
			}

			spot = getWinInRow(new Point(0, 2), new Point(1, 1), new Point(2, 0), side);
			if (spot != null)
			{
				return spot;
			}

			return null;
		}

		public boolean canBlock(TTTPiece side)
		{
			return getBlockingSpot(side) != null;
		}
		public Point getBlockingSpot(TTTPiece side)
		{
			return getWinningSpot(side.not());
		}
	}

	public static enum TTTPiece
	{
		EMPTY,
		X,
		O;

		public String getRender()
		{
			return "[" + toString() + "]";
		}
		public String toString()
		{
			switch (this)
			{
				case EMPTY:
					return " ";
				case X:
					return "X";
				case O:
					return "O";
				default:
					return "?";
			}
		}

		public TTTPiece not()
		{
			switch (this)
			{
				case X:
					return O;
				case O:
					return X;
				default:
					return EMPTY;
			}
		}
	}
}

package solution;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * A maze game.
 * 
 * @author Greg Rapp
 * @version 1.0
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;
    private final static int STRINGPARAM = 41;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;

    /**
     * The current location of the player vertically.
     */
    private int userCol;

    /**
     * The current location of the player horizontally.
     */
    private int userRow;

    /**
     * The scanner from which each move is read.
     */
    private Scanner moveScanner;

    /**
     * The row and column of the goal.
     */
    private int goalRow;
    private int goalCol;


    /**
     * The row and column of the start.
     */
    private int startRow;
    private int startCol;

    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        loadMaze(mazeFile);
        moveScanner = new Scanner(System.in);
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
        loadMaze(mazeFile);
        setMoveScanner(moveScanner);
    }

    /**
     * loads a 19x39 maze.
     * 
     * @param mazeFile 
     */
    public void 
        loadMaze(String mazeFile)
    {
        String index;
        boolean[][] b = new boolean[HEIGHT][WIDTH];
        File file = new File(mazeFile);
        try
        {
            Scanner sc = new Scanner(file);
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    index = sc.next();
                    if (index.equals("1"))
                    {
                        b[i][j] = true;
                    }
                    else if (index.equals("0"))
                    {
                        b[i][j] = false;
                    }
                    else if (index.equals("S"))
                    {
                        setStartRow(i);
                        setStartCol(j);
                        b[i][j] = false;
                    }
                    else if (index.equals("G"))
                    {
                        setGoalRow(i);
                        setGoalCol(j);
                        b[i][j] = false;
                    }
                }
            }            
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        setMaze(b);
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }
    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        while (playerAtGoal() != true)
        {
            printMaze();
            System.out.println("Enter your move: ");
            String move = moveScanner.next();

            if (!move.equals("quit"))
            {
                makeMove(move);
            }
        }
        moveScanner.close();
    }

    /**
     * Checks to see if the player has won the game.
     * 
     * @param row
     * @param col
     * @return true if the player has won.
     */
    public boolean playerAtGoal()
    {
        return (userRow == goalRow && userCol == goalCol);
    }

    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {
        move.toLowerCase();
        move = move.charAt(0) + "";
        int up = userRow - 1;
        int down = userRow + 1;
        int right = userCol + 1;
        int left = userCol - 1;

        if (move.equals("u")
            && userRow != 0
            && !blocked[up][userCol])
        {
            System.out.println("up");
            setUserRow(up);
            return true;

        }
        else if (move.equals("d") 
            && userRow != HEIGHT - 1 
            && !blocked[down][userCol])
        {
            System.out.println("down");
            setUserRow(down);
            return true;
        }
        else if (move.equals("r")
            && userCol != WIDTH - 1
            && !blocked[userRow][right])
        {
            System.out.println("right");
            setUserCol(right);
            return true;
        }

        else if (move.equals("l") 
            && userCol != 0
            && !blocked[userRow][left])
        {
            System.out.println("left");
            setUserCol(left);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        String[][] str1 = new String[HEIGHT][STRINGPARAM];
        String str3 = "*";

        for (int i = 0; i < HEIGHT; i++)
        {
            str3 = str3 + "-";
            str1[i][0] = "|";
            for (int j = 0; j < WIDTH; j++)
            {
                if (blocked[i][j] == false)
                {
                    str1[i][j + 1] = " ";
                }
                else if (blocked[i][j] == true)
                {
                    str1[i][j + 1] = "X";
                }
            }
            str1[i][STRINGPARAM - 1] = "|";
            str3 = str3 + "-";
        }
        str1[startRow][startCol + 1] = "S";
        str1[goalRow][goalCol + 1] = "G";
        str1[userRow][userCol + 1] = "@";
        str3 = str3 + "-*";

        System.out.println(str3);
        for (int i = 0; i < HEIGHT; i++)
        {
            String str2 = String.join("", str1[i]);
            System.out.println(str2);
        }
        System.out.println(str3);
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }

    /**
     * accessor for blocked.
     * 
     * @return blocked
     */
    public boolean[][] getBlocked()
    {
        return blocked;
    }

    /**
     * mutator for blocked.
     * 
     * @param blocked 
     */
    public void setBlocked(boolean[][] blocked)
    {
        this.blocked = blocked;
    }

    /**
     * accessor for userCol.
     * 
     * @return userCol 
     */
    public int getUserCol()
    {
        return userCol;
    }

    /**
     * mutator for userCol.
     * 
     * @param userCol 
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
    }

    /**
     * accessor for userRow.
     * 
     * @return userRow 
     */
    public int getUserRow()
    {
        return userRow;
    }

    /**
     * mutator for userRow.
     * 
     * @param userRow 
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
    }

    /**
     * accessor for goalRow.
     * 
     * @return goalRow 
     */
    public int getGoalRow()
    {
        return goalRow;
    }

    /**
     * mutator for goalRow.
     * 
     * @param goalRow
     */
    public void setGoalRow(int goalRow)
    {
        this.goalRow = goalRow;
    }

    /**
     * accessor for goalCol.
     * 
     * @return goalCol 
     */
    public int getGoalCol()
    {
        return goalCol;
    }

    /**
     * mutator for goalCol.
     * 
     * @param goalCol
     */
    public void setGoalCol(int goalCol)
    {
        this.goalCol = goalCol;
    }

    /**
     * accessor for startRow.
     * 
     * @return startRow 
     */
    public int getStartRow()
    {
        return startRow;
    }

    /**
     * mutator for startRow.
     * 
     * @param startRow
     */
    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

    /**
     * accessor for startCol.
     * 
     * @return startCol 
     */
    public int getStartCol()
    {
        return startCol;
    }

    /**
     * mutator for startCol.
     * 
     * @param startCol
     */
    public void setStartCol(int startCol)
    {
        this.startCol = startCol;
    }

    /**
     * accessor for moveScanner.
     * 
     * @return moveScanner 
     */
    public Scanner getMoveScanner()
    {
        return moveScanner;
    }

    /**
     * mutator for moveScanner.
     * 
     * @param moveScanner 
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
        //        game.makeMove("r");
        //        game.makeMove("r");
        //        game.makeMove("d");
    }
}

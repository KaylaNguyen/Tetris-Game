import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* Class that acts as the controller for the text version of the game
**/
public class TetrisTextController
{
	//instance properties
	//variable to hole the instance of TetrisGame
	private TetrisGame game;
	//variable to hole instance of textView class
	private TetrisBoardTextView view;
	
	//methods
	//constructor
	public TetrisTextController()
	{
		//create an instance for tetris game
		game = new TetrisGame();
		//create an instance for tetris text view
		view = new TetrisBoardTextView(game);
		//print out the board
		refreshDisplay();
		//read input from user
		readInput();
	}

	//Get input from the user, looping until the user types "Quit".
	private void readInput()
	{
		// wrap input stream read input from user
		BufferedReader in = 
		new BufferedReader( new InputStreamReader( System.in ) );
 
		// prompt the user for input
		System.out.println( "Please enter r, l, d, z, or x (r: right l: left d: down z: clockwise x: counterclockwise) or type Quit to end." ); 
 
		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;
 
			// loop until the user types "Quit"
			do {
				// try to read a line
				line = in.readLine(); 
 				//invoke moveEntered function
 				moveEntered(line);
 				//refresh display
 				refreshDisplay();
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	//Print text view of the game.
	//First, print the number of tetrises cleared.
	//Second, print the number of lines cleared.
	//Then, print the tetris board.
	private void refreshDisplay()
	{
		System.out.println(view.getBoardString());
	}

	//r: right l: left d: down z: cw x: ccw
	private void moveEntered(String move)
	{	
		//if user input r, attempt to move right
		if(move.equals("r"))
			game.attemptMove(TetrisGame.RIGHT);
		//if user input l, attempt to move left
		else if(move.equals("l"))
			game.attemptMove(TetrisGame.LEFT);
		//if user input d, attempt to move down
		else if(move.equals("d"))
			game.attemptMove(TetrisGame.DOWN);
		//if user input z, attempt to rotate cw
		else if(move.equals("z"))
			game.attemptMove(TetrisGame.CW);
		//if user input x, attempt to rotate ccw
		else if(move.equals("x"))
			game.attemptMove(TetrisGame.CCW);
		else
			// prompt the user for correct input
			System.out.println( "Invalid Move" ); 
 
	}

	//main method
	public static void main(String[] args)
	{
		//make new instance
		new TetrisTextController();
	}
	
}

//import java.util.Timer;

/**
* A class acts as the model of the game
* Keeps track of what is happening in the game (score, print out the board…)
**/
public class TetrisGame
{
	//instance properties
	//variables to hold the values of each movement
	public static final int CCW = 1;
	public static final int CW = 2;
	public static final int DOWN = 3; 
	public static final int LEFT = 4; 
	public static final int RIGHT = 5;
	//variable to hold the number of cleared lines
	private int	numLines = 0; 
	//variable to hold the number of tetrises created
	private int	numTetrises = 0; 
	//variable to hold the board
	private TetrisBoard	board;

	//methods
	//constructor
	public TetrisGame()
	{
		//create a new instance of the board
		board = new TetrisBoard();
	}
	
	//Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	public void attemptMove(int moveType)
	{
		//if move is CCW
		if(moveType == CCW)
			board.rotateCCW();
		//if move is CW
		if(moveType == CW)
			board.rotateCW();
		//if move is down
		if(moveType == DOWN)
		{
			boolean checkMoveDown = board.moveDown();
			if (!checkMoveDown)
				endRound();
		}
		//if move is left
		if(moveType == LEFT)
			board.moveLeft();
		//if move is right
		if(moveType == RIGHT)
			board.moveRight();
	}
	
	//Performed when a piece cannot move down anymore.
	private void endRound()
	{	
		//add the piece to the board
		board.landPiece();
		//add a new piece to the board
		board.addNewPiece();
	}

	//getter method to get the number of formed lines
	public int getNumLines()
	{
		return (numLines += board.numberOfFormedLines());
	}

	//getter method to get the number of tetrises created
	public int getNumTetrises()
	{
		if (board.numberOfFormedLines() == 4)
				numTetrises++;
		return numTetrises;
	}

	//getter method to get the board
	public TetrisBoard getTetrisBoard()
	{
		return board;
	}

}

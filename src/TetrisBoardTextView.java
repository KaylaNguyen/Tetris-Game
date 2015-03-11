/**
* A class to set the text view of Tetris game
**/
public class TetrisBoardTextView
{
	//instance properties
	//a board for the game
	private TetrisBoard board;
	//an instance of the game
	private TetrisGame game;

	//methods
	//constructor
	public TetrisBoardTextView(TetrisGame g)
	{
		//get board from tetris game
		board = g.getTetrisBoard();
		//get game from Tetris game
		game = g;
	}
	
	//method to update the display
	//return a String that shows the state of the board
	//x for filled, nothing for empty
	//String should be full lines long (= row num), use “\n” for new line
	public String getBoardString()
	{	
		//a string to hold the score
		//First, print the number of tetrises cleared.
		//Second, print the number of lines cleared.
		String scoreString = 	"Number of Tetrises cleared: " + game.getNumTetrises()
						+ "\n" + "Nummber of cleared lines: " + game.getNumLines();

		//a string to hold the board
		String printBoard = "";
		//Then, print the tetris board.
		//loop through the array
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols(); j++){
				//if there is a block in the index
				if(board.hasBlock(i, j))
					//print out x
					printBoard += "x";
				//else
				else
					//print out empty space
					printBoard += " ";
			}
			//separate each row
			printBoard += "\n";
		}

		//a string that holds the view of the whold game
		String boardString = scoreString
							+ "\n" + "__________"
							+ "\n" + printBoard
							+ "\n" + "__________";
		//return board string
		return boardString;
	}
}

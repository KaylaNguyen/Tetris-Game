/**
* A class that handles the logic in the board
* The TetrisBoard class represents the model:
* a board on which Tetris is played;
* it maintains the grid and pieces on it.
**/
public class TetrisBoard
{
	//instance properties
	//an array of Boolean acts as the game board
	private boolean[][] board;
	//variables to hold the number of rows of the board
	private static final int NUM_ROWS = 18;
	//variables to hold the number of columes of the board
	private static final int NUM_COLS = 10;
	//a variable to hold the current piece that’s moving in the game
	private TetrisPiece currentPiece;
	//a variable to hold the current piece position
	private int[] currentGridPosition;

	//Constructor
	public TetrisBoard()
	{
		//sets up the board
		initBoard();
		//initialize the currentGP
		initCurrentGP();
		//add new piece to the board
		addNewPiece();
	}

	//Initialize an int array of length two
	//to keep track of the grid position of the current piece (row, col)
	private void initCurrentGP()
	{
		//initialize currentGridPosition
		currentGridPosition = new int[2];
		//keep the position of the current piece at (0, 3)
		currentGridPosition[0] = 0;
		currentGridPosition[1] = 3;

	}

	//method to initilize the board
	private void initBoard()
	{
		//initialize the board
		board = new boolean[NUM_ROWS][NUM_COLS];
		// initialize the contents of the board
		for ( int i = 0; i < NUM_ROWS; i++){
		    for (int j = 0; j < NUM_COLS; j++){
				//set value to false
				board[i][j] = false;
			}
		}
	} 

	//Add a new random Tetris piece to the board
	//at grid position (0, 3)
	public void addNewPiece()
	{
		//declare a variable to hold a random number
		double random = Math.random()*7;
		//if ransom number falls into these ranges
		//assign a tetris piece to the current piece
		if (random < 1)
		 	currentPiece = new TetrisL1();
		else if (random < 2)
		 	currentPiece = new TetrisL2();
		else if (random < 3)
		 	currentPiece = new TetrisS1();
		else if (random < 4)
		 	currentPiece = new TetrisS2();
		else if (random < 5)
		 	currentPiece = new TetrisSquare();
		else if (random < 6)
		 	currentPiece = new TetrisStick();
		else
		 	currentPiece = new TetrisT();
		//reset current grid
		initCurrentGP();
	}
	
	//Update the board array to reflect the newly landed piece's filled squares
	//using the currentGridPosition values and the currentPiece's rotation value.
	//Basically this method is to add piece to the board
	public void	landPiece()
	{
 		//loop through all rows and columns less than the size of piece
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				//if there is a piece
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), i, j))
				{
					//assign a new row position for the piece
					int row = currentGridPosition[0] + i;
					//assign a new col position for the piece
					int col = currentGridPosition[1] + j;
					//set the value of the new position to true
					board[row][col] = true;
				}
			}
		}
	}

	//Check if moving down is valid.
	//If so, move the current piece down.
	public boolean moveDown()
	{
		//declare and assign a variable
		//that holds new row position for the current piece
		int newRowPosition = currentGridPosition[0] + 1;
		//if moving down is a valid move
		if (validMove(currentPiece, currentPiece.getPieceRotation(), newRowPosition, currentGridPosition[1]))
		{
			//move the current piece down
			currentGridPosition[0] = newRowPosition;
			//return true
			return true;
		}
		else
			//return false if moving down is not a valid move
			return false;
	}

	//Check if moving left is valid.
	//If so, move the current piece left.
	public boolean moveLeft()
	{
		//declare and assign a variable
		//that holds new column position for the current piece
		int newColPosition = currentGridPosition[1] - 1;
		//if moving left is a valid move
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], newColPosition))
		{
			//move the current piece left
			currentGridPosition[1] = newColPosition;
			//return true
			return true;
		}
		else
			//return false if moving left is not a valid move
			return false;
	}
	
	//Check if moving right is valid.
	//If so, move the current piece down.
	public boolean moveRight()
	{
		//declare and assign a variable
		//that holds new column position for the current piece
		int newColPosition = currentGridPosition[1] + 1;
		//if moving left is a valid move
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], newColPosition))
		{
			//move the current piece right
			currentGridPosition[1] = newColPosition;
			//return true
			return true;
		}
		else
			//return false if moving left is not a valid move
			return false;
	}

	//Check if rotating counterclockwise is valid.
	//If so, rotate the current piece counterclockwise by 90 degrees.
	public boolean rotateCCW()
	{
		//declare and assign variable
		//that holds the current rotation value
		int currentRotation = currentPiece.getPieceRotation();
		//if current rotation is 0 degree
		if (currentRotation == 0)
			//rotate the piece by giving it new rotation value of 270 degree
			currentRotation = 3;
		//else, not 0 degree
		else
			//subtract 90 degree from its current rotation
			currentRotation -= 1;

		//check if rotating counterclockwise is valid
		if (validMove(currentPiece, currentRotation, currentGridPosition[0], currentGridPosition[1]))
		{
			//rotate the piece counterclockwise
			currentPiece.rotateCCW();
			//return true
			return true;
		}
		else
			//return false if rotating is not a valid move
			return false;
	}

	//Check if rotating clockwise is valid.
	//If so, rotate the current piece clockwise by 90 degrees.
	public boolean rotateCW()
	{
		//declare and assign variable
		//that holds the current rotation value
		int currentRotation = currentPiece.getPieceRotation();
		//if current rotation is 0 degree
		if (currentRotation == 3)
			//rotate the piece by giving it new rotation value of 270 degree
			currentRotation = 0;
		//else, not 0 degree
		else
			//subtract 90 degree from its current rotation
			currentRotation += 1;

		//check if rotating clockwise is valid
		if (validMove(currentPiece, currentRotation, currentGridPosition[0], currentGridPosition[1]))
		{
			//rotate the piece clockwise
			currentPiece.rotateCW();
			//return true
			return true;
		}
		else
			//return false if rotating is not a valid move
			return false;
	}
	
	//Checks if placing the piece at grid position (row, col)
	//with the rotation rot (values can be 0, 1, 2, 3)
	//would cause a collision
	//(i.e., if there would be a block on an already-filled grid square)
	private boolean	detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//loop through all rows and columns less than the size of piece
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				//if the piece touches the given index of the board
				if (piece.isFilled(rot, i, j) && board[gridRow+i][gridCol+j]){
					System.out.println("Invalid move");
					//return true
					return true;
				}
			}
		}
		//else, return false
		return false;
	}

	//Checks if placing the piece at grid position (row, col)
	//with the rotation rot (values can be 0, 1, 2, 3)
	//would cause an out of bounds condition
	//(i.e., if there would be a block falling off the board).
	private boolean	detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//loop through all rows and columns less than the size of piece
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				//System.out.println(gridRow + "," + gridCol);
				int row = gridRow + i;
				int col = gridCol + j;
				//if there is a piece
				if(piece.isFilled(rot, i, j)){
					//if the position is off the board
					if ((row < 0) || (row >= NUM_ROWS) || (col < 0) || (col >=NUM_COLS)){
						System.out.println("Invalid move");
						//then the piece is out of bound
						return true;
					}
				}
			}
		}
		//return false if it's in bound
		return false;
	}

	//Checks if placing the piece at grid position (row, col)
	//with the rotation rot (values can be 0, 1, 2, 3) is a valid move.
	private boolean	validMove(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		//if there is a collision or the moving piece is out of bound
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) || detectCollision(piece, rot, gridRow, gridCol))
			//it's not a valid move
			return false;
		//else
		else
			//it is a valid move
			return true;
	}

	//check if there is block at the given position
	public boolean hasBlock(int row, int col)
	{
		//declare and assign variable
		//that holds the current rotation value
		int rot = currentPiece.getPieceRotation();

		//loop through all rows and columns less than the size of piece
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				//check inside each piece to mark the blocks filled with an x
				//while i & j are within the range of a possible piece 
				//if((i >= currentGridPosition[0] && i < currentGridPosition[0]+4 && j >= currentGridPosition[1] && j< currentGridPosition[1]+4) && (currentPiece.isFilled(rot, i- currentGridPosition[0], j- currentGridPosition[1])) )
				if(currentPiece.isFilled(rot, i, j) && (currentGridPosition[0] + i == row) && (currentGridPosition[1] + j == col))
					{
						//return the value of the filled piece
						return true;
					}
			}
		} 
		//return the value of the board                                                                                                                                                                                                                         
		return (board[row][col]);
	} 

	//Detect and remove any lines formed.
	public int numberOfFormedLines()
	{
		//declare and assign a variable to hold the number of formed lines
		int formedLineNum = 0;
		//loop through all the rows
		for(int i = 0; i < NUM_ROWS; i++){
			//if the current line is full
			if (fullLine(i))
			{
				//increment the formed line number by 1
				formedLineNum ++;
				//remove the full line
				removeLine(i);
			}
		}
		//return the formed line number
		return formedLineNum;

	}

	//Check if there is a full line at the row.
	public boolean fullLine(int row)
	{
		//loop through all the columns
		for (int j = 0; j < NUM_COLS; j++){
			//if there is any false value in the given row
			if (!board[row][j])
				//the line is not full
				return false;
		}
		//else, the line is full
		return true;
	}
	
	//Remove the line at row in the model.
	//Shift all values for rows at a lower index to be at one row higher.
	//Make row 0 full of false values. ******(for what?)
	private void removeLine(int row)
	{
		//loop through the array
		for(int i = NUM_ROWS - 1; i > 0; i--){
			for(int j = NUM_COLS - 1; j >= 0; j--){
				//shift all values for rows at a lower index to be at one row higher
				board[i][j] = board[i-1][j];
			}
		}
	}
	
	//getter method to get the board
	public boolean[][] getBoard() 
	{
		return board;
	}

	//getter method to get the current grid position
	public int[] getCurrentGridPosition() 
	{
		return currentGridPosition;
	}

	//getter method to get the current piece
	public TetrisPiece getCurrentPiece() 
	{
		return currentPiece;
	}

	//getter method to get the number of columns in the board
	public int getNumCols()
	{
		return NUM_COLS;
	}

	//getter method to get the number of rows in the board
	public int getNumRows()
	{
		return NUM_ROWS;
	}
}

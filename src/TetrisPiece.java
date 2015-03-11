/**
* An abstract class to set the design of tetris pieces
**/
public abstract class TetrisPiece
{
	//instance properties
	//3 dimensional array maintaining which grid squares are filled
	//first dimension is rotation
	//(index 0 -> 0 degrees, index 1 -> 90 degrees, index 2 -> 180 degrees, index 3 -> 270 degrees)
	//second and third dimensions create 4x4 grid
	//with true entries indicating a filled square
	protected boolean[][][] filledSquares;
	//Maintains the current rotation
	//0 -> 0 degrees, 1 -> 90 degrees, 2 -> 180 degrees, 3 -> 270 degrees
	protected int pieceRotation;

	//Constructor
	public TetrisPiece()
	{
		//set default rotation value to 0
		pieceRotation = 0;
	}

	//methods
	//Get the rotation of this piece.
	//Returns: 0, 90, 180, or 270 degrees.
	public int getPieceRotation()
	{
		return pieceRotation;
	}

	//method to rotate counterclockwise
	public void rotateCCW()
	{
		//if current rotation is 0 degree
		if (pieceRotation == 0)
			//rotate the piece by giving it new rotation value of 270 degree
			pieceRotation = 3;
		//else, not 0 degree
		else
			//subtract 90 degree from its current rotation
			pieceRotation -= 1;
	}

	//method to rotate clockwise
	public void rotateCW()
	{
		//if current rotation is 0 degree
		if (pieceRotation == 3)
			//rotate the piece by giving it new rotation value of 270 degree
			pieceRotation = 0;
		//else, not 0 degree
		else
			//subtract 90 degree from its current rotation
			pieceRotation += 1;
	}

	//Checks if there is a TetrisBlock at the (row, col) position for the rotation rot,
	//where rot is 0, 90, 180 or 270 degrees.
	public boolean isFilled(int rot, int row, int col)
	{
		//if there is a piece at given position
		if(filledSquares[rot][row][col])
			//return true
			return true;
		//else
		else
			//return false
			return false;
	}
}

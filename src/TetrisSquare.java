/**
* A class that hold the shape of square piece
**/
public class TetrisSquare extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisSquare()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//oooo
							//oxxo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//oxxo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 180 degree
							//oooo
							//oxxo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 270 degree
							//oooo
							//oxxo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, true, true, false},
							{false, false, false, false}
						}
					};
					filledSquares = array;
	}
}

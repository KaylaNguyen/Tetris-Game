/**
* A class that hold the shape of T piece
**/
public class TetrisT extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisT()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//oooo
							//oxoo
							//xxxo
							//oooo
						{
							{false, false, false, false},
							{false, true, false, false},
							{true, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//oxoo
							//oxxo
							//oxoo
						{
							{false, false, false, false},
							{false, true, false, false},
							{false, true, true, false},
							{false, true, false, false}
						},
							//shape at 180 degree
							//oooo
							//oooo
							//xxxo
							//oxoo
						{
							{false, false, false, false},
							{false, false, false, false},
							{true, true, true, false},
							{false, true, false, false}
						},
							//shape at 270 degree
							//oooo
							//oxoo
							//xxoo
							//oxoo
						{
							{false, false, false, false},
							{false, true, false, false},
							{true, true, false, false},
							{false, true, false, false}
						}
					};
					filledSquares = array;
	}
}

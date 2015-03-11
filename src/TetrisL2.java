/**
* A class that hold the shape of L2 piece
**/
public class TetrisL2 extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisL2()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//ooxo
							//ooxo
							//oxxo
							//oooo
						{
							{false, false, true, false},
							{false, false, true, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//oxoo
							//oxxx
							//oooo
						{
							{false, false, false, false},
							{false, true, false, false},
							{false, true, true, true},
							{false, false, false, false}
						},
							//shape at 180 degree
							//oooo
							//oxxo
							//oxoo
							//oxoo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, true, false, false},
							{false, true, false, false}
						},
							//shape at 270 degree
							//oooo
							//xxxo
							//ooxo
							//oooo
						{
							{false, false, false, false},
							{true, true, true, false},
							{false, false, true, false},
							{false, false, false, false}
						}
					};
					filledSquares = array;
	}
}

/**
* A class that hold the shape of L1 piece
**/
public class TetrisL1 extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisL1()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//oxoo
							//oxoo
							//oxxo
							//oooo
						{
							{false, true, false, false},
							{false, true, false, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//oxxx
							//oxoo
							//oooo
						{
							{false, false, false, false},
							{false, true, true, true},
							{false, true, false, false},
							{false, false, false, false}
						},
							//shape at 180 degree
							//oooo
							//oxxo
							//ooxo
							//ooxo
						{
							{false, false, false, false},
							{false, true, true, false},
							{false, false, true, false},
							{false, false, true, false}
						},
							//shape at 270 degree
							//oooo
							//xooo
							//xxxo
							//oooo
						{
							{false, false, false, false},
							{true, false, false, false},
							{true, true, true, false},
							{false, false, false, false}
						}
					};
		filledSquares = array;
	}
}
/**
* A class that hold the shape of s2 piece
**/
public class TetrisS2 extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisS2()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//oooo
							//ooxx
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, false, true, true},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//oxoo
							//oxxo
							//ooxo
						{
							{false, false, false, false},
							{false, true, false, false},
							{false, true, true, false},
							{false, false, true, false}
						},
							//shape at 180 degree
							//oooo
							//ooxx
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{false, false, true, true},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 270 degree
							//oooo
							//oxoo
							//oxxo
							//ooxo
						{
							{false, false, false, false},
							{false, true, false, false},
							{false, true, true, false},
							{false, false, true, false}
						}
					};
					filledSquares = array;
	}
}

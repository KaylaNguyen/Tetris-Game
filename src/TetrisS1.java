/**
* A class that hold the shape of s1 piece
**/
public class TetrisS1 extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisS1()
	{
			//set values for the array
			boolean[][][] array = {
							//shape at 0 degree
							//oooo
							//xxoo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{true, true, false, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 90 degree
							//oooo
							//ooxo
							//oxxo
							//oxoo
						{
							{false, false, false, false},
							{false, false, true, false},
							{false, true, true, false},
							{false, true, false, false}
						},
							//shape at 180 degree
							//oooo
							//xxoo
							//oxxo
							//oooo
						{
							{false, false, false, false},
							{true, true, false, false},
							{false, true, true, false},
							{false, false, false, false}
						},
							//shape at 270 degree
							//oooo
							//ooxo
							//oxxo
							//oxoo
						{
							{false, false, false, false},
							{false, false, true, false},
							{false, true, true, false},
							{false, true, false, false}
						}
					};
					filledSquares = array;
	}
}


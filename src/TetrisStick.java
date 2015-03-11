/**
* A class that hold the shape of stick piece
**/
public class TetrisStick extends TetrisPiece
{
	//Constructor
	//set the shape of the piece
	public TetrisStick()
	{
		//set values for the array
		boolean[][][] array = {
							//shape at 0 degree
							//oxoo
							//oxoo
							//oxoo
							//oxoo
						{
							{false, true, false, false},
							{false, true, false, false},
							{false, true, false, false},
							{false, true, false, false}
						},
							//shape at 90 degree
							//oooo
							//xxxx
							//oooo
							//oooo
						{
							{false, false, false, false},
							{true, true, true, true},
							{false, false, false, false},
							{false, false, false, false}
						},
							//shape at 180 degree
							//oxoo
							//oxoo
							//oxoo
							//oxoo
						{
							{false, true, false, false},
							{false, true, false, false},
							{false, true, false, false},
							{false, true, false, false}
						},
							//shape at 270 degree
							//oooo
							//xxxx
							//oooo
							//oooo
						{
							{false, false, false, false},
							{true, true, true, true},
							{false, false, false, false},
							{false, false, false, false}
						}
					};
					filledSquares = array;
	}
}

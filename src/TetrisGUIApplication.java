import javax.swing.JFrame;

/**
* A class that creates the GUI version of the game
**/
public class TetrisGUIApplication
{
	//instance properties
	//a variable to hold the game frame
	private JFrame tetrisFrame;

	//method
	//main method
	public static void main( String[] args )
	{
		JFrame tetrisFrame = new JFrame( "Tetris" ); 
		tetrisFrame.setSize(350, 700); 
		tetrisFrame.getContentPane().add( new TetrisGUIController() ); 
		tetrisFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		tetrisFrame.setVisible( true ); 
	}
}


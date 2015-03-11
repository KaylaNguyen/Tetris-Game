// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

//swing
import javax.swing.*;

//timer
import javax.swing.Timer;

/**
* A class that acts as the controller for the GUI version of the game
* extends JPanel
**/
public class TetrisGUIController extends JPanel implements KeyListener
{
	//instance properties
	public static final int DEFAULT_DROP_RATE = 800;
	//instance of tetris game
	private TetrisGame game; 
	//instance of tetris GUI view
	private TetrisGUIView view;
	//Labels to hold score
	private JPanel scorePanel;
	private JLabel linesLabel;
	private JLabel tetrisesLabel; 
	//a timer to keep time
	private Timer gameTimer; 
	//private int dropRate;

	//constructor
	//set the layout, initGUI and game
	public TetrisGUIController()
	{
		//initializw the game instance
		game = new TetrisGame();
		//initialize view
		view = new TetrisGUIView(game.getTetrisBoard());

		//use BorderLayout 
		setLayout( new BorderLayout() );
		//add score panel to NORTH
		add( createScorePanel(), BorderLayout.NORTH ); 
		// add tetris board
		add( view, BorderLayout.CENTER ); 

		//set background to be black
		setBackground(Color.BLACK);
		//set focusable for key events.
		setFocusable(true); 
		//set up timer
		setupTimer();
		//refresh display to update screen
		refreshDisplay();
		//add key listener
		addKeyListener(this);
	}

	//METHODS
	//method to set up the timer
	private void setupTimer()
	{
		//set up timer
		gameTimer = new Timer(DEFAULT_DROP_RATE, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//move the piece down
				game.attemptMove(game.DOWN);
				//repaint the board to refresh display
				refreshDisplay();
			}
		});
		//start timer
		gameTimer.start();
	}

	//method to create the output field
	private JPanel createScorePanel()
	{
		//display lines cleared
		scorePanel = new JPanel(new GridLayout(1, 1));
		//initialize lines label
		linesLabel = new JLabel();
		//add it to scorePanel
		scorePanel.add(linesLabel);
		//initialize tetrises label
		tetrisesLabel = new JLabel();
		//add it to scorePanel
		scorePanel.add(tetrisesLabel);
		//return Jpanel
		return scorePanel;
	}

	//method to refresh display
	public void refreshDisplay()
	{
		//repaint to refresh view
		repaint();
		//update the score
		//display lines cleared
		linesLabel.setText("Lines cleared: " + game.getNumLines());
		//displayed tetrises cleared
		tetrisesLabel.setText("Tetrises cleared: " + game.getNumTetrises());
	}

	//method to handle the key-pressed event
	public void keyPressed(KeyEvent e)
	{
		//get input from user
		//r: right l: left d: down z: cw x: ccw
		switch(e.getKeyCode())
		{
			//if user presses X key
			case KeyEvent.VK_X:
				//rotate piece counterclockwise
				game.attemptMove(game.CCW);
				break;
			//if user presses Z key
			case KeyEvent.VK_Z: case KeyEvent.VK_UP:
				//rotate piece clockwise
				game.attemptMove(game.CW);
				break;
			//if user presses down key
			case KeyEvent.VK_DOWN:
				//move piece down
				game.attemptMove(game.DOWN);
				break;
			//if user presses left key
			case KeyEvent.VK_LEFT:
				//move piece left
				game.attemptMove(game.LEFT);
				break;
			//if user presses right key
			case KeyEvent.VK_RIGHT:
				//move piece right
				game.attemptMove(game.RIGHT);
				break;
			//default case: do nothing
			default:
				break;
		}
		//refresh display to update screen
		refreshDisplay();
	}

	//method to handle the key typed event
	public void keyTyped(KeyEvent e)
	{

	}

	//method to handle the key-released event
	public void keyReleased(KeyEvent e)
	{

	}
}
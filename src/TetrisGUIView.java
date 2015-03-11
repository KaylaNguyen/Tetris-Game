import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

/**
* A class that acts as the view of the GUI game
**/
public class TetrisGUIView extends JComponent
{
	//instance properties
	//a variable to hold the board array
	private TetrisBoard board;
	//a variable to hold blocksize
	private int blockSize = 0;

	//methods
	//constructor
	public TetrisGUIView(TetrisBoard b)
	{
		//call super class fỏ no reason
		super();
		//set board by assigning b to board
		board = b;
		//set background
		setBackground(Color.BLACK);
		//set Opaque
		this.setOpaque( true );
		//repaint
		repaint();
	}

	//method to paint the game
	public void paint(Graphics g)
	{
		//compute block size
		blockSize = computeBlockSize();
		//paint the outline of the board
		paintBoardOutline(g, blockSize);

		//loop through the array
		for ( int i = 0; i < board.getNumRows(); i++){
    		for (int j = 0; j < board.getNumCols(); j++){
    			//if there's piece on the board
    			if (board.hasBlock(i, j))
    			{
    				//paint it
    				paintBlock(g, i, j, blockSize);
    				//paint the grid
    				paintGrid(g, i, j, blockSize);
    			}
    		}
    	}
	}
	
	//method to paint the outline for the board
	private void paintBoardOutline(Graphics g, int blockSize)
	{
		//set color to the board outline
		g.setColor(Color.BLACK);
		//draw rectangle around the grid
		g.drawRect(0, 0, getWidth(), getHeight());
	}

	//method to paint the block at grid row, grid col
	private void paintBlock(Graphics g, int row, int col, int blockSize)
	{
		//compute block size
		blockSize = computeBlockSize();
    	//set the color
    	g.setColor(Color.RED);
    	//paint rectangle
    	g.fillRect( col * blockSize, row * blockSize, blockSize, blockSize);

	}

	//paint a grid for the board	
	private void paintGrid(Graphics g, int i, int j, int blockSize)
	{
		//set the color to black
		g.setColor( Color.BLACK );
		//draw the grid
		g.drawRect( j*blockSize, i*blockSize, blockSize, blockSize );
	}

	//method to ompute the best block size for the current width and height.
	private int computeBlockSize()
	{
		// max size based on width
		int maxWidth = getWidth() / board.getNumCols();
		// max size based on height
		int maxHeight = getHeight() / board.getNumRows();
		//calculates biggest possible block size
		return Math.min( maxWidth, maxHeight );
	}
}


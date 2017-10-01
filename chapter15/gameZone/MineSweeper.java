package gameZone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MineSweeper extends JFrame implements ActionListener
{
	JPanel mainPanel = new JPanel();
	JPanel gamePanel = new JPanel();

	JLabel message = new JLabel();

	final static int sizeHeigth = 4;
	final static int sizeWidth = 5;
	final static int numberOfBombs = 4;

	static int squaresClicked = 0;

	Font textFont = new Font("Comic Sans", Font.BOLD, 20);

	static JButton[] buttons = new JButton[sizeHeigth * sizeWidth];

	static List<Integer> bombLocations = new ArrayList<Integer>();

	public MineSweeper()
	{
		super("Mine Sweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);

		message.setText("Welcome!");

		gamePanel.setLayout(new GridLayout(sizeHeigth, sizeWidth));

		for (int i = 0; i < (sizeHeigth * sizeWidth); i++)
		{
			buttons[i] = new JButton();
			gamePanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(textFont);
		}

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(message, BorderLayout.NORTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		add(mainPanel);

		for (int i = 0; i < numberOfBombs; i++)
		{
			// prevents from bomb being created in same spot
			bombLocations.add(getUniqueRand());
			// to debug:
			// buttons[bombLocations.get(i)].setText("BOMB");
		}

		/*
		 * for (int i = 0; i < (sizeHeigth * sizeWidth); i++) { if
		 * (!bombLocations.contains(i)) {
		 * buttons[i].setText(Integer.toString(getBombValue(i))); } }
		 */
	}

	public static int getUniqueRand()
	{
		int randomNumber = 1 + (int) (Math.random() * ((sizeHeigth * sizeWidth) - 1));

		for (int i = 0; i < bombLocations.size(); i++)
		{
			if (bombLocations.get(i) == randomNumber)
				return getUniqueRand();
		}

		return randomNumber;
	}

	public static int getBombValue(int position)
	{
		int totalBombCount = 0;

		int row = position % sizeWidth;
		int column = position / sizeWidth;

		for (int i = 0; i < numberOfBombs; i++)
		{
			int bombPosition = bombLocations.get(i);
			int bombRow = bombPosition % sizeWidth;
			int bombColumn = bombPosition / sizeWidth;

			if (bombRow == row + 1 && bombColumn == column)
				totalBombCount++;
			if (bombRow == row - 1 && bombColumn == column)
				totalBombCount++;
			if (bombColumn == column + 1 && bombRow == row)
				totalBombCount++;
			if (bombColumn == column - 1 && bombRow == row)
				totalBombCount++;
			if (bombRow == row + 1 && bombColumn == column + 1)
				totalBombCount++;
			if (bombRow == row + 1 && bombColumn == column - 1)
				totalBombCount++;
			if (bombRow == row - 1 && bombColumn == column + 1)
				totalBombCount++;
			if (bombRow == row - 1 && bombColumn == column - 1)
				totalBombCount++;

			// check row+1, row-1,
			// column+1, column-1,
			// row+1 column+1, row+1 column-1,
			// row-1 column+1, row-1 column-1
		}

		return totalBombCount;
	}

	public static void main(String[] args)
	{
		MineSweeper frame = new MineSweeper();
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{

		// Check location of button being pressed
		for (int i = 0; i < (sizeHeigth * sizeWidth); i++)
		{
			if (source.getSource() == buttons[i])
			{
				// Check if it is a bomb location
				if (bombLocations.contains(i))
				{
					// Change all bombs to red and all normal squares to gray and show values
					for (int j = 0; j < (sizeHeigth * sizeWidth); j++)
					{
						buttons[j].setBackground(Color.DARK_GRAY);
						buttons[j].setText(Integer.toString(getBombValue(j)));
						buttons[j].setEnabled(false);
					}
					for (int k = 0; k < numberOfBombs; k++)
					{
						buttons[bombLocations.get(k)].setBackground(Color.RED);
						buttons[bombLocations.get(k)].setText("BOMB");
					}

					message.setText("You lost!");
					JOptionPane.showMessageDialog(null, "You Lost");

				}
				// else if location is normal square
				else
				{
					// make gray and show value
					buttons[i].setBackground(Color.GRAY);
					buttons[i].setText(Integer.toString(getBombValue(i)));
					squaresClicked++;

					// Check if win Game
					if (squaresClicked == (sizeHeigth * sizeWidth) - numberOfBombs)
					{

						for (int l = 0; l < (sizeHeigth * sizeWidth); l++)
						{
							buttons[l].setEnabled(false);
						}

						message.setText("Congradulations! You Won!");
						JOptionPane.showMessageDialog(null, "Congradulations! You Won!");

					}
				}

			}
		}

	}

}

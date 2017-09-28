package chapter15gamezone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineSweeper extends JFrame implements ActionListener
{
	JPanel mainPanel = new JPanel();
	JPanel gamePanel = new JPanel();
	
	JLabel message = new JLabel();

	final static int sizeHeigth = 4;
	final static int sizeWidth = 5;
	final static int numberOfBombs = 4;
	
	Font textFont = new Font("Comic Sans", Font.BOLD, 15);
	
	static JButton[] buttons = new JButton[sizeHeigth * sizeWidth];
	
	static List<Integer> bombLocations = new ArrayList<Integer>();
	
	public MineSweeper () 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		
		message.setText("Mine Sweeper");
		
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
			bombLocations.add(getUniqueRand());
			buttons[bombLocations.get(i)].setText("BOMB");
			//prevent from bomb being created in same spot
		}
		
	}
	
	public static int getUniqueRand() 
	{
		int randomNumber = 1 + (int)(Math.random() * ((sizeHeigth * sizeWidth)-1));
		
		for (int i = 0; i < bombLocations.size(); i++)
			if (bombLocations.get(i) == randomNumber)
				return getUniqueRand();
				
	}
		return randomNumber;

	public static void main(String[] args)
	{
	    MineSweeper frame = new MineSweeper();
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{
		// Check location of button being pressed
		// Check if it is a bomb location
		// if it is change all bombs to red and all normal squares to gray
		// show values
		// else if location is normal square
		// make gray and show value
		
	}

}

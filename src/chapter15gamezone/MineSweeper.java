package chapter15gamezone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	static int[] bombLocations = new int[numberOfBombs];
	
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
			bombLocations[i] = 1 + (int)(Math.random() * ((sizeHeigth * sizeWidth)-1));
			buttons[bombLocations[i]].setText("BOMB");
			//prevent from bomb being created in same spot
		}
	}

	public static void main(String[] args)
	{
	    MineSweeper frame = new MineSweeper();
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{
		for (int i = 0; i < numberOfBombs; i++) 
		{
			if (source.getSource()==buttons[i])
			{
				for (int j = 0; j < (sizeHeigth * sizeWidth); j++) 
				{
					buttons[j].setBackground(Color.GRAY);
					buttons[bombLocations[i]].setBackground(Color.RED);
					message.setText("You Lost!");
				}
				
				//Show all bomb positions and values for each square
			}
		}
	}

}

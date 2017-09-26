package chapter15gamezone;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import chapter15debugging.FixDebugFifteen1;
import sun.applet.Main;

//Page 85
public class MineField extends JFrame implements ActionListener
{		
	JPanel mainPanel = new JPanel();
	JPanel gamePanel = new JPanel();
	JPanel difficulty = new JPanel();
	
	JLabel message = new JLabel();

	static JButton easy = new JButton();
	static JButton intermediate = new JButton();
	static JButton difficult = new JButton();
	
	final static int sizeHeigth = 5;
	final static int sizeWidth = 4;
	static int bomb;
	static int safeCount = 0;
	static int safeToWin = 10;

	static JButton[] buttons = new JButton[sizeHeigth * sizeWidth];
	
	public MineField() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	      
		message.setText("The Mine Field");
		easy.setText("Easy");
		intermediate.setText("Intermediate");
		difficult.setText("Difficult");
		easy.addActionListener(this);
		intermediate.addActionListener(this);
		difficult.addActionListener(this);

		gamePanel.setLayout(new GridLayout(sizeHeigth, sizeWidth));
		
		for (int i = 0; i < (sizeHeigth * sizeWidth); i++) 
		{
			buttons[i] = new JButton();
			gamePanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.BLUE);
			buttons[i].setEnabled(false);
		}
		
		difficulty.setLayout(new GridLayout(1,3));
		difficulty.add(easy);
		difficulty.add(intermediate);
		difficulty.add(difficult);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(message, BorderLayout.NORTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		mainPanel.add(difficulty, BorderLayout.SOUTH);
		add(mainPanel);
		
		bomb = 1 + (int)(Math.random() * (sizeHeigth * sizeWidth));			
	}
	
	public static void main(String[] args) 
	{
	      MineField frame = new MineField();
	}

	public static void startGame () 
	{
		easy.setEnabled(false);
		intermediate.setEnabled(false);
		difficult.setEnabled(false);
		
		for (int i = 0; i < 20; i++) 
		{
			buttons[i].setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{
		if (source.getSource() == easy) 
		{
			safeToWin = 5;
			startGame();
		}
		if (source.getSource() == intermediate) 
		{
			safeToWin = 10;
			startGame();
		}
		if (source.getSource() == difficult) 
		{
			safeToWin = 15;
			startGame();
		}
				
		
		for (int i = 0; i < 20; i++) 
		{
			if (source.getSource()==buttons[bomb])
			{
				buttons[i].setBackground(Color.WHITE);
				buttons[bomb].setBackground(Color.RED);
				message.setText("You Lost!");
			}
			else if (source.getSource()==buttons[i] && source.getSource()!=buttons[bomb])
			{
				if (buttons[i].getBackground() != Color.WHITE)
				{
				buttons[i].setBackground(Color.WHITE);
				safeCount++;
				}
				
				if (safeCount == safeToWin)
					message.setText("Congratulations!");			

			}
		}

	}
}

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
	
	JLabel message = new JLabel();
	
	JMenuBar menuBar = new JMenuBar();
	
	JMenu difficulty = new JMenu();
	JMenu congratzMessage = new JMenu("The Mine Field");

	JMenuItem Easy = new JMenuItem();
	JMenuItem Intermediate = new JMenuItem();
	JMenuItem Difficult = new JMenuItem();
	
	final int sizeWidth = 4;
	final int sizeHeigth = 5;
	static int bomb;
	static int safeCount = 0;

	JButton[] buttons = new JButton[sizeWidth * sizeHeigth];
	
	public MineField() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	      
		message.setText("The Mine Field");

		gamePanel.setLayout(new GridLayout(sizeWidth, sizeHeigth));
		
		for (int i = 0; i < (sizeWidth * sizeHeigth); i++) 
		{
			buttons[i] = new JButton();
			gamePanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.BLUE);
		}
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(message, BorderLayout.NORTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		add(mainPanel);
		
		bomb = 1 + (int)(Math.random() * (sizeWidth * sizeHeigth));
		
		//mainPanel.add(menuBar, BorderLayout.NORTH);
		//menuBar.add(difficulty);
		//menuBar.add(congratzMessage);
		
	}
	
	public static void main(String[] args) 
	{
	      MineField frame = new MineField();
	}


	@Override
	public void actionPerformed(ActionEvent source)
	{
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
				if (safeCount == 10)
					message.setText("Congratulations!");

				buttons[i].setBackground(Color.WHITE);
				safeCount++;
			}
		}

	}
}

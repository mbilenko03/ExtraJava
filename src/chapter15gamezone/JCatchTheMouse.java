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

public class JCatchTheMouse extends JFrame implements ActionListener
{
	JPanel mainPanel = new JPanel();
	JPanel gamePanel = new JPanel();

	JLabel message = new JLabel();

	Font messageFont = new Font("Comic Sans", Font.BOLD, 15);
	Font buttonFont = new Font("Comic Sans", Font.BOLD, 24);

	long startTime = System.nanoTime();
	
	final static int sizeHeigth = 8;
	final static int sizeWidth = 6;
	static int x;
	
	static double totalClickCount = 0;
	static double mouseClickCount = 0;
	
	static JButton[] buttons = new JButton[sizeHeigth * sizeWidth];

	
	public JCatchTheMouse() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		
		message.setFont(messageFont);
		message.setText("Catch The Mouse");
		
		gamePanel.setLayout(new GridLayout(sizeHeigth, sizeWidth));
		
		for (int i = 0; i < (sizeHeigth * sizeWidth); i++) 
		{
			buttons[i] = new JButton();
			gamePanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(buttonFont);
		}
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(message, BorderLayout.NORTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		add(mainPanel);

		x = 1 + (int)(Math.random() * ((sizeHeigth * sizeWidth)-1));
		buttons[x].setText("X");
		

	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
	    JCatchTheMouse frame = new JCatchTheMouse();
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{	
		if (source.getSource()==buttons[x])
			{
			buttons[x].setText("");
			x = 1 + (int)(Math.random() * (sizeHeigth * sizeWidth));
			buttons[x].setText("X");
			mouseClickCount++;
			}
			
		totalClickCount++;
		
		if (mouseClickCount >=  10)
		{
			buttons[x].setText("");
			long endTime = System.nanoTime() - startTime;
			
			message.setText("Congradulations! Your hit percent is " + Math.round((mouseClickCount/totalClickCount)*100) + "%!"
					+ " It took you " + (int)(endTime/1000000000) + " seconds!");

		}	
	}

}

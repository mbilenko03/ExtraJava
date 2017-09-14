package gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameWithManyComponents extends JFrame
{
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 150;
	
	public JFrameWithManyComponents() 
	{
		super("Demonstrating many components");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel heading = new JLabel("This frame has many components");
		heading.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel namePrompt = new JLabel("Enter your name:");
		JTextField nameField = new JTextField(12);
		JButton button = new JButton("Click to continue");
		setLayout(new FlowLayout());
		add(heading);
		add(namePrompt);
		add(nameField);
		add(button);
		button.setToolTipText("Click this button");
		
	}

}

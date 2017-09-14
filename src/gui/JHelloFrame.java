package gui;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JHelloFrame extends JFrame implements ActionListener
{
	JLabel question = new JLabel("What is your name?");
	Font bigFont = new Font("Arial", Font.BOLD, 16);
	JTextField answer = new JTextField(10);
	JButton pressmMe = new JButton("Press me");
	JLabel greeting = new JLabel("");
	final int WIDTH = 275;
	final int HEIGHT = 225;
	
	public JHelloFrame() 
	{
		super("Hello Frame");
	}
	
}

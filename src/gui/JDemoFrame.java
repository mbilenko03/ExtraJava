package gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDemoFrame
{

	public static void main(String[] args)
	{
		JFrame aFrame = new JFrame("This is a frame");
		final int WIDTH = 250;
		final int HEIGHT = 100;
		Font headlineFont = new Font("Arial", Font.BOLD, 36);
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel greeting = new JLabel("Good day");
		JLabel greeting2 = new JLabel("Who are you?");
		greeting.setFont(headlineFont);
		aFrame.setLayout(new FlowLayout());
		aFrame.add(greeting);
		aFrame.add(greeting2);
	}

}

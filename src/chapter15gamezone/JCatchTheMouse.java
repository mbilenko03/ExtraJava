package chapter15gamezone;

import java.awt.Color;
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

	final static int sizeHeigth = 8;
	final static int sizeWidth = 6;
	static int x;
	
	static JButton[] buttons = new JButton[sizeHeigth * sizeWidth];
	
	public JCatchTheMouse() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		
		message.setText("Catch The Mouse");
		
		gamePanel.setLayout(new GridLayout(sizeHeigth, sizeWidth));
		
		for (int i = 0; i < (sizeHeigth * sizeWidth); i++) 
		{
			buttons[i] = new JButton();
			gamePanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.BLUE);
			buttons[i].setEnabled(false);
		}

	}
	
	public static void main(String[] args)
	{
	      JCatchTheMouse frame = new JCatchTheMouse();
	}

	@Override
	public void actionPerformed(ActionEvent source)
	{
		// TODO Auto-generated method stub
		
	}

}

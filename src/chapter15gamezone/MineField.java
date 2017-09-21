package chapter15gamezone;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;


public class MineField extends JFrame implements MouseInputListener 
{
	JLabel message = new JLabel(); //North Congratz Message
	Container con = null;
	GridLayout field = new GridLayout(4,5);
	JPanel pane = new JPanel(field);
	JPanel[] panel = new JPanel[20];
	
	public MineField() 
	{
	    con = this.getContentPane();
	    con.setLayout(new BorderLayout());
	    this.message.setText("Test");
		con.add(message, BorderLayout.NORTH);
		
		for(int i = 0; i < 20; ++i)
		{
			panel[i] = new JPanel();
			con.add(panel[i], BorderLayout.CENTER);
			panel[i].setBackground(Color.BLUE);
		}
		
		addMouseListener(this);
		
	}
	
	public static void main(String[] args)
	{
	      MineField f = new MineField();
	      f.setSize(300, 300);
	      f.setVisible(true);
	}
	

	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	} 



}

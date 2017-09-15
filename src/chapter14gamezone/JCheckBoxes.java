package chapter14gamezone;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxes extends JFrame implements ItemListener
{
	//questions
	JLabel questionOne = new JLabel("Which of the following are in the top three most populated states?");
	JLabel questionTwo = new JLabel("Which of the following is the most populated?");
	JLabel questionThree = new JLabel("Which of the following has Tallahassee as its capital?");
	JLabel questionFour = new JLabel("Which of the following have the northern mockingbird as their state bird?");
	JLabel questionFive = new JLabel("Which of the following have the largest area?");
	
	//check boxes
	JCheckBox california = new JCheckBox("California", false);
	JCheckBox texas = new JCheckBox("Texas", false);
	JCheckBox florida = new JCheckBox("Florida", false);

	//other important
	Font bigFont = new Font("Arial", Font.BOLD, 16);
	JButton submit = new JButton("Submit");
	final int WIDTH = 1000;
	final int HEIGHT = 500;
	
	public JCheckBoxes() 
	{
		super("HedgeYourBet");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		questionOne.setFont(bigFont);
		questionTwo.setFont(bigFont);
		questionThree.setFont(bigFont);
		questionFour.setFont(bigFont);
		questionFive.setFont(bigFont);

		california.addItemListener(this);
		texas.addItemListener(this);
		florida.addItemListener(this);
		submit.addItemListener(this);
		
		add(questionOne);
		add(california);
		add(texas);
		add(florida);
		add(submit);
		
//		add(questionTwo);
//		add(california);
//		add(texas);
//		add(florida);
//		
//		add(questionThree);
//		add(california);
//		add(texas);
//		add(florida);
//		
//		add(questionFour);
//		add(california);
//		add(texas);
//		add(florida);
//		
//		add(questionFive);
//		add(california);
//		add(texas);
//		add(florida);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent check) 
	{
		 //actions based on choice
	}
}

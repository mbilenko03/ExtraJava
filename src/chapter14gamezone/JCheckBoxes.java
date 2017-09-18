package chapter14gamezone;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxes extends JFrame implements ItemListener, ActionListener
{
	//questions
	JLabel questionOne = new JLabel("Which of the following is the most populated?");
	JLabel questionTwo = new JLabel("Which of the following is the most densly populated?");
	JLabel questionThree = new JLabel("Which of the following have Tallahassee as its capital?");
	JLabel questionFour = new JLabel("Which of the following have the quail as their state bird?");
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
	
	public int score = 0;
	public int question = 1;
	public boolean selected = false;
	
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
		submit.addActionListener(this);
		
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
	
	public void resetAnswers() 
	{
		california.setSelected(false);
		texas.setSelected(false);
		florida.setSelected(false);
	}
	
	@Override
	public void itemStateChanged(ItemEvent check) 
	{
		if (selected) 
		{			
			if (question == 1) 
			{
				if (california.isSelected()) 
				{
					if (!texas.isSelected() && !florida.isSelected())
						score += 5;
					
					if (texas.isSelected() && !florida.isSelected() || !texas.isSelected() && florida.isSelected())
						score += 2;
						
					if (texas.isSelected() && florida.isSelected())
						score += 1;
				}
				
				resetAnswers();
				
				remove(questionOne);
				add(questionTwo);
				question++;
				score++;
				
				selected = false;
			}
		}
		
		//when submit is pressed 
		//Check for check box states
		//score it
		//Change question 
		//restore states of checkboxes
	}	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submit)
			selected = true;
	}
	

}

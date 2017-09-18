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

public class JCheckBoxes extends JFrame implements ActionListener
{
	//questions
	public String[] questions = new String[] {"Which of the following is the most populated?", 
			"Which of the following is the most densly populated?", 
			"Which of the following have Tallahassee as its capital?",
			"Which of the following have the quail as their state bird?",
			"Which of the following have the largest area?"
			};

	JLabel questionLabel = new JLabel(questions[1]);

	//info
	JLabel result = new JLabel();
	JLabel message = new JLabel();
	
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
	
	public JCheckBoxes() 
	{
		super("HedgeYourBet");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		questionLabel.setFont(bigFont);

		
		submit.addActionListener(this);
		
		add(questionLabel);

		add(california);
		add(texas);
		add(florida);
		add(submit);
		
		add(result);
		add(message);	

	}
	
	public void reset() 
	{
		california.setSelected(false);
		texas.setSelected(false);
		florida.setSelected(false);
		
		
	}
	
	public void finish () 
	{
			if (score > 21)
				this.message.setText("Fantastic!");
			if (score > 15)
				this.message.setText("Very good!");
			else
				this.message.setText("OK.");
		
			this.questionLabel.setText(questions[question]);
	}
	
	@Override	
		//when submit is pressed 
		//Check for check box states
		//score it
		//Change question 
		//restore states of checkboxes
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submit) 
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
				
				reset();	
			}
			if (question == 2)
			{
				if (florida.isSelected()) 
				{
					if (!texas.isSelected() && !california.isSelected())
						score += 5;
					
					if (texas.isSelected() && !california.isSelected() || !texas.isSelected() && california.isSelected())
						score += 2;
						
					if (texas.isSelected() && california.isSelected())
						score += 1;
				}
				
				reset();	
			}
			if (question == 3)
			{
				if (florida.isSelected()) 
				{
					if (!texas.isSelected() && !california.isSelected())
						score += 5;
					
					if (texas.isSelected() && !california.isSelected() || !texas.isSelected() && california.isSelected())
						score += 2;
						
					if (texas.isSelected() && california.isSelected())
						score += 1;
				}
				
				reset();	
			}
			if (question == 4)
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
				
				reset();	
			}
			if (question == 5)
			{
				if (texas.isSelected()) 
				{
					if (!california.isSelected() && !florida.isSelected())
						score += 5;
					
					if (california.isSelected() && !florida.isSelected() || !california.isSelected() && florida.isSelected())
						score += 2;
						
					if (california.isSelected() && florida.isSelected())
						score += 1;
				}
				
				reset();	
			}
			if (question > 5) 
			{
				finish();
			}
			
			this.result.setText("Score: " + score);
			question++;
		}
	}
	

}

package gamezone;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxes extends JFrame implements ActionListener 
{
	// questions
	public String[] questions = new String[] { "Which of the following is the most populated?",
			"Which of the following is the most densly populated?",
			"Which of the following have Tallahassee as its capital?",
			"Which of the following have the quail as their state bird?",
			"Which of the following have the largest area?" };
	JLabel questionLabel = new JLabel(questions[0]);

	// info
	JLabel result = new JLabel();
	JLabel message = new JLabel();

	// check boxes
	JCheckBox california = new JCheckBox("California", false);
	JCheckBox texas = new JCheckBox("Texas", false);
	JCheckBox florida = new JCheckBox("Florida", false);

	// other important
	Font bigFont = new Font("Arial", Font.BOLD, 16);
	JButton submit = new JButton("Submit");
	final int WIDTH = 1000;
	final int HEIGHT = 250;

	public int score = 0;
	public int question = 0;

	public JCheckBoxes() {
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

		this.message.setText("Previous score was " + getScore());
	}

	public void reset() 
	{
		california.setSelected(false);
		texas.setSelected(false);
		florida.setSelected(false);

		this.questionLabel.setText(questions[question]);
	}

	public void finish() 
	{
		if (score > 21)
			this.message.setText("Fantastic!");
		if (score > 15)
			this.message.setText("Very good!");
		else
			this.message.setText("OK.");
		saveScores();
	}

	public String getScore() 
	{
		String lastScore = "";
		try {
			lastScore = new String(Files.readAllBytes(Paths.get("scores.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lastScore;
	}

	public void saveScores() {
		List<String> lines = Arrays.asList(String.valueOf(score));
		Path file = Paths.get("scores.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	// when submit is pressed
	// Check for check box states
	// score it
	// Change question
	// restore states of check boxes
	// displays message when finished

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			if (question == 0) {
				if (california.isSelected()) {
					if (!texas.isSelected() && !florida.isSelected())
						score += 5;

					if (texas.isSelected() && !florida.isSelected() || !texas.isSelected() && florida.isSelected())
						score += 2;

					if (texas.isSelected() && florida.isSelected())
						score += 1;
				}
			} else if (question == 1) {
				if (florida.isSelected()) {
					if (!texas.isSelected() && !california.isSelected())
						score += 5;

					if (texas.isSelected() && !california.isSelected()
							|| !texas.isSelected() && california.isSelected())
						score += 2;

					if (texas.isSelected() && california.isSelected())
						score += 1;
				}
			} else if (question == 2) {
				if (florida.isSelected()) {
					if (!texas.isSelected() && !california.isSelected())
						score += 5;

					if (texas.isSelected() && !california.isSelected()
							|| !texas.isSelected() && california.isSelected())
						score += 2;

					if (texas.isSelected() && california.isSelected())
						score += 1;
				}

			} else if (question == 3) {
				if (california.isSelected()) {
					if (!texas.isSelected() && !florida.isSelected())
						score += 5;

					if (texas.isSelected() && !florida.isSelected() || !texas.isSelected() && florida.isSelected())
						score += 2;

					if (texas.isSelected() && florida.isSelected())
						score += 1;
				}

			} else if (question == 4) {
				if (texas.isSelected()) {
					if (!california.isSelected() && !florida.isSelected())
						score += 5;

					if (california.isSelected() && !florida.isSelected()
							|| !california.isSelected() && florida.isSelected())
						score += 2;

					if (california.isSelected() && florida.isSelected())
						score += 1;
				}

			}
			question++;

			if (question >= 5) 
			{
				finish();
			} else
				reset();

			this.result.setText("Score: " + score);

		}
	}

}

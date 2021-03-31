

// 1- imports
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
Creates an application that keeps track of team scores based on clicks.
@author Devin Watters
 */
public class ScoreButtonDW implements ActionListener{

	// 2- Definition of global values and items that are part of the GUI.
	int blueScoreAmount = 0;
	int redScoreAmount = 0;

	// 3- Define the JLabels
	JLabel blueLabel, redLabel, blueScore, redScore;

	// 4- Define the JButtons
	JButton blueAddButton, redAddButton, blueMinusButton, redMinusButton, resetButton;

	// 5- Define the JPanels
	JPanel titlePanel, scorePanel, buttonPanel;

	public JPanel createContentPane() throws NullPointerException {

		//6- We create a bottom JPanel to place everything on.
		JPanel ScoreBoard = new JPanel();
		ScoreBoard.setLayout(null);

		//7- Creation of a Panel to contain the title labels
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(10,0);
		titlePanel.setSize(250,30);
		ScoreBoard.add(titlePanel);

		//8- Create the Blue Team label - set location 0,0 size 120,30
		blueLabel = new JLabel("Blue Team");
		blueLabel.setLocation(0, 0);
		blueLabel.setSize(120, 30);
		blueLabel.setHorizontalAlignment(0);
		blueLabel.setForeground(Color.blue);
		titlePanel.add(blueLabel);

		//9- Create the Red Team label - set location 130,0 size 120,30
		redLabel = new JLabel("Red Team");
		redLabel.setLocation(130, 0);
		redLabel.setSize(120, 30);
		redLabel.setHorizontalAlignment(0);
		redLabel.setForeground(Color.red);
		titlePanel.add(redLabel);

		//10- Creation of a Panel to contain the score labels.
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(10, 40);
		scorePanel.setSize(260, 30);
		ScoreBoard.add(scorePanel);

		//11- Creation of the label to hold the blueScore
		blueScore = new JLabel("" + blueScoreAmount);
		blueScore.setLocation(0, 0);
		blueScore.setSize(120, 30);
		blueScore.setHorizontalAlignment(0);
		scorePanel.add(blueScore);

		//12- Creation of the label to hold the redScore
		redScore = new JLabel("" + redScoreAmount);
		redScore.setLocation(130, 0);
		redScore.setSize(120, 30);
		redScore.setHorizontalAlignment(0);
		scorePanel.add(redScore);

		//13- Creation of a Panel to contain all the JButtons.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 80);
		buttonPanel.setSize(260, 260);
		ScoreBoard.add(buttonPanel);

		//14- We create a button and manipulate it using the syntax we have
		// used before. Now each button has an ActionListener which posts 
		// its action out when the button is pressed.
		// Create the button for the Blue Score click
		blueAddButton = new JButton(" Blue Score!");
		blueAddButton.setLocation(0, 0);
		blueAddButton.setSize(120, 30);
		blueAddButton.addActionListener(this);
		buttonPanel.add(blueAddButton);

		//15- Create the button for the Red Score click
		redAddButton = new JButton(" Red Score!");
		redAddButton.setLocation(130, 0);
		redAddButton.setSize(120, 30);
		redAddButton.addActionListener(this);
		buttonPanel.add(redAddButton);
		
		//16- Create the button for the minus Blue Score click
		blueMinusButton = new JButton(" -1 from Blue");
		blueMinusButton.setLocation(0, 40);
		blueMinusButton.setSize(120, 30);
		blueMinusButton.addActionListener(this);
		buttonPanel.add(blueMinusButton);

		//17- Create the button for the minus Red Score click
		redMinusButton = new JButton(" -1 from Red");
		redMinusButton.setLocation(130, 40);
		redMinusButton.setSize(120, 30);
		redMinusButton.addActionListener(this);
		buttonPanel.add(redMinusButton);

		//18- Create the button for resetting the scores
		resetButton = new JButton("Reset Score");
		resetButton.setLocation(0, 80);
		resetButton.setSize(250, 30);
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);

		//19- set the ScoreBoard with paint every pixel of the region with no transparent pixels
		// Swing will clear the region to the background color for you automatically
		ScoreBoard.setOpaque(true);
		return ScoreBoard;

	}

	// This is the new ActionPerformed Method.
	// It catches any events with an ActionListener attached.
	// Using an if statement, we can determine which button was pressed
	// and change the appropriate values in our GUI.
	public void actionPerformed(ActionEvent e) {

		// 20- if the blue button is clicked, add 1 to the Blue score
		if(e.getSource() == blueAddButton) {
			blueScoreAmount = blueScoreAmount + 1;
			blueScore.setText("" + blueScoreAmount);
		}
		// 21- if the Red button is pushed, add 1 to the Red score
		else if (e.getSource() == redAddButton) {
			redScoreAmount = redScoreAmount + 1;
			redScore.setText("" + redScoreAmount);
		}
		// 22-if the minus 1 Blue button is pushed, minus 1 from Blue score
		else if (e.getSource() == blueMinusButton) {
		blueScoreAmount = blueScoreAmount - 1;
		blueScore.setText("" + blueScoreAmount);
		}
		// 23- if the minus 1 Red button is pushed, minus 1 from Red score
		else if (e.getSource() == redMinusButton) {
		redScoreAmount = redScoreAmount - 1;
		redScore.setText("" + redScoreAmount);
	}
		// 24- if the reset is clicked, reset the Blue and Red scores
		else if (e.getSource() == resetButton) {
			blueScoreAmount = 0;
			redScoreAmount = 0;
			blueScore.setText("" + blueScoreAmount);
			redScore.setText("" + redScoreAmount);
		}
	}
	/** 
	 * method to create and show the GUI
	 */
	private static void createAndShowGUI() {

		// 25- create the frame with Java decorations look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame(" Play with JButton Scores!");

		// 26- Create and set up the content pane
		ScoreButtonDW demo = new ScoreButtonDW();
		frame.setContentPane(demo.createContentPane());

		// 27-specify your option for the close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 28- set your frame size to 280, 260
		frame.setSize(280, 260);

		// 29- make the frame visible
		frame.setVisible(true);

	}
	/** 
	 * main method to use event-dispatching to create and how the GUI
	 */
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// 30-execute createAndShowGUI
				createAndShowGUI();

			}
		});
	}
}
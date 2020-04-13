//Student Name: Tianle Shu
//Student Id: 19232619
//Lecturer Name: Dr Umair ul Hassan
package ie.nuig.ct548.assignment3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CricketMatchApp {

	public static void main(String[] args) {
		// new CricketData object named cd
		CricketData cd = new CricketData();
		// new AvgScoreDisplay object named asd
		AvgScoreDisplay asd = new AvgScoreDisplay();
		// new CurentScoreDisplay object named csd
		CurentScoreDisplay csd = new CurentScoreDisplay();
		// call addObserver method from cd
		cd.addObserver(csd);
		cd.addObserver(asd);

		// create 3 textfields to get the value of runs, overs and wickets
		final JFormattedTextField textfield1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		final JFormattedTextField textfield2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		final JFormattedTextField textfield3 = new JFormattedTextField(NumberFormat.getIntegerInstance());

		// create JFrame and give the title is "Cricket Data"
		JFrame mainFrame = new JFrame("Cricket Data");
		mainFrame.setLayout(new GridLayout(5, 2));
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.add(new JLabel("Runs: ", SwingConstants.RIGHT));
		mainFrame.add(textfield1);
		mainFrame.add(new JLabel("Overs: ", SwingConstants.RIGHT));
		mainFrame.add(textfield2);
		mainFrame.add(new JLabel("Wickets: ", SwingConstants.RIGHT));
		mainFrame.add(textfield3);
		JButton button = new JButton("Submit Score");
		mainFrame.add(new JLabel(""));
		mainFrame.add(button);
		mainFrame.pack();
		// set the frame size
		mainFrame.setSize(300, 150);
		// set the frame location in the window
		mainFrame.setLocation(600, 300);
		// let the frame can visible
		mainFrame.setVisible(true);

		// ActionListener method : let values to CricketData and call the setScore
		// method
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cd.setScore(((Number) textfield1.getValue()).intValue(), ((Number) textfield2.getValue()).intValue(),
						((Number) textfield3.getValue()).intValue());

			}
		});

	}

}

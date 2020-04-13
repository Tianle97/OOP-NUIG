package ie.nuig.ct548.assignment3;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CurentScoreDisplay extends JFrame implements Observer {
	private JLabel runs;
	private JLabel overs;
	private JLabel wickets;

	public CurentScoreDisplay() {
		// set the window title is "Current scores"
		super("Current scores");
		this.setLayout(new GridLayout(5, 2));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(new JLabel("Runs: ", SwingConstants.RIGHT));
		this.add(this.runs = new JLabel());
		this.add(new JLabel("Overs: ", SwingConstants.RIGHT));
		this.add(this.overs = new JLabel());
		this.add(new JLabel("Wickets: ", SwingConstants.RIGHT));
		this.add(this.wickets = new JLabel());
		this.pack();
		// set the frame size
		this.setSize(300, 200);
		// set the frame location in the window
		this.setLocation(400, 500);
		// let the frame can visible
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		//let int value covert to string for set in JLbel type runs text
		this.runs.setText(Integer.toString(((CricketData) o).getRuns()));
		this.overs.setText(Float.toString(((CricketData) o).getOvers()));
		this.wickets.setText(Integer.toString(((CricketData) o).getWickets()));
	}

	public JLabel getRuns() {
		return runs;
	}

	public JLabel getOvers() {
		return overs;
	}

	public JLabel getWickets() {
		return wickets;
	}

}

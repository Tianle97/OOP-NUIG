package ie.nuig.ct548.assignment3;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class AvgScoreDisplay extends JFrame implements Observer {
	private JLabel rpo;
	private JLabel rpw;
	private JLabel wpo;

	public AvgScoreDisplay() {
		// set the window title is "Average scores"
		super("Average scores");
		this.setLayout(new GridLayout(5, 3));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(new JLabel("Runs per over: ", SwingConstants.RIGHT));
		this.add(this.rpo = new JLabel());
		this.add(new JLabel("Runs per wicket: ", SwingConstants.RIGHT));
		this.add(this.rpw = new JLabel());
		this.add(new JLabel("Wickets per over: ", SwingConstants.RIGHT));
		this.add(this.wpo = new JLabel());
		this.pack();
		// set the frame size
		this.setSize(300, 200);
		// set the frame location in the window
		this.setLocation(800, 500);
		// let the frame can visible
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// let float value covert to string for set in JLbel type rpo text
		// "((CricketData) o).getRuns() / ((CricketData) o).getOvers()" let runs/overs
		// then get value give to rpo
		this.rpo.setText(Float.toString(((CricketData) o).getRuns() / ((CricketData) o).getOvers()));
		this.rpw.setText(Float.toString((float) ((CricketData) o).getRuns() / (float) ((CricketData) o).getWickets()));
		this.wpo.setText(Float.toString(((CricketData) o).getWickets() / ((CricketData) o).getOvers()));
	}

	// getter methods
	public JLabel getRpo() {
		return rpo;
	}

	public JLabel getRpw() {
		return rpw;
	}

	public JLabel getWpo() {
		return wpo;
	}

}

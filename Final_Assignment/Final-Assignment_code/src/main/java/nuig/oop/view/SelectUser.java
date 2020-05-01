package nuig.oop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nuig.oop.controller.SelectUser_Controller;
import nuig.oop.model.Container;
import nuig.oop.model.Media;
import nuig.oop.model.Profiles;

public class SelectUser implements Strategy {

	private JButton[] button = new JButton[4];
	private JFrame selectFrame = new JFrame();// creating instance of JFrame

	private void showPage(Container c) {
		selectFrame.setTitle("Select User");
		selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectFrame.setLayout(new BorderLayout());

		/*** Button Layout ***/
		JPanel panelButton = new JPanel(new GridLayout(4, 1,0,20));// x axis, y axis, width, 间距
		
		//convert the hashset to arraylist ,can easy get name in the for-loop
		List<Profiles> ps = new ArrayList<Profiles>(c.getProfiles());
		
		//set button text = profile_name
		for (int i = 0; i < 4; i++) {
			button[i] = new JButton();
			button[i].setText(ps.get(i).getName());
			panelButton.add(button[i]);
			button[i].addActionListener(e -> {
				SelectUser_Controller.btn_user_action(e, c);
				// close select user frame
				selectFrame.dispose();
			});
		}
		selectFrame.add(panelButton, BorderLayout.CENTER);
	}

	public void display(Container c) {
		showPage(c);
		selectFrame.pack();
		selectFrame.setSize(200, 250);// 200 width and 250 height
		selectFrame.setLocationRelativeTo(null); //let the frame always show in the center of screen
		selectFrame.setVisible(true);// making the frame visible

	}

	@Override
	public TreeMap<?, List<Media>> sortMap() {
		// TODO Auto-generated method stub
		return null;
	}

}

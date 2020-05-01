package nuig.oop.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nuig.oop.controller.ItemDetail_Controller;
import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.Genre;
import nuig.oop.model.Media;
import nuig.oop.model.People;
import nuig.oop.model.TVseries;

public class ItemDetails implements Strategy {

	private JButton saveButton;
	private JFrame itemframe = new JFrame();// creating instance of JFrame
	private JTextField textfield1, textfield3, textfield5;
	private JTextArea textArea1, textArea2, textArea3;
	Container c;
	private String title;

	public ItemDetails(String title) {
		this.title = title;
	}

	private void showPage(Container c) {
		itemframe.setTitle("Item Details");
		itemframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		itemframe.setLayout(new GridLayout(1, 1));

		JPanel panel1 = new JPanel(new GridLayout(7, 0, 50, 20));
		JPanel panel2 = new JPanel(new FlowLayout(0, 0, 20));

		textfield1 = new JTextField(12);
		textArea1 = new JTextArea(3, 12);
		// textArea1.setPreferredSize(new Dimension (20,20));
		textfield3 = new JTextField(12);
		textArea2 = new JTextArea(3, 12);
		textfield5 = new JTextField(12);
		textArea3 = new JTextArea(3, 12);

		panel1.add(new JLabel("Title: ", JLabel.CENTER));
		panel1.add(new JLabel("Description: ", JLabel.CENTER));
		panel1.add(new JLabel("Year: ", JLabel.CENTER));
		panel1.add(new JLabel("Genre: ", JLabel.CENTER));
		panel1.add(new JLabel("Director: ", JLabel.CENTER));
		panel1.add(new JLabel("Cast: ", JLabel.CENTER));

		// new a hashset to stored hashset<Films> and hashset<TVseries>
		HashSet<Media> sett = new HashSet<>();
		sett.addAll(c.getFilms());
		sett.addAll(c.getTvseries());
		for (Media md : sett) {
			if (title == md.getTitle()) {
				// setter title in the field
				textfield1.setText(title);
				panel2.add(textfield1);
				// setter description in the field
				textArea1.setText(md.getDescription());
				// setter scroll in the textArea1
				textArea1.setLineWrap(true);
				textArea1.setWrapStyleWord(true);
				JScrollPane scroll_1 = new JScrollPane(textArea1);
				panel2.add(scroll_1);
				// setter year in the field
				textfield3.setText(Integer.toString(md.getYear()));
				panel2.add(textfield3);

				//new a String s to got genre as string
				String s = "";
				for (String i : md.getGenre()) {
					for (Genre g : c.getGenres()) {
						if (Integer.parseInt(i) == g.getGid()) {
							s += g.getGenre() + " | ";
						}
					}
				}
				//set s in this textArea2
				textArea2.setText(s);
				textArea2.setLineWrap(true);
				textArea2.setWrapStyleWord(true);
				JScrollPane scroll_2 = new JScrollPane(textArea2);
				panel2.add(scroll_2);

				//compare it is film or tv then set the director or creator in this field
				if (md.getClass() == Films.class) {
					for (People p : c.getPeople()) {
						if (Integer.parseInt(((Films) md).getDirector()) == p.getPid()) {
							textfield5.setText(p.getName());
						}
					}
					
				} else {
					for (People p : c.getPeople()) {
						if (Integer.parseInt(((TVseries) md).getCreator()) == p.getPid()) {
							textfield5.setText(p.getName());
						}
					}
				}
				panel2.add(textfield5);

				//new a string named cast to stored people name
				String cast = "";
				for (People p : c.getPeople()) {

					for (String i : md.getCast()) {
						if (Integer.parseInt(i) == p.getPid()) {
							cast += p.getName() + "\n";
						}
					}
					textArea3.setText(cast);
				}
				panel2.add(textArea3);
			}
		}

		panel1.add(new JLabel(""));
		//new button "back"
		saveButton = new JButton("Back");
		panel2.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemDetail_Controller.btn_back_action(e,c);
				// call another method in the same class which will close this Jframe
				itemframe.dispose();
			}
		});
		itemframe.add(panel1);
		itemframe.add(panel2);
	}

	public void display(Container c) {
		showPage(c);
		itemframe.pack();
		itemframe.setSize(400, 450);// 400 width and 450 height
		itemframe.setLocationRelativeTo(null); //let the frame always show in the center of screen
		itemframe.setVisible(true);// making the frame visible

	}

	@Override
	public TreeMap<?, List<Media>> sortMap() {
		// TODO Auto-generated method stub
		return null;
	}


}

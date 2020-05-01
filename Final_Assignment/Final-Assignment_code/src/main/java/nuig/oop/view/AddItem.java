package nuig.oop.view;

import java.awt.GridLayout;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nuig.oop.controller.AddItem_Controller;
import nuig.oop.factory.Factory;
import nuig.oop.factory.FilmFactory;
import nuig.oop.factory.TVFactory;
import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.Media;
import nuig.oop.model.TVseries;

public class AddItem implements Strategy {

	private JButton saveButton;
	private JFrame itemframe = new JFrame();// creating instance of JFrame
	private JTextField titleField, dtField, yearField;
	private JTextArea descArea, genreArea, castArea;
	private Container c;

	public AddItem(Container container) {
		this.c = container;
	}

	private void showPage() {
		itemframe.setTitle("Add Item");
		itemframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		itemframe.setLayout(new GridLayout(1, 1));

		JPanel panel1 = new JPanel(new GridLayout(8, 0, 60, 20));
		JPanel panel2 = new JPanel(new GridLayout(8, 0, 60, 20));

		titleField = new JTextField(15);
		descArea = new JTextArea();
		// textArea1.setPreferredSize(new Dimension (20,20));
		dtField = new JTextField();
		genreArea = new JTextArea();
		yearField = new JTextField();
		castArea = new JTextArea();

		panel1.add(new JLabel("Title: ", JLabel.CENTER));
		panel2.add(titleField);
		panel1.add(new JLabel("Description: ", JLabel.CENTER));
		panel2.add(descArea);
		panel1.add(new JLabel("Year: ", JLabel.CENTER));
		panel2.add(yearField);
		panel1.add(new JLabel("Genre: ", JLabel.CENTER));
		panel2.add(genreArea);
		panel1.add(new JLabel("Director: ", JLabel.CENTER));
		panel2.add(dtField);
		panel1.add(new JLabel("Cast: ", JLabel.CENTER));
		panel2.add(castArea);
		panel1.add(new JLabel("TV Series: ", JLabel.CENTER));

		JCheckBox checkBox1 = new JCheckBox();
		panel2.add(checkBox1);

		saveButton = new JButton("Save");
		saveButton.addActionListener(e -> {

			if (checkBox1.isSelected()) {
				// use factory design pattern
				Factory tvFactory = new TVFactory();
				// create new tv instance through use factory design pattern
				TVseries tv = (TVseries) tvFactory.getInstance();
				tv.setTitle(titleField.getText());
				tv.setYear(Integer.parseInt(yearField.getText()));
				tv.setDescription(descArea.getText());
				tv.setCreator(dtField.getText());
				tv.setCast(castArea.getText().split(" "));
				tv.setGenre(genreArea.getText().split(" "));

				// call controller save tv method
				AddItem_Controller.btn_saveTV_action(e, c, tv);
				itemframe.dispose();
				System.out.println("save tv success!");
			} else {
				// use factory design pattern
				Factory filmFactory = new FilmFactory();
				// create new film instance through use factory design pattern
				Films f = (Films) filmFactory.getInstance();
				f.setTitle(titleField.getText());
				f.setYear(Integer.parseInt(yearField.getText()));
				f.setDescription(descArea.getText());
				f.setDirector(dtField.getText());
				f.setCast(castArea.getText().split(" "));
				f.setGenre(genreArea.getText().split(" "));

				// call controller save film method
				AddItem_Controller.btn_saveFilm_action(e, c, f);
				itemframe.dispose();
				System.out.println("save film success!");
			}

		});

		panel2.add(saveButton);
		itemframe.add(panel1);
		itemframe.add(panel2);

	}

	public void display(Container c) {
		showPage();
		itemframe.pack();
		itemframe.setSize(400, 450);// 600 width and 250 height
		itemframe.setLayout(null);
		itemframe.setLocationRelativeTo(null); // let the frame always show in the center of screenj
		itemframe.setVisible(true);// making the frame visible

	}

	@Override
	public TreeMap<?, List<Media>> sortMap() {
		// TODO Auto-generated method stub
		return null;
	}

}

package nuig.oop.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nuig.oop.controller.VC_Controller;
import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.Genre;
import nuig.oop.model.Media;
import nuig.oop.model.TVseries;

public class VideoCatalogue implements Strategy {
	private JButton button1, button2, button3, button4;
	//set 5 films or tvs in this frame
	private JLabel[] hyperlink = new JLabel[5];
	private JLabel[] yearLabel = new JLabel[5];
	private JLabel[] genreLabel = new JLabel[5];
	private JFrame frame = new JFrame();// creating instance of JFrame
	private String user = "Mewtwo";
	private JLabel userLabel;

	public VideoCatalogue() {
	}

	public VideoCatalogue(String user) {
		this.user = user;
	}

	public void showPage(Container c) {
		frame.setTitle("Video Catalogue");
		frame.setLayout(new FlowLayout(0, 40, 0));
		/*** Button Layout ***/
		JPanel panelButton = new JPanel(new GridLayout(4, 0, 0, 15));// x axis, y axis, width, 间距

		// click button1 go to select user page
		button1 = new JButton("Switch Profile");
		button1.setSize(new Dimension(3, 1));
		panelButton.add(button1);
		// add a action listener to button1
		button1.addActionListener(e -> {
			VC_Controller.btn_1_action(e, c);
			frame.dispose();
		});

		button2 = new JButton("Add new");
		panelButton.add(button2);
		// add a action listener to button2 go add item frame
		button2.addActionListener(e -> {
			VC_Controller.btn_2_action(e, c);
			frame.dispose();
		});

		button3 = new JButton("List by Year");
		panelButton.add(button3);
		button3.addActionListener(e -> {
			VC_Controller.btn_3_action(e, c);
			frame.dispose();
		});

		button4 = new JButton("List by Genre");
		panelButton.add(button4);
		button4.addActionListener(e -> {
			VC_Controller.btn_4_action(e, c);
			frame.dispose();
		});

		frame.add(panelButton);

		/*** Hyperlink Layout ***/
		JPanel panelHyper = new JPanel(new GridLayout(6, 0, 0, 15));
		JPanel kong = new JPanel(new GridLayout(1, 0));
		panelHyper.add(kong);

		// let the hashset convert to arraylist
		List<Films> fs = new ArrayList<Films>(c.getFilms());
		List<TVseries> tvs = new ArrayList<TVseries>(c.getTvseries());

		// main frame for title
		for (int i = 0; i < 5; i++) {
			hyperlink[i] = new JLabel();
			if (i >= fs.size()) {
				hyperlink[i].setText(tvs.get(i-fs.size()).getTitle());
			} else {
				hyperlink[i].setText(fs.get(i).getTitle());
			}
			hyperlink[i].setForeground(Color.BLUE.darker());
			hyperlink[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panelHyper.add(hyperlink[i]);
			hyperlink[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					VC_Controller.btn_hyper_action(e, c);
					// close the main frame
					frame.dispose();
				}
			});
		}
		frame.add(panelHyper);

		// main frame for year
		JPanel panelYear = new JPanel(new GridLayout(6, 0, 0, 15));
		JPanel kong1 = new JPanel(new GridLayout(1, 0));
		panelYear.add(kong1);
		for (int i = 0; i < 5; i++) {
			yearLabel[i] = new JLabel();
			if (i >= fs.size()) {
				yearLabel[i].setText(Integer.toString(tvs.get(i- fs.size()).getYear()));
			} else {
				yearLabel[i].setText(Integer.toString(fs.get(i ).getYear()));
			}
			panelYear.add(yearLabel[i]);
		}
		frame.add(panelYear);

		// main frame for genre
		JPanel panelGrener = new JPanel(new GridLayout(6, 0, 0, 15));
		userLabel = new JLabel("User Profile: " + user);
		panelGrener.add(userLabel);
		int n = 0;
		while (n < 5) {
			if (n >= fs.size()) {
					genreLabel[n] = new JLabel();
					String genre = "";
					for (Genre g : c.getGenres()) {
						for (String num : tvs.get(n-fs.size()).getGenre()) {
							if (Integer.parseInt(num) == g.getGid()) {
								genre += g.getGenre() + " | ";
							}
						}
					}
					genreLabel[n].setText(genre);
					panelGrener.add(genreLabel[n]);
					n++;

			} else {
					genreLabel[n] = new JLabel();
					String genre = "";
					for (Genre g : c.getGenres()) {
						for (String num : fs.get(n).getGenre()) {
							if (Integer.parseInt(num) == g.getGid()) {
								genre += g.getGenre() + " | ";
							}
						}
					}
					genreLabel[n].setText(genre);
					panelGrener.add(genreLabel[n]);
					n++;
					if (n >= 5) {
						break;
					}
			}
		}
		frame.add(panelGrener);

	}

	public void display(Container c) {
		showPage(c);
		frame.pack();
		frame.setSize(720, 215);// 720 width and 215 height
		frame.setLocationRelativeTo(null); // let the frame always show in the center of screen
		frame.setVisible(true);// making the frame visible
	}

	@Override
	public TreeMap<?, List<Media>> sortMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package nuig.oop.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import nuig.oop.controller.VC_Controller;
import nuig.oop.model.Container;
import nuig.oop.model.Genre;
import nuig.oop.model.Media;

public class ListByGenre implements Strategy {
	private JFrame genreFrame = new JFrame();
	private Container container;
	private List<Media> list;
	private List<Media> sortedList = new ArrayList<>();
	private TreeMap<String, List<Media>> treeMap;

	public ListByGenre(Container c) {
		this.container = c;
	}

	private void showPage() {
		treeMap = sortMap();
		JLabel[] titleLink;
		JLabel[] year = new JLabel[treeMap.size()];
		genreFrame.setTitle("List by Year: ");
		genreFrame.setLayout(new GridLayout(1, 0));
		int num = 0;
		for (String genre : treeMap.keySet()) {
			num += treeMap.get(genre).size();
		}
		num = num + (treeMap.size() * 2);

		JPanel panel = new JPanel(new GridLayout(num, 0, 60, 3));
		//add scroll in the genreFrame
		JScrollPane scroll = new JScrollPane(panel);
		
		int j = 0;
		while (j < treeMap.size()) {
			for (String genre : treeMap.keySet()) {
				year[j] = new JLabel();
				year[j].setText(genre);
				panel.add(year[j]);
				j++;
				/**
				 * sorted the list, use java8 new characteristic (lambda), let the list order by
				 * media's title, and setter title to each link(jlabel)
				 */
				list = treeMap.get(genre);
				sortedList = list.stream().sorted(Comparator.comparing(Media::getTitle)).collect(Collectors.toList());
				for (int i = 0; i < sortedList.size(); i++) {
					titleLink = new JLabel[j + 1];
					titleLink[i] = new JLabel();
					titleLink[i].setText(sortedList.get(i).getTitle());
					titleLink[i].setForeground(Color.BLUE.darker());
					titleLink[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					titleLink[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							VC_Controller.btn_hyper_action(e, container);
							// close the main frame
							genreFrame.dispose();
						}
					});
					panel.add(titleLink[i]);
				}

				panel.add(new JLabel());
			}
			genreFrame.add(scroll, panel);
		}
	}

	public void display(Container c) {
		showPage();
		genreFrame.pack();
		genreFrame.setSize(400, 450);// 400 width and 450 height
		genreFrame.setLocationRelativeTo(null); // let the frame always show in the center of screen
		genreFrame.setVisible(true);// making the frame visible
	}

	@Override
	public TreeMap<String, List<Media>> sortMap() {
		TreeMap<String, List<Media>> treeMap = new TreeMap<>();
		List<Media> fs = new ArrayList<>(container.getFilms());
		List<Media> tvs = new ArrayList<>(container.getTvseries());

		List<Media> genreMedia = new ArrayList<>();
		// add film objects to genreMedia, according to genre
		for (Genre g : container.getGenres()) {
			for (Media film : fs) {
				if (Arrays.asList(film.getGenre()).contains(Integer.toString(g.getGid())))
					genreMedia.add(film);
			}
			for (Media tv : tvs) {
				if (Arrays.asList(tv.getGenre()).contains(Integer.toString(g.getGid())))
					genreMedia.add(tv);
			}
		}

		// add value and key to the treemap and avoid the object in list duplication
		for (Genre g : container.getGenres()) {
			for (Media m : genreMedia) {
				List<Media> ms = new ArrayList<>();
				ms.add(m);
				if (Arrays.asList(m.getGenre()).contains(Integer.toString(g.getGid())))
					// check the key is exist or not.
					if (treeMap.containsKey(g.getGenre())) {
						// check the value is in this treeMap.get(g.getGenre()) list or not
						if (!treeMap.get(g.getGenre()).contains(m)) {
							// if not exist then add this object(m)
							treeMap.get(g.getGenre()).add(m);
						}
					} else {
						treeMap.put(g.getGenre(), ms);
					}
			}
		}
		return treeMap;

	}

}

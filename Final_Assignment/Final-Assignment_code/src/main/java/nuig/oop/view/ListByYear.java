package nuig.oop.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import nuig.oop.model.Media;

public class ListByYear implements Strategy {
	private JFrame yearFrame = new JFrame();
	private Container container;
	private List<Media> list;
	private List<Media> sortedList = new ArrayList<>();
	private TreeMap<Integer, List<Media>> treeMap;

	public ListByYear(Container c) {
		this.container = c;
	}

	private void showPage() {
		treeMap = sortMap();
		JLabel[] titleLink;
		JLabel[] year = new JLabel[treeMap.size()];
		yearFrame.setTitle("List by Year: ");
		yearFrame.setLayout(new GridLayout(1, 0));
		int num = 0;
		for (Integer y : treeMap.keySet()) {
			num += treeMap.get(y).size();
		}
		// through num them we can know how many rows we need
		num += (treeMap.size()*2);

		JPanel panel1 = new JPanel(new GridLayout(num, 0, 60, 3));
		JScrollPane scroll = new JScrollPane(panel1);
		// filt the contents in the frame
		int j = 0;
		while (j < treeMap.size()) {
			for (Integer y : treeMap.keySet()) {
				year[j] = new JLabel();
				year[j].setText(Integer.toString(y));
				panel1.add(year[j]);
				j++;
				// sorted the list, use java8 new characteristic, let the list order by media's
				// title
				list = treeMap.get(y);
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
							yearFrame.dispose();
						}
					});
					panel1.add(titleLink[i]);
				}
			//add a empty lebal let the frame more beautyful
			panel1.add(new JLabel());
			}
			yearFrame.add(scroll, panel1);
		}
	}

	public void display(Container c) {
		showPage();
		yearFrame.pack();
		yearFrame.setSize(400, 450);// 600 width and 250 height
		yearFrame.setLocationRelativeTo(null); // let the frame always show in the center of screen
		yearFrame.setVisible(true);// making the frame visible
	}

	//methid 2 order by year use list
	public List<Media> sort() {
		List<Media> fs = new ArrayList<>(container.getFilms());
		List<Media> tvs = new ArrayList<>(container.getTvseries());

		List<Media> list = new ArrayList<>();
		list.addAll(fs);
		list.addAll(tvs);
		// let the list sort descending
		list.sort((Media m1, Media m2) -> m2.getYear() - m1.getYear());

		System.out.println();
		return list;

	}
	
	@Override
	public TreeMap<Integer, List<Media>> sortMap() {
		TreeMap<Integer, List<Media>> treeMap = new TreeMap<>();
		List<Media> fs = new ArrayList<>(container.getFilms());
		List<Media> tvs = new ArrayList<>(container.getTvseries());

		// List<Media> list = new ArrayList<>();
		// list.addAll(fs);
		// list.addAll(tvs);
		// // let the list sort descending
		// list.sort((Media m1, Media m2) -> m2.getYear() - m1.getYear());

		for (Media film : fs) {
			List<Media> mfs = new ArrayList<>();
			mfs.add(film);
			if (treeMap.containsKey(film.getYear()))
				treeMap.get(film.getYear()).add(film);
			else
				treeMap.put(film.getYear(), mfs);
		}

		for (Media tv : tvs) {
			List<Media> mtvs = new ArrayList<>();
			mtvs.add(tv);

			if (treeMap.containsKey(tv.getYear()))
				treeMap.get(tv.getYear()).add(tv);
			else
				treeMap.put(tv.getYear(), mtvs);
		}
		TreeMap<Integer, List<Media>> treeMap_desc = new TreeMap<>(treeMap.descendingMap());
		
		return treeMap_desc;

	}

}

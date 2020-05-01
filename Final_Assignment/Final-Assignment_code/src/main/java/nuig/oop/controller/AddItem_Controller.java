package nuig.oop.controller;

import java.awt.event.ActionEvent;

import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.TVseries;
import nuig.oop.view.Strategy;
import nuig.oop.view.VideoCatalogue;

public class AddItem_Controller {

	// if user does not select tv check box then do this method to save film
	public static void btn_saveFilm_action(ActionEvent e, Container c, Films f) {
		f.setFid(c.getFilms().size() + 1);
		c.addFilms(f);
		//debug
		System.out.println("update save the " + c.getFilms().size() + "th film -" + f.getTitle());
		Strategy vc = new VideoCatalogue();
		vc.display(c);
	}

	// if user select tv check box then do this method to save tv
	public static void btn_saveTV_action(ActionEvent e, Container c, TVseries tv) {
		tv.setTid(c.getFilms().size() + 1);
		System.out.println(tv.getTid());
		c.addTVseries(tv);
		//debug
		System.out.println("update save the " + c.getTvseries().size() + "th tv -" + tv.getTitle());
		Strategy vc = new VideoCatalogue();
		vc.display(c);
	}

}

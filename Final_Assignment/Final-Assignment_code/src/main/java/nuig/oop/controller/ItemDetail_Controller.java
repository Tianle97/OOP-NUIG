package nuig.oop.controller;

import java.awt.event.ActionEvent;

import nuig.oop.model.Container;
import nuig.oop.view.Strategy;
import nuig.oop.view.VideoCatalogue;

public class ItemDetail_Controller {

	//if user click back button then do this method
	public static void btn_back_action(ActionEvent e, Container c) {
		Strategy vc = new VideoCatalogue();
		vc.display(c);
	}
	
}

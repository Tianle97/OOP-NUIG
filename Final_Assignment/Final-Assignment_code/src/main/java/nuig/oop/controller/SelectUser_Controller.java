package nuig.oop.controller;

import java.awt.event.ActionEvent;

import nuig.oop.model.Container;
import nuig.oop.view.Strategy;
import nuig.oop.view.VideoCatalogue;

public class SelectUser_Controller {
	
	public static void btn_user_action(ActionEvent e, Container c) {
		Strategy vc = new VideoCatalogue(e.getActionCommand());
		//get the button text
		System.out.println(e.getActionCommand());
		vc.display(c);
	}
}

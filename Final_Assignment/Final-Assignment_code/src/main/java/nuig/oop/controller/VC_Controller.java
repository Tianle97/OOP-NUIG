package nuig.oop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import nuig.oop.model.Container;
import nuig.oop.view.AddItem;
import nuig.oop.view.ItemDetails;
import nuig.oop.view.ListByGenre;
import nuig.oop.view.ListByYear;
import nuig.oop.view.SelectUser;
import nuig.oop.view.Strategy;

public class VC_Controller {
	
	//if user click "switch user" button then do this method
	public static void btn_1_action(ActionEvent e,Container c) {
		Strategy sp = new SelectUser();
		//show the select user page
		sp.display(c);
	}
	
	//if user click "add item" button then do this method
	public static void btn_2_action(ActionEvent e,Container c) {
		Strategy addItem = new AddItem(c);
		//show the add item page
		addItem.display(c);
	}
	
	//if user click "list by yesr" button then do this method
	public static void btn_3_action(ActionEvent e,Container c) {
		Strategy listY = new ListByYear(c);
		//show the list by year page
		listY.display(c);
	}
	
	//if user click "list by genre" button then do this method
	public static void btn_4_action(ActionEvent e,Container c) {
		Strategy listG = new ListByGenre(c);
		//show the list by genre page
		listG.display(c);
	}
	
	//if user click "title" then do this method
	public static void btn_hyper_action(MouseEvent e,Container c) {
		//let title get the e.text
		JLabel title=(JLabel) e.getSource();
		//show the item details page
		Strategy id = new ItemDetails(title.getText());
		id.display(c);
	}

}

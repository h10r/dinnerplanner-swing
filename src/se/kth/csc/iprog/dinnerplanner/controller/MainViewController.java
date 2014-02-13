package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class MainViewController extends ViewController {

	public MainViewController(DinnerModel model, JPanel view ) {
		super( model, view );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if(e.getSource() == view.plusButton) { 
			model.setNumberOfGuests( model.getNumberOfGuests() + 1 );
		}
		
		if(e.getSource() == view.minusButton) {
			model.setNumberOfGuests(model.getNumberOfGuests() - 1); }
		}
		*/
	}
	
}

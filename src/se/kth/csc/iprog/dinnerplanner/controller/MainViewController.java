package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class MainViewController extends ViewController {

	public MainViewController(DinnerModel model, JPanel view ) {
		super( model, view );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button clicked");
		
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

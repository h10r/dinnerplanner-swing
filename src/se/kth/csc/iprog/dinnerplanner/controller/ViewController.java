package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ViewController implements ActionListener {

	DinnerModel model; 
	JPanel view;
	
	public ViewController(DinnerModel model, JPanel view ) { 
		this.model = model;
		this.view = view;
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

package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.swing.view.MainSidebarView;
import se.kth.csc.iprog.dinnerplanner.swing.view.MainView;

public class MainViewController extends ViewController {

	public MainViewController(DinnerModel model, JPanel view ) {
		super( model, view );
		
		MainView currentView = (MainView) view;
		
		currentView.sidebarView.btnPreparation.addActionListener( this );
		currentView.sidebarView.btnIngredients.addActionListener( this );
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

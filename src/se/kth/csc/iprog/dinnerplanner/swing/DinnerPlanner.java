package se.kth.csc.iprog.dinnerplanner.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.controller.MainViewController;
import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.view.*;

public class DinnerPlanner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public DinnerPlanner() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	private DinnerModel model = new DinnerModel();

	public DinnerModel getModel() {
		return model;
	}

	public void setModel(DinnerModel model) {
		this.model = model;
	}
	    
    public void renderView( JPanel newView ) {
    	this.getContentPane().add( newView );
    }
    
	public static void main(String[] args) {
		//Initiating the main JFrame
		DinnerPlanner dinnerPlanner = new DinnerPlanner();
		dinnerPlanner.setTitle("Dinner Planner");
		
		//create an instance of Model to pass to views
		DinnerModel modelInstance = dinnerPlanner.getModel();
		
		//Creating the first view
		MainView mainView = new MainView( modelInstance );
		//DishView dishView = new DishView(modelInstance);
		
		// Controllers
		MainViewController mainViewController = new MainViewController( modelInstance, mainView );
		
		//Adding the view to the main JFrame
		//dinnerPlanner.getContentPane().add(mainView);
		dinnerPlanner.renderView( mainView );

		//Resize it so content fits
		dinnerPlanner.pack();
		
		//and starting the JFrame
		dinnerPlanner.setVisible(true);
		dinnerPlanner.setSize(1024,768);
		
	}

}

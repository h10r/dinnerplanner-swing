package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	MainContentView contentView = new MainContentView();
	MainSidebarView sidebarView = new MainSidebarView();
	
	private DinnerModel modelInstance = new DinnerModel();
	
	public MainView(DinnerModel model){
		
		modelInstance = model;
		Dish selectedDish = modelInstance.getSelectedDish(1);
		
		this.setLayout(new BorderLayout() );
				
		this.add( contentView, BorderLayout.WEST);
		this.add( sidebarView, BorderLayout.EAST);
	}
	
}

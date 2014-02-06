package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public MainView(DinnerModel modelInstance){
		
		MainContentView contentView = new MainContentView( modelInstance );
		MainSidebarView sidebarView = new MainSidebarView( modelInstance );
		
		this.setLayout(new BorderLayout() );
				
		this.add( contentView, BorderLayout.WEST);
		this.add( sidebarView, BorderLayout.EAST);
	}
	
}

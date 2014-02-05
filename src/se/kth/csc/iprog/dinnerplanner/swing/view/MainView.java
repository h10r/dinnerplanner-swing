package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	MainContentView contentView = new MainContentView();
	MainSidebarView sidebarView = new MainSidebarView();
	
	public MainView(){
		this.setLayout(new BorderLayout() );
				
		this.add( contentView, BorderLayout.WEST);
		this.add( sidebarView, BorderLayout.EAST);
	}
	
}

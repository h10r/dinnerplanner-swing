package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import java.awt.Dimension;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public MainView(DinnerModel modelInstance){
		
		MainContentView contentView = new MainContentView( modelInstance, this );
		contentView.setPreferredSize(new Dimension(600, 16));
		MainSidebarView sidebarView = new MainSidebarView( modelInstance, this );
		setLayout(new BorderLayout(0, 0));
				
		this.add( contentView, BorderLayout.WEST);
		this.add( sidebarView, BorderLayout.EAST);
	}
	
	void openView( JPanel newView, String title ) {
		JFrame frame = new JFrame ( title );
	    //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add ( newView );
	    frame.setSize(800, 600);
	    frame.pack();
	    frame.setVisible (true);
	}
}

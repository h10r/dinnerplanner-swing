package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;


public class MainView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private DinnerModel modelInstance;
	
	public MainContentView contentView;
	public MainSidebarView sidebarView;
	
	public MainView(DinnerModel modelInstance) {
		
		this.modelInstance = modelInstance;
		this.modelInstance.addObserver(this);
		
		this.contentView = new MainContentView( modelInstance, this );
		this.contentView.setPreferredSize(new Dimension(600, 16));
		
		this.sidebarView = new MainSidebarView( modelInstance, this );
		
		setLayout(new BorderLayout(0, 0));
				
		this.add( this.contentView, BorderLayout.WEST);
		this.add( this.sidebarView, BorderLayout.EAST);
	}
	
	void openView( JPanel newView, String title ) {
		JFrame frame = new JFrame ( title );
	    //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add ( newView );
	    frame.setSize(800, 600);
	    frame.pack();
	    frame.setVisible (true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}

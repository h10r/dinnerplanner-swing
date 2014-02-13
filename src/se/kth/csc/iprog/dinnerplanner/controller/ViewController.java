package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
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

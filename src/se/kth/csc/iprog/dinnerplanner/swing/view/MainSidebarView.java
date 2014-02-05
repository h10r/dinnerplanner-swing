package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class MainSidebarView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	
	public MainSidebarView(){
		
		this.setLayout( new GridLayout(0,2) );
		
		JLabel lblNumberOfPeople = new JLabel("Number of People");
		
		JLabel lblTotalCosts = new JLabel("Total cost:");
		JLabel lblTotalCostsValue = new JLabel("$ 0.00");
		
		JLabel lblTitle = new JLabel("Dinner Menu");
		
		JLabel lblDragArea = new JLabel("Drag your dish to the menu");
		
		JButton btnPreparation = new JButton("Preparation");
		btnPreparation.addActionListener( new ActionListener() {			 
            public void actionPerformed(ActionEvent e)
            {
            	frame1.getContentPane().add( new PreparationView() );
            	
            	System.out.println("You clicked the button");
            }
        });

   
		JButton btnIngredients = new JButton("Ingredients");
		
		String[] numberOfPeople = { "1","2","3","4","5","6","7","8","9","10","11","12" };
		JComboBox comboNumberOfPeople = new JComboBox(numberOfPeople);
		
		this.add(lblNumberOfPeople);
		this.add(lblNumberOfPeople);
		
		comboNumberOfPeople.setSelectedIndex(3);
		this.add(comboNumberOfPeople);
		
		this.add(lblTotalCosts);
		this.add(lblTotalCostsValue);
		
		this.add(lblTitle);
		
		this.add(lblDragArea);
		
		this.add(btnPreparation);
		this.add(btnIngredients);
	}
	
}

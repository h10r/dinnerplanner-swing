package se.kth.csc.iprog.dinnerplanner.swing.view;


import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.JTextArea;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Dimension;
import java.util.Set;

import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;



public class PreparationView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblDinnerMenuPreparation = new JLabel("Diner menu preparation");
	private final JLabel lblStarterName = new JLabel("Starter: $Dishname");
	private final JLabel lblMainName = new JLabel("Main: $Dishname");
	private final JLabel lblDessertName = new JLabel("Dessert: $Dishname");
	private final JTextArea txtStarterInstructions = new JTextArea();
	private final JTextArea txtMainInstructions = new JTextArea();
	private final JTextArea txtDessertInstructions = new JTextArea();
	
	private DinnerModel modelInstance; 
	
	public PreparationView(DinnerModel modelInstance){
		setPreferredSize(new Dimension(550, 600));
		
		this.modelInstance = modelInstance;
		
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{61, 0};
		gbl_panel.rowHeights = new int[]{68, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblDinnerMenuPreparation = new GridBagConstraints();
		gbc_lblDinnerMenuPreparation.anchor = GridBagConstraints.NORTH;
		gbc_lblDinnerMenuPreparation.insets = new Insets(0, 0, 5, 0);
		gbc_lblDinnerMenuPreparation.gridx = 0;
		gbc_lblDinnerMenuPreparation.gridy = 0;
		lblDinnerMenuPreparation.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel.add(lblDinnerMenuPreparation, gbc_lblDinnerMenuPreparation);
		GridBagConstraints gbc_lblStarterName = new GridBagConstraints();
		gbc_lblStarterName.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterName.gridx = 0;
		gbc_lblStarterName.gridy = 2;
		lblStarterName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		panel.add(lblStarterName, gbc_lblStarterName);
		
		GridBagConstraints gbc_txtStarterInstructions = new GridBagConstraints();
		gbc_txtStarterInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_txtStarterInstructions.fill = GridBagConstraints.BOTH;
		gbc_txtStarterInstructions.gridx = 0;
		gbc_txtStarterInstructions.gridy = 3;
		txtStarterInstructions.setPreferredSize(new Dimension(500, 150));
		panel.add(txtStarterInstructions, gbc_txtStarterInstructions);
		
		GridBagConstraints gbc_lblMainName = new GridBagConstraints();
		gbc_lblMainName.insets = new Insets(0, 0, 5, 0);
		gbc_lblMainName.gridx = 0;
		gbc_lblMainName.gridy = 6;
		lblMainName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		panel.add(lblMainName, gbc_lblMainName);
		
		GridBagConstraints gbc_txtMainInstructions = new GridBagConstraints();
		gbc_txtMainInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_txtMainInstructions.fill = GridBagConstraints.BOTH;
		gbc_txtMainInstructions.gridx = 0;
		gbc_txtMainInstructions.gridy = 7;
		txtMainInstructions.setPreferredSize(new Dimension(500, 150));
		panel.add(txtMainInstructions, gbc_txtMainInstructions);
		
		GridBagConstraints gbc_lblDessertName = new GridBagConstraints();
		gbc_lblDessertName.insets = new Insets(0, 0, 5, 0);
		gbc_lblDessertName.gridx = 0;
		gbc_lblDessertName.gridy = 10;
		lblDessertName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		panel.add(lblDessertName, gbc_lblDessertName);
		
		GridBagConstraints gbc_txtDessertInstructions = new GridBagConstraints();
		gbc_txtDessertInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_txtDessertInstructions.fill = GridBagConstraints.BOTH;
		gbc_txtDessertInstructions.gridx = 0;
		gbc_txtDessertInstructions.gridy = 11;
		txtDessertInstructions.setPreferredSize(new Dimension(500, 150));
		panel.add(txtDessertInstructions, gbc_txtDessertInstructions);
				
		
		Dish starterDish = this.modelInstance.getSelectedDish(1);
		lblStarterName.setText( starterDish.getName() );
		txtStarterInstructions.setText( starterDish.getDescription() );
		
		Dish mainDish = this.modelInstance.getSelectedDish(2);
		lblMainName.setText( mainDish.getName() );
		txtMainInstructions.setText( mainDish.getDescription() );
		
		Dish dessertDish = this.modelInstance.getSelectedDish(3);
		lblDessertName.setText( dessertDish.getName() );
		txtDessertInstructions.setText( dessertDish.getDescription() );
	}
}


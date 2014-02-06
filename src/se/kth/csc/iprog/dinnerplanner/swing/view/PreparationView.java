package se.kth.csc.iprog.dinnerplanner.swing.view;


import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.JTextArea;



public class PreparationView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JLabel lblDinnerMenuPreparation = new JLabel();
	private final JLabel lblStarter = new JLabel("Starter:");
	private final JLabel lblMain = new JLabel("Main:");
	private final JLabel lblDessert = new JLabel("Dessert:");
	private final JTextArea txtMainRecipe = new JTextArea();
	private final JTextArea txtDessertRecipe = new JTextArea();
	private final JLabel LblStarterName = new JLabel("lblStarterName");
	private final JLabel LblMainName = new JLabel("lblMainName");
	private final JLabel LblDessertName = new JLabel("lblDessertName");
	
	public PreparationView(DinnerModel modelInstance){
		
		int dishNumber = modelInstance.getClickedDish();
		Dish selectedDish = modelInstance.getSelectedDish(dishNumber);
		setLayout(null);
		lblDinnerMenuPreparation.setBounds(11, 6, 119, 14);

		lblDinnerMenuPreparation.setText("Dinner Menu Preparation");
		
		// Add label to the view
		this.add(lblDinnerMenuPreparation);
		lblStarter.setBounds(11, 34, 38, 14);
		
		add(lblStarter);
		LblStarterName.setBounds(61, 34, 90, 14);
		
		add(LblStarterName);
		lblMain.setBounds(20, 153, 26, 14);
		
		add(lblMain);
		LblMainName.setBounds(61, 153, 90, 14);
		
		add(LblMainName);
		lblDessert.setBounds(15, 274, 41, 14);
		
		add(lblDessert);
		
		
		
		JTextArea txtStarterRecipe = new JTextArea();
		txtStarterRecipe.setBounds(11, 54, 140, 76);
		txtStarterRecipe.setEditable(false);
		add(txtStarterRecipe);
		txtMainRecipe.setBounds(11, 175, 140, 76);
		txtMainRecipe.setEditable(false);
		
		add(txtMainRecipe);
		LblDessertName.setBounds(61, 274, 90, 14);
		
		add(LblDessertName);
		txtDessertRecipe.setBounds(11, 297, 140, 76);
		txtDessertRecipe.setEditable(false);
		
		add(txtDessertRecipe);
		
		
		// Get Dish Specific Data
		
		if(selectedDish.getType()==1){
			LblStarterName.setText(selectedDish.getName());
			txtStarterRecipe.setText(selectedDish.getDescription());
			}
		else if (selectedDish.getType()==2){
			LblMainName.setText(selectedDish.getName());
			txtMainRecipe.setText(selectedDish.getDescription());
			}
		else if (selectedDish.getType()==3){
			LblDessertName.setText(selectedDish.getName());
			txtDessertRecipe.setText(selectedDish.getDescription());
			}
		
	}
}


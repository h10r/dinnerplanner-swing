package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.util.HashSet;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class IngredientView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	

	
	//JButton plusButton = new JButton("World");
	//JButton minusButton = new JButton("Wayne's");
	
	public IngredientView() {
		
		// column names for table
		String[] columnNames = {"Ingredient", "Quantity", "Cost"};
		
		// new instance of dinnerModel 
		//DinnerModel dinnerModel = new DinnerModel();
				
		// The components of our view
		JLabel label = new JLabel();
		//JTable ingredientTable = new JTable(idinnerModel.getAllIngredients(), columnNames);

		label.setText("List of all ingredients");
		
		// Add label to the view
		this.add(label);
		//this.add(ingredientTable);
		
		
		// Setup the rest of the view layout
	}
	
}

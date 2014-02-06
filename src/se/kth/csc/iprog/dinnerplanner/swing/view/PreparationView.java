package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;


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
							
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("45px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("90px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("76px"),
				RowSpec.decode("20px"),
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("76px"),
				RowSpec.decode("20px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("76px"),}));

		lblDinnerMenuPreparation.setText("Dinner Menu Preparation");
		
		// Add label to the view
		this.add(lblDinnerMenuPreparation, "2, 2, 3, 1, left, top");
		
		add(lblStarter, "2, 4, left, center");
		
		add(LblStarterName, "4, 4");
		
		add(lblMain, "2, 8, center, center");
		
		add(LblMainName, "4, 8");
		
		add(lblDessert, "2, 12, right, center");
		
		
		
		JTextArea txtStarterRecipe = new JTextArea();
		txtStarterRecipe.setEditable(false);
		add(txtStarterRecipe, "2, 6, 3, 1, fill, fill");
		txtMainRecipe.setEditable(false);
		
		add(txtMainRecipe, "2, 10, 3, 1, fill, fill");
		
		add(LblDessertName, "4, 12");
		txtDessertRecipe.setEditable(false);
		
		add(txtDessertRecipe, "2, 14, 3, 1, fill, fill");
		
		
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

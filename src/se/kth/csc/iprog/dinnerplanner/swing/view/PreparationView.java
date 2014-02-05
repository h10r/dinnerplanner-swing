package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class PreparationView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JLabel lblDinnerMenuPreparation = new JLabel();
	private final JLabel lblStarter = new JLabel("Starter:");
	private final JLabel lblMain = new JLabel("Main:");
	private final JLabel lblDessert = new JLabel("Dessert:");
	private final JTextField txtFieldStarter = new JTextField();
	private final JTextField txtMainDessert = new JTextField();
	private final JTextField txtFieldDessert = new JTextField();
	private final JTextArea txtMainRecipe = new JTextArea();
	private final JTextArea txtDessertRecipe = new JTextArea();
	
	public PreparationView(){
		txtFieldDessert.setBounds(72, 227, 86, 20);
		txtFieldDessert.setColumns(10);
		txtMainDessert.setBounds(162, 151, 86, 20);
		txtMainDessert.setColumns(10);
		txtFieldStarter.setBounds(58, 33, 86, 20);
		txtFieldStarter.setColumns(10);
		setLayout(null);
		lblDinnerMenuPreparation.setBounds(14, 8, 119, 14);

		lblDinnerMenuPreparation.setText("Dinner Menu Preparation");
		
		// Add label to the view
		this.add(lblDinnerMenuPreparation);
		lblStarter.setBounds(10, 36, 38, 14);
		
		add(lblStarter);
		
		add(txtFieldStarter);
		lblMain.setBounds(126, 154, 26, 14);
		
		add(lblMain);
		
		add(txtMainDessert);
		lblDessert.setBounds(21, 230, 41, 14);
		
		add(lblDessert);
		
		add(txtFieldDessert);
		
		
		
		JTextArea txtStarterRecipe = new JTextArea();
		txtStarterRecipe.setBounds(38, 61, 106, 76);
		add(txtStarterRecipe);
		txtMainRecipe.setBounds(140, 168, 144, 35);
		
		add(txtMainRecipe);
		txtDessertRecipe.setEditable(false);
		txtDessertRecipe.setBounds(14, 253, 156, 36);
		
		add(txtDessertRecipe);
		
		
		// Setup the rest of the view layout
	}
}

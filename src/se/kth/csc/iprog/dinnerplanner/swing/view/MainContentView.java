package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainContentView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JLabel label = new JLabel();
	JButton plusButton = new JButton("World");
	JButton minusButton = new JButton("Wayne's");
	
	public MainContentView(){

		label.setText("Hello");
		
		// Add label to the view
		this.add(label);
		
		this.add(plusButton);
		this.add(minusButton);
		
		
		// Setup the rest of the view layout
	}
	
}

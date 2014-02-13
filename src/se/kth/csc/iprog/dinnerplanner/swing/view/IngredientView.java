package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;


public class IngredientView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	private final JPanel topPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable ingTable = new JTable();

	private DinnerModel modelInstance;
	
	public IngredientView(DinnerModel modelInstance) {
		this.modelInstance = modelInstance;
		this.modelInstance.addObserver(this);
		
		setLayout(new BorderLayout(0, 0));
		
		add(topPane, BorderLayout.NORTH);
		topPane.setLayout(new BorderLayout(10, 10));
		
		//System.out.println(modelInstance.getNumberOfGuests());
		
		JLabel lblListOfIngredients = new JLabel("Shopping List for " + modelInstance.getNumberOfGuests() + " guests");
		lblListOfIngredients.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		topPane.add(lblListOfIngredients, BorderLayout.NORTH);
				
		// add panels to layout
		add(topPane, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		// set Model of table 
		ingTable.setModel(modelInstance.getIngredientsTableModel());
		
		// add table to viewport
		scrollPane.add(ingTable);
		scrollPane.setViewportView(ingTable);
	}
	
	@Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}

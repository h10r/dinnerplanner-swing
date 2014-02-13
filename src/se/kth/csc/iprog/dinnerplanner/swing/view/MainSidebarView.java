package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("unused")
public class MainSidebarView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	// The components of our view
	private MainView parent;
	
	private DinnerModel modelInstance;
	
	public JButton btnPreparation;
	public JButton btnIngredients;
	public JButton btnMinus;
	public JButton btnPlus;
	public JComboBox comboBox;
	public JLabel lblTotalCost;

	public MainSidebarView(DinnerModel modelInstance, MainView parent) {
		
		this.parent = parent;
		
		this.modelInstance = modelInstance;
		this.modelInstance.addObserver(this);
		
		String[] numberOfPeople = { "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 84, 130, 0, 135, 0 };
		gridBagLayout.rowHeights = new int[] { 27, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNumberOfPeople = new JLabel("Number of People");
		GridBagConstraints gbc_lblNumberOfPeople = new GridBagConstraints();
		gbc_lblNumberOfPeople.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfPeople.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfPeople.gridx = 1;
		gbc_lblNumberOfPeople.gridy = 0;
		add(lblNumberOfPeople, gbc_lblNumberOfPeople);

		this.comboBox = new JComboBox();
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		add(this.comboBox, gbc_comboBox);
		
		this.btnMinus = new JButton("-");
		GridBagConstraints gbc_btnMinus = new GridBagConstraints();
		gbc_btnMinus.insets = new Insets(0, 0, 5, 5);
		gbc_btnMinus.gridx = 1;
		gbc_btnMinus.gridy = 1;
		add(this.btnMinus, gbc_btnMinus);
		
		this.btnPlus = new JButton("+");
		GridBagConstraints gbc_btnPlus = new GridBagConstraints();
		gbc_btnPlus.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlus.gridx = 2;
		gbc_btnPlus.gridy = 1;
		add(this.btnPlus, gbc_btnPlus);

		JLabel lblTotalCostDescription = new JLabel("Total costs");
		lblTotalCostDescription.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTotalCostDescription = new GridBagConstraints();
		gbc_lblTotalCostDescription.anchor = GridBagConstraints.WEST;
		gbc_lblTotalCostDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCostDescription.gridx = 1;
		gbc_lblTotalCostDescription.gridy = 2;
		add(lblTotalCostDescription, gbc_lblTotalCostDescription);

		this.lblTotalCost = new JLabel("0.00 SEK");
		GridBagConstraints gbc_lblTotalCost = new GridBagConstraints();
		gbc_lblTotalCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCost.gridx = 2;
		gbc_lblTotalCost.gridy = 2;
		add(this.lblTotalCost, gbc_lblTotalCost);

		JLabel lblDinerMenuLabel = new JLabel("Dinner Menu");
		GridBagConstraints gbc_lblDinerMenuLabel = new GridBagConstraints();
		gbc_lblDinerMenuLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDinerMenuLabel.gridwidth = 2;
		gbc_lblDinerMenuLabel.gridx = 1;
		gbc_lblDinerMenuLabel.gridy = 3;
		add(lblDinerMenuLabel, gbc_lblDinerMenuLabel);

		JLabel lblDishDragNDrop = new JLabel("Drag your dish to the menu");
		lblDishDragNDrop.setPreferredSize(new Dimension(173, 400));
		GridBagConstraints gbc_lblDishDragNDrop = new GridBagConstraints();
		gbc_lblDishDragNDrop.gridheight = 4;
		gbc_lblDishDragNDrop.gridwidth = 2;
		gbc_lblDishDragNDrop.insets = new Insets(0, 0, 5, 5);
		gbc_lblDishDragNDrop.gridx = 1;
		gbc_lblDishDragNDrop.gridy = 4;
		add(lblDishDragNDrop, gbc_lblDishDragNDrop);

		this.btnPreparation = new JButton("Preparation");
		GridBagConstraints gbc_btnPreparation = new GridBagConstraints();
		gbc_btnPreparation.insets = new Insets(0, 0, 0, 5);
		gbc_btnPreparation.gridx = 1;
		gbc_btnPreparation.gridy = 8;
		add( this.btnPreparation, gbc_btnPreparation);

		this.btnIngredients = new JButton("Ingredients");
		GridBagConstraints gbc_btnIngredients = new GridBagConstraints();
		gbc_btnIngredients.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngredients.gridx = 2;
		gbc_btnIngredients.gridy = 8;
		add( this.btnIngredients, gbc_btnIngredients);

		
		this.modelInstance.setNumberOfGuests(4);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		
		this.comboBox.setSelectedIndex( this.modelInstance.getNumberOfGuests()-1 );
		this.lblTotalCost.setText( this.modelInstance.getTotalMenuPrice() + " SEK" );
		
		repaint();
	}
}

package se.kth.csc.iprog.dinnerplanner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.sun.codemodel.internal.JLabel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.swing.view.IngredientView;
import se.kth.csc.iprog.dinnerplanner.swing.view.MainSidebarView;
import se.kth.csc.iprog.dinnerplanner.swing.view.MainView;
import se.kth.csc.iprog.dinnerplanner.swing.view.PreparationView;

public class MainViewController extends ViewController {

	public MainViewController(DinnerModel model, JPanel view ) {
		super( model, view );
		
		MainView currentView = (MainView) view;
		
		currentView.sidebarView.btnPreparation.addActionListener( this );
		currentView.sidebarView.btnIngredients.addActionListener( this );
		
		currentView.sidebarView.btnMinus.addActionListener( this );
		currentView.sidebarView.btnPlus.addActionListener( this );
		
		currentView.sidebarView.comboBox.addActionListener( this );
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if event from button
		if ( e.getSource() instanceof JButton ) {
			JButton sourceButton = (JButton) e.getSource();
			
			if ( sourceButton.getText() == "Preparation" ) {
				this.openView( new PreparationView( this.model ), "Diner Planer - Preparation"  );
			} else if ( sourceButton.getText() == "Ingredients" ) {
				this.openView( new IngredientView( this.model ), "Diner Planer - Ingredient"  );
			} else if ( sourceButton.getText() == "-" ) {
				this.model.setNumberOfGuests( model.getNumberOfGuests() - 1 );
			}  else if ( sourceButton.getText() == "+" ) {
				this.model.setNumberOfGuests( model.getNumberOfGuests() + 1 );
			}					
		}
	
		if ( e.getSource() instanceof JComboBox ) {
			JComboBox sourceComboBox = (JComboBox) e.getSource();
			int selectedIndex = sourceComboBox.getSelectedIndex() + 1;
			this.model.setNumberOfGuests( selectedIndex );			
		}		
	}
}

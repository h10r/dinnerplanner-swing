package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import java.awt.Font;


public class MainContentPanelView extends JPanel {
	
	private DinnerModel modelInstance;
	private MainView controllerInstance;

	
	private static final long serialVersionUID = 1L;

	public MainContentPanelView(DinnerModel modelInstance, MainView controllerInstance){
		this.modelInstance = modelInstance;
		this.controllerInstance = controllerInstance;
		
	}
	
	public void setupInlinePanels(JComponent currentComponent, int typeOfDish) {

		Set<Dish> dishes = this.modelInstance.getDishes();

		for (Dish d : dishes) {
			if (d.getType() == typeOfDish) {
				try {
					JLabel newDish = d.getImageIcon();

					newDish.setText(d.getName());
					newDish.setFont(new Font("Dialog", Font.BOLD, 16));

					this.addMouseListenerForDish(newDish);

					currentComponent.add(newDish);
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}

	void addTextChangeListenerForSearchBar(JTextField textField, int typeOfDish) {

		final int typeOfDishForKeyListener = typeOfDish;
	}

	void addMouseListenerForDish(JLabel lbl) {
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controllerInstance.openView(new DishView(modelInstance,
						((JLabel) evt.getSource()).getText()),
						"Diner Planer - Dish");
			}
		});
	}
}

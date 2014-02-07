package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.Set;

import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MainContentView extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel desertPanel = new JPanel();
	private final JTextField txtDesertSearchBar = new JTextField();
	private final JPanel desertContentPanel = new JPanel();
	private final JPanel mainPanel = new JPanel();
	private final JTextField txtMainSearchBar = new JTextField();
	private final JPanel mainContentPanel = new JPanel();
	private final JPanel starterPanel = new JPanel();

	private DinnerModel modelInstance;
	private final JTextField txtStarterSearchBar = new JTextField();
	private final JPanel starterContentPanel = new JPanel();

	private MainView controllerInstance;

	public MainContentView(DinnerModel modelInstance,
			MainView controllerInstance) {

		this.controllerInstance = controllerInstance;
		this.modelInstance = modelInstance;

		setLayout(new BorderLayout(0, 0));

		add(tabbedPane, BorderLayout.WEST);
		starterPanel.setPreferredSize(new Dimension(200, 1000));
		tabbedPane.addTab("Starter", null, starterPanel, null);
		starterPanel.setLayout(new BorderLayout(0, 0));

		GridBagConstraints gbc_starterContentPanel = new GridBagConstraints();
		gbc_starterContentPanel.fill = GridBagConstraints.BOTH;
		gbc_starterContentPanel.gridx = 0;
		gbc_starterContentPanel.gridy = 1;
		// starterPanel.add(starterContentPanel, gbc_starterContentPanel);
		this.setUpScrollPanes(starterPanel, starterContentPanel);
		txtStarterSearchBar.setText("Search");
		txtStarterSearchBar.setColumns(10);
		starterPanel.add(txtStarterSearchBar, BorderLayout.NORTH);

		tabbedPane.addTab("Main", null, mainPanel, null);
		mainPanel.setLayout(new BorderLayout(0, 0));
		txtMainSearchBar.setText("Search dish...");
		txtMainSearchBar.setColumns(10);
		mainPanel.add(txtMainSearchBar, BorderLayout.NORTH);
		mainPanel.add(mainContentPanel);
		this.setUpScrollPanes(mainPanel, mainContentPanel);

		tabbedPane.addTab("Desert", null, desertPanel, null);
		desertPanel.setLayout(new BorderLayout(0, 0));
		desertPanel.add(txtDesertSearchBar, BorderLayout.NORTH);
		txtDesertSearchBar.setText("Search dish...");
		txtDesertSearchBar.setColumns(10);
		desertPanel.add(desertContentPanel, BorderLayout.CENTER);
		this.setUpScrollPanes(desertPanel, desertContentPanel);

		// Setup the rest of the view layout

		this.setupInlinePanels(starterContentPanel, 1);
		this.setupInlinePanels(mainContentPanel, 2);
		this.setupInlinePanels(desertContentPanel, 3);

		this.addTextChangeListenerForSearchBar(txtStarterSearchBar, 1);
		this.addTextChangeListenerForSearchBar(txtMainSearchBar, 2);
		this.addTextChangeListenerForSearchBar(txtDesertSearchBar, 3);
	}

	public void setUpScrollPanes(JComponent parentComponent,
			JComponent currentComponent) {
		JScrollPane scrollFrame = new JScrollPane(currentComponent);
		currentComponent.setAutoscrolls(true);
		// scrollFrame.setPreferredSize(new Dimension( 550,660 ));
		// scrollFrame.setHorizontalScrollBarPolicy(
		// ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		scrollFrame
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		parentComponent.add(scrollFrame);
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

		textField.addKeyListener( new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			    // TODO Auto-generated method stub
				System.out.println( ((JTextField)arg0.getSource()).getText() );

				//modelInstance.filterDishesOfType( ((JTextField)arg0.getSource()).getText() , typeOfDish )
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			    // TODO Auto-generated method stub
			}
		});
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

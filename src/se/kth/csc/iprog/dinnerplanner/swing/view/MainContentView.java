package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
import java.util.Observable;
import java.util.Observer;
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

public class MainContentView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel desertPanel = new JPanel();
	private final JTextField txtDesertSearchBar = new JTextField();
	private final JPanel desertContentPanel = new JPanel();
	private final JPanel mainPanel = new JPanel();
	private final JTextField txtMainSearchBar = new JTextField();
	private final JPanel mainContentPanel = new JPanel();
	private final JPanel starterPanel = new JPanel();
	private final JPanel starterContentPanel = new JPanel();

	private MainView parent;
	
	private DinnerModel modelInstance;
	private final JPanel starterContentPanel2 = new JPanel();
	private final JTextField txtStarterSearchBar = new JTextField();

	public MainContentView(DinnerModel modelInstance,
			MainView parent) {
		txtStarterSearchBar.setText("Search dish...");
		txtStarterSearchBar.setToolTipText("");
		txtStarterSearchBar.setColumns(10);

		this.parent = parent;

		this.modelInstance = modelInstance;
		this.modelInstance.addObserver(this);

		setLayout(new BorderLayout(0, 0));

		add(tabbedPane, BorderLayout.WEST);
		starterPanel.setPreferredSize(new Dimension(200, 1000));
		tabbedPane.addTab("Starter", null, starterPanel, null);
		starterPanel.setLayout(new BorderLayout(0, 0));
		starterPanel.add(starterContentPanel2, BorderLayout.NORTH);
		starterContentPanel2.setLayout(new BorderLayout(0, 0));
		
		starterContentPanel2.add(txtStarterSearchBar, BorderLayout.NORTH);

		GridBagConstraints gbc_starterContentPanel = new GridBagConstraints();
		gbc_starterContentPanel.fill = GridBagConstraints.BOTH;
		gbc_starterContentPanel.gridx = 0;
		gbc_starterContentPanel.gridy = 1;

		tabbedPane.addTab("Main", null, mainPanel, null);
		mainPanel.setLayout(new BorderLayout(0, 0));
		txtMainSearchBar.setText("Search dish...");
		txtMainSearchBar.setColumns(10);
		mainPanel.add(txtMainSearchBar, BorderLayout.NORTH);
		mainPanel.add(mainContentPanel);

		tabbedPane.addTab("Desert", null, desertPanel, null);
		desertPanel.setLayout(new BorderLayout(0, 0));
		desertPanel.add(txtDesertSearchBar, BorderLayout.NORTH);
		txtDesertSearchBar.setText("Search dish...");
		txtDesertSearchBar.setColumns(10);
		desertPanel.add(desertContentPanel, BorderLayout.CENTER);

		this.setupInlinePanels(starterContentPanel2, 1);
		this.setupInlinePanels(mainContentPanel, 2);
		this.setupInlinePanels(desertContentPanel, 3);
		this.addTextChangeListenerForSearchBar(txtMainSearchBar, 2);
		this.addTextChangeListenerForSearchBar(txtDesertSearchBar, 3);
	}

	/*
	public void setUpScrollPanes(JComponent parentComponent,
			JComponent currentComponent) {
		starterPanel.add(starterContentPanel, BorderLayout.NORTH);
		currentComponent.setAutoscrolls(true);
	}
	*/

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
				JFrame frame = new JFrame ( "Diner Planer - Dish" );
				frame.getContentPane().add ( new DishView(modelInstance, ((JLabel) evt.getSource()).getText()) );
				frame.setSize(800, 600);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}

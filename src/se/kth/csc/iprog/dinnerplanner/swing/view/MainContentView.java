package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private final JTextField txtStarterSearchBar = new JTextField();
	
	private DinnerModel modelInstance;
	private final JScrollPane starterScrollPane = new JScrollPane();
	
	public MainContentView( DinnerModel modelInstance ) {
		this.modelInstance = modelInstance;
		
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.WEST);
		GridBagLayout gbl_starterPanel = new GridBagLayout();
		gbl_starterPanel.columnWidths = new int[]{147, 134, 0};
		gbl_starterPanel.rowHeights = new int[]{28, 0, 0, 0};
		gbl_starterPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_starterPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		tabbedPane.addTab("Starter", null, starterPanel, null);
		starterPanel.setLayout(gbl_starterPanel);
		
		GridBagConstraints gbc_txtStarterSearchBar = new GridBagConstraints();
		gbc_txtStarterSearchBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtStarterSearchBar.gridwidth = 2;
		gbc_txtStarterSearchBar.insets = new Insets(0, 0, 5, 0);
		gbc_txtStarterSearchBar.gridx = 0;
		gbc_txtStarterSearchBar.gridy = 0;
		txtStarterSearchBar.setText("Search dish...");
		txtStarterSearchBar.setColumns(10);
		starterPanel.add(txtStarterSearchBar, gbc_txtStarterSearchBar);
		tabbedPane.addTab("New tab", null, starterScrollPane, null);
		
		tabbedPane.addTab("Main", null, mainPanel, null);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{147, 134, 0};
		gbl_mainPanel.rowHeights = new int[]{28, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		GridBagConstraints gbc_txtMainSearchBar = new GridBagConstraints();
		gbc_txtMainSearchBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtMainSearchBar.gridwidth = 2;
		gbc_txtMainSearchBar.insets = new Insets(0, 0, 5, 0);
		gbc_txtMainSearchBar.gridx = 0;
		gbc_txtMainSearchBar.gridy = 0;
		txtMainSearchBar.setText("Search dish...");
		txtMainSearchBar.setColumns(10);
		mainPanel.add(txtMainSearchBar, gbc_txtMainSearchBar);
		
		GridBagConstraints gbc_mainContentPanel = new GridBagConstraints();
		gbc_mainContentPanel.gridwidth = 2;
		gbc_mainContentPanel.fill = GridBagConstraints.BOTH;
		gbc_mainContentPanel.insets = new Insets(0, 0, 0, 5);
		gbc_mainContentPanel.gridx = 0;
		gbc_mainContentPanel.gridy = 1;
		mainPanel.add(mainContentPanel, gbc_mainContentPanel);
		
		tabbedPane.addTab("Desert", null, desertPanel, null);
		GridBagLayout gbl_desertPanel = new GridBagLayout();
		gbl_desertPanel.columnWidths = new int[]{147, 134, 0};
		gbl_desertPanel.rowHeights = new int[]{28, 0, 0};
		gbl_desertPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_desertPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		desertPanel.setLayout(gbl_desertPanel);
		txtDesertSearchBar.setText("Search dish...");
		txtDesertSearchBar.setColumns(10);
		
		GridBagConstraints gbc_txtDesertSearchBar = new GridBagConstraints();
		gbc_txtDesertSearchBar.insets = new Insets(0, 0, 5, 0);
		gbc_txtDesertSearchBar.gridwidth = 2;
		gbc_txtDesertSearchBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDesertSearchBar.gridx = 0;
		gbc_txtDesertSearchBar.gridy = 0;
		desertPanel.add(txtDesertSearchBar, gbc_txtDesertSearchBar);
		
		GridBagConstraints gbc_desertContentPanel = new GridBagConstraints();
		gbc_desertContentPanel.gridwidth = 2;
		gbc_desertContentPanel.insets = new Insets(0, 0, 0, 5);
		gbc_desertContentPanel.fill = GridBagConstraints.BOTH;
		gbc_desertContentPanel.gridx = 0;
		gbc_desertContentPanel.gridy = 1;
		desertPanel.add(desertContentPanel, gbc_desertContentPanel);
		
		
		// Setup the rest of the view layout

		for ( int i = 0; i < 10; i++ ) {
			this.setupInlinePanels( starterPanel, 1 );
		}
		
		// starterContentPanel.
	}
	
	public void setupInlinePanels( JComponent currentComponent, int typeOfDish  ) {
		
		Set<Dish> dishes = this.modelInstance.getDishes();
		
		for(Dish d : dishes) {
			if(d.getType() == typeOfDish){
				try {
					JLabel newDish = d.getImageIcon();
					
					newDish.setText( d.getName()); 
					newDish.setFont(new Font("Dialog", Font.BOLD, 16));
					
					currentComponent.add( newDish );
				} catch (IOException e) {
					System.err.println( e );
				}
			}
		}
	}
	
	
}

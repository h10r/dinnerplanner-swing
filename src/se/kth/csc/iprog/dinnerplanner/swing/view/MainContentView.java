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
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.BoxLayout;


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
	private final JTextField txtSearchBar = new JTextField();
	private final JPanel starterContentPanel = new JPanel();
	
	public MainContentView( DinnerModel modelInstance ) {
		this.modelInstance = modelInstance;
		
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.WEST);
		starterPanel.setPreferredSize(new Dimension(400, 10));
		tabbedPane.addTab("Starter", null, starterPanel, null);
		starterPanel.setLayout(new BorderLayout(0, 0));
		
		GridBagConstraints gbc_starterContentPanel = new GridBagConstraints();
		gbc_starterContentPanel.fill = GridBagConstraints.BOTH;
		gbc_starterContentPanel.gridx = 0;
		gbc_starterContentPanel.gridy = 1;
		// starterPanel.add(starterContentPanel, gbc_starterContentPanel);
		this.setUpScrollPanes( starterPanel, starterContentPanel );
		txtSearchBar.setText("Search");
		txtSearchBar.setColumns(10);
		starterPanel.add(txtSearchBar, BorderLayout.NORTH);
		
		tabbedPane.addTab("Main", null, mainPanel, null);
		mainPanel.setLayout(new BorderLayout(0, 0));
		txtMainSearchBar.setText("Search dish...");
		txtMainSearchBar.setColumns(10);
		mainPanel.add(txtMainSearchBar, BorderLayout.NORTH);
		mainPanel.add(mainContentPanel);
		this.setUpScrollPanes( mainPanel, mainContentPanel );
		
		tabbedPane.addTab("Desert", null, desertPanel, null);
		desertPanel.setLayout(new BorderLayout(0, 0));
		desertPanel.add(txtDesertSearchBar, BorderLayout.NORTH);
		txtDesertSearchBar.setText("Search dish...");
		txtDesertSearchBar.setColumns(10);
		desertPanel.add(desertContentPanel, BorderLayout.CENTER);
		this.setUpScrollPanes( desertPanel, desertContentPanel );
		
		// Setup the rest of the view layout
		

		for ( int i = 0; i < 10; i++ ) {
			this.setupInlinePanels( starterContentPanel, 1 );
			this.setupInlinePanels( mainContentPanel, 1 );
			this.setupInlinePanels( desertContentPanel, 1 );
		}
		
		// starterContentPanel.
	}
	
	public void setUpScrollPanes( JComponent parentComponent, JComponent currentComponent ) {
		JScrollPane scrollFrame = new JScrollPane(currentComponent);
		currentComponent.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension( 400,400 ));
		parentComponent.add(scrollFrame);
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

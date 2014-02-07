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

	private DinnerModel modelInstance;
	private MainView controllerInstance;

	public MainContentView(DinnerModel modelInstance,
			MainView controllerInstance) {

		this.controllerInstance = controllerInstance;
		this.modelInstance = modelInstance;

		setLayout(new BorderLayout(0, 0));

		add(tabbedPane, BorderLayout.WEST);
		
		tabbedPane.setPreferredSize( new Dimension(600,400) );
		
		MainContentPanelView starterTab = new MainContentPanelView( this.modelInstance, this.controllerInstance);
		MainContentPanelView mainTab = new MainContentPanelView( this.modelInstance, this.controllerInstance);
		MainContentPanelView dessertTab = new MainContentPanelView( this.modelInstance, this.controllerInstance);
		
		tabbedPane.addTab("Starter", starterTab);
		tabbedPane.addTab("Main", mainTab);
		tabbedPane.addTab("Dessert", dessertTab);
	}
	
}

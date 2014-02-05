package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class DishView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JLabel lblDishName = new JLabel();
	JLabel lblPricePerPerson = new JLabel();
	JPanel northPane = new JPanel();
	JPanel northPaneRight = new JPanel();
	JPanel northPaneLeft = new JPanel();
	JPanel centerPane = new JPanel();
	JPanel rightPane = new JPanel();
	BufferedImage dishImage = null;
	JLabel imageLabel = null;

	
	public DishView(){
		
		//get current dish specific data.
		try {
		    dishImage = ImageIO.read(new File("images/toast.jpg"));
		    imageLabel = new JLabel(new ImageIcon(dishImage));
		    
		    System.out.println(dishImage.getWidth());
		} catch (IOException e) {
			System.out.println("error image file not found");
		}
		//set text values for currently selected dish
		lblDishName.setText("Dish Name");
		lblPricePerPerson.setText("$12 per person");
		lblPricePerPerson.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
		
		//set up layout styles.
		this.setLayout( new BorderLayout() );
		northPane.setLayout( new FlowLayout() );
		northPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		northPaneRight.setLayout(new BoxLayout(northPaneRight, BoxLayout.Y_AXIS));
		
		//set borders on each panel just to see where they are.
		northPane.setBorder(BorderFactory.createLineBorder(Color.black));
		northPaneRight.setBorder(BorderFactory.createLineBorder(Color.black));
		northPaneLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//add the labels to the northPane
		northPaneLeft.add(imageLabel);
		northPaneRight.add(lblDishName);		
		northPaneRight.add(lblPricePerPerson);
		
		northPane.add(northPaneLeft);
		northPane.add(northPaneRight);
				
		this.add(northPane,BorderLayout.NORTH);
		
		
		// Setup the rest of the view layout
	}
	
}

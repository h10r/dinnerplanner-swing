package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTable;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import java.awt.Insets;


public class DishView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	BufferedImage dishImage = null;
	JLabel imageLabel = null;
	private final JPanel panel = new JPanel();
	private JLabel imageDish = new JLabel("Image");
	private final JLabel lblName = new JLabel("Name");
	private final JLabel lblPricePerPerson = new JLabel("price");
	private final JPanel panel_1 = new JPanel();
	private final JTextPane txtInfoPane = new JTextPane();
	private final JScrollPane ingredientsViewPanel = new JScrollPane();
	private final JTable table = new JTable();
	
	private DinnerModel modelInstance;
	
	public DishView(DinnerModel modelInstance, String dishName) {
		this.modelInstance = modelInstance;
		this.modelInstance.addObserver(this);
		
		Dish selectedDish = this.modelInstance.getDishByName(dishName);
		
		//get current dish specific data.
		lblName.setText(selectedDish.getName()); 
		lblPricePerPerson.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPricePerPerson.setText("$ "+selectedDish.getTotalDishPrice()+" for "+this.modelInstance.getNumberOfGuests()+" guests.");
		this.modelInstance.getTotalMenuPrice();

		//try to open image file for dish
		try {
		    imageLabel = selectedDish.getImageIcon();
		    imageDish = imageLabel;
		} catch (IOException e) {
			System.out.println("error image file not found");
		}
		
		
		//set up layout styles.
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		imageDish.setBorder(new EmptyBorder(0, 0, 10, 10));
		panel.add(imageDish);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		lblName.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_1.add(lblName);
		lblPricePerPerson.setBorder(new EmptyBorder(10, 10, 10, 0));
		panel_1.add(lblPricePerPerson);
		txtInfoPane.setPreferredSize(new Dimension(250, 21));
		txtInfoPane.setMaximumSize(new Dimension(200, 2147483647));
		txtInfoPane.setMargin(new Insets(5, 5, 5, 5));
		txtInfoPane.setMinimumSize(new Dimension(500, 300));
		txtInfoPane.setContentType("text/html");
		txtInfoPane.setEditable(false);
		txtInfoPane.setText("<center><h3>Dish Preparation</h3><p>"+selectedDish.getDescription()+"</p></center>");
		
		add(txtInfoPane, BorderLayout.WEST);
		add(ingredientsViewPanel, BorderLayout.CENTER);

		table.setModel(modelInstance.getDishTableModel(dishName));
		ingredientsViewPanel.setViewportView(table);	
	}
	
	@Override
    public void update(Observable o, Object arg) {
        repaint();
    }
	
}

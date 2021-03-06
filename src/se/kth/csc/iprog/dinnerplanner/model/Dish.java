package se.kth.csc.iprog.dinnerplanner.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dish {
	
	public static final int STARTER = 1;
	public static final int MAIN = 2;
	public static final int DESERT = 3;
	
	String name;
	int type; // starter (1), main (2) or desert (3)  
	String image;
	String description;
	
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	public Dish(String name, int type, String image, String description) {
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public JLabel getImageIcon() throws IOException {
		BufferedImage dishImage;
		try {
			dishImage = ImageIO.read(new File("images/"+this.getImage()));
		} catch (IOException e) {
			dishImage = ImageIO.read(new File("images/default.gif"));
		}
	    return new JLabel(new ImageIcon(dishImage));
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public void addIngredient(Ingredient ing){
		ingredients.add(ing);
	}
	
	public void removeIngredient(Ingredient ing){
		ingredients.remove(ing);
	}
	
	public boolean contains(String filter){
		if(name.toLowerCase().contains(filter.toLowerCase())){
			return true;
		}
		for(Ingredient i : ingredients){
			if(i.getName().toLowerCase().contains(filter.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	public float getTotalDishPrice() {
		float totalPrice = -1.0f;
			
			for(Ingredient i : this.getIngredients() ) {
				totalPrice += i.getPrice();
			}
		
		return totalPrice;
	}

}

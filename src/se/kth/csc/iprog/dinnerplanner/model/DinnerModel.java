package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class DinnerModel implements IDinnerModel {
	
	Set<Dish> dishes = new HashSet<Dish>();
	int numberOfGuests;
	int clickedDish = 3;
	
	Set<Dish> selectedDished = new HashSet<Dish>();
	Set<Ingredient> allIngredients = new HashSet<Ingredient>();
	
	/**
	 * TODO: For Lab2 you need to implement the IDinnerModel interface.
	 * When you do this you will have all the needed fields and methods
	 * for the dinner planner (number of guests, selected dishes, etc.). 
	 */
	
	
	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
		
		//Adding some example data, you can add more
		Dish dish1 = new Dish("French toast",Dish.STARTER,"toast.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
		Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
		Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
		Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		dishes.add(dish1);
		
		
		Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs.jpg","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
		Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
		Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
		Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
		Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
		Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
		Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
		Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		dishes.add(dish2);
		
		
		Dish dish3 = new Dish("Sour dough",Dish.STARTER,"sourdough.jpg","In a large bowl, combine the water, yeast, and sugar. Let sit until the yeast becomes foamy, about 5 minutes. (If the yeast does not foam, discard the mixture and begin again with a new yeast.) Add the flour and stir vigorously to work air into the mixture. Cover with a towel let rest in a warm, draft-free place (an oven with its pilot light or light bulb turned on works well) for 8 to12 hours. (The mixture should become very bubbly.) Use immediately or cover loosely with plastic wrap and store in the refrigerator");
		Ingredient dish3ing1 = new Ingredient("bread flour",2,"cups",4);
		Ingredient dish3ing2 = new Ingredient("sourdough starter",1.5,"cups",6);
		Ingredient dish3ing3 = new Ingredient("salt",0.75,"teaspoon",1);
		Ingredient dish3ing4 = new Ingredient("dry yeast",1.5,"tablespoon",5);
		Ingredient dish3ing5 = new Ingredient("sugar",1,"teaspoon",2);
		dish3.addIngredient(dish3ing1);
		dish3.addIngredient(dish3ing2);
		dish3.addIngredient(dish3ing3);
		dish3.addIngredient(dish3ing4);
		dish3.addIngredient(dish3ing5);
		dishes.add(dish3);

		Dish dish4 = new Dish("Ice Cream",Dish.DESERT,"icecream.jpg","Make sure that you have plenty of room spare in the freezer. First, separate the eggs, placing the yolks in a large bowl. (You will not need the whites for this recipe. You can use them to make meringues.)    Add the sugar to the egg yolks and whisk until pale and thick.    Add the cornflour (if using) and whisk well to incorporate into the egg yolks.    Put the cream and milk into a medium saucepan.    Cut the vanilla pod open lengthways and scrape out the seeds with the back of a knife, then add to the cream and milk.    Heat the cream and milk until just below boiling. Slowly pour the hot cream and milk onto the eggs and sugar, whisking as you go.    Sieve the custard into a clean pan, and set it over a very low heat. Stir the custard constantly with a wooden spoon, paying special attention to the corners of the pan, until it is steaming and has thickened slightly. The custard is ready when you can draw a clear line through it on the back of the wooden spoon. This can take up to 10 minutes.    Tip the custard into a large, shallow, freezer-proof container, and allow to cool to room temperature (you can speed this up by sitting the tub of custard in a large bowl of iced water).    Once at room temperature, place a lid on the custard and chill in the fridge overnight.    Once chilled, transfer the custard to the freezer and take it out every hour, for three hours, to whisk it with an electric handheld whisk. This will disperse the ice crystals and keep it smooth.    Then leave the ice-cream in the freezer for a final freeze, until it is solid.    Remove the ice cream from the freezer 10 minutes before serving, so that it’s easy to scoop.");
		Ingredient dish4ing1 = new Ingredient("egg yolks",4,"",2);
		Ingredient dish4ing2 = new Ingredient("vanilla pod",1,"",6);
		Ingredient dish4ing3 = new Ingredient("milk",300,"ml",1);
		Ingredient dish4ing4 = new Ingredient("double cream",300,"ml",5);
		Ingredient dish4ing5 = new Ingredient(" golden caster sugar",100,"g",6);
		dish4.addIngredient(dish4ing1);
		dish4.addIngredient(dish4ing2);
		dish4.addIngredient(dish4ing3);
		dish4.addIngredient(dish4ing4);
		dish4.addIngredient(dish4ing5);
		dishes.add(dish4);
		
		
		Dish dish5 = new Dish("Baked Brie",Dish.MAIN,"bakedbrie.jpg"," Preheat oven to 350 degrees F. If you want, start with chilled brie and use a sharp knife to carefully cut off the thin top rind of the cheese. This may help the crust stay with the cheese when served. The rind is edible so you don't have to do this step if you don't want to. On a stick-free cookie sheet, lay out the puff pastry or the crescent rolls flat; put the brie round or wedge on top. Spread jam on brie, fold dough over top, cutting off excess dough. Drizzle maple syrup and place a handful of brown sugar on top. Bake at 350º for 25-30 minutes, pastry should be golden brown. Let cool for 10 minutes before serving. Serve with crackers and apple slices.");
		Ingredient dish5ing1 = new Ingredient("maple syrup",4,"cup",2);
		Ingredient dish5ing2 = new Ingredient("pastry dough",1,"cup",6);
		Ingredient dish5ing3 = new Ingredient("brie cheese",300,"g",1);
		Ingredient dish5ing4 = new Ingredient("sweet jam",300,"g",5);
		Ingredient dish5ing5 = new Ingredient(" brown sugar",100,"g",6);
		dish5.addIngredient(dish5ing1);
		dish5.addIngredient(dish5ing2);
		dish5.addIngredient(dish5ing3);
		dish5.addIngredient(dish5ing4);
		dish5.addIngredient(dish5ing5);
		dishes.add(dish5);
		
		selectedDished.add(dish1); // !!! just added that for testing
		selectedDished.add(dish2); // !!! just added that for testing
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}
	
	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient. 
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}
	
	public int getNumberOfGuests() {
		return this.numberOfGuests;
	}
	
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	
	/**
	 * Returns the dish that is on the menu for selected type (1 = starter, 2 = main, 3 = desert).
	 */
	public Dish getSelectedDish(int type) {
		for(Dish d : dishes){
			if(d.getType() == type){
				return d;
			}
		}
		return new Dish("",Dish.STARTER,"","");
	}
	
	/**
	 * Returns all the dishes on the menu.
	 */
	public Set<Dish> getFullMenu() {
		return this.selectedDished;
	}
	
	/**
	 * Returns all ingredients for all the dishes on the menu.
	 */
	public Set<Ingredient> getAllIngredients() {
		return this.allIngredients;
	}
	
	/**
	 * Returns the total price of the menu (all the ingredients multiplied by number of guests).
	 */
	public float getTotalMenuPrice() {
		float totalPrice = -1.0f;
		
		for(Dish d : this.getFullMenu() ){		
			for(Ingredient i : d.getIngredients() ) {
				totalPrice += i.getPrice();
			}
		}
		
		return totalPrice;
	}
	
	public DefaultTableModel getDishTableModel(int type){
		DefaultTableModel tableModel = null;
		
		//assign ingredients data to table
		//set up empty table data.
				String[] colTitles = new String[] {"Ingredients", "Quantity", "Cost"};
				Object[][] tableData = new Object[25][3];
				
				Iterator<Ingredient> ingIterator = this.getSelectedDish(type).getIngredients().iterator();
				int itrCount = 0;
				while(ingIterator.hasNext()){
					Ingredient ingredient = ingIterator.next();
					tableData[itrCount][0] = ingredient.getName();
					tableData[itrCount][1] = ingredient.getQuantity()+" "+ingredient.getUnit();
					tableData[itrCount][2] = "$"+ingredient.getPrice();
					itrCount++;
				}
				tableModel = new DefaultTableModel(tableData,colTitles);
		return tableModel;
	}
	
	// method that returns an a tableModel object with all ingredients needed for the dinner 
	public DefaultTableModel getIngredientsTableModel(){
		
		DefaultTableModel tableModel = null;
		
		String[] colTitles = new String[] {"Ingredients", "Quantity", "Cost"};
		Object[][] ingredientsData = new Object[100][3];
		
		// iterate through whole menu
		int i = 0;
		for(Dish dish : this.getFullMenu()){		
			for(Ingredient ingredient : dish.getIngredients() ) {
				//System.out.println(ingredient.getName());
				ingredientsData[i][0] = ingredient.getName();
				ingredientsData[i][1] = ingredient.getQuantity() + " " + ingredient.getUnit();
				ingredientsData[i][2] = "$" + ingredient.getPrice();
				//allIngredients.add(ingredient);
				i++;
			}
		}
		
		//System.out.println(ingredientsData);
				
		tableModel = new DefaultTableModel(ingredientsData, colTitles);
		return tableModel;
	}
	
	public int getClickedDish(){
		return clickedDish;
	}
	
	public void setClickedDish(int selection){
		clickedDish = selection;
	}
}

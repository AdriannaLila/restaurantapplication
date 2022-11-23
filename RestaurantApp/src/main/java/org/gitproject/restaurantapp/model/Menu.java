package org.gitproject.restaurantapp.model;

import java.util.HashMap;

import org.gitproject.restaurantapp.model.product.Drink;
import org.gitproject.restaurantapp.model.product.Meal;
import org.gitproject.restaurantapp.model.product.Product;

public class Menu {
	
	private HashMap<Integer,Product>menuItems=new HashMap<>();
	
	public Menu (boolean menuItemsFromFile) {
		if(! menuItemsFromFile) {
			initializeMenuItems();
		}
	}
	
	public Menu() {
		initializeMenuItems();
	}
	private void initializeMenuItems() {
		menuItems.put(100, new Meal("Hamburger",100,3.5,"Tomato,pickles,ketchup"));
		menuItems.put(101, new Product("Cheeseburger",101,5));
		menuItems.put(102, new Product("Sandwich",102,3));
		menuItems.put(103, new Product("Hotdog",103,3.5));
		menuItems.put(104, new Product("Pizza",104,6));
		menuItems.put(105, new Product("Fries",105,5));
		menuItems.put(200, new Drink("Cola cola",200,1,false));  
		menuItems.put(201, new Drink("Cola cola Zero",201,1,true));
		menuItems.put(202, new Product("Fanta",202,1));
		menuItems.put(203, new Product("Sprite",203,1));
		menuItems.put(204, new Product("Red Bull",204,2));
		menuItems.put(205, new Product("Coffee",205,0.5));
		menuItems.put(300, new Product("Ice Cream",300,1.6));
		menuItems.put(301, new Product("Waffle",301,2.9));
		menuItems.put(302, new Product("Brownie",302,3));
	}
	
	public HashMap<Integer,Product> getMenuItems(){
		return menuItems;
}
}

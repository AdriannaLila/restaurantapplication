package org.gitproject.restaurantapp.controller.menu;
import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.product.Product;

import java.util.Map.Entry;
import java.util.HashMap;

public class MenuPrinter {
	
	public void printMenu(Menu menu) {
		System.out.println("---------------Menu----------------");
	
HashMap<Integer,Product>menuItems=menu.getMenuItems();
  
for(Entry<Integer,Product>menuEntry:menuItems.entrySet()) {
	Product menuItem=menuEntry.getValue();
	System.out.println(menuItem.getProductId() + ". "+ menuItem.getName()+ " | " + menuItem.getPrice()+ " Euro");
  }
System.out.println("------------------------------------");
	
}
}
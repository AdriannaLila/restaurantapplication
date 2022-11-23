package org.gitproject.restaurantapp.controller.menu;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.product.Drink;
import org.gitproject.restaurantapp.model.product.Meal;
import org.gitproject.restaurantapp.model.product.Product;

public class MenuImporter {

	public Menu importMenu(String filePath) {
		
		Menu importedMenu=new Menu(true);
	
		try {
			List<String> fileLines =Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
	for(String menuItemAsString:fileLines) {
		String [] menuItemAsStringArray=menuItemAsString.split(",");
			int productID= Integer.valueOf(menuItemAsStringArray[0]);
			String productName=menuItemAsStringArray[1];
			double productPrice=Double.valueOf(menuItemAsStringArray[2]);
			String productCategory=menuItemAsStringArray[3];
			
			Product product=null;
			if("meal".equals(productCategory)) {
				product=new Meal(productName,productID,productPrice);
			}else if("drink".equals(productCategory)) {
				boolean sugarFree=Boolean.valueOf(menuItemAsStringArray[4]);
				product=new Drink(productName,productID,productPrice,sugarFree);
				
			}else {
				StringBuffer stringBuffer=new StringBuffer();
				stringBuffer.append("The menu file could not be processed as the product category from product ")
				.append(productName).append(" is invalid.");
			}	
			importedMenu.getMenuItems().put(productID, product);
		}
		} catch (IOException e) {
			throw new RuntimeException("Menu file could not be found!",e);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importedMenu;
		
	}
	
	

}

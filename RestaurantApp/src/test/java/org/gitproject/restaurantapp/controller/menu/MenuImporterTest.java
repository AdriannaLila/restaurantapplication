package org.gitproject.restaurantapp.controller.menu;
import java.util.HashMap;
import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuImporterTest {

 MenuImporter menuImporter=new MenuImporter();
  final String  MENU_FILE_PATH="/menu-test.txt";
 @Test
 public void testImportMenu() {
	Menu menu = menuImporter.importMenu(MENU_FILE_PATH);
	
	 HashMap<Integer,Product> menuItems=menu.getMenuItems();
	 
	 Assertions.assertEquals(9, menuItems.size());
	 }

}

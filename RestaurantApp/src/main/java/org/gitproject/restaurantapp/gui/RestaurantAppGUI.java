package org.gitproject.restaurantapp.gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.gitproject.restaurantapp.controller.menu.MenuImporter;
import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.product.Product;
import java.awt.BorderLayout;

public class RestaurantAppGUI {

	private JFrame frame;
	private boolean fromFile=true;
	private final String MENU_FILE_PATH ="/pizza-menu.txt";;
	private DefaultTableModel menuItemTableModel=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantAppGUI window = new RestaurantAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantAppGUI() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel applicationNameLabel = new JLabel("RestaurantApp");
		applicationNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(applicationNameLabel,BorderLayout.NORTH);
		
		prepareMenuDataTable();
		
		
		JTable menuDataTable = new JTable(menuItemTableModel);
		JScrollPane scrollPane=new JScrollPane(menuDataTable);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Restaurant Menu"));
		//frame.getContentPane().add(scrollPane);
		
		JPanel panel =new JPanel();
		JButton switchMenuButton=createSwitchMenuButton();
		panel.add(switchMenuButton);
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
	}
	private JButton createSwitchMenuButton() {
    JButton switchMenuButton=new JButton("Switch Menu");
    switchMenuButton.setBounds(103,115,90,36);
    
    switchMenuButton.addActionListener(new ActionListener() {
    
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fromFile) {
				fromFile=false;
			}else {
				fromFile=true;
				
			}
			prepareMenuDataTable();
		}
    	
    });
		return switchMenuButton;
	}

	private void prepareMenuDataTable() {
	String  [] tableHeader= {"ID","Name","Price"};
		String [] [] menuItemListMultidimensionalArray= createMenuArray();
		menuItemTableModel.setDataVector(menuItemListMultidimensionalArray, tableHeader);	
	}
	private Menu getMenu() {
		Menu menu;
		if(fromFile) {
			MenuImporter importer=new MenuImporter();
			menu=importer.importMenu(MENU_FILE_PATH);
		}else {
			menu=new Menu();
		}
		return menu;
	}
	
	private String[][] createMenuArray() {
		Menu menu=getMenu();
		HashMap<Integer,Product> menuItems=menu.getMenuItems();
		String [][]  menuItemListMultidimensionalArray =new String[menuItems.size()][3];
		int i=0;
		for(Entry<Integer,Product>menuItem : menuItems.entrySet()) {
			Product product= menuItem.getValue();
			menuItemListMultidimensionalArray[i][0] = Integer.toString(product.getProductId());
			menuItemListMultidimensionalArray[i][1]=product.getName();
			menuItemListMultidimensionalArray[i][2]=Double.toString(product.getPrice());
			i++;
			
		}
		return menuItemListMultidimensionalArray;
	}

}

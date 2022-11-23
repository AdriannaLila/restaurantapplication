package org.gitproject.restaurantapp;
import java.util.Scanner;
import org.gitproject.restaurantapp.controller.menu.MenuPrinter;
import org.gitproject.restaurantapp.controller.order.IOrderCalculator;
import org.gitproject.restaurantapp.controller.order.OrderAmount;
import org.gitproject.restaurantapp.controller.order.OrderCalculatorGER;
import org.gitproject.restaurantapp.controller.order.OrderCalculatorKS;
import org.gitproject.restaurantapp.controller.order.OrderManager;
import org.gitproject.restaurantapp.controller.order.OrderPrinter;
import org.gitproject.restaurantapp.model.ApplicationMode;
import org.gitproject.restaurantapp.model.Client;
import org.gitproject.restaurantapp.model.Location;
import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.Restaurant;
import org.gitproject.restaurantapp.model.order.Order;


public class RestaurantApp {
	private static Location currentLocation;
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		ApplicationMode applicationMode=getApplicationMode();
	currentLocation=getCurrentLocation();
	    validateApplicationMode(applicationMode);
		
	}
private static Location getCurrentLocation() {
		
	System.out.println("Please enter a location : ");
		int locationID=scanner.nextInt();	
	switch(locationID) {
	
	case 1 : return Location.GERMANY;
	case 2 : return Location.KOSOVO;		
	
	default: throw new IllegalArgumentException("No valid application mode id selected!Application does not support "+ locationID);
	}
}
	    private static void validateApplicationMode(ApplicationMode applicationMode) {
	    	switch(applicationMode) {
			case ORDER:
				runOrderProcess();
				break;
			case TABLE_RESERVATION:
				runTableReservationProcess();
				break;
				default:
					throw new IllegalArgumentException("No valid application mode selected!Application does not support "+ applicationMode);
	    	}	
	    }
	 
	private static ApplicationMode getApplicationMode() {

		System.out.println("Please enter an application mode: " );
		int applicationModeID=scanner.nextInt();
		
		
		if(applicationModeID==1) {
			return ApplicationMode.ORDER;
			
		}else if(applicationModeID==2) {
			return ApplicationMode.TABLE_RESERVATION;
		}else {
			StringBuilder  stringBuilder=new StringBuilder();
			stringBuilder.append("The selected application mode id ");
			stringBuilder.append(applicationModeID);
			stringBuilder.append(" is not supported.Valid application mode: [1,2]");
		
			throw new IllegalArgumentException(stringBuilder.toString());
		}
	}
		
	private static void runOrderProcess() {

		Restaurant restaurant=new Restaurant("Route 12","Street A");
		Client client=new Client("Ann Cohl","Street B","+383123456","64285");
	
		Menu menu=new Menu();
		                                 
		MenuPrinter menuPrinter=new MenuPrinter();
		menuPrinter.printMenu(menu);
		
		OrderManager orderManager=new OrderManager();
		
		Order order1=orderManager.createOrder(menu);
		Order order2=new Order();
		Order order3=new Order();
		Order order4=new Order();
		Order order5=new Order();
		
		orderManager.addOrder(order1);
		orderManager.addOrder(order2);
		orderManager.addOrder(order3);
		orderManager.addOrder(order4);
		orderManager.addOrder(order5);
		
		IOrderCalculator orderCalculator= getOrderCalculator();
		OrderAmount orderAmount=orderCalculator.calculateOrderAmount(order1);
		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(order1, restaurant, client,orderAmount,orderCalculator.getVATRate(false));
	}

	private static IOrderCalculator getOrderCalculator() {
		switch(currentLocation) {
		case KOSOVO : return new OrderCalculatorKS();
		case GERMANY : return new OrderCalculatorGER();
		}
		System.err.println("Current location is invalid");
		return null;
	}
	private static void runTableReservationProcess() {
		System.out.println("The selection number 4 was reserved succcesfully!");
			
		}

}


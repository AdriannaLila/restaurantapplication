package org.gitproject.restaurantapp.controller.order;
import java.util.ArrayList;
import org.gitproject.restaurantapp.model.Client;
import org.gitproject.restaurantapp.model.Restaurant;
import org.gitproject.restaurantapp.model.order.Order;
import org.gitproject.restaurantapp.model.order.OrderItem;

public class OrderPrinter {
public void printOrderInfo(Order order,Restaurant restaurant,Client client,OrderAmount orderAmount,double vatRate) {
	printOrderInfoHeader(client);
	ArrayList<OrderItem>orderItems= order.getOrderItems();
	orderItems.forEach(o -> printOrderItemInfo(o));
	printOrderInfoFooter(restaurant,orderAmount,vatRate);
}
	
		public void printOrderItemInfo(OrderItem orderItem) {
			
			double totalOrderItemPrice=orderItem.getOrderItemPrice()*orderItem.getQuantity();
			
			System.out.println(orderItem.getQuantity() + "x " +orderItem.getProduct().getName() + "|  "
		+ orderItem.getOrderItemPrice() + "|" + totalOrderItemPrice + "Euro");
		}

		private void printOrderInfoFooter(Restaurant restaurant,OrderAmount orderAmount,double vatRate) {

		System.out.println("----------------------------------");
		
		System.out.println("Total amount:" +orderAmount.getTotalOrderAmount()+ " Euro");
		
int  vatRateText= (int)vatRate;
		System.out.println("VAT: "+ vatRateText + " % " + orderAmount.getTotalOrderAmountVAT());
		System.out.println("Total order amount with VAT:"+ orderAmount.getTotalOrderAmountWithVAT()+" Euro");
		System.out.println(restaurant.getName() + " in " + restaurant.getAddress());
}
		private void printOrderInfoHeader(Client client) {
			System.out.println("Order from " +client.getName() + " (" +client.getAddress() + ")");
				
				System.out.println("Contact number: " +client.getPhoneNr());
				System.out.println("----------------------------------");
			}
	}


package org.gitproject.restaurantapp.model.order;

import java.util.ArrayList;
public class Order {
	private ArrayList<OrderItem> orderItems=new ArrayList<OrderItem>();
	public Order() {
	}
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	

}

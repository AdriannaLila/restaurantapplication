package org.gitproject.restaurantapp.controller.order;
import org.gitproject.restaurantapp.model.Menu;
import org.gitproject.restaurantapp.model.order.Order;
import org.gitproject.restaurantapp.model.order.OrderItem;
import org.gitproject.restaurantapp.model.order.OrderItemSize;
import org.gitproject.restaurantapp.model.product.Product;

public class OrderManager {
	
	Order [] orderArray=new Order[5];

	public Order[] getOrderArray() {
		return orderArray;
	}

	public void setOrderArray(Order[] orderArray) {
		this.orderArray = orderArray;
	}
	
	public void addOrder(Order order) {
	for(int i=0;i<getOrderArray().length; i++) {
		if(orderArray[i]==null)
		orderArray[i]= order;
		return;
	}
	}
	
	public Order createOrder(Menu menu) {
		Order order=new Order();
		addOrderItem(order,menu.getMenuItems().get(103),OrderItemSize.XXL,1);
		addOrderItem(order,menu.getMenuItems().get(104),OrderItemSize.LARGE,2);
		addOrderItem(order,menu.getMenuItems().get(200),OrderItemSize.SMALL,2);
		addOrderItem(order,menu.getMenuItems().get(301),OrderItemSize.INVALID,3);
		return order;	
		}
	private void addOrderItem(Order order,Product product,OrderItemSize orderItemSize,int quantity) {
		OrderItem orderItem=new OrderItem(product,orderItemSize,quantity);
		order.getOrderItems().add(orderItem);
	}
}

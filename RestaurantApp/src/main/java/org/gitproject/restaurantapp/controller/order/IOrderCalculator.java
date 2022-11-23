package org.gitproject.restaurantapp.controller.order;
import org.gitproject.restaurantapp.model.order.Order;
import org.gitproject.restaurantapp.model.order.OrderItem;
import org.gitproject.restaurantapp.model.order.OrderItemSize;

public interface IOrderCalculator {
	
	public double calculateTotalOrderAmount(Order order);
	public OrderAmount calculateOrderAmount(Order order);
	public double calculateOrderItemPrice(OrderItem orderItem);
	public double getSizeRateAmount(OrderItemSize orderItemSize);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount);
	
	public double getVATRate(boolean decimal);

}

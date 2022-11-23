package org.gitproject.restaurantapp.controller.order;

import java.util.ArrayList;

import org.gitproject.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.gitproject.restaurantapp.model.order.Order;
import org.gitproject.restaurantapp.model.order.OrderItem;
import org.gitproject.restaurantapp.model.order.OrderItemSize;
import org.gitproject.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator{
	
	
	public double getVATRate(boolean decimal) {
		if(decimal) {
			return getVATRate();
		}else {
			return getVATRate()*100;
		}
		
	}
	
public double calculateTotalOrderAmount(Order order) {
		
		ArrayList<OrderItem>orderItems=order.getOrderItems();
		double totalOrderAmount=0.0;
		

		for(OrderItem orderItem:orderItems) {
			totalOrderAmount+=calculateOrderItemPrice(orderItem);
			
		}
	
		return totalOrderAmount;
	}

public double calculateOrderItemPrice(OrderItem orderItem) {
	double sizeRateAmount=1;
	try {
		getSizeRateAmount(orderItem.getOrderItemSize());
		
	}catch (InvalidOrderItemSizeException e) {
		System.err.println("No valid order item size: " + orderItem.getProduct().getName());
	}
	
	Product product = orderItem.getProduct();
	double totalOrderItemPrice=product.getPrice()*sizeRateAmount;
	orderItem.setOrderItemPrice(totalOrderItemPrice);
	
	return totalOrderItemPrice*orderItem.getQuantity();
}


public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
	return totalOrderAmount*18/100;
}

public OrderAmount calculateOrderAmount(Order order) {
	double totalOrderAmount=calculateTotalOrderAmount(order);
	double totalOrderAmountVAT=calculateTotalOrderAmountVAT(totalOrderAmount);
	double totalOrderAmountWithVAT=totalOrderAmount+totalOrderAmountVAT;
	
	OrderAmount orderAmount= new OrderAmount(totalOrderAmount,totalOrderAmountVAT,totalOrderAmountWithVAT);
	return orderAmount;
}
public abstract double getSizeRateAmount(OrderItemSize orderItemSize);
public  abstract double getVATRate();

}



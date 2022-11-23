package org.gitproject.restaurantapp.controller;

import org.gitproject.restaurantapp.controller.order.AbstractOrderCalculator;
import org.gitproject.restaurantapp.model.order.Order;
import org.gitproject.restaurantapp.model.order.OrderItem;
import org.gitproject.restaurantapp.model.order.OrderItemSize;
import org.gitproject.restaurantapp.model.product.Meal;
import org.gitproject.restaurantapp.model.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractOrderCalculatorTest {

	private AbstractOrderCalculator orderCalculatorTest=new AbstractOrderCalculator() {

		@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getVATRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	@Test
	public void testCalculateTotalOrderAmount() {
		
		double expectedTotalOrderAmount=2.0;
		
		Product productTest=new Meal("Test-Burger",100,1);
		OrderItem orderItemTest=new OrderItem(productTest,OrderItemSize.MEDIUM,2);
		
		Order orderTest = new Order();
		orderTest.getOrderItems().add(orderItemTest);
		
		double totalOrderAmount=orderCalculatorTest.calculateTotalOrderAmount(orderTest);
		
		Assertions.assertEquals(expectedTotalOrderAmount,totalOrderAmount);
		
		
		
		
		
	}
}

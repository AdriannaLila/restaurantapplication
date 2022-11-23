package org.gitproject.restaurantapp.controller.order;
import org.gitproject.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.gitproject.restaurantapp.model.order.OrderItemSize;
/**
 * Order Calculator for Kosovo
 * @author Anna Lila
 *
 */
public class OrderCalculatorKS extends AbstractOrderCalculator{ 
	
	private final double VAT_RATE=0.18;
	public double getSizeRateAmount(OrderItemSize orderItemSize) {
	
		switch(orderItemSize) {
		case SMALL : return 0.7;
		
		case MEDIUM : return 1;

		case LARGE : return 1.2;
	
		case XXL : return 1.25;
			
		default: 
			throw new InvalidOrderItemSizeException("No valid order item size: " +orderItemSize);	
			}

	}
public double getVATRate() {
		
		return VAT_RATE;
	}
}

package org.gitproject.restaurantapp.controller.order;
import org.gitproject.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.gitproject.restaurantapp.model.order.OrderItemSize;
public class OrderCalculatorGER extends AbstractOrderCalculator {
	
	private final double VAT_RATE=0.19;
	
	public double getSizeRateAmount(OrderItemSize orderItemSize){
		switch(orderItemSize) {
		case SMALL : return 0.8;
		
		case MEDIUM : return 1;

		case LARGE : return 1.25;
	
		case XXL : return 1.3;
			
		default: 
			throw new InvalidOrderItemSizeException("No valid order item size: " + orderItemSize);
			
		}

	}

	public double getVATRate() {
		
		return VAT_RATE;
	}
}

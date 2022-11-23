package org.gitproject.restaurantapp.model.order;
import org.gitproject.restaurantapp.controller.order.OrderCalculatorKS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderCalculatorKSTest {
	OrderCalculatorKS orderCalculatorTest=new OrderCalculatorKS();
	
     @Test
	public void testGetVATRate() {
		
    	 double expectedVATRate=0.18;
		double vatRate = orderCalculatorTest.getVATRate();
		System.out.println("VAT Rate: " + vatRate);
		Assertions.assertEquals(expectedVATRate,vatRate);
		
	}
     
     @Test
 	public void testGetSizeRateAmount() {
    	 double sizeRateAmountForSmallSize=orderCalculatorTest.getSizeRateAmount(OrderItemSize.SMALL);   
    	 Assertions.assertEquals(0.7,sizeRateAmountForSmallSize);
     }

}

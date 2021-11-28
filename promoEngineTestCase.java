package testCases;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import promotionEngine.PriceCalculator;

public class promoEngineTestCase {
	   @Test  
	    public void testCalculateTotalPrice(){  
		PriceCalculator obj = new PriceCalculator();
	        assertEquals(100,obj.calculateTotalPrice(new String[]{"A","B","C"}));  
	        assertEquals(370,obj.calculateTotalPrice(new String[]{"A","A","A","A","A","B","B","B","B","B","C"}));  
	        assertEquals(280,obj.calculateTotalPrice(new String[]{"A","A","A","B","B","B","B","B","C","D"}));  
		assertEquals(80,obj.calculateTotalPrice(new String[]{"A","B","E"})); 
		assertEquals(0,obj.calculateTotalPrice(null)); 
		assertEquals(0,obj.calculateTotalPrice(new String[] {"E","F","G"})); 
	    } 
}

package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.test;

public class CalculatorTest{

	@Test 
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}
}
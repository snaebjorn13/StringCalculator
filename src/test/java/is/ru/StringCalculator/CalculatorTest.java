package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("is.ru.StringCalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}
}
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

	@Test
	public void TestTwoNumber(){
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testOneTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testOneTwoThreeNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testOneTwoThreeFourNumbers(){
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testOneNewlineTwoThreeNumbers(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testOneNewlTwoNewlThreeNewlFourNumbers(){
		assertEquals(10, Calculator.add("1\n2\n3\n4"));
	}

	@Test
	public void testDelimiterSemiColon(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDelimiterqWithComma(){
		assertEquals(6, Calculator.add("//q\n1q2,3"));
	}

	@Test
	public void testDelimiterSemicolonWithNewline(){
		assertEquals(6, Calculator.add("//;\n1;2\n3"));
	}

	@Test
	public void testDelimiterpWithCommaAndNewline(){
		assertEquals(10, Calculator.add("//p\n1p2,3\n4"));
	}

	@Test
	public void testMinusOneTwoNumber(){
		try{
			int sum = Calculator.add("-1,2");
		} catch(IllegalArgumentException ex){
			assertEquals(ex.getMessage(), "Negatives not allowed: -1");
		}
	}
}
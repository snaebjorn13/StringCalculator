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
	public void testDelimiterw(){
		assertEquals(6, Calculator.add("//w\n1w2w3"));
	}

	@Test
	public void testDelimiterMetaChar(){
		assertEquals(10, Calculator.add("//*\n1*2*3*4"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExpressionThrown(){
		int sum = Calculator.add("-1,2");
	}

	@Test
	public void testMinusOneTwoNumbers(){
		try{
			int sum = Calculator.add("-1,2");
		} catch(IllegalArgumentException ex){
			assertEquals(ex.getMessage(), "Negatives not allowed: -1");
		}
	}

	@Test
	public void testMinusOneTwoMinusThreeNumbers(){
		try{
			int sum = Calculator.add("-1,2,-3");
		} catch(IllegalArgumentException ex){
			assertEquals(ex.getMessage(), "Negatives not allowed: -1, -3");
		}
	}

	@Test
	public void testThousandAndOneTwoNumbers(){
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testThousandAndOneThousandAndTwoThousandAndThreeNumbers(){
		assertEquals(0, Calculator.add("1001,1002,1003"));
	}

	@Test
	public void testDelimiterOfAnyLength(){
		assertEquals(10, Calculator.add("//[***]\n1***2***3***4"));
	}
}
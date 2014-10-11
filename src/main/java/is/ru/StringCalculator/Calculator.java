package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		 if(text.equals("")){
		 	return 0;
		 }
		 else if(text.contains(",")){
		 	String[] numbers = split(text);
		 	if(numbers.length == 2){
		 		return toInt(numbers[0]) + toInt(numbers[1]);
		 	}
		 	else{
		 		return toInt(numbers[0]) + toInt(numbers[1]) + toInt(numbers[2]);
		 	}
		 }
		 else{
		 	return toInt(text);
		 }
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] split(String text){
		return text.split(",");
	}

}
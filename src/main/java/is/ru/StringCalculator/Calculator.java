package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			negativeNumbers(text);
		}
		if(text.length() > 4){
			if(text.substring(0, 2).equals("//")){
				return customDelimiter(text);
			}
		}
		if(text.contains(",")){
			if(text.contains("\n")){
				return splitByCommaAndNewline(text);

			}
			return splitByDelimiter(text, ",");
		}
		if(text.contains("\n")){
			return splitByDelimiter(text, "\n");
		}
		return toInt(text);
	}

	private static void negativeNumbers(String text) throws IllegalArgumentException{
		String[] parts = text.split("-");
		String number = "-" + parts[1].substring(0, 1);
		String message = "Negatives not allowed: " + number;
		throw new IllegalArgumentException(message);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] split(String text){
		return text.split(",");
	}

	private static int splitByDelimiter(String text, String delimiter){
		String[] numbers = text.split(delimiter);
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			sum += toInt(numbers[i]);
		}
		return sum;
	}

	private static int splitByCommaAndNewline(String text){
		String[] texts = text.split("\n");
		int sum = 0;
		for(int i = 0; i < texts.length; i++){
			sum += splitByDelimiter(texts[i], ",");
		}
		return sum;
	}

	private static int customDelimiter(String text){
		String delimiter = text.substring(2, 3);
		String equation = text.substring(4);
		String[] numbers = equation.split(delimiter);
		int sum = 0;
		if(equation.contains(",") && equation.contains("\n")){
			for(int i = 0; i < numbers.length; i++){
				sum += splitByCommaAndNewline(numbers[i]);
			}
		}
		else if(equation.contains(",")){
			for(int i = 0; i < numbers.length; i++){
				sum += splitByDelimiter(numbers[i], ",");
			}
		}
		else if(equation.contains("\n")){
			for(int i = 0; i < numbers.length; i++){
			sum += splitByDelimiter(numbers[i], "\n");
			}
		}
		else{	
			for(int i = 0; i < numbers.length; i++){
				sum += toInt(numbers[i]);
			}
		}
		return sum;
	}
}	
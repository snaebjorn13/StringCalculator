package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			// throw exception along with message detailing
			// which numbers in the input are negative
			negativeNumbers(text);
		}
		if(text.length() > 4){
			if(text.substring(0, 2).equals("//")){
				// if a custom delimiter is chosen, we split by that
				// delimiter, possibly also by comma and newline
				return customDelimiter(text);
			}
		}
		if(text.contains(",")){
			// if text contains both \n and , we split by both delimiters
			if(text.contains("\n")){
				return splitByCommaAndNewline(text);

			}
			// if text only contains commas, we split by comma
			return splitByDelimiter(text, ",");
		}
		if(text.contains("\n")){
			// if text only contains newlines, we split by newline
			return splitByDelimiter(text, "\n");
		}
		// no delimiters, return the number
		return toInt(text);
	}

	private static void negativeNumbers(String text) throws IllegalArgumentException{
		String[] parts = text.split("-");
		String message = "Negatives not allowed: ";
		for(int i = 1; i < parts.length; i++){
			message += "-" + parts[i].substring(0,1);
			if(i < parts.length - 1){
				message += ", ";
			}
		}
		
		throw new IllegalArgumentException(message);
	}

	private static int toInt(String number){
		int int_number = Integer.parseInt(number);
		if(int_number > 1000){
			return 0;
		}
		return int_number;
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
		for(int i = 0; i < numbers.length; i++){
			sum += toInt(numbers[i]);
		}
		return sum;
	}
}	
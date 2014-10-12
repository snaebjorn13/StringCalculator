package is.ru.StringCalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.length() > 4){
			if(text.substring(0, 2).equals("//")){
				String delimiter = text.substring(2, 3);
				String[] numbers = text.substring(4).split(delimiter);
				int sum = 0;	
				for(int i = 0; i < numbers.length; i++){
					sum += toInt(numbers[i]);
				}
				return sum;
			}
		}
		if(text.contains(",")){
			if(text.contains("\n")){
				return splitByCommaAndNewline(text);

			}
			return splitByComma(text);
		}
		if(text.contains("\n")){
			return splitByNewline(text);
		}
		return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] split(String text){
		return text.split(",");
	}

	private static int splitByNewline(String text){
		String[] numbers = text.split("\n");
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
			sum += splitByComma(texts[i]);
		}
		return sum;
	}

	private static int splitByComma(String text){
		String[] numbers = split(text);
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			sum += toInt(numbers[i]);
		}
		return sum;
	}

}
package test.selenium;

public class SumIntFromString {

	public static void main(String[] args) {
		String s = "assf123ggghg456";
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				// sum=sum+Integer.valueOf(s.charAt(i));
				sum = sum + Character.getNumericValue(s.charAt(i));
			}
		}
		System.out.println("Sum : " + sum);	}
}

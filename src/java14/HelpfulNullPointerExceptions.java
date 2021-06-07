package java14;

import java.util.Locale;

public class HelpfulNullPointerExceptions {

	public static void main(String[] args) {
		
		String input = null;
        String result = showUpperCase(input); // NullPointerException
        System.out.println(result);

	}
	
	public static String showUpperCase(String str){
        return str.toUpperCase(Locale.US);
    }

}

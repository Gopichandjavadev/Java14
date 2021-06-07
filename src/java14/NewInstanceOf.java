package java14;

public class NewInstanceOf {

	public static void main(String[] args) {
		
		Object obj = "string";
		
		if (obj instanceof String str) {
		    int len = str.length();
		    System.out.println(len);
		}
		
		User user = new User(0, null);
		user.id();
		user.password();
	}
}

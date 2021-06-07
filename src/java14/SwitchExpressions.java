package java14;

public class SwitchExpressions {

	public static void main(String[] args) {
		 String day = "MONDAY";
		 
		boolean isTodayHoliday = switch (day) {
	    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
	    case "SATURDAY", "SUNDAY" -> true;
	    default -> throw new IllegalArgumentException("What's a " + day);
	};
	
	System.out.println("day is holiday "+isTodayHoliday);

	}

}

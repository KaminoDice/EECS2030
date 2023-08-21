public class EnumDemo1 {

	public static void main(String[] args) {
		Month month = Month.JULY;
		System.out.println(month);

		someMethod(Month.JULY);
	}

	public enum Month {
		JANUARY, FEBRUARY,
		  MARCH, APRIL,
		  MAY, JUNE,
		  JULY, AUGUST,
		  SEPTEMBER, OCTOBER, 
		  NOVEMBER, DECEMBER;
	}
	
	public static void someMethod (Month month){
		System.out.println("someMethod(" + month + ");");
	}

	public static void someMethod (int month){
		System.out.println("someMethod(" + month + ");");
	}
}
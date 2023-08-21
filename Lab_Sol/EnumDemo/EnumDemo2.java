import java.util.Arrays;

public class EnumDemo2 {

	public static void main(String[] args) {
		Month month = Month.JULY;
		System.out.println(month);
		System.out.println(month.days);

		month = Month.FEBRUARY;
		System.out.println(month);
		System.out.println(month.days); //accessible, because Month is a nested type
		System.out.println(month.days(2020));
		System.out.println(month.days(1900));
		System.out.println(month.days(1600));
		System.out.println(month.days(2000));
		System.out.println(month.days(2100));

		System.out.println(Arrays.toString(Month.values()));
		for (Month m : Month.values()) {
			System.out.println(m + " " + m.days(2021));
		}

	}


	enum Month {
		JANUARY(31),
		FEBRUARY(28),
		MARCH(31), 
		APRIL(30),
		MAY(31), 
		JUNE(30),
		JULY(31), 
		AUGUST(31),
		SEPTEMBER(30), 
		OCTOBER(31), 
		NOVEMBER(30), 
		DECEMBER(31);

		private final int days;

		Month(int days) {
			this.days = days;
		}

		public int days(int year) {
			if (this != FEBRUARY) {
				return this.days;
			}
			if (year % 400 == 0 || 
					(year % 4 == 0 && year % 100 != 0)) {
				return this.days + 1;
			}
			return this.days;
		}
	}
}
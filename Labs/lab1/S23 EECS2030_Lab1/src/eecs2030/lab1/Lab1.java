package eecs2030.lab1;

/**
 * Short methods reviewing fundamental Java concepts covered in EECS1021,
 * EECS1022, or EECS1720
 * 
 * @author EECS2030
 *
 */
public class Lab1 {

	/**
	 * The course name for EECS2030.
	 */
	public static final String COURSE_NAME = "EECS 2030: Advanced Object Oriented Programming";

	private Lab1() {
		// empty by design
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		return java.lang.Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minPositiveDouble() {
		return java.lang.Double.MIN_NORMAL;
	}

	/**
	 * Removes the last three digits of a positive integer base-10 number. If
	 * <code>n</code> is less than <code>1000</code> then the value of
	 * <code>0</code> is returned.
	 * 
	 * 
	 * @param n
	 *            a positive integer
	 * @return the integer produced by removing the last three digits of n, or 0
	 *         if n is less than 1000
	 */
	public static int removeLastThreeDigits(int n) {
		return n/1000;
	}

	/**
	 * Returns the last three digits of a positive integer base-10 number. If the
	 * third last digit is a <code>0</code> then only the last two digits are
	 * returned, etc. If <code>n</code> is less than <code>1000</code> then the value
	 * of <code>n</code> is returned.
	 * 
	 * @param n
	 *            a positive integer
	 * @return the last three digits of n, or the last one or two digits of n if the second
	 *         last or third last digits are 0
	 */
	public static int lastThreeDigits(int n) {
		return n-1000*removeLastThreeDigits(n);
	}

	/**
	 * Returns the second byte of an integer number. 
	 * @param n
	 *            an integer
	 * @return the last three digits of n, or the last one or two digits of n if the second
	 *         last or third last digits are 0
	 */
	public static byte secondByte(int n) {
		return (byte) ((n & 0x0000FF00) >> 8);
	}

	/**
	 * Compute the average of three values as a <code>double</code> value.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 * @param b
	 *            a third value
	 * @return the average of the three values
	 */
	public static double avg(int a, int b, int c) {
		double result = 0.0;
		result +=a;
		result +=b;
		result +=c;
		return result/3;
	}

	/**
	 * Returns the Terminal velocity on an object in m/s in air at sea level,
	 * based on mass (in kg), drag coefficient, and projected area (in m^2) 
	 * 
	 * <p>
	 * 
	 * @param mass
	 *            object mass in kg
	 * @param area
	 *            projected area in m^2
	 * @param c_d
	 *            drag coefficient
	 * @return terminal velocity in m/s
	 * @see <a href="https://en.wikipedia.org/wiki/Terminal_velocity">
	 *      Wikipedia article on Terminal velocity
	 *      find and use all the constants needed</a>
	 */
	public static double terminalVelocity(double mass, double area, double c_d) {
		final double AIR_DENSITY = 1.2929977101;
		final double GRAVITY_ACC = 9.80665;
		double result = 0.0;
		result = java.lang.Math.sqrt(2*mass*GRAVITY_ACC/(AIR_DENSITY*area*c_d));
		return result;
	}

	/**
	 * Determine if an integer <code>x</code> is even.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is even and false otherwise
	 */
	public static boolean isEven(int x) {
		return x % 2 == 0;
	}

	/**
	 * Determine if the coordinates <code>(x, y)</code> describe a unit vector 
	 * 
	 * @param x
	 *            the x-coordinate of a vector
	 * @param y
	 *            the y-coordinate of a vector
	 * @return true if (x, y) is a unit vector
	 *         and false otherwise
	 */
	public static boolean isUnitVector(double x, double y) {
		return java.lang.Math.pow(x, 2) + java.lang.Math.pow(y, 2) == 1;
	}

	/**
     * Enrolls a student with a specified SID
     * 
     * @param studentNumber a student number
     * @return true 
     * @throws BadSIDException 
     *           if x is not a 9-digit number.
     */
	public static boolean enrolStudent(int studentNumber) {
		if (!(java.lang.Integer.toString(studentNumber).length() == 9)) {
			throw new BadSIDException();
		}
        return true;
	}

	
	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to Lab1.COURSE_NAME
	 */
	public static String getCourseName() {
		return COURSE_NAME;
	}

	/**
	 * Returns the character located in the middle of the string. If
	 * <code>s</code> has an even number of characters then the middle character
	 * is taken to be the last character in the first half of the string
	 * (i.e., the middle character of the string <code>"abcd"</code> is
	 * <code>'b'</code>.
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 * @return the middle character of s
	 * @throws IllegalArgmpumentException
	 *             if s is ety
	 */
	public static char middleChar(String s) {
		return s.charAt((s.length() +1) / 2 -1);
	}

	/**
	 * Returns the string formed by alternating the case of the characters in
	 * the specified string. The first character in the returned string is in
	 * uppercase, the second character is in lowercase, the third character is
	 * in uppercase, the fourth character is in lowercase, and so on.
	 * Examples:
	 * 
	 * <ul>
	 * <li><code>alternatingCaps("a")</code> returns <code>"A"</code>
	 * <li><code>alternatingCaps("ab")</code> returns <code>"Ab"</code>
	 * <li><code>alternatingCaps("abc")</code> returns <code>"AbC"</code>
	 * <li><code>alternatingCaps("XYZ")</code> returns <code>"XyZ"</code>
	 * <li><code>alternatingCaps("Toronto")</code> returns <code>"ToRoNto"</code>
	 * <li><code>alternatingCaps("eecs2030")</code> returns <code>"EeCs2030"</code>
	 * </ul>
	 * 
	 * <p>
	 * The conversion of characters to lower or uppercase is identical to 
	 * that performed by the methods <code>Character.toLowerCase(int)</code>
	 * and <code>Character.toLowerCase(int)</code>
	 * 
	 * @param s
	 *            a string
	 * @return the string formed by alternating the case of the characters in s
	 */
	public static String alternatingCaps(String s) {
		StringBuilder alCaps = new StringBuilder();
		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if ( i%2 != 0 ){
				alCaps.append(Character.toLowerCase(c));
			}else {
				alCaps.append(Character.toUpperCase(c));
			}
		}
		return alCaps.toString();
	}

}

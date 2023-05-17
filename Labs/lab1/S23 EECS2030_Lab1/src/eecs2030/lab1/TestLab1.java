package eecs2030.lab1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab1 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static Random rng = new Random();

	@Test
	public void test01_maxInt() {
		assertEquals(Integer.MAX_VALUE, Lab1.maxInt());
	}

	@Test
	public void test02_minDouble() {
		assertEquals(0, Double.compare(Double.MIN_NORMAL, Lab1.minPositiveDouble()));
	}

	@Test
	public void test03_removeLastThreeDigits() {
		final int[] EXPECTED = { 1, 5, 9, 27, 345, 7821 };
		for (Integer exp : EXPECTED) {
			for (int i = 0; i < 1000; i++) {
				int n = i + 1000 * exp;
				String error = String.format("removeLastThreeDigits(%d) failed", n);
				assertEquals(error, exp.intValue(), Lab1.removeLastThreeDigits(n));
			}
		}
		assertEquals("removeLastThreeDigits(2147483647) failed", 2147483, Lab1.removeLastThreeDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test04_removeLastThreeDigits() {
		for (int n = 0; n < 1000; n++) {
			String error = String.format("removeLastTheeDigits(%d) failed", n);
			assertEquals(error, 0, Lab1.removeLastThreeDigits(n));
		}
	}

	@Test
	public void test05_lastThreeDigits() {
		final int[] FIRST_DIGITS = { 0, 1, 5, 9, 27, 345, 7821 };
		for (Integer d : FIRST_DIGITS) {
			for (int exp = 0; exp < 1000; exp++) {
				int n = 1000 * d + exp;
				String error = String.format("lastThreeDigits(%d) failed", n);
				assertEquals(error, exp, Lab1.lastThreeDigits(n));
			}
		}
		assertEquals("lastThreeDigits(2147483647) failed", 647, Lab1.lastThreeDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test06_avg() {
		rng.setSeed(6);
		for (int i = 0; i < 100; i++) {
			int a = rng.nextInt();
			int b = rng.nextInt();
			int c = rng.nextInt();
			double sum = 0.0 + a + b + c;
			String error = String.format("avg(%d, %d, %d) failed", a, b, c);
			assertEquals(error, sum, 3.0 * Lab1.avg(a, b, c), Math.ulp(sum));
		}
	}

	@Test
	public void test07_terminalVelocity() {
		final double[] MASS = { 0.0, 59.0, 0.1, 2000};
		final double[] AREA = { 1.0, 2.0, 0.01, 0.07};
		final double[] CX = { 1.0, 0.294, 0.47, 0.1 };
		final double[] RESULT = {0, 39.0134, 17.965, 2081.8146};
		for (int i = 0; i < MASS.length; i++) {
			double mass = MASS[i];
			double area = AREA[i];
			double c_x = CX[i];
			double result = RESULT[i];
			String error = String.format("terminalVelocity(%f, %f, %f) failed", mass, area, c_x);
			assertEquals(error, result, Lab1.terminalVelocity(mass, area, c_x), 1e-2);
		}
	}

	@Test
	public void test08_isEven() {
		rng.setSeed(8);
		for (int i = 0; i < 100; i++) {
			int even = 2 * rng.nextInt(Integer.MAX_VALUE / 2);
			int odd = even + 1;
			String error = String.format("isEven(%d) failed (returned true)", odd);
			assertFalse(error, Lab1.isEven(odd));

			error = String.format("isEven(%d) failed (returned false)", even);
			assertTrue(error, Lab1.isEven(even));
		}
	}

	@Test
	public void test09_isUnitVector() {
		rng.setSeed(9);
		// random vector shorter than 1.0
		for (int i = 0; i < 100; i++) {
			double radius = rng.nextDouble(); // less than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isUnitVector(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab1.isUnitVector(x, y));
		}
		// random vector longer than 1.0
		for (int i = 0; i < 100; i++) {
			double radius = 1.0 + rng.nextDouble() + Math.ulp(1.0); // greater
																	// than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isUnitVector(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab1.isUnitVector(x, y));
		}
		// exactly a unit vector
		final double[] X = { 1.0, 0.0, -1.0, 0.0 };
		final double[] Y = { 0.0, 1.0, 0.0, -1.0 };
		for (int i = 0; i < X.length; i++) {
			double x = X[i];
			double y = Y[i];
			String error = String.format("isUnitVector(%f, %f) failed (returned false)", x, y);
			assertTrue(error, Lab1.isUnitVector(x, y));
		}
	}

	@Test
	public void test10_enrolStudent() {
		int studentNumber = 123456789;
		String error = String.format("test10_enrolStudent(%d) failed (returned false)", studentNumber);
		assertTrue(error, Lab1.enrolStudent(studentNumber));

	}

	@Test
	public void test11_enrolStudent_throws() {
		for (int x = 0; x < 10; x++) {
			try {
				Lab1.enrolStudent(x);
				String error = String.format("enrolStudent(%s) should have thrown an exception", x);
				fail(error);
			} catch (BadSIDException ex) {
				// ok
			} catch (Exception ex) {
				fail("enrolStudent threw the wrong type of exception");
			}
		}

	}

	@Test
	public void test12_getCourseName() {
		assertEquals("getCourseName() failed", "EECS 2030: Advanced Object Oriented Programming", Lab1.getCourseName());
	}

	private static char randomChar() {
		return (char) (TestLab1.rng.nextInt('Z' - 'A') + 'A');
	}

	@Test
	public void test13_middleChar() {
		StringBuilder builder = new StringBuilder();
		int mid = 0;
		builder.append(TestLab1.randomChar());
		String s = builder.toString();
		String error = String.format("middleChar(%s) failed with s = %s", s, s);
		assertEquals(error, s.charAt(mid), Lab1.middleChar(s));
		//mid++;

		for (int i = 0; i < 500; i++) {
			builder.append(TestLab1.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab1.middleChar(s));

			mid++;
			builder.append(TestLab1.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab1.middleChar(s));

		}
	}

	private static class Pair {
		String exp;
		String in;

		public Pair(String exp, String in) {
			this.exp = exp;
			this.in = in;
		}
	}

	private static char randomCase(char c) {
		if (TestLab1.rng.nextBoolean()) {
			return Character.toLowerCase(c);
		} else {
			return Character.toUpperCase(c);
		}
	}

	private static Pair randomString(int n) {
		StringBuilder exp = new StringBuilder();
		StringBuilder in = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char c1 = TestLab1.randomChar();
			char c2 = TestLab1.randomChar();
			char lower = Character.toLowerCase(c1);
			char upper = c2;
			exp.append(upper);
			in.append(TestLab1.randomCase(upper));
			if (i < n - 1) {
				exp.append(lower);
				in.append(TestLab1.randomCase(lower));
			}
		}
		return new Pair(exp.toString(), in.toString());
	}

	@Test
	public void test14_alternatingCaps() {
		for (int length = 1; length < 1000; length++) {
			for (int i = 0; i < 10; i++) {
				Pair testCase = TestLab1.randomString(length);
				String error = String.format("alternatingCaps(\"%s\") failed", testCase.in);
				assertEquals(error, testCase.exp, Lab1.alternatingCaps(testCase.in));
			}
		}
	}
	@Test

	public void test15_2ndByte() {
		assertEquals("secondByte(0x1234) failed", 0x12, Lab1.secondByte(0x1234));
		assertEquals("secondByte(0x123456) failed", 0x34, Lab1.secondByte(0x123456));
		assertEquals("secondByte('A') failed", 0x0, Lab1.secondByte('A'));
		assertEquals("secondByte(-1) failed", (byte)0xFF, Lab1.secondByte(-1));
	}
}

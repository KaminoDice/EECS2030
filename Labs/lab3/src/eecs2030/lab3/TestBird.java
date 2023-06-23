package eecs2030.lab3;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBird {
	Bird b1 = new Bird("Pigeon", 360.0);
	Bird b2 = new Bird("Pigeon", 350.0);
	Bird b3 = new Bird("Chicken", 440.0);
	Bird b4 = new Bird("Chicken", 445.0);
	Bird b5 = new Bird("Pigeon", 380.0);
	Bird b6 = new Bird();
	Bird b7 = new Bird("Goose", 450.0);
	Bird b8 = new Bird("Duck", 450.0);

	@Test
	public void test01_Equals() {

		assertEquals(b1, b2);
		assertEquals(b3, b4);

		assertNotEquals(b1, b3);
		assertNotEquals(b2, b4);
		assertNotEquals(b1, b5);
		assertNotEquals(b2, b5);

		assertNotEquals(b6, b1);
		assertNotEquals(b6, b2);
		assertNotEquals(b6, b3);
		assertNotEquals(b6, b4);
		assertNotEquals(b6, b5);

	}

	@Test
	public void test02_HashCode() {

		assertEquals(b1.hashCode(), b2.hashCode());
		assertEquals(b3.hashCode(), b4.hashCode());

		assertNotEquals(b1.hashCode(), b3.hashCode());
		assertNotEquals(b2.hashCode(), b4.hashCode());
		assertNotEquals(b1.hashCode(), b5.hashCode());
		assertNotEquals(b2.hashCode(), b5.hashCode());

		assertNotEquals(b6.hashCode(), b1.hashCode());
		assertNotEquals(b6.hashCode(), b2.hashCode());
		assertNotEquals(b6.hashCode(), b3.hashCode());
		assertNotEquals(b6.hashCode(), b4.hashCode());
		assertNotEquals(b6.hashCode(), b5.hashCode());
	}

	@Test
	public void test03_ToString() {

		assertEquals("Bird{type='Pigeon', sizeGrams=360.0}", b1.toString());
		assertEquals("Bird{type='Goose', sizeGrams=450.0}", b7.toString());
	}

	@Test
	public void test04_CompareTo() {

		assertTrue(b1.compareTo(b2) == 0);
		assertTrue(b2.compareTo(b1) == 0);
		assertTrue(b3.compareTo(b4) == 0);
		assertTrue(b4.compareTo(b3) == 0);

		assertTrue(b1.compareTo(b3) < 0);
		assertTrue(b3.compareTo(b1) > 0);
		assertTrue(b2.compareTo(b4) < 0);
		assertTrue(b4.compareTo(b2) > 0);

		assertTrue(b1.compareTo(b5) < 0);
		assertTrue(b5.compareTo(b1) > 0);

		assertTrue(b2.compareTo(b6) < 0);
		assertTrue(b6.compareTo(b2) > 0);

		assertTrue(b7.compareTo(b8) > 0);
		assertTrue(b8.compareTo(b7) < 0);

	}
}

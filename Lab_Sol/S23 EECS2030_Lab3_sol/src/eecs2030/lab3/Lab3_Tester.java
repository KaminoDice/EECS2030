package eecs2030.lab3;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab3_Tester {

	@Test (timeout = 2000)
	public void testBirdFields_10pts() {
		final Field[] fields = Bird.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("Bird contains a public non-final field", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
	}

	@Test (timeout = 2000)
	public void testBirdConstrGetSizeGrams_10pts() {
		Bird trip = new Bird();
		assertEquals("Bird constructor or getSizeGrams failed", 350.0f, trip.getSizeGrams(), 1e-6);
	}

	@Test (timeout = 2000)
	public void testBirdConstrGetType_10pts() {
		Bird trip = new Bird(new String("Bird B"), 250.0f);
		assertTrue("Bird constructor or getType failed", trip.getType().equals("Bird B"));
	}

	@SuppressWarnings("unused")
	@Test
	public void testBirdConstrExceptions_10pts() {
		try {
			new Bird("Bird", -1.0);
			String error = String.format("Bird constructor failed to throw an exception");
			fail(error);
		} catch (Exception x) {
			// ok
		}
	}

	@Test (timeout = 2000)
	public void testBirdEquals_10pts() {
		Bird birdA = new Bird("Bird", 140);
		Bird birdB = new Bird("Bird", 149);
		Bird birdC = new Bird("Bird", 131);
		Bird birdD = new Bird("Bird2", 140);
		Bird birdE = new Bird("Bird", 156);
		Bird birdF = new Bird("Bird", 153);
		assertTrue("Bird equals failed 1", birdA.equals(birdA));
		assertTrue("Bird equals failed 2", birdA.equals(birdB));
		assertTrue("Bird equals failed 3", birdB.equals(birdC));
		assertTrue("Bird equals failed 4", !birdA.equals(birdD));
		assertTrue("Bird equals failed 5", !birdA.equals(birdE));
		assertTrue("Bird equals failed 6", !birdA.equals(birdF));
	}

	@Test (timeout = 2000)
	public void testBirdCompareTo_10pts() {
		Bird birdA = new Bird("Bird", 140);
		Bird birdB = new Bird("Bird", 149);
		Bird birdC = new Bird("Bird", 131);
		Bird birdD = new Bird("Bird2", 140);
		Bird birdE = new Bird("Bird", 156);
		Bird birdF = new Bird("Bird", 153);
		assertTrue("Bird compareTo failed 1.1", birdE.compareTo(birdA) > 0);
		assertTrue("Bird compareTo failed 1.2", birdD.compareTo(birdA) > 0);
		assertTrue("Bird compareTo failed 1.3", birdF.compareTo(birdA) > 0);
		assertTrue("Bird compareTo failed 2.1", birdA.compareTo(birdA) == 0);
		assertTrue("Bird compareTo failed 2.2", birdA.compareTo(birdB) == 0);
		assertTrue("Bird compareTo failed 2.3", birdA.compareTo(birdC) == 0);
		assertTrue("Bird compareTo failed 3.1", birdA.compareTo(birdE) < 0);
		assertTrue("Bird compareTo failed 3.2", birdA.compareTo(new Bird ("Bird", 153)) < 0);
		assertTrue("Bird compareTo failed 3.3", birdA.compareTo(new Bird ("BirdD", 140)) < 0);
	}

	@Test (timeout = 2000)
	public void testBirdHashCode_10pts() {
		Bird birdA = new Bird("Bird", 140);
		Bird birdB = new Bird("Bird", 149);
		Bird birdC = new Bird("Bird", 131);
		Bird birdD = new Bird("Bird2", 140);
		Bird birdE = new Bird("Bird", 156);
		Bird birdF = new Bird("Bird", 153);
		assertTrue("Bird hashCode failed 1", birdA.hashCode() == birdA.hashCode());
		assertTrue("Bird hashCode failed 2", birdA.hashCode() == birdB.hashCode());
		assertTrue("Bird hashCode failed 3", birdA.hashCode() == birdC.hashCode());
		assertTrue("Bird hashCode failed 4", birdA.hashCode() != birdD.hashCode());
		assertTrue("Bird hashCode failed 5", birdA.hashCode() != birdE.hashCode());
		assertTrue("Bird hashCode failed 6", birdA.hashCode() != birdF.hashCode());
	}

	@Test (timeout = 2000)
	public void testBirdToString_10pts() {
		Bird trip = new Bird("Bird A", 222.0f);
		assertTrue("Bird toString failed 1", !trip.toString().contains("@"));
		assertTrue("Bird toString failed 2", trip.toString().contains("Bird A"));
		assertTrue("Bird toString failed 3", trip.toString().contains("222"));
		System.out.println(trip);
	}

}

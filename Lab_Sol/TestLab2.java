package eecs2030.lab2;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab2 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static String encryptionKey1 = "ABCDEFGH";
	private static String encryptionKey2 = "2030";
	private static String plainTextShort = 
			"IN CRYPTOGRAPHY, A SUBSTITUTION CIPHER IS A METHOD OF ENCODING B";

	private static String encryptedTextShort = 
			"WGVYXOBJOTOR GOHYOYOJXUCT RJAFKUUSGYJOHBJBOJWVBWNXCBTAOS NVUOYAO";

	private static String encryptedTextShort2 = 
			"XMLYHEVG HNVQDEZQOSGDUTAO LAEYDEAZMYGEJVYEYEGHANGVEGXLVXEQESOMEJ";

	private static String decryptedTextShort = 
			"IN CRYPTOGRAPHY  A SUBSTITUTION CIPHER IS A METHOD OF ENCODING B";

	private static String plainText = 
			"In cryptography, a substitution cipher is a method of encoding by "
					+ "which units of plaintext are replaced with ciphertext, according to a "
					+ "fixed system; the \"units\" may be single letters (the most common), "
					+ "pairs of letters, triplets of letters, mixtures of the above, and so "
					+ "forth. The receiver deciphers the text by performing the inverse "
					+ "substitution.";

	private static String encryptedText = 
			"WGVYXOBJOTOR GOHYOYOJXUCT RJAFKUUSGYJOHBJBOJWVBWNXCBTAOS NVUOYAO"
					+ "XYGGGXYWZJLOLYTWOKATO OJJVJTWOABOU Y JAGNROEAZXOWOUAAWETXBYOHJYH"
					+ "YAFRGUYAOEAOFJYXONXVAOOVBHOUNSAOSJYOOVAYUKVAOOLOOOOJOLTFGVYYCAVB"
					+ "B OOYYJBWOKVAAFOUVYJKVTXFGLOVYEKOOBTLLOVYOOA OOAFJAYOAYOBTYTBTRY"
					+ "CHYTOTAAGUTOTAY OOYJJXCTBOXAHVETOGBAAXOOAOKXP ANPVOWAOYKABOAWYOB"
					+ "SPCBOOOOUURJOOOOAAYOOOOOOAVUOOOOJJVYOOOOFOOROOOOYTYOOOOOXVJOOOOO";

	private static String decryptedText = 
			"IN CRYPTOGRAPHY  A SUBSTITUTION CIPHER IS A METHOD OF ENCODING B"
					+ "Y WHICH UNITS OF PLAINTEXT ARE REPLACED WITH CIPHERTEXT  ACCORDI"
					+ "NG TO A FIXED SYSTEM  THE  UNITS  MAY BE SINGLE LETTERS  THE MOS"
					+ "T COMMON   PAIRS OF LETTERS  TRIPLETS OF LETTERS  MIXTURES OF TH"
					+ "E ABOVE  AND SO FORTH  THE RECEIVER DECIPHERS THE TEXT BY PERFOR"
					+ "MING THE INVERSE SUBSTITUTION                                   ";

	@Test
	public void test01_encrypt1() {
		String result = Encryption.encrypt(plainText, encryptionKey1);
		System.out.println(result);
		System.out.println("test01_encrypt1\nExpected:");
		System.out.println(encryptedText);
		assertTrue(result.equals(encryptedText));
		System.out.println();
	}

	@Test
	public void test02_decrypt1() {
		String result = Encryption.decrypt(encryptedText, encryptionKey1);
		System.out.println(result);
		System.out.println("test02_decrypt1\nExpected:");
		System.out.println(decryptedText);
		assertTrue(result.equals(decryptedText));
		System.out.println();
	}

	@Test
	public void test03_encrypt2() {
		String result = Encryption.encrypt(plainTextShort, encryptionKey1);
		String expected = encryptedTextShort;
		System.out.println(result);
		System.out.println("test03_encrypt2\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test
	public void test04_decrypt2() {
		String result = Encryption.decrypt(encryptedTextShort, encryptionKey1);
		String expected = decryptedTextShort;
		System.out.println(result);
		System.out.println("test04_decrypt2\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test
	public void test05_encrypt3() {
		String result = Encryption.encrypt(" ".repeat(64), encryptionKey1);
		String expected = "O".repeat(64);
		System.out.println(result);
		System.out.println("test05_encrypt3\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test
	public void test06_decrypt3() {
		String result = Encryption.decrypt(" ".repeat(64), encryptionKey1);
		String expected = "P".repeat(64);
		System.out.println(result);
		System.out.println("test06_decrypt3\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test
	public void test07_encrypt4() {
		String result = Encryption.encrypt(plainTextShort, encryptionKey2);
		String expected = encryptedTextShort2;
		System.out.println(result);
		System.out.println("test07_encrypt3\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test
	public void test08_decrypt4() {
		String result = Encryption.decrypt(encryptedTextShort2, encryptionKey2);
		String expected = decryptedTextShort;
		System.out.println(result);
		System.out.println("test08_decrypt3\nExpected:");
		System.out.println(expected);
		System.out.println();
		assertTrue(result.equals(expected));
	}

	@Test (timeout = 2000)
	public void testCakeFields() {
		final Field[] fields = Encryption.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("Encryption contains a public non-final field", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
	}

	@Test
	public void testEncryptionConstructors() {
		final Constructor<?>[] constructors = Encryption.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			assertTrue("Encryption contains a non-private constructor", Modifier.isPrivate(constructor.getModifiers()));
		}
	}

}

package eecs2030.lab2;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab2 {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	private static String encryptionKey = "ABCDEFGH";
	private static String plainText = "In cryptography, a substitution cipher is a method of encoding by "
			+ "which units of plaintext are replaced with ciphertext, according to a "
			+ "fixed system; the \"units\" may be single letters (the most common), "
			+ "pairs of letters, triplets of letters, mixtures of the above, and so "
			+ "forth. The receiver deciphers the text by performing the inverse " + "substitution.";

	private static String encryptedText = "WGVYXOBJOTOR GOHYOYOJXUCT RJAFKUUSGYJOHBJBOJWVBWNXCBTAOS NVUOYAO"
			+ "XYGGGXYWZJLOLYTWOKATO OJJVJTWOABOU Y JAGNROEAZXOWOUAAWETXBYOHJYH"
			+ "YAFRGUYAOEAOFJYXONXVAOOVBHOUNSAOSJYOOVAYUKVAOOLOOOOJOLTFGVYYCAVB"
			+ "B OOYYJBWOKVAAFOUVYJKVTXFGLOVYEKOOBTLLOVYOOA OOAFJAYOAYOBTYTBTRY"
			+ "CHYTOTAAGUTOTAY OOYJJXCTBOXAHVETOGBAAXOOAOKXP ANPVOWAOYKABOAWYOB"
			+ "SPCBOOOOUURJOOOOAAYOOOOOOAVUOOOOJJVYOOOOFOOROOOOYTYOOOOOXVJOOOOO";

	private static String decryptedText = "IN CRYPTOGRAPHY  A SUBSTITUTION CIPHER IS A METHOD OF ENCODING B"
			+ "Y WHICH UNITS OF PLAINTEXT ARE REPLACED WITH CIPHERTEXT  ACCORDI"
			+ "NG TO A FIXED SYSTEM  THE  UNITS  MAY BE SINGLE LETTERS  THE MOS"
			+ "T COMMON   PAIRS OF LETTERS  TRIPLETS OF LETTERS  MIXTURES OF TH"
			+ "E ABOVE  AND SO FORTH  THE RECEIVER DECIPHERS THE TEXT BY PERFOR"
			+ "MING THE INVERSE SUBSTITUTION                                   ";

	@Test
	public void test01_encrypt1() {
		System.out.println(Encryption.encrypt(plainText, encryptionKey));
		System.out.println("Expected:");
		System.out.println(encryptedText);
		assertTrue(Encryption.encrypt(plainText, encryptionKey).equals(encryptedText));
		// assertEquals(Encryption.encrypt(plainText, encryptionKey), encryptedText);
	}

	@Test
	public void test02_decrypt1() {
		System.out.println(Encryption.decrypt(encryptedText, encryptionKey));
		System.out.println("Expected:");
		System.out.println(decryptedText);
		assertTrue(Encryption.decrypt(encryptedText, encryptionKey).equals(decryptedText));
		// assertEquals(Encryption.decrypt(encryptedText, encryptionKey),
		// decryptedText);
	}

	private static Random rng = new Random();
	private static Random lengs = new Random();

	private static char randomChar() {
		return (char) (TestLab2.rng.nextInt('Z' - 'A') + 'A');
	}

	@Test
	public void test03_randomatch() {
		StringBuilder origText = new StringBuilder();
		StringBuilder randomKey = new StringBuilder();

		for (int i = 0; i < 128 + lengs.nextInt(128); i++) {
			origText.append(TestLab2.randomChar());
		}

		System.out.println("OriginText: ");
		System.out.println(origText.toString());

		for (int i = 0; i < 4 + lengs.nextInt(60); i++) {
			randomKey.append(TestLab2.randomChar());
		}

		System.out.println("GenerateKey: ");
		System.out.println(randomKey.toString());
		System.out.println("EncrypText: ");
		String encryText = Encryption.encrypt(origText.toString(), randomKey.toString());
		System.out.println(encryText);

		System.out.println("DecrypText: ");
		String decryText = Encryption.decrypt(encryText.toString(), randomKey.toString());
		System.out.println(decryText);

		assertEquals(String.format("%-1024s", origText), String.format("%-1024s", decryText));
	}
}

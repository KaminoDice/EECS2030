package eecs2030.lab2;

import java.util.HashMap;
import java.util.Random;

/**
 * Lab for reviewing array and String manipulation in Java and 
 * an intro to utility classes and static features 
 * 
 * @author saikoro(Huanrui Cao/219256809)@EECS2030
 *
 */
public class Encryption {
	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	
	public static String encrypt(String textToEncrypt, String key) {
		int hashSeed = key.hashCode();
		HashMap<Character, Character> subsMap = hashMap(hashSeed);
		
		StringBuilder encryStr = new StringBuilder();
		for (int i = 0; i < textToEncrypt.length(); i += 64) {
			String chunk = textToEncrypt.substring(i, Math.min(i + 64, textToEncrypt.length()));
			String subsChunk = toSubs(chunk, subsMap);
			encryStr.append(toTrans(subsChunk, hashSeed));
			//encryStr.append(subChunk);
		}	
		
		return encryStr.toString();
	}

	public static String decrypt(String textToDecrypt, String key) {
		int hashSeed = key.hashCode();
		HashMap<Character, Character> subsMap = hashMap(hashSeed);
		HashMap<Character, Character> inveMap = new HashMap<Character, Character>();
		subsMap.forEach((ori, subs) -> inveMap.put(subs, ori));
		
		
		return textToDecrypt;
	}
	
/*
	public static void main(String[] args) {
		System.out.println(encrypt(ALPHABET, "ABCDEFGH"));
	}
*/
	
	public static HashMap<Character, Character> hashMap(int hashSeed){
		Random r = new Random(hashSeed);
		StringBuilder subString = new StringBuilder(ALPHABET);
		HashMap<Character, Character> subsMap = new HashMap<Character, Character>();
		
		for (int i = 0; i < 100; i++) {
			int pos1 = r.nextInt(ALPHABET.length());
			int pos2 = r.nextInt(ALPHABET.length());
			char pos1Char = subString.charAt(pos1);
			subString.setCharAt(pos1, subString.charAt(pos2));
			subString.setCharAt(pos2, pos1Char);
		}
		
		for (int i = 0; i < ALPHABET.length(); i++) {
			subsMap.put(ALPHABET.charAt(i),  subString.charAt(i));
		}
		
		return subsMap;
		
	}
	
	public static String toSubs(String chunk, HashMap<Character, Character> subsMap) {
		StringBuilder subsChunk = new StringBuilder();
		//String coverChunk = String.format("%-64s", chunk);
		
		for (int i = 0; i < chunk.length(); i++) {
			char subsChar = subsMap.getOrDefault(Character.toUpperCase(chunk.charAt(i)), subsMap.get(ALPHABET.charAt(ALPHABET.length()-1)));
			subsChunk.append(subsChar);
		}

		for (int i = chunk.length(); i < 64; i++) {
			char subsChar = subsMap.get(ALPHABET.charAt(ALPHABET.length()-1));
			subsChunk.append(subsChar);
		}

		return subsChunk.toString();
	}
	
	
	public static String toTrans(String subsChunk, int hashSeed) {
		Random random = new Random(hashSeed);
		int[] pattern = {0, 1, 2, 3, 4, 5, 6, 7};
		
		for (int i = 0; i < 100; i++) {
			int in1 = random.nextInt(pattern.length);
			int in2 = random.nextInt(pattern.length);
			int tp = pattern[in1];
			pattern[in1] = pattern[in2];
			pattern[in2] = tp;
		}
/*		
		for (int i = 0; i < pattern.length; i++) {
			System.out.println(pattern[i]);
		}
*/		
		//System.out.println(subsChunk);
		StringBuilder transChunk = new StringBuilder();
		for (int i = 0; i < subsChunk.length(); i++) {
			int col = pattern[i / pattern.length];
			int row = i % pattern.length;
			int index = col + row * pattern.length;
			//System.out.println(index);
			transChunk.append(subsChunk.charAt(index));
			//System.out.println(transChunk.toString());
		}
		
		return transChunk.toString();
	}
	
}

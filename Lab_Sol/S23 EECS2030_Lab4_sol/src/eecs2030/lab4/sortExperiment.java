package eecs2030.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortExperiment {
	private static Random rng = new Random();

	public static void main(String[] args) {
		List <Integer> list;
		long start, end;

		//You might need to change the 1M value to something smaller for other sorts
		for (int i = 1000; i <= 8_000; i *= 2){ 
			System.out.println("N = " + i);
			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.defaultSort(list);
			end = System.nanoTime();
			System.out.println("Time spent (D): " + (end - start)/1e6 + " ms");

			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.insertionSortIterative(list);
			end = System.nanoTime();
			System.out.println("Time spent (I): " + (end - start)/1e6 + " ms");

			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.insertionSortRecursive(list);
			end = System.nanoTime();
			System.out.println("Time spent (R): " + (end - start)/1e6 + " ms\n");
		}
	}

	private static List <Integer> createRandomList (int size){
		rng.setSeed(8);
		List <Integer> list = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			list.add(rng.nextInt());
		}
		return list;
	}


}

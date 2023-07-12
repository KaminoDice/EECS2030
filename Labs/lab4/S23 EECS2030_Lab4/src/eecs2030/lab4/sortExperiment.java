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
		// -Xss1024M to ignore the stack limit when test the Recursive Insertion method.
		for (int i = 1000; i <= 1_000_000; i *= 2){ 
			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.defaultSort(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\n Built-in mergesort, Time spent: " + (end - start)/1e6 + " ms");
			
			start = System.nanoTime();
            Lists.insertionSortIterative(list);
            end = System.nanoTime();
            System.out.println("Insertion-Iterative, Time spent: " + (end - start) / 1e6 + " ms");

            start = System.nanoTime();
            Lists.insertionSortRecursive(list);
            end = System.nanoTime();
            System.out.println("Insertion-Recursive, Time spent: " + (end - start) / 1e6 + " ms");
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

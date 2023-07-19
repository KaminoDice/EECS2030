package eecs2030.lab4;

//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortExperiment {
	private static Random rng = new Random();

	public static void main(String[] args) {
		List <Integer> list;
		long start, end;
		
		/*
		 * PrintStream ps = new PrintStream("testrun.txt"); System.setOut(ps);
		 */

		//You might need to change the 1M value to something smaller for other sorts
		// -Xss32M to ignore the stack limit when test the Recursive Insertion method.
		for (int i = 1000; i <= 1_000_000; i *= 2){ 
			list = createRandomList(i);
			List <Integer> list1 = new ArrayList<>(list);
			List <Integer> list2 = new ArrayList<>(list);
			
//			printListofFive(list);
			start = System.nanoTime();
			Lists.defaultSort(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\n Built-in mergesort, Time spent: " + (end - start)/1e6 + " ms");
//			printListofFive(list);
			
//			printListofFive(list1);
			start = System.nanoTime();
            Lists.insertionSortIterative(list1);
            end = System.nanoTime();
            System.out.println("Insertion-Iterative, Time spent: " + (end - start) / 1e6 + " ms");
//            printListofFive(list1);
            
//            printListofFive(list2);
            try{
            	start = System.nanoTime();
                Lists.insertionSortRecursive(list2);
                end = System.nanoTime();
                System.out.println("Insertion-Recursive, Time spent: " + (end - start) / 1e6 + " ms");
//                printListofFive(list2);
            }
            
            
            catch(StackOverflowError e){
                System.err.println("Insertion-Recursive Error: StackOverflow!! Please set -Xss above 32M \n");
            }
		}
//		ps.close();
	}

	private static List <Integer> createRandomList (int size){
		/*
		 * long t = System.currentTimeMillis(); rng.setSeed(t);
		 */
		rng.setSeed(8);
		
		List <Integer> list = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			list.add(rng.nextInt());
		}
		return list;
	}
	
	


	/*
	 * private static void printListofTen(List <Integer> list) {
	 * System.out.printf(": "); for (int i = 0; i < 10; i++) {
	 * System.out.printf("%d, ", list.get(i)); } System.out.println(""); }
	 */

}

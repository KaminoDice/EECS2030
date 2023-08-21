package eecs2030.lab4;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListsTester {
	private static Random rng = new Random();

	@Test (timeout = 2000)
	public void test01_defaultSort() {
		List <Integer> list = createRandomList(100);

		Lists.defaultSort(list);

		String error = "defaultSort failed (list not sorted)";
		checkSortedOrder (error, list);
	}

	@Test (timeout = 2000)
	public void test02_insertionSortRecursive() {
		List <Integer> list = createRandomList(100);
		Lists.insertionSortRecursive(list);
		String error = "insertionSortRecursive failed (list not sorted)";
		checkSortedOrder (error, list);
	}

	@Test (timeout = 2000)
	public void test03_insertionSortIterative() {
		List <Integer> list = createRandomList(100);

		Lists.insertionSortIterative(list);

		String error = "insertionSortIterative failed (list not sorted)";
		//System.out.println(list);
		checkSortedOrder (error, list);
	}

	@Test (timeout = 20000)
	public void test04_sortExperiment() {
		System.out.println("Expected:");
		sortExperimentModel.main(null);
		System.out.println("-------------------------------");
		
		System.out.println("Actual:");
		sortExperiment.main(null);
	}

	@Test (timeout = 1000) //will time out if not insertion sort
	public void test05_IterativeNotInsertionSort() {
		long start, end;
		//List <Integer> list = createRandomList(100_000);
		List <Integer> list = createSortedList(100_000);

		start = System.nanoTime();
		Lists.insertionSortIterative(list);
		end = System.nanoTime();
		System.out.println("Time spent (sorted - ISort): " + (end - start)/1e6 + " ms");

		String error = "test05_notInsertionSort failed 1 (list not sorted)";
		checkSortedOrder (error, list);

		list = createSortedList(10_0);
		start = System.nanoTime();
		Lists.defaultSort(list);
		end = System.nanoTime();
		System.out.println("Time spent (sorted - DSort): " + (end - start)/1e6 + " ms");

		error = "test05_notInsertionSort failed 2 (list not sorted)";
		checkSortedOrder (error, list);
	}

	@Test (timeout = 1000) //will time out or s/overflow if not insertion sort
	public void test06_RecursiveNotInsertionSort() {
		long start, end;
		List <Integer> list = createSortedList(10_000);
		//list = createRandomList(10_000);

		start = System.nanoTime();
		Lists.insertionSortRecursive(list);
		end = System.nanoTime();
		System.out.println("Time spent (sorted - ISortRec): " + (end - start)/1e6 + " ms");

		String error = "test06_notInsertionSort failed 1 (list not sorted)";
		checkSortedOrder (error, list);
	}

	@Test (timeout = 2000) //will time out if not insertion sort
	public void test07_RecursiveNotRecursive() {
		List <Integer> list = createSortedList(100_000);
		try {
			Lists.insertionSortRecursive(list);
			fail("Not recursive");
		} catch (StackOverflowError e) {
			//OK
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

	private static List <Integer> createSortedList (int size){
		List <Integer> list = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		return list;
	}

	private static void checkSortedOrder (String error, List <Integer> list){
		int prev = list.get(0);
		for (int item:list){
			assertTrue(error, item >= prev);
			prev = item;
		}
	}

}

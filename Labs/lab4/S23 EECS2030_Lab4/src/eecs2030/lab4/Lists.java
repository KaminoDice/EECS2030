package eecs2030.lab4;

import java.util.Comparator;
import java.util.List;

public class Lists {
	private Lists(){} //no objects of this class are desired
	
	public static <T extends Comparable <? super T>> void defaultSort(List <T> list){
		list.sort(Comparator.naturalOrder()); //will use a built-in variation of mergesort
											//alternative: Collections.sort(list);
	}
	

	/**
     * Sorts the given list using recursive insertion sort.
     *
     * @param list the list to sort
     * @param <T> element type, must implement Comparable interface
     */
	public static <T extends Comparable <? super T>> void insertionSortRecursive(List <T> list){
		//TODO implement the recursive solution
		//your solution may not use loops of any kind, neither directly, nor indirectly (e.g., in some helper method)
		insertionSortRecursiveHelper(list, list.size() - 1);
	}
	
	private static <T extends Comparable<? super T>> void insertionSortRecursiveHelper(List<T> list, int endIndex) {
	    if (endIndex <= 0) {
	        return;
	    }
	    insertionSortRecursiveHelper(list, endIndex - 1);
	    T key = list.get(endIndex);
	    int j = endIndex - 1;
	    shiftElementsAndInsert(list, key, j);
	}

	private static <T extends Comparable<? super T>> void shiftElementsAndInsert(List<T> list, T key, int j) {
	    if (j >= 0 && list.get(j).compareTo(key) > 0) {
	        T element = list.get(j);
	        list.set(j + 1, element);
	        shiftElementsAndInsert(list, key, j - 1);
	    } else {
	        list.set(j + 1, key);
	    }
	}
	
	
	/**
     * Sorts the given list using iterative insertion sort.
     *
     * @param list the list to sort
     * @param <T> element type, must implement Comparable interface
     */
	public static <T extends Comparable <? super T>> void insertionSortIterative(List <T> list){
		//TODO implement the Iterative solution
		for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
	}

}

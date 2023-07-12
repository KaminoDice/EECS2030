package eecs2030.lab4;

import java.util.Comparator;
import java.util.List;

public class Lists {
	private Lists(){} //no objects of this class are desired
	
	public static <T extends Comparable <? super T>> void defaultSort(List <T> list){
		list.sort(Comparator.naturalOrder()); //will use a built-in variation of mergesort
											//alternative: Collections.sort(list);
	}

	public static <T extends Comparable <? super T>> void insertionSortRecursive(List <T> list){
		//TODO implement the recursive solution
		//your solution may not use loops of any kind, neither directly, nor indirectly (e.g., in some helper method)
	}
	
	public static <T extends Comparable <? super T>> void insertionSortIterative(List <T> list){
		//TODO implement the Iterative solution
	}

}

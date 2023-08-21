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
		if(list.size() > 1) {
			insertionSortRecursive(list.subList(0, list.size() - 1)); //sort the first n - 1
			
			// remove the last element (n) and insert it in the sorted left side
			insertRecursive(list.remove(list.size() - 1), list.subList(0, list.size())); 
		}
	}
	
	private static <T extends Comparable <? super T>> void insertRecursive(T item, List <T> list){
		if (list.size() > 0 && item.compareTo(list.get(list.size() - 1)) < 0) {	//if item smaller than the last
			insertRecursive (item, list.subList(0, list.size() - 1));	//insert in the sublist before the last
		}
		else list.add(item);
	}

	public static <T extends Comparable <? super T>> void insertionSortIterative(List <T> list){
		for (int i = 1; i < list.size(); i++)
			for (int j = i; j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0; j--)
				swap(list, j, j - 1);
	}

	private static <T extends Comparable <? super T>> void swap (List <T> list, int pos1, int pos2){
		T temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}
}

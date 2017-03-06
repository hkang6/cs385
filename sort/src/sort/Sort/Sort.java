package sort;

import java.util.HashSet;
import java.util.Set;

/**I pledge my honor that i have abided by the stevens honor system
 * I would like this assignment to replace a homework grade
 * @author harkiratkang
 * Sort is a class that sorts an array into order, and only with type int
 */

public class Sort {

	
/**
 * 
 * Interval is a class that contructs an upper and lower bound
 *
 */
	private static class Interval {
		private int lower;
		private int upper;

		public Interval(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;

		}
		/**
		 * 
		 * @return lower bound
		 */

		public int getLower() {
			return this.lower;

		}
		/**
		 * 
		 * @return upper bound
		 */

		public int getUpper() {
			return this.upper;
		}
		
		/**
		 * returns boolean for whether interval upper and lower are lower than the upper and lower bounds
		 */

		public boolean equals(Object o) {
			if (((Interval) o).getLower() == this.lower && (((Interval) o)).getUpper() == this.upper) {
				return true;
			}
			return false;

		}
		
		/**
		 * 
		 * @returns a hashcode 
		 */
		public int hashCode() {
			return (this.lower * this.lower) + this.upper;

		}

	}
	/**
	 * swaps the two integers a and b
	 * @param table the table of integers
	 * @param a int a
	 * @param b int b
	 */

	public static <T extends Comparable <T>> void swap(T[] table, int a, int b){
		T temp = table[a];
		table[a] = table[b];
		table[b] = temp;
		}
	/**
	 * bubbleS3 sorts the elements, integers specifically, using bubble sort
	 * @param table the elements to sort
	 * @param first first element
	 * @param last last element
	 */
	public static <T extends Comparable <T>> void bubbleS3(T[] table, int first, int  last){
		int middle = first + (1-first)/2;
		if (table[middle].compareTo(table[first]) < 0){
			swap(table, first, middle);
		}
		if (table[last].compareTo(table[middle])< 0){
			swap(table, last, middle);
		}
		if (table[middle].compareTo(table[first]) < 0){
			swap(table, first, middle);
		}
		
	}
	
	/**
	 * partition is a function that moves elements around the pivot points to sort the table using a type of bubble sort
	 * @returns pivot point
	 * @param lower is lower bound
	 * @param upper is upper bound
	 */
	public static <T extends Comparable <T>> int partition(T[] table, int first, int last){
		bubbleS3(table, first, last);
		swap(table, first,(first + (1-first)/2));
		T pivot = table [first];
		int up = first;
		int down = last;
		do {
			while ((up <last) && (pivot.compareTo(table[up]) >= 0)) {
				up++;
			}
			while (pivot.compareTo(table[down]) < 0) {
				down--;
				
			}
			if (up < down){
				swap(table, up, down);
			}
		} while (up < down);
		
		swap(table, first, down);
		return down;
			
		}
	/**
	 * sort is a function that sorts your table
	 * @param array of elements that need to be sorted 
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		if (array.length <2){
			return;
		}
		Set<Interval> S = new HashSet<Interval>();
		S.add(new Interval(0, array.length-1)); 
		while(!S.isEmpty()){
			Interval x = (Interval) S.toArray()[0];
			S.remove(x);
			if (x.getLower() != x.getUpper()){
				int y = partition(array, x.getLower(), x.getUpper());
				S.add(new Interval(x.getLower(), Math.max(x.getLower(), y-1)));
				S.add(new Interval(Math.min(x.getUpper(), y+1), x.getUpper()));
			}
		}
	}
	
	public static void main(String[] args){
		Integer[] a = {1, 4, 34, 5, 2, 7};
		
		sort(a);
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	}


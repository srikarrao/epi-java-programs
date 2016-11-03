package com.eop.java.programs.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * JAVA program to find the length of largest subset of array elements
 * 
 * @author Srikar Rao
 *
 */
public class LongestContainedInterval {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(-2, -1, 0,
				1, 2, 3, 5, 7, 8, 8, 9));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(20, 5, 3, 9,
				6, 8, 4, 7));
		List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1, 10, 15,
				77, 100));

		System.out.println(getLength_arrays(list1));
		System.out.println(getLength_arrays(list2));
		System.out.println(getLength_arrays(list3));

		System.out.println("----------------------");

		System.out.println(getLength_hashtable(list1));
		System.out.println(getLength_hashtable(list2));
		System.out.println(getLength_hashtable(list3));

	}

	/**
	 * method to find the max lenght of subset using hashtable
	 * 
	 * @param list
	 * @return
	 */
	private static int getLength_hashtable(List<Integer> list) {
		int maxLength = 0;

		// inserting list elements to set
		Set<Integer> unprocessedEntries = new HashSet<Integer>(list);

		// iterate till all the set is empty
		while (!unprocessedEntries.isEmpty()) {
			// get element from set
			int val = unprocessedEntries.iterator().next();
			unprocessedEntries.remove(val); // remove element from set

			int lower = val - 1; // set lower number
			// iterate for lower level number
			while (unprocessedEntries.contains(lower)) {
				unprocessedEntries.remove(lower); // remove if found
				--lower;
			}

			int higher = val + 1; // set higher number
			// iterate for higher level number
			while (unprocessedEntries.contains(higher)) {
				unprocessedEntries.remove(higher); // remove if found
				++higher;
			}

			maxLength = Math.max(higher - lower - 1, maxLength); // find max
		}
		return maxLength;
	}

	/**
	 * method to find the max lenght of subset using array lists
	 * 
	 * @param list
	 * @return
	 */
	private static int getLength_arrays(List<Integer> list) {
		Collections.sort(list); // sort the array list
		int count = 1;
		int max = 1;

		/**
		 * iterate the sorted list to find the max length of a subset
		 */
		for (int i = 1; i < list.size(); i++) {
			// if i and (i-1)+1 values are equal then count
			if (list.get(i) == list.get(i - 1) + 1) {
				count++;
			} else {
				// find max count
				max = Math.max(count, max);
				count = 1;
			}
		}
		// finding max for the last element
		if (list.get(list.size() - 2) + 1 == list.get(list.size() - 1)) {
			max = Math.max(count, max);
		}
		return max;
	}
}

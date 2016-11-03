package com.eop.java.programs.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortFile2 {

	private static final int INITIAL_CAPACITY = 16;

	private static class ArrayEntry {
		public Integer value;
		public Integer arrayId;

		public ArrayEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	public static void main(String[] args) {

		List<Integer> listA = new ArrayList<Integer>(Arrays.asList(3, 5, 7));
		List<Integer> listB = new ArrayList<Integer>(Arrays.asList(0, 6));
		List<Integer> listC = new ArrayList<Integer>(Arrays.asList(0, 6, 28));
		List<List<Integer>> sorted = new ArrayList<List<Integer>>(
				(Arrays.asList(listA, listB, listC)));
		System.out.println(mergeSortedArrays(sorted));
	}

	public static List<Integer> mergeSortedArrays(
			List<List<Integer>> sortedArrays) {

		// Create Priority Queue with capacity and Comparator object
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<ArrayEntry>(
				INITIAL_CAPACITY, new Comparator<ArrayEntry>() {
					public int compare(ArrayEntry a1, ArrayEntry a2) {
						return Integer.compare(a1.value, a2.value);
					}
				});
		// Integer type arrayList with size of (number of sorted arrays)
		List<Integer> heads = new ArrayList<Integer>(sortedArrays.size());
		// Adding initial values of each sorted array into the PQueue
		for (int i = 0; i < sortedArrays.size(); i++) {
			if (sortedArrays.get(i).size() > 0) {
				// ading (value,arrayId)
				minHeap.add(new ArrayEntry(sortedArrays.get(i).get(0), i));
				// adding '1' for every succesful entry
				heads.add(1);
			} else {
				// adding '0' for unsuccesful entry
				heads.add(0);
			}
		}
		// Defining the arrayList for "result"
		List<Integer> result = new ArrayList<Integer>();
		// Declare the headEntry
		ArrayEntry headEntry;
		// Add the minimum number into headEntry
		while ((headEntry = minHeap.poll()) != null) {
			result.add(headEntry.value);
			// smallestArray is assigned with the sortedArray number of the
			// poll() value
			List<Integer> smallestArray = sortedArrays.get(headEntry.arrayId);
			int smallestArrayHead = heads.get(headEntry.arrayId); 
			
			// compare heads value with smallestArray value
			if (smallestArrayHead < smallestArray.size()) {
				minHeap.add(new ArrayEntry(
						smallestArray.get(smallestArrayHead), headEntry.arrayId));
				heads.set(headEntry.arrayId, heads.get(headEntry.arrayId) + 1);
			}
		}
		return result;
	}
}

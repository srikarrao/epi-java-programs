package com.eop.java.programs.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortedMedian {

	private static final int INITIAL_CAPACITY = 16;

	public static void main(String[] args) {

		int[] input = { 0, 1, 3, 5, 2, 6, 1 };
		findMedian(input);
	}

	public static void findMedian(int[] array) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
				INITIAL_CAPACITY, Collections.reverseOrder());

		for (int i = 0; i < array.length; i++) {
			int x = array[i];

			if (minHeap.isEmpty()) {
				minHeap.add(x);
			} else {
				if (x >= minHeap.peek()) {
					minHeap.add(x);
				} else {
					maxHeap.add(x);
				}
			}

			if (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.add(minHeap.remove());
			} else if (minHeap.size() < maxHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			System.out
					.println(minHeap.size() == maxHeap.size() ? 0.5 * (maxHeap
							.peek() + minHeap.peek()) : minHeap.peek());
		}
	}
}
 
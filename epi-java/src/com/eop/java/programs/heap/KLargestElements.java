package com.eop.java.programs.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements implements Comparator<Element> {

	public static final KLargestElements K_LARGEST_ELEMENTS = new KLargestElements();

	@Override
	public int compare(Element o1, Element o2) {
		return Integer.compare(o2.value, o1.value);
	}

	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(561,
				314, 401, 28, 156, 359, 271, 11, 3));
		System.out.println(findKLargest(inputList, inputList.size() - 1));
	}

	private static List<Integer> findKLargest(List<Integer> L, int k) {

		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Element> heap = new PriorityQueue<Element>(16,
				K_LARGEST_ELEMENTS);
		heap.add(new Element(L.get(0), 0));

		for (int i = 0; i < k; i++) {
			Integer candidateIndex = heap.peek().index;
			result.add(heap.remove().value);

			int leftChildIndx = 2 * candidateIndex + 1;
			if (leftChildIndx < L.size()) {
				heap.add(new Element(L.get(leftChildIndx), leftChildIndx));
			}

			int rightChildIndx = 2 * candidateIndex + 2;
			if (rightChildIndx < L.size()) {
				heap.add(new Element(L.get(rightChildIndx), rightChildIndx));
			}

		}
		return result;
	}
}

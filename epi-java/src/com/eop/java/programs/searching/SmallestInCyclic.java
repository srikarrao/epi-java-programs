package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestInCyclic {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(378, 478,
				550, 631, 103, 203, 220, 234, 279, 368));
		System.out.println(findSmallestInCyclic(input));
		System.out.println(findSmallestInCyclicDuplicates(input, 0,
				input.size() - 1));
	}

	public static int findSmallestInCyclic(List<Integer> A) {
		int low = 0;
		int high = A.size() - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A.get(mid) > A.get(high)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return A.get(low);
	}

	public static int findSmallestInCyclicDuplicates(List<Integer> A, int low,
			int high) {
		if (low == high) {
			return A.get(low);
		} else {
			int mid = low + (high - low) / 2;
			if (A.get(mid) > A.get(high)) {
				low = mid + 1;
				findSmallestInCyclicDuplicates(A, mid + 1, high);
			} else if (A.get(mid) < A.get(high)) {
				high = mid;
				findSmallestInCyclicDuplicates(A, low, mid);
			} else {
				int lowResult = findSmallestInCyclicDuplicates(A, low, mid);
				int highResult = findSmallestInCyclicDuplicates(A, mid + 1, mid);
				return A.get(highResult) < A.get(lowResult) ? A.get(highResult)
						: A.get(lowResult);
			}
		}
		return 0;
	}
}

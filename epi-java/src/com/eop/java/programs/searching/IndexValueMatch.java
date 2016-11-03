package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexValueMatch {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(-2, 0, 1, 2,
				4, 5, 8, 9));
		System.out.println(findIndexMatch(input));
	}

	public static int findIndexMatch(List<Integer> A) {
		int low = 0;
		int high = A.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int diff = A.get(mid) - mid;
			if (diff == 0) {
				return mid;
			} else if (diff > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}

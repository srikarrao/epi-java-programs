package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySearching {

	public static void main(String[] args) {

		List<Integer> R1 = new ArrayList<Integer>(Arrays.asList(-4, 2, 4, 4, 6));
		List<Integer> R2 = new ArrayList<Integer>(Arrays.asList(1, 5, 5, 9, 21));
		List<Integer> R3 = new ArrayList<Integer>(Arrays.asList(3, 6, 6, 9, 22));
		List<Integer> R4 = new ArrayList<Integer>(
				Arrays.asList(3, 6, 8, 10, 24));
		List<Integer> R5 = new ArrayList<Integer>(Arrays.asList(8, 10, 12, 13,
				40));
		List<List<Integer>> RC = new ArrayList<List<Integer>>(Arrays.asList(R1,
				R2, R3, R4, R5));
		System.out.println(findElementInArray(RC, 500));
	}

	public static int findElementInArray(List<List<Integer>> A, int k) {

		int i = 0;
		int low = 0, mid = 0, high = A.get(i).size() - 1;
		while (i < A.size()) {
			mid = low + (high - low) / 2;
			if (low <= high && mid < A.get(i).size()) {
				if (A.get(i).get(mid) == k) {
					return A.get(i).get(mid);
				} else if (A.get(i).get(mid) >= k) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				i++;
				low = 0;
				if (i < A.size())
					high = A.get(i).size();
			}
		}
		return -1;
	}
}
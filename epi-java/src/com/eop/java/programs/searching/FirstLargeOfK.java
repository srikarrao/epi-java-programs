package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLargeOfK {

	public static void main(String[] args) {

		List<Integer> kOccurenceList = new ArrayList<Integer>(Arrays.asList(
				-14, -10, 2, 108, 108, 243, 285, 285, 285, 401));
		System.out.println("First larger number is : "
				+ searchFirstLargerOfK(kOccurenceList, 40));
	}

	public static int searchFirstLargerOfK(List<Integer> A, int k) {
		int result = -1;
		int low = 0;
		int mid = 0;
		int high = A.size() - 1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (A.get(mid) > k) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return A.get(result);
	}
}

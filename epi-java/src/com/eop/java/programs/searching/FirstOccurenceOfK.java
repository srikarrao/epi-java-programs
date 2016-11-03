package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstOccurenceOfK {

	public static void main(String[] args) {
		List<Integer> kOccurenceList = new ArrayList<Integer>(Arrays.asList(
				-14, -10, 2, 108, 108, 243, 285, 285, 285, 401));
		System.out.println("First occurence is at: "
				+ findFirstOccurenceOfK(kOccurenceList, -14)
				+ " and last occurence is at: "
				+ findLastOccurenceOfK(kOccurenceList, -14));

		List<Integer> ascendDescendList = new ArrayList<Integer>(Arrays.asList(
				-14, -10, -12, 108, 107, 2043, 208, 285, 281, 401));
		System.out.println("Largest integer is: "
				+ findLargest(ascendDescendList));
	}

	public static int findFirstOccurenceOfK(List<Integer> kList, int k) {
		int result = 0;
		int low = 0;
		int high = kList.size() - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (kList.get(mid) < k) {
				low = mid + 1;
			} else if (kList.get(mid) == k) {
				result = mid;
				high = mid - 1;
			} else {
				high = mid - 1;
			}
		}
		return result + 1;
	}

	public static int findLastOccurenceOfK(List<Integer> kList, int k) {
		int result = 0;
		int low = 0;
		int high = kList.size() - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (kList.get(mid) < k) {
				low = mid + 1;
			} else if (kList.get(mid) == k) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result + 1;
	}

	public static int findLargest(List<Integer> max) {
		int low = 0;
		int high = max.size() - 1;
		int pivot = 0;
		int mid = low + (high - low) / 2;
		if (mid == 0 || (mid > 0 && max.get(mid) > max.get(mid - 1))) {
			pivot = mid;
		} else {
			pivot = mid - 1;
		}
		int i = 1;
		if (mid > 0) {
			i = (pivot % 2 == 0 ? 0 : 1);
		}
		while (i < max.size()) {
			if (max.get(pivot) < max.get(i)) {
				pivot = i;
			}
			i += 2;
		}
		return pivot + 1;
	}
}

package com.eop.java.programs.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AscendDescendSortedArrays {
	private static enum SubarrayType {
		INCREASING, DECREASING
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(57, 131, 493,221, 294,339, 418,
				452,190, 442));
		System.out.println(sortIncreasingDecreasingArray(input));
	}

	public static List<Integer> sortIncreasingDecreasingArray(List<Integer> A) {

		List<List<Integer>> sortedSubarrays = new ArrayList<List<Integer>>();
		SubarrayType subArrayType = SubarrayType.INCREASING;
		int startIndx = 0;
		for (int i = 1; i <= A.size(); i++) {
			if (i == A.size() || (A.get(i - 1) < A.get(i))
					&& subArrayType == SubarrayType.DECREASING
					|| (A.get(i - 1) >= A.get(i))
					&& subArrayType == SubarrayType.INCREASING) {
				List<Integer> subList = A.subList(startIndx, i);
				if (subArrayType == SubarrayType.DECREASING) {
					Collections.reverse(subList);
				}
				sortedSubarrays.add(subList);
				startIndx = i;
				subArrayType = (subArrayType == SubarrayType.INCREASING ? SubarrayType.DECREASING
						: SubarrayType.INCREASING);
			}
		}

		return MergeSortFile2.mergeSortedArrays(sortedSubarrays);
	}
}

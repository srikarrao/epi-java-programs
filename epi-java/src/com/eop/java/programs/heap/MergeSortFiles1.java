package com.eop.java.programs.heap;

import java.util.ArrayList;
import java.util.List;

public class MergeSortFiles1 {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		List<Integer> C = new ArrayList<>();

		A.add(3);
		A.add(5);
		A.add(7);

		B.add(0);
		B.add(6);

		C.add(0);
		C.add(6);
		C.add(28);
		List<List<Integer>> filesList = new ArrayList<>();
		filesList.add(A);
		filesList.add(B);
		filesList.add(C);
		displayMergedFiles(doMerging(filesList));
	}

	public static List<Integer> doMerging(List<List<Integer>> filesList) {

		List<Integer> merged = filesList.get(0);

		for (int i = 1; i < filesList.size(); i++) {
			merged = mergeSortImpl(merged, filesList.get(i));
		}
		return merged;
	}

	public static List<Integer> mergeSortImpl(List<Integer> x, List<Integer> y) {
		int i = 0;
		int j = 0;
		List<Integer> result = new ArrayList<Integer>();
		while (i < x.size() && j < y.size()) {
			if (x.get(i) <= y.get(j)) {
				result.add(x.get(i));
				i++;
			} else {
				result.add(y.get(j));
				j++;
			}
		}

		while (i < x.size()) {
			result.add(x.get(i));
			i++;
		}
		while (j < y.size()) {
			result.add(y.get(j));
			j++;
		}
		return result;
	}

	public static void displayMergedFiles(List<Integer> resultFile) {

		for (int i = 0; i < resultFile.size(); i++) {
			System.out.print(resultFile.get(i) + " ");
		}
		System.out.println();
	}
}

package com.eop.java.programs.sorting;

public class InPlaceMergeSort {
	public static int[] A = { 5, 13, 17, 0, 0, 0, 0, 0 };
	public static int[] B = { 3, 7, 11, 19 };

	public static void main(String[] args) {
		mergeSort(3, 4);
		System.out.println("Final Merged array in-place ");
		displayResult();
	}

	public static void mergeSort(int m, int n) {

		int a = m - 1;
		int b = n - 1;
		int index = ((m + n) - 1);
		while (a >= 0 && b >= 0) {
			if (A[a] > B[b]) {
				A[index] = A[a];
				a--;
			} else {
				A[index] = B[b];
				b--;
			}
			index--;
		}
		while (b >= 0) {
			A[index] = B[b];
			b--;
			index--;
		}
	}

	public static void displayResult() {
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

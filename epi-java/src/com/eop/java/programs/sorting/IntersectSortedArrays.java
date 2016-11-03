package com.eop.java.programs.sorting;

public class IntersectSortedArrays {

	public static int[] arrayA = { 2, 3, 3, 5, 5, 6, 8, 18};
	public static int[] arrayB = { 5, 5, 6, 8, 8, 9, 18, 100 };
	public static int[] resultArray = { 0, 0, 0, 0, 0, 0, 0 };
	public static int displayNum;

	public static void main(String[] args) {
		System.out.println("Brute Force!!!!!");
		bruteForceIntersect();
		displayResult();

		System.out.println("Using Binary Search!!!!");
		binarySearchIntersect();
		displayResult();

		if (arrayA.length == arrayB.length) {
			System.out.println("If the array size are equal!!!!");
			intersectForEqualSizeArrays();
			displayResult();
		}

	}

	public static void bruteForceIntersect() {
		displayNum = 0;
		for (int i = 0; i < arrayA.length; i++) {
			if (i == 0 || arrayA[i - 1] != arrayA[i]) {
				for (int j = 0; j < arrayB.length; j++) {
					if (arrayA[i] == arrayB[j]) {
						resultArray[displayNum] = arrayA[i];
						displayNum++;
						break;
					}
				}
			}
		}
	}

	public static void binarySearchIntersect() {
		displayNum = 0;
		for (int i = 0; i < arrayA.length; i++) {
			if ((i == 0 || arrayA[i - 1] != arrayA[i])
					&& binarySearch(arrayB, arrayA[i]) >= 0) {
				resultArray[displayNum] = arrayA[i];
				displayNum++;
			}
		}
	}

	public static int binarySearch(int[] array, int keyValue) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (array[mid] == keyValue) {
				return mid;
			} else if (array[mid] < keyValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void displayResult() {
		for (int i = 0; i < displayNum; i++) {
			System.out.print(resultArray[i] + " ");
		}
		System.out.println();
	}

	public static void intersectForEqualSizeArrays() {
		displayNum = 0;
		int i = 0;
		int j = 0;
		while (i < arrayA.length && j < arrayB.length) {
			if (arrayA[i] == arrayB[j]
					&& (i == 0 || arrayA[i] != arrayA[i - 1])) {
				resultArray[displayNum] = arrayA[i];
				displayNum++;
				i++;
				j++;
			} else if (arrayA[i] < arrayB[j]) {
				i++;
			} else {
				j++;
			}
		}
	}
}

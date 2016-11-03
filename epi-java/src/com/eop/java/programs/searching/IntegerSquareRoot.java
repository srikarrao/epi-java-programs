package com.eop.java.programs.searching;

public class IntegerSquareRoot {

	public static void main(String[] args) {

		System.out.println(finSquareRoot(200));
	}

	public static int finSquareRoot(int k) {

		int low = 0;
		int high = k;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int squareRoot = mid * mid;
			if (squareRoot <= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low - 1;
	}
}

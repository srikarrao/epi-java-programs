package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArbitaryPrecisionIncrement {

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>();
		A.add(9);
		A.add(9);
		A.add(3);
		System.out.println(plusOne(A));
	}

	public static List<Integer> plusOne(List<Integer> A) {
		int n = A.size() - 1;
		A.set(n, A.get(n) + 1);

		for (int i = n; i > 0 && A.get(i) == 10; i--) {
			A.set(i, 0);
			A.set(i - 1, A.get(i - 1) + 1);
		}
		if (A.get(0) == 10) {
			A.set(0, 0);
			A.add(0, 1);
		}
		return A;
	}
}

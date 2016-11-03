package com.eop.java.programs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JAVA program to find the number of ways to traverse a 2D array
 * 
 * @author SrikarRao
 *
 */
public class Traversing2DArray {

	public static int numberOfWays(int n, int m) {

		if (n <= 0 || m <= 0) {
			return -1;
		}

		if (n < m) {
			n = n + m;
			m = n - m;
			n = n - m;
		}

		List<Integer> A = new ArrayList<Integer>(Collections.nCopies(m, 1));
		for (int i = 1; i < n; i++) {
			int prevRes = 0;
			for (int j = 0; j < m; j++) {
				A.set(j, A.get(j) + prevRes);
				prevRes = A.get(j);
			}
		}
		return A.get(m - 1);
	}
}

package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NextPermutation {

	private static int pSize;

	public static void main(String[] args) {

		List<Integer> nextPerm = new ArrayList<>();
		int initial = 0;
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the number of permutations");
			pSize = scn.nextInt();

			System.out.println("Enter the values for the permutation list ");
			for (int i = 0; i < pSize; i++) {
				nextPerm.add(scn.nextInt());
			}
			System.out.println("Before permutation");
			System.out.println(nextPerm);
			System.out.println("After permutation");
			System.out.println(findNextPermutation(nextPerm));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static List<Integer> findNextPermutation(List<Integer> nextPerm) {
		int k = nextPerm.size() - 2;

		while (k >= 0 && (nextPerm.get(k) >= nextPerm.get(k + 1))) {
			k--;
		}

		if (k == -1) {
			return Collections.emptyList();
		}
		for (int x = nextPerm.size() - 1; x > k; x--) {
			if (nextPerm.get(x) > nextPerm.get(k)) {
				Collections.swap(nextPerm, k, x);
				break;
			}
		}
		Collections.reverse(nextPerm.subList(k + 1, nextPerm.size()));
		return nextPerm;
	}
}

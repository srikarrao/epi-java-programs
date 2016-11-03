package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutation {

	public static void main(String[] args) {

		List<Character> A = new ArrayList<Character>(Arrays.asList('a', 'b',
				'c', 'd'));
		List<Integer> perm = new ArrayList<Integer>(Arrays.asList(3, 1, 2, 0));
		
		System.out.println("Before Permuted Array: " + A);
		System.out.println("Before Position Array: " + perm);
		
		applyPermutation(perm, A);
		System.out.println("After Permuted Array: " + A);
		System.out.println("After Position Array: " + perm);
	}

	public static void applyPermutation(List<Integer> perm, List<Character> A) {
		for (int i = 0; i < A.size(); ++i) {
			if (perm.get(i) >= 0) {
				cyclicPermutation(i, perm, A);
			}
		}
		for (int i = 0; i < perm.size(); i++) {
			perm.set(i, perm.get(i) + perm.size());
		}
	}

	private static void cyclicPermutation(int start, List<Integer> perm,
			List<Character> A) {
		int i = start;
		char temp = A.get(start);

		do {
			int nextI = perm.get(i);
			char nextTemp = A.get(nextI);
			A.set(nextI, temp);
			perm.set(i, perm.get(i) - perm.size());
			i = nextI;
			temp = nextTemp;

		} while (i != start);
	}
}

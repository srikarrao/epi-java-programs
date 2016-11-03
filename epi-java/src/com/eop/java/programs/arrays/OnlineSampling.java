package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineSampling {

	public static void main(String[] args) {

		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the size of the list");
			int n = scn.nextInt();
			System.out.println("After Sampling " +computeRandomPerumtation(n));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static List<Integer> computeRandomPerumtation(int n) {
		List<Integer> permutations = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			permutations.add(i);
		}
		System.out.println("Before sampling " + permutations);
		OfflineSampling.randomSampling(permutations.size(), permutations);
		return permutations;
	}

}

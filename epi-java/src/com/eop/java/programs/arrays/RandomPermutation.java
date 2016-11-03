package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;

public class RandomPermutation {

	public static void main(String[] args) {
		System.out.println(randomSampling(20));

	}

	private static List<Integer> randomSampling(int n) {
		List<Integer> randomArray = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			randomArray.add(i);
		}
		OfflineSampling.randomSampling(randomArray.size(), randomArray);
		return randomArray;
	}
}

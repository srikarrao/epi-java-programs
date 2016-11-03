package com.eop.java.programs.greedyAlgorithm;

import java.util.Collections;
import java.util.List;

/**
 * JAVA Program to find if the given number is the sum of any three numbers in
 * the array (can use more than once)
 * 
 * @author SrikarRao
 *
 */
public class ThreeSum {

	public static boolean hasThreeSum(List<Integer> array, int num) {

		if (array == null || array.size() < 3) {
			return false;
		}

		Collections.sort(array);
		for (Integer x : array) {
			if (hasTwoSum(array, num - x)) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasTwoSum(List<Integer> array, int num) {
		int i = 0;
		int j = array.size() - 1;

		while (i <= j) {
			if (array.get(i) + array.get(j) == num) {
				return true;
			} else if (array.get(i) + array.get(j) < num) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
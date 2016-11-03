package com.eop.java.programs.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMax {
	private Integer min;
	private Integer max;

	public MinMax(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public static MinMax minMax(Integer a, Integer b) {
		return Integer.compare(a, b) > 0 ? new MinMax(b, a) : new MinMax(a, b);
	}

	public static MinMax findMinMax(List<Integer> A) {
		if (A.size() <= 1) {
			minMax(A.get(0), A.get(1));
		}

		MinMax global = minMax(A.get(0), A.get(1));

		for (int i = 2; i + 1 < A.size(); i = i + 2) {
			MinMax local = minMax(A.get(i), A.get(i + 1));
			global = new MinMax(Math.min(local.min, global.min), Math.max(
					local.max, global.max));
		}

		if (A.size() % 2 != 0) {
			global = new MinMax(Math.min(A.get(A.size() - 1), global.min),
					Math.max(A.get(A.size() - 1), global.max));
		}
		return global;
	}

	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<Integer>((Arrays.asList(1, 304,
				67, 1, 304, 19, 88)));
		MinMax result = findMinMax(inputList);
		System.out.println("Max is: " + result.max + ", Min is: " + result.min);

	}

}

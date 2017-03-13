package com.eop.java.programs.arrays;

import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {
		displayPascalTriangle(generate(10));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return triangle;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(triangle.get(i - 1).get(j - 1)
							+ triangle.get(i - 1).get(j));
				}
			}
			triangle.add(row);
		}
		return triangle;
	}

	public static void displayPascalTriangle(List<List<Integer>> pascalTriangle) {
		for (List<Integer> list : pascalTriangle) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
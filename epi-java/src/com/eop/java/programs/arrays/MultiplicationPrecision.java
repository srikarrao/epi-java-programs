package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplicationPrecision {

	private static List<Integer> A = new ArrayList<Integer>();
	private static List<Integer> B = new ArrayList<Integer>();
	private static List<Integer> C = new ArrayList<>();
	private static List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	private static int carry = 0;

	public static void main(String[] args) {
		A.add(7);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(9);

		B.add(5);
		B.add(9);
		B.add(2);
		B.add(3);
		B.add(9);

		for (int i = 0; i < A.size() + B.size(); i++) {
			C.add(0);
		}
		doMultiplication();
		displayMultipliedNumber();
	}

	public static void doMultiplication() {
		for (int x = A.size() - 1; x >= 0; x--) {
			for (int y = B.size() - 1; y >= 0; y--) {
				C.set(y, (A.get(x) * B.get(y) + carry) % 10);
				C.set(y - 1, (A.get(x) * B.get(y) + carry) / 10);
			}
		}
	}

	public static void displayMultipliedNumber() {
		System.out.println(resultList);
	}
}

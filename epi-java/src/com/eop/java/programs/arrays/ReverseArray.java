package com.eop.java.programs.arrays;

import java.util.Scanner;

public class ReverseArray {
	private static int len;
	private static int val = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the array ");
		Integer size = scn.nextInt();
		String regex = "[0-9]+";
		if ((size > 0) & (Integer.valueOf(size)).toString().matches(regex)) {
			int[] mainArray = new int[size];

			for (int i = 0; i < mainArray.length; i++) {
				mainArray[i] = i + 1;
			}
			len = (mainArray.length) - 1;

			System.out.println("Array before reversing");
			displayArray(mainArray);
			reverseArray(mainArray);
			System.out.println("Array after reversing");
			displayArray(mainArray);
		} else {
			System.out.println("Enter size number > 0");
		}
	}

	public static void reverseArray(int[] rArray) {
		swapArrayValues(rArray);
		if (len > val) {
			reverseArray(rArray);
		}
	}

	public static void swapArrayValues(int[] swapArray) {
		int temp = swapArray[len];
		swapArray[len] = swapArray[val];
		swapArray[val] = temp;
		len--;
		val++;
	}

	public static void displayArray(int[] dArray) {
		for (int i = 0; i < dArray.length; i++) {
			System.out.print(dArray[i] + " ");
		}
		System.out.println();
	}
}
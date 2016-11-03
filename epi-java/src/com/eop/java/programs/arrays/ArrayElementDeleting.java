package com.eop.java.programs.arrays;

import java.util.Scanner;

public class ArrayElementDeleting {

	public static void main(String[] args) {
		int[] delArray = new int[7];
		Scanner scn = new Scanner(System.in);
		try {
			for (int i = 0; i < delArray.length; i++) {
				delArray[i] = i + 1;
			}
			displayArray(delArray,0);
			System.out.println("Enter the position of element to be deleted ");
			int x = scn.nextInt();
			if (x > 0) {
				delElement(delArray, x);
				displayArray(delArray, 1);
			} else {
				System.out
						.println("Element position should be greater than 0 and less than "
								+ delArray.length);
			}
		} catch (Exception e) {
			System.out.println("Illegal Input " + e);
		}
	}

	public static void delElement(int[] delArray, int position) {
		int x = position - 1;
		if (x < delArray.length) {
			for (int i = 0; i < delArray.length && x < delArray.length - 1; i++) {
				if (i == x) {
					delArray[i] = delArray[i + 1];
				} else if (i > x && i < delArray.length - 1) {
					delArray[i] = delArray[i + 1];
				}
			}
			delArray[delArray.length - 1] = 0;
		}else {
			System.out.println("Element doesn't exist as size of array is "
					+ delArray.length);
		}
	}

	public static void displayArray(int[] delArray,int x) {
		for (int i = 0; i < delArray.length - x; i++) {
			System.out.print(delArray[i] + " ");
		}
		System.out.println();
	}
}

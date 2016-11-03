package com.eop.java.programs.arrays;

import java.util.Scanner;

public class PascalsTriangle {

	public static int[] pascalArray;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows for Pascal's triangle");
		try {
			Integer x = sc.nextInt();
			if ((x > 1)) {
				int[] pascalArray2 = new int[x];
				pascalArray = pascalArray2;

				System.out.println("Creating Pascal's triangle");
				System.out
						.println("Enter the first number of Pascal's triangle");
				pascalArray[0] = sc.nextInt();
				System.out.println("Displaying Pascal's triangle");
				System.out.print(pascalArray[0] + " ");
				createPascalTriangle();
			} else {
				System.out.println("Rows should be more than 1 ");
			}
		} catch (Exception e) {
			System.out
					.println("Invalid input:: Give correct input value (number only) "
							+ e);
		}
	}

	public static void createPascalTriangle() {
		for (int i = 1; i < pascalArray.length; i++) {
			System.out.println();
			pascalArray[i] = pascalArray[i - 1];
			for (int j = i; j > 1; j--) {
				pascalArray[j - 1] = pascalArray[j - 2] + pascalArray[j - 1];
			}
			displayPascalTriangle(i);
		}
	}

	public static void displayPascalTriangle(int x) {
		for (int i = 0; i <= x; i++) {
			System.out.print(pascalArray[i] + " ");
		}
	}
}

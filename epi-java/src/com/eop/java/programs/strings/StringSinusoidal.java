package com.eop.java.programs.strings;

import java.util.Scanner;

public class StringSinusoidal {

	public static void main(String[] args) {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter a string to display in sinusoidal");
			String hw = scn.nextLine();
			displaySnakeString(createSnakeString(hw));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String createSnakeString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i += 4) {
			sb.append(s.charAt(i));
		}

		for (int i = 0; i < s.length(); i += 2) {
			sb.append(s.charAt(i));
		}

		for (int i = 3; i < s.length(); i += 4) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void displaySnakeString(String s) {
		int zip = 0;
		int x1 = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i == (4 * x1) + 1) {
				System.out.print(s.charAt(zip) + " ");
				zip++;
				x1++;
			} else {
				System.out.print(' ' + " ");
			}
		}
		System.out.println();

		for (int j = 0; j < s.length(); j++) {
			if (j % 2 == 0) {
				System.out.print(s.charAt(zip) + " ");
				zip++;
			} else {
				System.out.print(' ' + " ");
			}
		}
		System.out.println();

		int x3 = 1;
		int y3 = 0;
		for (int k = 0; k < s.length(); k++) {
			if (k == (3 * x3) + y3) {
				System.out.print(s.charAt(zip) + " ");
				zip++;
				x3++;
				y3++;
			} else {
				System.out.print(' ' + " ");
			}
		}
		System.out.println();
	}
}
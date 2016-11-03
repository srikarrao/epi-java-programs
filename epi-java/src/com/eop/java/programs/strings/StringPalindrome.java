package com.eop.java.programs.strings;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {

		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter a string to check if it is a palindrome");
			String inputString = scn.nextLine();
			System.out.println("Is the string '" + inputString
					+ "' a palindrome??");
			String result = checkPalindrome(inputString) == true ? "Yes" : "No";
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static boolean checkPalindrome(String s) {
		int x = 0;
		int y = s.length() - 1;

		for (int i = 0; i < s.length() && x < y; i++) {
			if (!Character.isLetterOrDigit(s.charAt(x))) {
				x++;
			} else if (!Character.isLetterOrDigit(s.charAt(y))) {
				y--;
			} else if (Character.toUpperCase(s.charAt(x)) == Character
					.toUpperCase(s.charAt(y))) {
				x++;
				y--;
			} else {
				return false;
			}
		}
		return true;
	}
}

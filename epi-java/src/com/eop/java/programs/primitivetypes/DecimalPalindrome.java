package com.eop.java.programs.primitivetypes;

/**
 * Java program to find if the given decimal number is a palindrome
 * @author SrikarRao
 *
 */
public class DecimalPalindrome {

	public static boolean isPalindrome(int num) {

		if (num < 0) {
			return false;
		}
		if (num == 0) {
			return true;
		}

		int numOfDigits = (int) (Math.floor(Math.log10(num))) + 1;
		int msdMask = (int) Math.pow(10, numOfDigits - 1);

		for (int i = 0; i < (numOfDigits / 2); i++) {
			if (num / msdMask != num % 10) {
				return false;
			}
			num %= msdMask;
			num /= 10;
			msdMask /= 100;
		}
		return true;
	}
}

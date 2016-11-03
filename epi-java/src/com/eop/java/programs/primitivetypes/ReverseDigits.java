package com.eop.java.programs.primitivetypes;

/**
 * JAVA program to reverse digits of a number
 * 
 * @author SrikarRao
 *
 */
public class ReverseDigits {

	/**
	 * method to reverse digits
	 * 
	 * @param number
	 * @return
	 */
	public static int reverseDigits(int number) {
		int res = 0, rev = 0;

		boolean isNegative = number < 0;
		if (isNegative) {
			number *= -1;
		}

		do {
			res = number % 10;
			rev = calculateResult(res, rev);
			number /= 10;
		} while (number != 0);

		return (isNegative ? -rev : rev);
	}

	/**
	 * method to calculate the result
	 * 
	 * @param x
	 * @param rev
	 * @return
	 */
	private static int calculateResult(int x, int rev) {
		rev = (rev * 10) + x;
		return rev;
	}
}

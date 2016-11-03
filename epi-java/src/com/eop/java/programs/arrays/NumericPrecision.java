package com.eop.java.programs.arrays;

import java.util.Scanner;

/**
 * 
 * @author SrikarRao Program to implement number precision for decimal numbers
 *
 */
public class NumericPrecision {

	private static String[] words;
	private static StringBuffer sb;
	private static String negativeSign = "";
	private static String regex = "(\\-)?([0-9]+(\\.?[0-9]+)?)";
	private static String number;

	public static void main(String[] args) {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the desired number for precision");
			number = scn.nextLine();

			if (null != number && !number.isEmpty()) {
				// checking if it is a valid number
				if (number.matches(regex)) {
					System.out.println(convertToNumericPrecision());
				} else {
					System.out.println("Enter a Valid Number");
				}
			} else {
				System.out.println("Enter a Number");
			}
		} catch (Exception e) {
			System.out.println("Exception occured due to: " + e);
		}
	}

	/**
	 * Method to implement numeric precision
	 * 
	 * @return Number after precision
	 */
	public static String convertToNumericPrecision() {
		try {
			// checks if it is a floating point or integer type number
			if (number.contains(".")) {
				/** splitting the integer part and decimal point numbers **/
				words = number.split("\\.");
				sb = new StringBuffer(words[0]);
			} else {
				sb = new StringBuffer(number);
			}
			// checking if the number is negative
			if (Long.valueOf(sb.toString()) < 0) {
				sb = sb.deleteCharAt(0);
				negativeSign = "-";
			}
			sb = sb.reverse();
			// adding the "," between the precision
			for (int i = sb.length() - 1; i > 0; i--) {
				if (i % 3 == 0) {
					sb.insert(i, ",");
				}
			}
			if (null != words) {
				number = (negativeSign + sb.reverse().toString() + "." + words[1])
						.trim();
			} else {
				number = (negativeSign + sb.reverse().toString()).trim();
			}
		} catch (Exception e) {
			System.out
					.println("Exception occured in method convertToNumericPrecision due to: "
							+ e);
		}
		return number;
	}
}

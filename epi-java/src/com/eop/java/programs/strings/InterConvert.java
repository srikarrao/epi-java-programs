package com.eop.java.programs.strings;

import java.util.Scanner;

public class InterConvert {

	public static void main(String[] args) {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the Integer to be converted to String");
			int numString = scn.nextInt();
			System.out.println("Integer value is --> "
					+ convertIntToString(numString));
			System.out.println("Enter the String to be converted to Integer");
			scn = new Scanner(System.in);
			String stringNum = scn.nextLine();
			if (stringNum.matches("^[-]?[0-9]+")) {
				System.out.println("String value is --> "
						+ convertStringToInt(stringNum));
			} else {
				System.out
						.println("Wrong Input:: Enter only Integer type values");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String convertIntToString(int number) {
		try {
			boolean isNegative = false;
			if (number < 0) {
				number = -number;
				isNegative = true;
			}

			StringBuilder sb = new StringBuilder();
			do {
				sb.append((char) ('0' + number % 10));
				number /= 10;
			} while (number != 0);

			if (isNegative) {
				sb.append("-");
			}
			sb.reverse();
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static int convertStringToInt(String stringTypeNum) {
		int result = 0;
		for (int i = stringTypeNum.charAt(0) == '-' ? 1 : 0; i < stringTypeNum
				.length(); i++) {
			int number = stringTypeNum.charAt(i) - '0';
			result = result * 10 + number;
		}
		if (stringTypeNum.charAt(0) == '-') {
			result = result * -1;
		}
		return result;
	}
}
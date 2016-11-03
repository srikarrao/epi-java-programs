package com.eop.java.programs.strings;

import java.util.Scanner;

public class BaseConversion {
	private static Scanner scn;
	private static boolean isNegative = false;

	public static void main(String[] args) {
		try {
			System.out.println("Print the string to be base converted");
			scn = new Scanner(System.in);
			String stringValue = scn.nextLine();
			System.out.println("Print the base1 value");
			scn = new Scanner(System.in);
			int base1 = scn.nextInt();
			System.out.println("Print the base2 value");
			int base2 = scn.nextInt();

			doBaseConversion(stringValue, base1, base2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void doBaseConversion(String s, int base1, int base2) {
		isNegative = s.charAt(0) == '-' ? true : false;
		int resultForBase1 = doBase1Conversion(s, base1);

		System.out.println("value of the base conversion " + base1 + " is "
				+ resultForBase1);
		String resultForBase2 = doBase2Conversion(s, base2, resultForBase1);
		System.out.println("value of the base conversion " + base2 + " is "
				+ resultForBase2);
	}

	public static int doBase1Conversion(String s, int base) {
		StringBuilder sb;
		int value1 = 0;
		int x = 0;
		sb = new StringBuilder(s);

		if (s.charAt(0) == '-') {
			x = s.length() - 1;
		} else {
			x = s.length();
		}
		s = sb.reverse().toString();
		
		for (int i = s.charAt(0) == '-' ? 1 : 0; i < x; i++) {
			value1 += (s.charAt(i) - '0') * power(base, i);
		}
		if (isNegative)
			value1 *= -1;
		return value1;
	}

	public static String doBase2Conversion(String s, int base, int resultOfBase1) {
		StringBuilder sb = new StringBuilder();
		if (isNegative)
			resultOfBase1 *= -1;
		do {
			if (resultOfBase1 % base < 10) {
				sb.append((char) ('0' + resultOfBase1 % base));
			} else {
				sb.append((char) ('A' + ((resultOfBase1 % base) - 10)));
			}
			resultOfBase1 = resultOfBase1 / base;
		} while (resultOfBase1 != 0);

		if (isNegative)
			sb.append('-');
		return sb.reverse().toString();
	}

	public static int power(int baseNumber, int pow) {
		int result = 1;
		for (int i = 1; i <= pow; i++) {
			result *= baseNumber;
		}
		return result;
	}
}
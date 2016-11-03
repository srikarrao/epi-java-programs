package com.eop.java.programs.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanConversion {

	private static Map<Character, Integer> roman = new HashMap<Character, Integer>();

	public static void main(String[] args) {
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the Roman Number");
			String romanInput = scn.nextLine();

			System.out.println("The converted number is: "
					+ romanToIntger(romanInput));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static int romanToIntger(String s) {
		int sum = roman.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if ((roman.get(s.charAt(i))) < roman.get(s.charAt(i + 1))) {
				sum -= roman.get(s.charAt(i));
			} else {
				sum += roman.get(s.charAt(i));
			}
		}
		return sum;
	}
}

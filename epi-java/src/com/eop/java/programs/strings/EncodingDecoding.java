package com.eop.java.programs.strings;

import java.util.Scanner;

public class EncodingDecoding {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the String to encode");
		String encodeString = scn.nextLine();
		System.out.println("Encoded String: " + encodeString(encodeString));
		System.out.println("Decoded String: " +decodeString(encodeString(encodeString)));
	}

	public static String encodeString(String s) {
		if (s.length() > 0) {
			StringBuilder sb = new StringBuilder();
			int count = 1;

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i - 1) == s.charAt(i)) {
					count++;
				} else {
					sb.append((count) + "" + s.charAt(i - 1));
					count = 1;
				}
			}
			sb.append((count) + "" + s.charAt(s.length() - 1));
			return sb.toString();
		} else {
			return s;
		}
	}

	public static String decodeString(String s) {
		if (s.length() > 0) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isDigit(c)) {
					count = count * 10 + c - '0';
				} else {
					while (count > 0) {
						sb.append(c);
						count--;
					}
				}
			}
			return sb.toString();
		}
		return s;
	}
}

package com.eop.java.programs.strings;

public class RabinKarpSubString {

	private static int kBase = 26, kMod = 997;

	public static void main(String[] args) {

		String inputString = "Srikar Rao";
		String subString = "Rao";

		int result = rabinKarp(inputString, subString);
		if (result == -1) {
			System.out.println("Sub string Not Found!!");
		} else {
			System.out.println("Sub String occurence found at: " + (result + 1)
					+ "th position of the input String");
		}
	}

	public static int rabinKarp(String input, String sub) {

		if (input.length() < sub.length()) {
			return -1;
		}
		int inputHash = 0, subHash = 0;
		int PowerS = 1;
		for (int i = 0; i < sub.length(); i++) {
			PowerS = i > 0 ? PowerS * kBase % kMod : 1;
			inputHash = (inputHash * kBase + input.charAt(i)) % kMod;
			subHash = (subHash * kBase + sub.charAt(i)) % kMod;
		}

		for (int i = sub.length(); i < input.length(); i++) {

			if (inputHash == subHash
					&& input.substring(i - sub.length(), i).equals(sub)) {
				return i - sub.length();
			}
			inputHash -= (input.charAt(i - sub.length()) * PowerS) % kMod;
			if (inputHash < 0) {
				inputHash += kMod;
			}
			inputHash = (inputHash * kBase + input.charAt(i)) % kMod;

		}
		if (inputHash == subHash
				&& input.substring(input.length() - sub.length()).equals(sub)) {
			return input.length() - sub.length();
		}
		return -1;
	}
}

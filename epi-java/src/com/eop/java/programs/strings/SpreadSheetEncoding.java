package com.eop.java.programs.strings;

public class SpreadSheetEncoding {

	public static void main(String[] args) {

		String s = "AZ";
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = (result * 26) + s.charAt(i) - 'A' + 1;
		}
		System.out.println(result);
	}
}

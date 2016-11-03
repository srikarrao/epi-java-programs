package com.eop.java.programs.strings;

import java.util.Arrays;

public class ReplaceRemove {

	public static void main(String[] args) {

		char[] sChars = { 'b', 'd', 'b', 'b', 'b', 'a', 'a' };
		System.out.println(replaceAndRemove(sChars));
	}

	public static String replaceAndRemove(char[] sChars) {

		int index = 0;
		int count = 0;
		for (int i = 0; i < sChars.length; i++) {
			if (sChars[i] != 'b') {
				sChars[index] = sChars[i];
				index++;
			}
			if (sChars[i] == 'a') {
				count++;
			}
		}

		sChars = Arrays.copyOf(sChars, index + count);
		int otherIndex = index - 1;
		index = sChars.length - 1;

		while (index >= 0) {
			if (sChars[otherIndex] == 'a') {
				sChars[index] = 'd';
				index--;
				sChars[index] = 'd';
				index--;
			} else {
				sChars[index] = sChars[otherIndex];
				index--;
			}
			otherIndex--;
		}

		return new String(sChars);
	}
}

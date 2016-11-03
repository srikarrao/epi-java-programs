package com.eop.java.programs.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FormablePalindrome {

	public static void main(String[] args) {
		System.out.print(canFormPalindrome("level"));
	}

	private static boolean canFormPalindrome(String s) {
		Map<Character, Integer> charFrequencies = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (charFrequencies.containsKey(s.charAt(i))) {
				charFrequencies.put(s.charAt(i),
						charFrequencies.get(s.charAt(i)) + 1);
			} else {
				charFrequencies.put(s.charAt(i), 1);
			}
		}
		int odd = 0;
		for (Map.Entry<Character, Integer> p : charFrequencies.entrySet()) {
			if (p.getValue() % 2 != 0 && ++odd > 1) {
				return false;
			}
		}
		return true;
	}
}

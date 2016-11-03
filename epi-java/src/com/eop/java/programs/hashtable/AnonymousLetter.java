package com.eop.java.programs.hashtable;

import java.util.HashMap;
import java.util.Map;

public class AnonymousLetter {

	public static void main(String[] args) {

		boolean res = isAnonymousLetterPossible("aabghklloop",
				"aaabbghkllloopp");
		System.out.println(res ? "Can write anonymous letter!!"
				: "Cannot write anonymous letter!!");
	}

	private static boolean isAnonymousLetterPossible(String letter,
			String magazine) {
		Map<Character, Integer> charFrequencyInLetter = new HashMap<Character, Integer>();

		for (char lt : letter.toCharArray()) {
			if (charFrequencyInLetter.containsKey(lt)) {
				charFrequencyInLetter
						.put(lt, charFrequencyInLetter.get(lt) + 1);
			} else {
				charFrequencyInLetter.put(lt, 1);
			}
		}

		for (char mg : magazine.toCharArray()) {
			if (charFrequencyInLetter.containsKey(mg)) {
				charFrequencyInLetter
						.put(mg, charFrequencyInLetter.get(mg) - 1);
				if (charFrequencyInLetter.get(mg) == 0) {
					charFrequencyInLetter.remove(mg);
					if (charFrequencyInLetter.isEmpty()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

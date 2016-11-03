package com.eop.java.programs.sorting;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * JAVA program to count the character frequency using hashMap
 * 
 * @author SrikarRao
 *
 */
public class CharFrequencyCount_Map {

	// treemap of Character type keys to hold the characters in the string
	private static Map<Character, Integer> charMap = new TreeMap<Character, Integer>();

	public static void main(String[] args) {

		String input = "/Now you don't care if it is uppercaselower case or whatever.Actually if you are interested specifically for ASCII strings using a Map could be overkill compared to a simple array. The array doesn't waste so much space and perhaps a Map (a very efficient construct) is too much for such a simple task.";

		/*
		 * converting all charactersto uppercase and passing as an input to
		 * invoke the method
		 */
		doCharCount(input.toUpperCase());
	}

	/**
	 * Method to count the character frequency
	 * 
	 * @param string
	 */
	public static void doCharCount(String string) {

		for (int i = 0; i < string.length(); i++) {
			// check for alphabets
			if (Character.isAlphabetic(string.charAt(i))) {
				// check if key already exists
				if (charMap.containsKey(string.charAt(i))) {
					// increment the value
					charMap.put(string.charAt(i),
							charMap.get(string.charAt(i)) + 1);
				} else {
					// put the key, value
					charMap.put(string.charAt(i), 1);
				}
			}
		}

		// printing all the characters, frequencies using entry set
		for (Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() > 0) {
				System.out.print("(" + entry.getKey() + "," + entry.getValue()
						+ ")");
			}
		}
	}
}

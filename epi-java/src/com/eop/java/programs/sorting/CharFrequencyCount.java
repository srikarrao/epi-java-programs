package com.eop.java.programs.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * JAVA program to count the character frequency, Time complexity: O(n log n),
 * Space complexity: O(1)
 * 
 * @author SrikarRao
 */
public class CharFrequencyCount {

	public static void main(String[] args) {
		// Scanner object to get user input
		Scanner scn = new Scanner(System.in);
		System.out.println("Print a sequence of characters");
		String input = scn.next();
		// converting string to charArray
		char[] charInput = input.toCharArray();
		// sort the array
		Arrays.sort(charInput);
		// invoke the method by passing the array as argument
		calculateFrequency(charInput);
	}

	/**
	 * 
	 * @param input
	 */
	public static void calculateFrequency(char[] charArray) {
		int count = 1; // count variable

		/**
		 * For loop to iterate through the array
		 */
		for (int i = 1; i < charArray.length; i++) {
			// check if i and i-1 elements are equal
			if (charArray[i - 1] == charArray[i]) {
				count++; // increment count if valid
			} else {
				System.out.print("(" + charArray[i - 1] + "," + count + ")"
						+ ","); // print the (character,frequency)
				count = 1; // set count to 1
			}
		}
		// print the (character,frequency) of the final element of the array
		System.out.print("(" + charArray[charArray.length - 1] + "," + count
				+ ")" + ",");
	}
}

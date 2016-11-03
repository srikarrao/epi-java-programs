package com.eop.java.programs.greedyAlgorithm;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Find the program to find the word with the majority repetition in a stream
 * 
 * @author SrikarRao
 *
 */
public class MajoritySearch {

	/**
	 * method to implement majority search
	 * 
	 * @param stream
	 * @return
	 */
	public static String majoritySearch(InputStream stream) {
		Scanner scn = new Scanner(stream);
		int count = 0;
		String buffer = "";
		String candidate = "";
		while (scn.hasNextLine()) {
			buffer = scn.nextLine();
			if (count == 0) {
				candidate = buffer;
				count = 1;
			} else if (candidate.equals(buffer)) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
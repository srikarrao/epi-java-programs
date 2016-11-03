package com.eop.java.programs.parallelcomputing;

/**
 * Utility class for Caching in multi-threading program
 * 
 * @author SrikarRao
 *
 */
public class SpellDictionary {

	private static final String word1_X = "xyz";
	private static final String word2_X = "ssxxcc";
	private static final String word3_X = "xc";
	private static final String word4_X = "fsxc";
	private static final String word5_X = "ssxcc";
	private static final String word6_X = "sxxcc";

	private static final String word1_Y = "yyz";
	private static final String word2_Y = "ssyycc";
	private static final String word3_Y = "yc";
	private static final String word4_Y = "fsyc";
	private static final String word5_Y = "ssycc";
	private static final String word6_Y = "syycc";

	public static String[] closestInDictionary(String word) {
		if (word.equalsIgnoreCase("x")) {
			String[] resultsX = { word1_X, word2_X, word3_X, word4_X, word5_X,
					word6_X };
			return resultsX;
		}

		String[] results = { word1_Y, word2_Y, word3_Y, word4_Y, word5_Y,
				word6_Y };
		return results;
	}
}
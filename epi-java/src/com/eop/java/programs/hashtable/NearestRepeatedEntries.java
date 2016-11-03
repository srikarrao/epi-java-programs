package com.eop.java.programs.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>(Arrays.asList("All", "work",
				"no", "and", "play", "makes", "for", "no", "work", "no", "fun",
				"and", "no", "results"));
		System.out.println(findMinimumDistanceOfRepeatedEntries(input));
	}

	private static int findMinimumDistanceOfRepeatedEntries(
			List<String> wordsList) {

		int nearestDist = Integer.MAX_VALUE;
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();

		for (int i = 0; i < wordsList.size(); i++) {
			if (wordsMap.containsKey(wordsList.get(i))) {
				nearestDist = Math.min(nearestDist,
						i - wordsMap.get(wordsList.get(i)));
			}
			wordsMap.put(wordsList.get(i), i);
		}

		return nearestDist;
	}
}

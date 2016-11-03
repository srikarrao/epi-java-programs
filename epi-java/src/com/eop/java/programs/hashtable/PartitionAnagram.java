package com.eop.java.programs.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionAnagram {

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>(Arrays.asList("debitcard",
				"elvis", "money", "badcredit", "lives", "levis", "freedom",
				"listen", "silent","eat","ate"));
		List<List<String>> result = findAnagrams(input);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static List<List<String>> findAnagrams(List<String> dictionary) {

		Map<String, List<String>> anagramsSortedArray = new HashMap<String, List<String>>();
		for (String s : dictionary) {
			char[] sortedArray = s.toCharArray();
			Arrays.sort(sortedArray);
			String sArray = new String(sortedArray);
			if (!anagramsSortedArray.containsKey(sArray)) {
				anagramsSortedArray.put(sArray, new ArrayList<String>());
			}
			anagramsSortedArray.get(sArray).add(s);
		}

		List<List<String>> anagramGroups = new ArrayList<>();
		for (Map.Entry<String, List<String>> p : anagramsSortedArray.entrySet()) {
			if (p.getValue().size() >= 2) {
				anagramGroups.add(p.getValue());
			}
		}
		return anagramGroups;
	}

}

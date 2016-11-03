package com.eop.java.programs.parallelcomputing;

import java.util.*;

/**
 * JAVA program to implement caching in multi-threading
 * 
 * @author SrikarRao
 *
 */
public class MultiThreadCaching extends Thread {

	private static String initVal = null;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			initVal = (i % 2 == 0 ? "y" : "x");
			MultiThreadCaching thread = new MultiThreadCaching();
			thread.start();
			Thread.sleep(2000);
		}
	}

	public void run() {
		try {
			String[] res = SafeSpellCheckService.service(initVal);
			System.out.println(Arrays.toString(res));
		} catch (Exception e) {
		}
	}

	public static class SafeSpellCheckService {
		private static final int MAX_ENTRIES = 3;
		private static final String spellLocker = "lock";

		private static LinkedHashMap<String, String[]> cachedClosestStrings = new LinkedHashMap<String, String[]>() {
			private static final long serialVersionUID = 1615553224L;

			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > MAX_ENTRIES;
			}
		};

		public static String[] service(String word) {
			System.out.println("Inside Service!!");
			synchronized (spellLocker) {
				if (cachedClosestStrings.containsKey(word)) {
					return cachedClosestStrings.get(word);
				}
			}

			String[] closestLastWord = SpellDictionary
					.closestInDictionary(word);
			synchronized (spellLocker) {
				cachedClosestStrings.put(word, closestLastWord);
			}
			return cachedClosestStrings.get(word);
		}
	}
}

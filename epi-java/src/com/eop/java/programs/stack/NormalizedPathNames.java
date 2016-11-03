package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author SrikarRao JAVA Class to implement the parsing of path into absolute
 *         or relative path
 */
public class NormalizedPathNames {
	public static void main(String[] args) throws IllegalAccessException {
		System.out.println("Shorest Equivalent Path!! ");
		System.out.println(shortestEquivalentPath("..//./hello/new/../.."));
	}

	/**
	 * Method to create and return shortest equivalent path
	 * 
	 * @param path
	 * @return
	 * @throws IllegalAccessException
	 */
	public static String shortestEquivalentPath(String path)
			throws IllegalAccessException {
		if (path.equals("")) {
			throw new IllegalAccessException("Empty string is not a legal path");
		}

		Deque<String> pathNames = new LinkedList<String>();

		if (path.startsWith("/")) {
			pathNames.addFirst("/");
		}
		for (String token : path.split("/")) {
			if (token.equals("..")) {
				if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
					pathNames.addFirst(token);
				} else {
					if (pathNames.peekFirst().equals("/")) {
						throw new IllegalArgumentException(
								"Path error, trying to go up root " + path);
					}
					pathNames.removeFirst();
				}
			} else if (!token.equals(".") && !token.isEmpty()) {
				pathNames.addFirst(token);
			}
		}

		StringBuilder result = new StringBuilder();
		if (!pathNames.isEmpty()) {
			Iterator<String> it = pathNames.descendingIterator();
			String prev = it.next();
			result.append(prev);
			while (it.hasNext()) {
				if (!prev.equals("")) {
					result.append("/");
				}
				prev = it.next();
				result.append(prev);
			}
		}
		return result.toString();
	}
}
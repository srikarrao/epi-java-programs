package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.LinkedList;
/**
 * JAVA Class to check if the given string is well formed
 * @author SrikarRao
 *
 */
public class WellFormedString {

	public static void main(String[] args) {
		String wellFormed = "{()}";
		System.out.println("Is " + wellFormed + " a well formed string?? ");
		System.out.println(isWellFormed(wellFormed));
	}

	/**
	 * method to check the well-formedness of a string
	 * @param s
	 * @return
	 */
	public static boolean isWellFormed(String s) {
		Deque<Character> leftChars = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				leftChars.addFirst(s.charAt(i));
			} else {
				if (leftChars.isEmpty()) {
					return false;
				}
				if ((s.charAt(i) == ')' && leftChars.peekFirst() != '(')
						|| (s.charAt(i) == '}' && leftChars.peekFirst() != '{')
						|| s.charAt(i) == ']' && leftChars.peekFirst() != '[') {
					return false;
				}
				leftChars.removeFirst();
			}
		}
		return leftChars.isEmpty();
	}
}

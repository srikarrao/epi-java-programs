package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * JAVA class to sort a Stack in descending order
 * 
 * @author SrikarRao JAVA class to implement the Stack sorting
 */
public class StackSorting_Descending {

	public static void main(String[] args) {
		Deque<Integer> input = new LinkedList<Integer>();
		input.add(17);
		input.add(4);
		input.add(21);
		input.add(-5);
		input.add(-1);
		input.add(8);

		System.out.println("Before sorting");
		printStack(input);
		sort(input);
		System.out.println("After sorting");
		printStack(input);
	}

	private static void printStack(Deque<Integer> stack) {
		Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	/**
	 * method to sort the stack
	 * 
	 * @param S
	 */
	private static void sort(Deque<Integer> S) {
		if (!S.isEmpty()) {
			Integer val = S.removeFirst();
			sort(S);
			insert(val, S);
		}
	}

	/**
	 * Method to insert an element into the stack
	 * 
	 * @param value
	 * @param S
	 */
	private static void insert(int value, Deque<Integer> S) {

		if (S.isEmpty() || Integer.compare(S.peekFirst(), value) <= 0) {
			S.addFirst(value);
		} else {
			Integer x = S.removeFirst();
			insert(value, S);
			S.addFirst(x);
		}
	}
}

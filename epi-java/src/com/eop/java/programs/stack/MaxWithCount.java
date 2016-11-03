package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * JAVA class to implement Stack using Max Count API
 * 
 * @author SrikarRao
 *
 */
public class MaxWithCount {

	private Integer count; // stores the count of the max element
	private Integer max; // stores the max element

	private MaxWithCount(Integer max, Integer count) {
		this.max = max;
		this.count = count;
	}

	public static class Stack {

		private static Deque<MaxWithCount> maxCount = new LinkedList<MaxWithCount>();
		private static Deque<Integer> elements = new LinkedList<Integer>();

		/**
		 * method to push element into the stack
		 * 
		 * @param number
		 */
		private static void push(Integer number) {
			elements.add(number);

			if (!maxCount.isEmpty()) {
				if (Integer.compare(number, maxCount.peekFirst().max) == 0) {
					maxCount.peekFirst().count = maxCount.peekFirst().count + 1;
				} else if (Integer.compare(number, maxCount.peekFirst().max) > 0) {
					maxCount.addFirst(new MaxWithCount(number, 1));
				}
			} else {
				maxCount.addFirst(new MaxWithCount(number, 1));
			}

		}

		/**
		 * method to check if the stack is empty
		 * 
		 * @return
		 */
		private static boolean isEmpty() {
			return elements.isEmpty();
		}

		/**
		 * method to pop element from the stack
		 * 
		 * @return
		 */
		private static Integer pop() {
			if (isEmpty()) {
				throw new IllegalArgumentException("Stack is empty!");
			}
			Integer popElement = elements.removeFirst();
			if (popElement.equals(maxCount.peekFirst().max)) {
				maxCount.addFirst(new MaxWithCount(popElement, maxCount
						.peekFirst().count - 1));
			}
			if (maxCount.peekFirst().count.equals(0)) {
				maxCount.removeFirst();
			}
			return popElement;
		}

		/**
		 * method to return the max element in the stack
		 * 
		 * @return
		 */
		private static Integer max() {
			if (isEmpty()) {
				throw new IllegalArgumentException("Stack is empty!");
			}
			return maxCount.peekFirst().max;
		}
	}

	public static void main(String[] args) {
		Stack.push(1);
		Stack.push(10);
		Stack.push(20);
		Stack.push(12);
		System.out.println("Max element: " + Stack.max());
		System.out.println("Pop element: " + Stack.pop());
		System.out.println("Max element: " + Stack.max());
		System.out.println("Pop element: " + Stack.pop());
		System.out.println("Max element: " + Stack.max());
		System.out.println("Pop element: " + Stack.pop());
	}
}
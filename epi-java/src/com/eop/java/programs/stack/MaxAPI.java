package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * JAVA class to implement Stack using Max API
 * 
 * @author SrikarRao
 *
 */
public class MaxAPI {

	private Integer element; // to store the element
	private Integer max; // to store the max element

	private MaxAPI(Integer element, Integer max) {
		this.element = element;
		this.max = max;
	}

	/**
	 * Inner class to implement Stack
	 * 
	 * @author SrikarRao
	 *
	 */
	public static class Stack {

		private Deque<MaxAPI> cachedMax = new LinkedList<MaxAPI>();

		/**
		 * method to push an element to stack
		 * 
		 * @param number
		 */
		public void push(Integer number) {
			cachedMax.addFirst(new MaxAPI(number, cachedMax.isEmpty() ? number
					: Math.max(number, cachedMax.peekFirst().max)));
		}

		/**
		 * method to check if the stack is empty
		 * 
		 * @return
		 */
		public boolean isEmpty() {
			return cachedMax.isEmpty();
		}

		/**
		 * method to return the max element in the array
		 * 
		 * @return
		 */
		public Integer max() {
			if (!isEmpty()) {
				return cachedMax.peek().max;
			}
			throw new IllegalArgumentException("Stack is empty!!");
		}

		/**
		 * method to pop the element from the stack
		 * 
		 * @return
		 */
		public Integer pop() {
			if (!cachedMax.isEmpty()) {
				return cachedMax.removeFirst().element;
			}
			throw new IllegalArgumentException("Stack is empty!!");
		}
	}

	public void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(10);
		s.push(20);
		s.push(12);
		System.out.println("Max element: " + s.max());
		System.out.println("Pop element: " + s.pop());
		System.out.println("Max element: " + s.max());
		System.out.println("Pop element: " + s.pop());
		System.out.println("Max element: " + s.max());
		System.out.println("Pop element: " + s.pop());
	}
}

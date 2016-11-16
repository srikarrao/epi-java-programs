package com.eop.java.programs.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Java Program to implement a stack API using a heap(EPI_Heaps)
 * 
 * @author SrikarRao
 *
 */
public class StackAPI {

	private static final int CAPACITY = 16;

	/**
	 * static inner class to store the values and index
	 * 
	 * @author SrikarRao
	 *
	 */
	private static class ValueWithIndex {

		public Integer value;
		public Integer index;

		public ValueWithIndex(Integer value, Integer index) {
			this.value = value;
			this.index = index;
		}
	}

	/**
	 * Comparator class for descending sorting
	 * 
	 * @author SrikarRao
	 *
	 */
	private static class Compare implements Comparator<ValueWithIndex> {
		public static final Compare COMPARE_ValueWithIndex = new Compare();

		@Override
		public int compare(ValueWithIndex v1, ValueWithIndex v2) {
			return Integer.compare(v2.value, v1.value);
		}
	}

	/**
	 * Stack implementation
	 * 
	 * @author SrikarRao
	 *
	 */
	public static class Stack {

		private int timestamp = 0;
		private PriorityQueue<ValueWithIndex> maxHeap = new PriorityQueue<>(
				CAPACITY, Compare.COMPARE_ValueWithIndex);

		public void push(Integer x) {
			maxHeap.add(new ValueWithIndex(timestamp++, x));
		}

		public Integer pop() throws NoSuchElementException {
			return maxHeap.remove().index;
		}

		public Integer peek() {
			return maxHeap.peek().index;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(70);
		stack.push(11);
		stack.push(-1);
		stack.push(13);
		stack.push(-7);
		stack.push(10);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

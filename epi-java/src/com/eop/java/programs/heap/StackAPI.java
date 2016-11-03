package com.eop.java.programs.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class StackAPI {

	private static final int CAPACITY = 16;

	private static class ValueWithRank {

		public Integer rank;
		public Integer value;

		public ValueWithRank(Integer value, Integer rank) {
			this.rank = rank;
			this.value = value;
		}
	}

	private static class Compare implements Comparator<ValueWithRank> {
		public static final Compare COMPARE_VALUEWITHRANK = new Compare();

		@Override
		public int compare(ValueWithRank v1, ValueWithRank v2) {
			return Integer.compare(v2.value, v1.value);
		}
	}

	public static class Stack {

		private int timestamp = 0;
		private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<>(
				CAPACITY, Compare.COMPARE_VALUEWITHRANK);

		public void push(Integer x) {
			maxHeap.add(new ValueWithRank(timestamp++, x));
		}

		public Integer pop() throws NoSuchElementException {
			return maxHeap.remove().rank;
		}

		public Integer peek() {
			return maxHeap.peek().rank;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(11);
		stack.push(13);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

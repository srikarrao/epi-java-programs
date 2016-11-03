package com.eop.java.programs.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * JAVA Class to implement Queue using Stack
 * 
 * @author SrikarRao
 *
 */
public class QueueWithStackAPI {

	// for pushing data
	private static Deque<Integer> deque = new LinkedList<Integer>();
	// for pulling data
	private static Deque<Integer> enque = new LinkedList<Integer>();

	/**
	 * method to push elements into the queue
	 * 
	 * @param val
	 */
	public static void enqueue(int val) {
		enque.addFirst(val);
	}

	/**
	 * method to pull elements from the queue
	 * 
	 * @return
	 */
	public static int dequeue() {
		if (deque.isEmpty()) {
			while (!enque.isEmpty()) {
				deque.addFirst(enque.removeFirst());
			}
		}
		if (!deque.isEmpty()) {
			return deque.removeFirst();
		}
		throw new IllegalArgumentException("Queue is empty!!");
	}

	public static void main(String[] args) {
		enqueue(10);
		enqueue(20);
		enqueue(-1);
		enqueue(88);
		enqueue(-43);

		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}

}

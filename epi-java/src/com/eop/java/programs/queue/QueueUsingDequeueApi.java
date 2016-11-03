package com.eop.java.programs.queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDequeueApi {

	private Deque<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		QueueUsingDequeueApi dqApi = new QueueUsingDequeueApi();
		dqApi.enqueue(10);
		dqApi.enqueue(11);
		dqApi.enqueue(12);
		dqApi.enqueue(13);

		System.out.println("Queue is " + dqApi.queue);
		System.out.println(dqApi.dequeue());
		System.out.println(dqApi.dequeue());
		System.out.println(dqApi.dequeue());
		System.out.println(dqApi.dequeue());
		// Queue is [13, 12, 11, 10]
		// 10,11,12,13
	}

	public void enqueue(Integer e) {
		queue.addFirst(e);
	}

	public int dequeue() {
		if (!queue.isEmpty()) {
			return queue.pollLast();
		}
		throw new IllegalArgumentException("Queue is empty!!!");
	}

}

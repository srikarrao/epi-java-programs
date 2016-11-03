package com.eop.java.programs.queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingStackApi {

	private Deque<Integer> EQueue = new LinkedList<Integer>();
	private Deque<Integer> DQueue = new LinkedList<Integer>();

	public void enqueue(Integer e) {
		EQueue.addFirst(e);
	}

	public int dequeue() {
		while (!EQueue.isEmpty()) {
			DQueue.addFirst(EQueue.pollFirst());
		}

		if (!DQueue.isEmpty()) {
			return DQueue.removeFirst();
		}
		throw new IllegalArgumentException("Queue is empty!!!");
	}

	public static void main(String[] args) {
		QueueUsingStackApi qStackApi = new QueueUsingStackApi();
		qStackApi.enqueue(10);
		qStackApi.enqueue(11);
		qStackApi.enqueue(12);
		qStackApi.enqueue(13);

		System.out.println(qStackApi.dequeue());
		System.out.println(qStackApi.dequeue());
		System.out.println(qStackApi.dequeue());
		System.out.println(qStackApi.dequeue());
	}
}

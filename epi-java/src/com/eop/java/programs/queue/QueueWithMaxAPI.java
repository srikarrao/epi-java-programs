package com.eop.java.programs.queue;

import com.eop.java.programs.stack.MaxAPI;
import com.eop.java.programs.stack.MaxAPI.Stack;

public class QueueWithMaxAPI {

	private MaxAPI.Stack enqueue = new Stack();
	private MaxAPI.Stack dequeue = new MaxAPI.Stack();

	public void enqueue(Integer x) {
		enqueue.push(x);
	}

	public Integer dequeue() {
		if (dequeue.isEmpty()) {
			while (!enqueue.isEmpty()) {
				dequeue.push(enqueue.pop());
			}
		}
		if (!dequeue.isEmpty()) {
			return dequeue.pop();
		}
		throw new IllegalArgumentException("Queue is Empty!!");
	}

	public Integer max() {
		if (!enqueue.isEmpty()) {
			return enqueue.max();
		} else {
			if (!dequeue.isEmpty()) {
				return dequeue.max();
			}
			throw new IllegalArgumentException("Queue is Empty!!");
		}
	}

	public static void main(String[] args) {
		QueueWithMaxAPI queMax = new QueueWithMaxAPI();
		queMax.enqueue(11);
		queMax.enqueue(12);
		queMax.enqueue(13);
		System.out.println("Max element: " + queMax.max());
		System.out.println("Dequeue element: " + queMax.dequeue());
		System.out.println("Max element: " + queMax.max());
		System.out.println("Dequeue element: " + queMax.dequeue());
		System.out.println("Max element: " + queMax.max());
		System.out.println("Dequeue element: " + queMax.dequeue());
	}
}

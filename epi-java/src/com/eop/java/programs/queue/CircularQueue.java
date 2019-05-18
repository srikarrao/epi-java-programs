package com.eop.java.programs.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CircularQueue {

	private final int SCALE_FACTOR = 2;
	private Integer[] queue;
	int head = 0, tail = 0, numOfElements = 0;

	public CircularQueue(int capacity) {
		queue = new Integer[capacity];
	}

	private Integer size() {
		return numOfElements;
	}

	private void enqueue(int value) {

		if (numOfElements == queue.length) {
			// Collections.rotate(Arrays.asList(queue), -head);
			head = 0;
			tail = numOfElements;
			queue = Arrays.copyOf(queue, numOfElements * SCALE_FACTOR);
		}
		queue[tail] = value;
		tail = (tail + 1) % queue.length;
		numOfElements++;
	}

	private Integer dequeue() {
		if (numOfElements != 0) {
			numOfElements--;
			Integer ret = queue[head];
			head = (head + 1) % queue.length;
			return ret;
		}
		throw new NoSuchElementException("Queue is Empty!!");

	}

	private void display() {
		int i = 0;
		while (i < queue.length) {
			System.out.print(queue[i++]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(3);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.display();
		
		cq.enqueue(4);
		cq.display();
		
		System.out.println(cq.dequeue());
		cq.display();
		
		cq.enqueue(5);
		cq.display();
		System.out.println(cq.dequeue());
		
		cq.enqueue(6);
		cq.display();
		System.out.println(cq.dequeue());
		
		cq.enqueue(7);
		cq.display();
		System.out.println(cq.dequeue());
		
		cq.enqueue(8);
		cq.display();
		System.out.println(cq.dequeue());
		
		cq.enqueue(9);
		cq.display();
		System.out.println(cq.dequeue());
		
		cq.enqueue(10);
		cq.display();
		System.out.println(cq.dequeue());
	}
}

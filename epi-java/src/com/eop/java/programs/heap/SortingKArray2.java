package com.eop.java.programs.heap;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.PriorityQueue;

public class SortingKArray2 {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		FileOutputStream out = new FileOutputStream("input//test.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(3);
		oout.writeObject(-1);
		oout.writeObject(2);
		oout.writeObject(6);
		oout.writeObject(4);
		oout.writeObject(5);
		oout.writeObject(8);
		oout.writeObject(11);
		oout.writeObject(10);

		sortApproximatelySortedData(new FileInputStream("input//test.txt"), 3);
	}

	public static void sortApproximatelySortedData(InputStream sequence, int k)
			throws ClassNotFoundException, FileNotFoundException, EOFException,
			IOException {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		try {
			ObjectInputStream osin = new ObjectInputStream(sequence);

			while (true) {
				minHeap.add((Integer) osin.readObject());
				if (minHeap.size() > k) {
					Integer smallElement = minHeap.poll();
					System.out.print(smallElement + " ");
				}
			}
		} catch (EOFException e) {
		}
		while (!minHeap.isEmpty()) {
			Integer smallElement = minHeap.poll();
			System.out.print(smallElement + " ");
		}
	}
}

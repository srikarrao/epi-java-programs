package com.eop.java.programs.heap.kStars;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PointDistance {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		Star star1 = new Star(2, 2, 3);
		Star star2 = new Star(0, 0, 0);
		Star star3 = new Star(-1, 1, 3);
		Star star4 = new Star(-2, -2, -3);
		Star star5 = new Star(4, 1, -4);
		Star star6 = new Star(-2, -1, 2);
		Star star7 = new Star(3, 6, 4);
		Star star8 = new Star(9, 9, 1);

		FileOutputStream out = new FileOutputStream("input//kStar.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(star1);
		oout.writeObject(star2);
		oout.writeObject(star3);
		oout.writeObject(star4);
		oout.writeObject(star5);
		oout.writeObject(star6);
		oout.writeObject(star7);
		oout.writeObject(star8);
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
				"input//kStar.txt"));
		displayCloseStars(findClosestStars(3, oin));
	}

	static Double distance(Star star) {
		if (star == null)
			return 0.0;

		return Math.sqrt(star.x * star.x + star.y * star.y + star.z * star.z);
	}

	public static List<Star> findClosestStars(int k, ObjectInputStream osin)
			throws ClassNotFoundException, IOException {

		PriorityQueue<Star> maxHeap = new PriorityQueue<Star>(16,
				new Comparator<Star>() {
					@Override
					public int compare(Star o1, Star o2) {
						double dist1 = distance(o1);
						double dist2 = distance(o2);
						return Double.compare(dist2, dist1);
					}
				});

		try {
			while (true) {
				Star star = (Star) osin.readObject();
				maxHeap.add(star);
				if (maxHeap.size() == k + 1) {
					maxHeap.remove();
				}
			}
		} catch (EOFException eof) {
		}
		List<Star> orderedStars = new ArrayList<Star>(maxHeap);
		Collections.sort(orderedStars);
		return orderedStars;
	}

	public static void displayCloseStars(List<Star> result) {
		for (Star s : result) {
			System.out.println("Distance is :--> " + s.distance()
					+ " and coordinates (x,y,z) are (" + s.x + "," + s.y + ","
					+ s.z + ")");
		}
	}
}

package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFlagPartition {
	public static enum Color {
		RED, WHITE, BLUE;
	}

	private static List<Color> dutchList = new ArrayList<>();

	public static void main(String[] args) {
		dutchList.add(Color.WHITE); 
		dutchList.add(Color.BLUE);
		dutchList.add(Color.RED);
		dutchList.add(Color.RED);
		dutchList.add(Color.BLUE);
		dutchList.add(Color.WHITE);
		dutchList.add(Color.BLUE);
		dutchList.add(Color.WHITE);
		dutchList.add(Color.BLUE);
		dutchList.add(Color.RED);
		dutchList.add(Color.RED);
		dutchList.add(Color.WHITE);

		System.out.println("Before DFP " + dutchList);
		dutchFlagPartition(5, dutchList);
	}

	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {

		Color pivot = A.get(pivotIndex);

		/*
		 * System.out.println("pivot Index: " + pivotIndex);
		 * System.out.println("pivot: " + A.get(pivotIndex));
		 * System.out.println("Initial Ordinal: " +
		 * A.get(pivotIndex).ordinal());
		 */

		// First passs: group elmenets smaller than pivot
		int smaller = 0;

		for (int i = 0; i < A.size(); ++i) {
			if (A.get(i).ordinal() < pivot.ordinal()) {
				Collections.swap(A, smaller, i);
				smaller++;
			}
		}

		// Second passs: group elements smaller than pivot
		int larger = A.size();

		for (int i = (A.size() - 1); i >= 0
		/* && A.get(i).ordinal() > pivot.ordinal() */; i--) {
			if (A.get(i).ordinal() > pivot.ordinal()) {
				larger--;
				Collections.swap(A, larger, i);
			}
		}
		System.out.println("After DFP " + A);
	}
}

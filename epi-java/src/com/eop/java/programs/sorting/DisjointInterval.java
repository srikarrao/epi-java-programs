package com.eop.java.programs.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JAVA program to find the disjoint intervals,Time complexity : O(n)
 * 
 * @author SrikarRao
 *
 */
public class DisjointInterval {

	/**
	 * Nested static class to hold interval variables
	 *
	 */
	static class Interval {

		// instance variables
		public int left, right;

		// Constructor to initialize variables
		public Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * method to form disjoint sets of time intervals
	 * 
	 * @param disjointList
	 * @param newDisjointInterval
	 * @return
	 */
	public static List<Interval> formDisjointIntervalList(
			List<Interval> disjointList, Interval newDisjointInterval) {

		// defining result List
		List<Interval> resultList = new ArrayList<Interval>();

		int i = 0; // iterating variable set to 0
		/*
		 * while loop to check and iterate the intervals list with given
		 * interval
		 */
		while (i < disjointList.size()
				&& newDisjointInterval.left > disjointList.get(i).right) {
			// adding intervals lesser than the given interval
			resultList.add(disjointList.get(i++));
		}

		/**
		 * while loop to check and iterate the given interval with remaining
		 * list
		 */
		while (i < disjointList.size()
				&& newDisjointInterval.right >= disjointList.get(i).left) {
			/*
			 * collapse the given interval with the current internal element of
			 * the list
			 */
			newDisjointInterval = new Interval(Math.min(
					newDisjointInterval.left, disjointList.get(i).left),
					Math.max(newDisjointInterval.right,
							disjointList.get(i).right));
			i++;
		}

		// add the disjoint interval to the result list
		resultList.add(newDisjointInterval);
		// add remaining intervals to the return list
		resultList.addAll(disjointList.subList(i, disjointList.size()));
		return resultList;
	}

	public static void main(String[] args) {
		// define interval list and add interval objects as elements
		List<Interval> disjointList = new ArrayList<Interval>(Arrays.asList(
				new Interval(-4, -1), new Interval(0, 2), new Interval(3, 6),
				new Interval(7, 9), new Interval(11, 12), new Interval(14, 17)));

		// defining a interval object to embed in the list of intervals
		Interval newDisjointInterval = new Interval(1, 8);

		// invoke the method to form a disjoint set of intervals
		List<Interval> result = formDisjointIntervalList(disjointList,
				newDisjointInterval);

		// print the newly formed intervals
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[" + result.get(i).left + ","
					+ result.get(i).right + "]");
		}
	}
}

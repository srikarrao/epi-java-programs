package com.eop.java.programs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * JAVA Program to calculate the largest rectangle in the skyline
 * 
 * @author SrikarRao
 *
 */
public class LargestSkylineRectangle {

	public static void main(String[] args) {

		List<Integer> inputs = new ArrayList<Integer>(Arrays.asList(7, 10, 15,
				4));
		System.out.println(calculateLargestRectangle(inputs));
	}

	public static int calculateLargestRectangle(List<Integer> heights) {
		Deque<Integer> S = new LinkedList<Integer>();
		int maxArea = 0;

		for (int i = 0; i <= heights.size(); i++) {
			while (!S.isEmpty()
					&& (i == heights.size() || heights.get(i) < heights.get(S
							.peekFirst()))) {
				int height = heights.get(S.peekFirst());
				S.removeFirst();
				maxArea = Math.max(maxArea,
						height * (S.isEmpty() ? i : i - S.peekFirst() - 1));
			}
			S.addFirst(i);
		}
		return maxArea;
	}
}
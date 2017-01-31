package com.eop.java.programs.greedyAlgorithm;

import java.util.*;

public class SkylineRectangle {

	public static void main(String[] args) {
		List<Integer> heights = Arrays.asList(1, 2, 1, 5);
		System.out.println(getArea(heights));
	}

	private static int getArea(List<Integer> heights) {
		int maxArea = 0;
		Deque<Integer> area = new LinkedList<Integer>();
		for (int i = 0; i <= heights.size(); i++) {
			while (!area.isEmpty()
					&& (i == heights.size() || heights.get(i) < heights
							.get(area.peekFirst()))) {
				int h = heights.get(area.peekFirst());
				area.removeFirst();
				maxArea = Math.max(maxArea,
						h * (area.isEmpty() ? i : i - area.peekFirst() - 1));
			}
			area.addFirst(i);
		}
		return maxArea;
	}
}
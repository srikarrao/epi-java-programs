package com.eop.java.programs.greedyAlgorithm;

import java.util.*;

public class SkylineRectangle {

    public static void main(String[] args) {
        // List<Integer> heights = Arrays.asList(1, 2, 1, 5);
        //List<Integer> heights = Arrays.asList(10, 4, 5, 10, 7, 11, 9);
        List<Integer> heights = Arrays.asList(4, 2, 1);
        System.out.println(getArea(heights));
    }

    private static int getArea(List<Integer> heights) {
        int maxArea = 0;
        Deque<Integer> buildings = new LinkedList<>();
        for (int i = 0; i <= heights.size(); i++) {
            while (!buildings.isEmpty()
                    && (i == heights.size() || heights.get(i) < heights
                    .get(buildings.peekFirst()))) {
                int height = heights.get(buildings.removeFirst());
                int width = (buildings.isEmpty() ? i : i - buildings.peekFirst() - 1);
                int area = height * width;
                System.out.println("height: " + height + ", width: " + width + ", area: " + area);
                maxArea = Math.max(maxArea, area);
            }
            buildings.addFirst(i);
        }
        return maxArea;
    }
}
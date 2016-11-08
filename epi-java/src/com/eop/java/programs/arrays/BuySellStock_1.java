package com.eop.java.programs.arrays;

import java.util.*;

/**
 * Buy and sell stock once
 * 
 * @author SrikarRao
 *
 */
public class BuySellStock_1 {

	public static void main(String[] args) {
		System.out.println(calculateMaxProfit(new ArrayList<Double>(Arrays
				.asList(310.0, 315.0, 275.0, 295.0, 260.0, 270.0, 290.0, 230.0,
						255.0, 250.0))));

		System.out.println(calculateMaxProfit(new ArrayList<Double>(Arrays
				.asList(12.0, 11.0, 13.0, 9.0, 12.0, 8.0, 14.0, 13.0, 15.0))));
	}

	/**
	 * method to calculate the maximum profit
	 * 
	 * @param pricesList
	 * @return
	 */
	private static double calculateMaxProfit(List<Double> pricesList) {

		double maxProfit = 0.0, minPrice = Double.MAX_VALUE;

		for (Double price : pricesList) {
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
		}
		return maxProfit;
	}
}

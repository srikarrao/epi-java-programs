package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JAVA Program to buy and sell stock twice
 * 
 * @author SrikarRao
 *
 */
public class BuySellStock_2 {

	public static void main(String[] args) {

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

		double maxForNow = 0.0, min = Double.MAX_VALUE;
		List<Double> firstRoundMax = new ArrayList<Double>();

		for (Double price : pricesList) {
			min = Math.min(min, price);
			maxForNow = Math.max(maxForNow, price - min);
			firstRoundMax.add(maxForNow);
		}

		double max = Double.MIN_VALUE;
		for (int i = firstRoundMax.size() - 1; i > 0; i--) {
			max = Math.max(max, pricesList.get(i));
			maxForNow = Math.max(maxForNow, max - pricesList.get(i)
					+ firstRoundMax.get(i - 1));
		}
		return maxForNow;
	}
}

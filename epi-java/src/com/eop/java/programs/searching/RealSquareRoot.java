package com.eop.java.programs.searching;

public class RealSquareRoot {

	private static enum Ordering {
		SMALL, EQUAL, LARGE
	}

	public static void main(String[] args) {
		System.out.println(finSquareRoot(1.001));
	}

	public static double finSquareRoot(double k) {
		double low;
		double high;
		if (k < 1.0) {
			low = k;
			high = 1.0;
		} else {
			high = k;
			low = 1.0;
		}
		while (compare(low, high) == Ordering.SMALL) {
			double mid = low + 0.5 * (high - low);
			double squareRoot = mid * mid;
			if (compare(squareRoot, k) == Ordering.EQUAL) {
				return mid;
			} else if (compare(squareRoot, k) == Ordering.LARGE) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

	private static Ordering compare(double x, double y) {
		final double EPSILON = 0.00001;
		x = (x - y) / y;
		if (x < -EPSILON) {
			return Ordering.SMALL;
		} else if (x > EPSILON) {
			return Ordering.LARGE;
		} else {
			return Ordering.EQUAL;
		}
	}
}

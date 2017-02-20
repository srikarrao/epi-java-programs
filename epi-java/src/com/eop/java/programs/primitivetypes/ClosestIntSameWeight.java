package com.eop.java.programs.primitivetypes;

/**
 * Java program to find the same weight i.e. number of 1 bits
 * 
 * @author SrikarRao
 *
 */
public class ClosestIntSameWeight {

	public static void main(String[] args) {
		System.out.println(closetWeight(6));
		System.out.println(closetWeight(5));
		System.out.println(closetWeight(92));
		System.out.println(closetWeight(0));
		System.out.println(closetWeight(15));
		System.out.println(closetWeight(1));
	}

	private static int closetWeight(int num) {
		int count = 0;
		do {
			if (num % 2 == 1) {
				count++;
			}
			num /= 2;
		} while (num > 0);
		return count;
	}
}

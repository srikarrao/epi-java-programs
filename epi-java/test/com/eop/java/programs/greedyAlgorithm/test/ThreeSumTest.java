package com.eop.java.programs.greedyAlgorithm.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import com.eop.java.programs.greedyAlgorithm.ThreeSum;

/**
 * Program to test the ThreeSum program
 * 
 * @author SrikarRao
 *
 */
public class ThreeSumTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {

		// list is null
		assertFalse(ThreeSum.hasThreeSum(null, 0));

		// List size < 3 elements
		assertFalse(ThreeSum.hasThreeSum(
				new ArrayList<Integer>(Arrays.asList(11, 2)), 21));

		// List more than 3 elements
		assertTrue(ThreeSum.hasThreeSum(
				new ArrayList<Integer>(Arrays.asList(11, 5, 2, 7, 3)), 21));

		// List more than 3 elements
		assertFalse(ThreeSum.hasThreeSum(
				new ArrayList<Integer>(Arrays.asList(11, 15, 2, 1, 17, 20, 3)),
				201));
		// negative numbers
		assertTrue(ThreeSum
				.hasThreeSum(
						new ArrayList<Integer>(Arrays.asList(-11, -15, 2, 1,
								17, 20, 3)), 6));
	}
}
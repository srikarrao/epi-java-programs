package com.eop.java.programs.dynamicprogramming.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eop.java.programs.dynamicprogramming.Traversing2DArray;

/**
 * JAVA program to test the Traversing2DArray program
 * 
 * @author SrikarRao
 *
 */
public class Traversing2DArrayTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {
		assertEquals(70, Traversing2DArray.numberOfWays(5, 5));
		assertEquals(-1, Traversing2DArray.numberOfWays(0,0 ));
		assertEquals(1, Traversing2DArray.numberOfWays(1, 1));
		assertEquals(2, Traversing2DArray.numberOfWays(2, 2));
		
		assertEquals(3, Traversing2DArray.numberOfWays(2, 3));
		assertEquals(10, Traversing2DArray.numberOfWays(4,3));
	}
}

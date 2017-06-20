package com.eop.java.programs.primitivetypes.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static com.eop.java.programs.primitivetypes.DecimalPalindrome.*;

/**
 * Java program to test if the given decimal number is a Palindrome
 * 
 * @author SrikarRao
 *
 */
public class DecimalPalindromTest {

	@Test
	public void test() {
		// assertEquals(true, isPalindrome(101));
		assertEquals(true, isPalindrome(1557551));
		assertEquals(true, isPalindrome(0));
		assertEquals(true, isPalindrome(1));
		assertEquals(false, isPalindrome(15557551));
		assertEquals(false, isPalindrome(-1));
		assertEquals(false, isPalindrome(1000));
	}
}

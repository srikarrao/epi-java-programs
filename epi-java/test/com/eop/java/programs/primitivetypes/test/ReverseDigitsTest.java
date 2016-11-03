package com.eop.java.programs.primitivetypes.test;

import org.junit.Test;
import com.eop.java.programs.primitivetypes.ReverseDigits;
import static org.junit.Assert.*;

public class ReverseDigitsTest {

	@Test
	public void test() {
		assertEquals(ReverseDigits.reverseDigits(-314), -413);
		assertEquals(ReverseDigits.reverseDigits(314), 413);
		assertEquals(ReverseDigits.reverseDigits(0), 0);
		assertEquals(ReverseDigits.reverseDigits(1), 1);
		assertEquals(ReverseDigits.reverseDigits(100), 1);
		assertEquals(ReverseDigits.reverseDigits(2311), 1132);
		assertEquals(ReverseDigits.reverseDigits(-2311), -1132);
	}

}

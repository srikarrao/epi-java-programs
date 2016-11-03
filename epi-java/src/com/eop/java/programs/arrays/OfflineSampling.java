package com.eop.java.programs.arrays;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OfflineSampling {

	public static void randomSampling(int k, List<Integer> list) {
		Random gen = new Random();
		for (int i = 0; i < k; i++) {
			Collections.swap(list, i, i + gen.nextInt(list.size() - i));
		}
	}
}

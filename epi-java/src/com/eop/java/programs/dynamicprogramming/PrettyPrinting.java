package com.eop.java.programs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Program to find the minimum messing count
 * 
 * @author SrikarRao
 *
 */
public class PrettyPrinting {

	/**
	 * method to implement pretty printing
	 * 
	 * @param W
	 * @param L
	 * @return
	 */
	public static int findPrettyPrinting(List<String> W, int L) {

		List<Long> M = new ArrayList<Long>(Collections.nCopies(W.size(),
				Long.MAX_VALUE));
		for (int i = 0; i < W.size(); i++) {
			int bLen = L - W.get(i).length();
			M.set(i,
					Math.min((i - 1 < 0 ? 0 : M.get(i - 1)) + (1 << bLen),
							M.get(i)));

			for (int j = i - 1; j >= 0; j--) {
				bLen -= (W.get(j).length() + 1);
				if (bLen < 0) {
					break;
				}
				M.set(i, Math.min((j - 1 < 0 ? 0 : M.get(j - 1)) + (1 << bLen),
						M.get(i)));
			}
		}

		long minMess = (W.size() >= 2 ? M.get(W.size() - 2) : 0);
		int bLen = L - W.get(W.size() - 1).length();
		for (int i = W.size() - 2; i >= 0; i--) {
			bLen -= (W.get(i).length() + 1);
			if (bLen < 0) {
				return (int) minMess;
			}
			minMess = Math.min(minMess, (i - 1 < 0 ? 0 : M.get(i - 1)));
		}
		return (int) minMess;
	}
}

package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;

public class AdvanceAnArray {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(0);
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(1);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		boolean result = canReachEnd(list);
		System.out.println("Result: " + result);
	}

	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestRaechSoFar = 0;
		int lastIndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= furthestRaechSoFar
				&& furthestRaechSoFar < lastIndex; i++) {
			furthestRaechSoFar = Math.max(furthestRaechSoFar, i
					+ maxAdvanceSteps.get(i));
			System.out.println("value of i is: " +i);
		}
		System.out.println("furthestReachSoFar: " +furthestRaechSoFar +"  lastIndex: "+lastIndex);
		return furthestRaechSoFar >= lastIndex;
	}
}

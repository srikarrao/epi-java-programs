package com.eop.java.programs.sorting.playersRowing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamPlayer {
	private static List<Integer> IndiaHeights = new ArrayList<Integer>();
	private static List<Integer> EnglandHeights = new ArrayList<Integer>();;

	public static void main(String[] args) {
		EnglandHeights.add(8);
		EnglandHeights.add(7);
		EnglandHeights.add(6);
		EnglandHeights.add(5);
		EnglandHeights.add(7);

		IndiaHeights.add(5);
		IndiaHeights.add(5);
		IndiaHeights.add(5);
		IndiaHeights.add(5);
		IndiaHeights.add(5);
		Collections.sort(IndiaHeights);
		Collections.sort(EnglandHeights);

		System.out.print(checkPlace());
	}

	public static boolean checkPlace() {
		for (int i = 0; i < IndiaHeights.size() && i < EnglandHeights.size(); i++) {
			if (IndiaHeights.get(i).compareTo(EnglandHeights.get(i)) > 0) {
			// if (EnglandHeights.get(i).compareTo(IndiaHeights.get(i)) > 0) {	
			return false;
			}
		}
		return true;
	}
}

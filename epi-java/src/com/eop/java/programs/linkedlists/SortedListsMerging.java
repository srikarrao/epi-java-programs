package com.eop.java.programs.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class SortedListsMerging {

	public static List<Integer> list1 = new ArrayList<>();
	public static List<Integer> list2 = new ArrayList<>();
	public static List<Integer> mergedList = new ArrayList<>();

	public static void main(String[] args) {
		list1.add(3);
		list1.add(5);
		list1.add(19);
		list1.add(45);
		list1.add(88);

		list2.add(13);
		list2.add(17);
		list2.add(29);
		list2.add(45);
		list2.add(73);

		System.out.println("Before Merging");
		System.out.println("List 1 --> " + list1);
		System.out.println("List 2 --> " + list2);
		System.out.println("Merged List --> " + mergeSortedLists());
	}

	public static List<Integer> mergeSortedLists() {
		int i1 = 0;
		int i2 = 0;
		while (i1 < list1.size() & i2 < list2.size()) {
			if (list1.get(i1) <= list2.get(i2)) {
				mergedList.add(list1.get(i1));
				i1++;
			} else {
				mergedList.add(list2.get(i2));
				i2++;
			}
		}

		while (i1 < list1.size()) {
			mergedList.add(list1.get(i1));
			i1++;
		}

		while (i2 < list2.size()) {
			mergedList.add(list2.get(i2));
			i2++;
		}
		return mergedList;
	}
}

package com.eop.java.programs.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplicate {
	private static List<Integer> dupValuesList = new ArrayList<>();
	private static int size = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the list: ");
		try {
			size = scn.nextInt();
			if (size > 0) {
				System.out.println("Enter the elements in the list");
				for (int i = 0; i < size; i++) {
					dupValuesList.add(scn.nextInt());
				}
				System.out.println("Before deleting the duplicate values ");
				displayDupValuesList();
				deleteDuplicates();
				System.out.println("After deleting the duplicate values ");
				displayDupValuesList();
			} else {
				System.out.println("Enter size > 1");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void deleteDuplicates() {

		if (null == dupValuesList && dupValuesList.isEmpty()) {
			return;
		}
		for (int i = 1; i < dupValuesList.size() - 1; i++) {
			if (dupValuesList.get(i - 1) == dupValuesList.get(i)) {
				dupValuesList.remove(i - 1);
				i--;
			}
		}
		if (dupValuesList.size()>1 && dupValuesList.get(dupValuesList.size() - 1) == dupValuesList
				.get(dupValuesList.size() - 2)) {
			dupValuesList.remove(dupValuesList.size() - 1);
		}
	}

	public static void displayDupValuesList() {
		for (int i = 0; i < dupValuesList.size(); i++) {
			System.out.print(dupValuesList.get(i) + " ");
		}
		System.out.println();
	}
}

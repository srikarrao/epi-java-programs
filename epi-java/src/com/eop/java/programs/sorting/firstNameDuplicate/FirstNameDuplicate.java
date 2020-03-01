package com.eop.java.programs.sorting.firstNameDuplicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JAVA program to remove the duplicates i.e. names with similar first names
 * 
 * @author SrikarRao
 *
 */
public class FirstNameDuplicate {

	public static void main(String[] args) {
		List<Name> duplicateList = new ArrayList<>(); // defining a list
		/**
		 * instantiating name objects
		 */
		Name n1 = new Name();
		Name n2 = new Name();
		Name n3 = new Name();
		Name n4 = new Name();

		/**
		 * Assigning values to the name instance variables
		 */
		n1.fName = "Ian";
		n1.lName = "Botham";
		n2.fName = "David";
		n2.lName = "Gover";
		n3.fName = "Ian";
		n3.lName = "Bell";
		n4.fName = "Ian";
		n4.lName = "Chappel";

		/**
		 * adding name objects as elements to the list
		 */
		duplicateList.add(n1);
		duplicateList.add(n2);
		duplicateList.add(n3);
		duplicateList.add(n4);
		// invoking the eliminate duplicates method
		eliminateDuplicates(duplicateList);
	}

	/**
	 * method to eliminate the duplicates from the list
	 * 
	 * @param duplicateList
	 */
	public static void eliminateDuplicates(List<Name> duplicateList) {
		int x = 0; // initialize the iterable variable

		// sorting the collection i.e. list
		Collections.sort(duplicateList);

		/**
		 * Logic to remove duplicates
		 */
		for (int i = 1; i < duplicateList.size(); i++) {
			if (!duplicateList.get(i).fName.equals(duplicateList.get(x).fName)) {
				x++;
				// set the next element
				duplicateList.set(x, duplicateList.get(i));
			}
		}

		// clear the remaining list
		x++;
		duplicateList.subList(x, duplicateList.size()).clear();

		/**
		 * Print the elements in the list after eliminating duplicates
		 */
		for (int i = 0; i < duplicateList.size(); i++) {
			System.out.println("(" + duplicateList.get(i).fName + ","
					+ duplicateList.get(i).lName + ")");
		}
	}
}

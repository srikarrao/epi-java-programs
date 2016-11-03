package com.eop.java.programs.sorting.firstNameDuplicate;

/**
 * Simple JAVA Class "Name"
 * 
 * @author SrikarRao
 *
 */
public class Name implements Comparable<Name> {
	/**
	 * Instance variables
	 */
	public String fName;
	public String lName;

	/**
	 * Override compareTo method of Comparable Interface to sort
	 */
	@Override
	public int compareTo(Name name) {
		int cmpFirst = fName.compareTo(name.fName);
		if (cmpFirst != 0) {
			return cmpFirst;
		}
		return lName.compareTo(name.lName);
	}
}

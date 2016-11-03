package com.eop.java.programs.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalaryThreshold {

	public static void main(String[] args) {

		List<Double> currentSalaries = new ArrayList<Double>();
		currentSalaries.add(20.00);
		currentSalaries.add(30.00);
		currentSalaries.add(40.00);
		currentSalaries.add(90.00);
		currentSalaries.add(100.00);
		System.out.println("The salary cap this year is: "
				+ findSalaryCap(210, currentSalaries));
	}

	public static double findSalaryCap(double targetPayroll,
			List<Double> currentSalaries) {
		Collections.sort(currentSalaries);
		double unadjustedSalarySum = 0;
		double adjustedSalarySum = currentSalaries.get(0)
				* currentSalaries.size();
		for (int i = 0; i < currentSalaries.size(); i++) {
			unadjustedSalarySum += currentSalaries.get(i);
			adjustedSalarySum = currentSalaries.get(i)
					* (currentSalaries.size() - (i + 1));
			if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {
				return (targetPayroll - unadjustedSalarySum + currentSalaries
						.get(i)) / (currentSalaries.size() - 1);
			}
		}
		return -1.0;
	}

}

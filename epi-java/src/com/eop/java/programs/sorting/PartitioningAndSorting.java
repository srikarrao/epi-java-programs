package com.eop.java.programs.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PartitioningAndSorting implements
		Comparable<PartitioningAndSorting> {

	public Integer age;
	public String name;

	public PartitioningAndSorting(Integer i, String s) {
		age = i;
		name = s;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public int compareTo(PartitioningAndSorting p) {
		return Integer.compare(age, p.age);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PartitioningAndSorting
				&& ((PartitioningAndSorting) o).age.equals(age)) {
			return true;
		} else {
			return false;
		}
	}

	public static List<PartitioningAndSorting> groupByAge(
			List<PartitioningAndSorting> people) {
		Map<Integer, Integer> ageToCount = new HashMap<>();
		for (int i = 0; i < people.size(); i++) {
			if (ageToCount.containsKey(people.get(i).age)) {
				ageToCount.put(people.get(i).age,
						ageToCount.get(people.get(i).age) + 1);
			} else {
				ageToCount.put(people.get(i).age, 1);
			}
		}

		Map<Integer, Integer> ageToOffset = new HashMap<>();
		int offset = 0;
		for (Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
			ageToOffset.put(kc.getKey(), offset);
			offset += kc.getValue();
		}
		while (!ageToOffset.isEmpty()) {
			Map.Entry<Integer, Integer> from = ageToOffset.entrySet()
					.iterator().next();
			Integer toAge = people.get(from.getValue()).age;
			Integer toValue = ageToOffset.get(toAge);
			Collections.swap(people, from.getValue(), toValue);
			Integer count = ageToCount.get(toAge) - 1;
			ageToCount.put(toAge, count);
			if (count > 0) {
				ageToOffset.put(toAge, toValue + 1);
			} else {
				ageToOffset.remove(toAge);
			}
		}
		return people;
	}

	public static void main(String[] args) {

		PartitioningAndSorting p1 = new PartitioningAndSorting(14, "Greg");
		PartitioningAndSorting p2 = new PartitioningAndSorting(12, "John");
		PartitioningAndSorting p3 = new PartitioningAndSorting(11, "Andy");
		PartitioningAndSorting p4 = new PartitioningAndSorting(13, "Jim");
		PartitioningAndSorting p5 = new PartitioningAndSorting(12, "Phil");
		PartitioningAndSorting p6 = new PartitioningAndSorting(13, "Bob");
		PartitioningAndSorting p7 = new PartitioningAndSorting(13, "Chip");
		PartitioningAndSorting p8 = new PartitioningAndSorting(14, "Tim");
		List<PartitioningAndSorting> people = new ArrayList<PartitioningAndSorting>();

		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p6);
		people.add(p7);
		people.add(p8);

		List<PartitioningAndSorting> result = groupByAge(people);
		for (PartitioningAndSorting p : result) {
			System.out.print("(" + p.name + "," + p.age + ")");
		}
	}
}

package com.eop.java.programs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JAVA program to find the optimum way to assign tasks
 * 
 * @author SrikarRao
 *
 */
public class OptimumAssignmentTasks {

	private static class PairedTask {
		public Integer task1;
		public Integer task2;

		public PairedTask(Integer task1, Integer task2) {
			this.task1 = task1;
			this.task2 = task2;
		}
	}

	/**
	 * method to assign task
	 * @param taskDuration
	 * @return
	 */
	public static List<PairedTask> assignTaks(List<Integer> taskDuration) {
		List<PairedTask> taskPairs = new ArrayList<PairedTask>();

		Collections.sort(taskDuration);
		for (int i = 0, j = taskDuration.size() - 1; i < j; i++, j--) {
			taskPairs.add(new PairedTask(taskDuration.get(i), taskDuration
					.get(j)));
		}
		return taskPairs;
	}
}
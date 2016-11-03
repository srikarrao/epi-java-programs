package com.eop.java.programs.sorting.calendar;

public class EndPoint implements Comparable<EndPoint> {
	int time;
	boolean isStart;

	public EndPoint(int time, boolean isStart) {
		this.time = time;
		this.isStart = isStart;
	}

	@Override
	public int compareTo(EndPoint e) {
		if (time != e.time) {
			return Integer.compare(time, e.time);
		}
		return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
	}
}

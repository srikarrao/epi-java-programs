package com.eop.java.programs.sorting.calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarEvents {

	public static void main(String[] args) {

		Event e1 = new Event(1, 5);
		Event e2 = new Event(6, 10);
		Event e3 = new Event(11, 12);
		Event e4 = new Event(14, 17);
		Event e5 = new Event(2, 5);
		Event e6 = new Event(8, 10);
		Event e7 = new Event(12, 13);
		Event e8 = new Event(4, 8);
		Event e9 = new Event(9, 17);

		List<Event> inputList = new ArrayList<>();
		inputList.add(e1);
		inputList.add(e2);
		inputList.add(e3);
		inputList.add(e4);
		inputList.add(e5);
		inputList.add(e6);
		inputList.add(e7);
		inputList.add(e8);
		inputList.add(e9);
		System.out.println("Number of concurrent events: "
				+ countSimultaneousEvents(inputList));
	}

	public static int countSimultaneousEvents(List<Event> E) {

		List<EndPoint> End = new ArrayList<EndPoint>();
		for (Event e : E) {
			End.add(new EndPoint(e.start, true));
			End.add(new EndPoint(e.finish, false));
		}
		Collections.sort(End);

		int numOfSimualtaneousEvents = 0;
		int maxEvents = 0;

		for (EndPoint e : End) {
			if (e.isStart) {
				numOfSimualtaneousEvents++;
				maxEvents = Math.max(maxEvents, numOfSimualtaneousEvents);
			} else {
				numOfSimualtaneousEvents--;
			}
		}
		return maxEvents;
	}
}
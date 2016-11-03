package com.eop.java.programs.sorting.playersRowing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

	private List<Player> players;
	public static void main(String[] args) {
		List<Integer> EnglandHeights = new ArrayList<Integer>();
		EnglandHeights.add(8);
		EnglandHeights.add(7);
		EnglandHeights.add(6);
		EnglandHeights.add(5);
		EnglandHeights.add(7);

		List<Integer> IndiaHeights = new ArrayList<Integer>();
		IndiaHeights.add(5);
		IndiaHeights.add(6);
		IndiaHeights.add(7);
		IndiaHeights.add(6);
		IndiaHeights.add(7);

		Team England = new Team(EnglandHeights);
		Team India = new Team(IndiaHeights);

		System.out.println("Placement exists? "
				+ validPlacementExists(England, India));
	}

	public Team(List<Integer> height) {
		players = new ArrayList<Player>(height.size());
		for (int i = 0; i < height.size(); i++) {
			players.add(new Player(height.get(i)));
		}
	}

	public static boolean validPlacementExists(Team England, Team India) {
		List<Player> ESorted = England.sortPlayersByHeights(); // team behind
		List<Player> ISorted = India.sortPlayersByHeights(); // team in-front

		for (int i = 0; i < ISorted.size() && i < ESorted.size(); i++) {
			if (ISorted.get(i).compareTo(ESorted.get(i)) > 0) {
				// if (ESorted.get(i).compareTo(ISorted.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}

	private List<Player> sortPlayersByHeights() {
		List<Player> sortedPlayers = new ArrayList<>(players);
		Collections.sort(sortedPlayers);
		return sortedPlayers;
	}
}

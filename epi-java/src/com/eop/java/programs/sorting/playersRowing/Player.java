package com.eop.java.programs.sorting.playersRowing;

public class Player implements Comparable<Player> {

	public Integer height;

	public Player(Integer height) {
		this.height = height;
	}

	@Override
	public int compareTo(Player p) {
		return Integer.compare(height, p.height);
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		if (this == obj) {
			return true;
		}
		Player that = (Player) obj;
		return this.height.equals(that.height);
	}

	public int hashcode() {

		return height.hashCode();
	}
}

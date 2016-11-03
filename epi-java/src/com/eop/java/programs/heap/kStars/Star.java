package com.eop.java.programs.heap.kStars;

import java.io.Serializable;

public class Star implements Serializable, Comparable<Star> {

	public double x;
	public double y;
	public double z;

	public Star(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	@Override
	public int compareTo(Star s) {
		return Double.compare(this.distance(), s.distance());
	}

}

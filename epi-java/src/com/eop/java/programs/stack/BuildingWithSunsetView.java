package com.eop.java.programs.stack;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * JAVA Class to print the buildings with sunset view
 * 
 * @author SrikarRao
 *
 */
public class BuildingWithSunsetView {

	@SuppressWarnings("unused")
	private int buildingId;
	private int buildingHeight;

	public BuildingWithSunsetView(int buildingId, int buildingHeight) {
		this.buildingId = buildingId;
		this.buildingHeight = buildingHeight;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		insertData();
		InputStream ins = new FileInputStream("input//buildings-heights.txt");
		Deque<BuildingWithSunsetView> result = examineTheSunsetViewBuildings(ins);
		while (!result.isEmpty()) {
			BuildingWithSunsetView build = result.removeFirst();
			System.out.println("Building number #" + build.buildingId
					+ " : Building height = " + build.buildingHeight);
		}
	}

	/**
	 * method to insert the building heights as inputStream
	 * 
	 * @throws IOException
	 */
	public static void insertData() throws IOException {
		FileOutputStream out = new FileOutputStream("input//buildings-heights.txt");
		ObjectOutputStream output = new ObjectOutputStream(out);

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(23, 405, 1,
				999, 103, 2, 1031, 55, 90, 9));
		int i = 0;
		int data = 0;
		while (i < list.size()) {
			data = list.get(i);
			output.writeObject(data);
			i++;
		}
		output.close();
	}

	/**
	 * method to find the buildings with sunset
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Deque<BuildingWithSunsetView> examineTheSunsetViewBuildings(
			InputStream input) throws IOException, ClassNotFoundException {
		int bIndx = 1;
		Integer bHeight;
		Deque<BuildingWithSunsetView> buildings = new LinkedList<>();
		try {
			ObjectInputStream osin = new ObjectInputStream(input);
			while (true) {
				bHeight = (Integer) osin.readObject();
				while (!buildings.isEmpty()
						&& Integer.compare(bHeight,
								buildings.getLast().buildingHeight) >= 0) {
					buildings.removeLast();
				}
				buildings.addLast(new BuildingWithSunsetView(bIndx++, bHeight));
			}
		} catch (EOFException eof) {
		}
		return buildings;
	}
}
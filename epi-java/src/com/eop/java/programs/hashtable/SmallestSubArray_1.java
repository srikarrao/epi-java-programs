package com.eop.java.programs.hashtable;

import java.util.*;

public class SmallestSubArray_1 {

	public static void main(String[] args) {

		Map<String, Integer> lmap = new LinkedHashMap<String, Integer>();
		
		lmap.put("b", 0);
		lmap.put("c", 2);
		
		// lmap.remove("b");
		// lmap.put("b", 1);
		
		for(Map.Entry<String, Integer> entry: lmap.entrySet()){
			System.out.println(entry.getValue());
			break;
		}

	}
}

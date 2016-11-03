package com.eop.java.programs.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class ISBNCache {

	private LinkedHashMap<Integer, Integer> isbnCache;

	@SuppressWarnings("serial")
	private ISBNCache(final int capcity) {
		this.isbnCache = new LinkedHashMap<Integer, Integer>() {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
				return this.size() > capcity;
			}
		};
	}

	public Integer lookUp(Integer key) {
		if (!isbnCache.containsKey(key)) {
			return null;
		}
		Integer currentValue = isbnCache.get(key);
		moveToFront(key, currentValue);
		return currentValue;
	}

	public Integer insert(Integer key, Integer value) {
		if (!isbnCache.containsKey(key)) {
			isbnCache.put(key, value);
			return value;
		}
		moveToFront(key, value);
		return null;
	}

	public Integer remove(Integer key) {
		return isbnCache.remove(key);
	}

	public void display() {
		System.out.println(isbnCache);
	}

	private void moveToFront(Integer key, Integer value) {
		isbnCache.remove(key);
		isbnCache.put(key, value);
	}

	public static void main(String[] args) {
		ISBNCache cache = new ISBNCache(10);
		System.out.println(cache.insert(1000, 10));
		System.out.println(cache.insert(1001, 13));
		System.out.println(cache.insert(1003, 4));
		System.out.println(cache.insert(1011, 44));

		cache.display();

		System.out.println(cache.lookUp(1000));
		cache.display();
		System.out.println(cache.lookUp(1011));
		cache.display();
		System.out.println(cache.remove(1000));
		cache.display();

	}

}

package com.eop.java.programs.strings;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = scn.nextLine();
		char inputArray[] = input.toCharArray();
		System.out.println(reverseWords(inputArray));
	}

	public static String reverseWords(char[] inputArray) {
		reverse(inputArray, 0, inputArray.length);
		int start = 0, end;
		while ((end = find(inputArray, ' ', start)) != -1) {
			reverse(inputArray, start, end);
			start = end + 1;
		}
		reverse(inputArray, start, inputArray.length);
		return new String(inputArray);
	}

	public static void reverse(char[] array, int start, int end) {
		char temp = ' ';
		if (start >= end) {
			return;
		} else {
			end = end - 1;
			for (int i = start; i <= start + ((end - start) / 2); i++) {
				temp = array[i];
				array[i] = array[end - i + start];
				array[end - i + start] = temp;
			}
		}
	}

	public static int find(char[] array, char c, int start) {
		for (int i = start; i < array.length; i++) {
			if (array[i] == c) {
				return i;
			}
		}
		return -1;
	}
}

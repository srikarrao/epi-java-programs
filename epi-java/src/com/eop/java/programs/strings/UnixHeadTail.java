package com.eop.java.programs.strings;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * JAVA Program to implement Unix Tail, Head commands
 * 
 * @author SrikarRao
 *
 */
public class UnixHeadTail {
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of lines:");
		int value = scn.nextInt();
		if (value > 0) {
			System.out.println("-------HEAD-------------");
			System.out.println(head("input/test.txt", value));

			System.out.println("-------TAIL-------------");
			System.out.println(tail("input/test.txt", value));
		} else {
			System.out.println();
		}
	}

	/**
	 * method to implement tail
	 * 
	 * @param fileName
	 * @param N
	 * @return
	 * @throws IOException
	 */
	public static String tail(String fileName, int N) throws IOException {
		RandomAccessFile filePtr = new RandomAccessFile(fileName, "r");

		filePtr.seek(filePtr.length() - 1);
		long fileSize = filePtr.length();
		long newLineCount = 0;

		StringBuilder lastNLines = new StringBuilder();
		for (long i = fileSize - 1; i != -1; i--) {
			filePtr.seek(i);
			int readByte = filePtr.readByte();
			char c = (char) readByte;
			if (c == '\n') {
				newLineCount++;
				if (newLineCount > N - 1) {
					break;
				}
			}
			lastNLines.append(c);
		}
		filePtr.close();
		lastNLines.reverse();
		return lastNLines.toString();
	}

	/**
	 * method to implement head
	 * 
	 * @param fileName
	 * @param N
	 * @return
	 * @throws IOException
	 */
	public static String head(String fileName, int N) throws IOException {
		RandomAccessFile filePtr = new RandomAccessFile(fileName, "r");

		filePtr.seek(0);
		long fileSize = filePtr.length();
		long newLineCount = 0;

		StringBuilder lastNLines = new StringBuilder();
		for (long i = 0; i != fileSize; i++) {
			filePtr.seek(i);
			int readByte = filePtr.readByte();
			char c = (char) readByte;
			if (c == '\n') {
				newLineCount++;
				if (newLineCount > N - 1) {
					break;
				}
			}
			lastNLines.append(c);
		}
		filePtr.close();
		return lastNLines.toString();
	}

}

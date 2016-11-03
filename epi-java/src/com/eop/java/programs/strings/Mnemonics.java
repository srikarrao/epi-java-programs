package com.eop.java.programs.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mnemonics {

	public static void main(String[] args) {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the phone number");
			String input = scn.nextLine();
			System.out.println("Phone Number Mnemonics are "
					+ phoneMnemonic(input).size() + "  they are :"
					+ phoneMnemonic(input));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static List<String> phoneMnemonic(String phnNum) {
		char[] partialMnemonic = new char[phnNum.length()];
		List<String> mnemonics = new ArrayList<>();
		phoneMnemonicHelper(phnNum, 0, partialMnemonic, mnemonics);
		return mnemonics;
	}

	private static final String[] M = new String[] { "0", "1", "ABC", "DEF",
			"GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static void phoneMnemonicHelper(String phnNumber, int digit,
			char[] partialMnemonic, List<String> mnemonics) {

		if (digit != phnNumber.length()) {
			for (int i = 0; i < M[phnNumber.charAt(digit) - '0'].length(); i++) {
				char c = M[phnNumber.charAt(digit) - '0'].charAt(i);
				partialMnemonic[digit] = c;
				phoneMnemonicHelper(phnNumber, digit + 1, partialMnemonic,
						mnemonics);
			}
		} else {
			mnemonics.add(new String(partialMnemonic));
		}
	}
}

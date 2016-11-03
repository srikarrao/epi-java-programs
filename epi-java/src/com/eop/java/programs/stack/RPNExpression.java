package com.eop.java.programs.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class RPNExpression {
	public static void main(String[] args) {
		System.out.println("Enter the expression to evaluate");
		Scanner scn = new Scanner(System.in);
		String regularExpression = scn.nextLine();
		System.out.println("Result for the expression is: "
				+ evaluateRPN(regularExpression));
	}

	private static int evaluateRPN(String RPNExpression) {
		Deque<Integer> results = new LinkedList<Integer>();
		String delimiter = ",";
		String[] tokens = RPNExpression.split(delimiter);
		for (String token : tokens) {
			if (token.length() == 1 && "+-*/".contains(token)) {
				int x = results.removeFirst();
				int y = results.removeFirst();
				switch (token.charAt(0)) {
				case '+':
					results.addFirst(x + y);
					break;
				case '-':
					results.addFirst(x - y);
					break;
				case '*':
					results.addFirst(x * y);
					break;
				case '/':
					results.addFirst(x / y);
					break;
				default:
					throw new IllegalArgumentException(
							"Invalid RPN Expression " + token);
				}
			} else {
				results.addFirst(Integer.parseInt(token));
			}
		}
		return results.removeFirst();
	}
}

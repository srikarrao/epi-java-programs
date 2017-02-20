package com.eop.java.programs.greedyAlgorithm;

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * JAVA Program to implement Huffman Coding
 * 
 * @author SrikarRao
 *
 */
public class HuffmanCoding {

	public static class Symbol {
		public double prob;
		public char c;
		public String code;

		Symbol(double prob, char c, String code) {
			this.prob = prob;
			this.c = c;
			this.code = code;
		}

		@Override
		public String toString() {
			return "[ (S_prob," + prob + ");(c," + c + ")" + "(code," + code
					+ ")]";
		}
	}

	public static class BinaryTree implements Comparable<BinaryTree> {
		public Symbol s;
		public double prob;
		public BinaryTree left, right;

		public BinaryTree(Symbol s, double prob, BinaryTree left,
				BinaryTree right) {
			this.s = s;
			this.prob = prob;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "[ (s," + s + ");(prob," + prob + ")]";
		}

		@Override
		public int compareTo(BinaryTree o) {
			return Double.compare(prob, o.prob);
		}

		@Override
		public boolean equals(Object obj) {

			if (!(obj instanceof BinaryTree)) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			BinaryTree that = (BinaryTree) obj;
			return this.prob == that.prob;
		}

		@Override
		public int hashCode() {
			return Objects.hash(prob);
		}
	}

	public static void huffmanEncoding(List<Symbol> symbols) {
		PriorityQueue<BinaryTree> minHeap = new PriorityQueue<BinaryTree>();
		for (Symbol s : symbols) {
			minHeap.add(new BinaryTree(s, s.prob, null, null));
		}

		while (minHeap.size() > 1) {
			BinaryTree left = minHeap.remove();
			BinaryTree right = minHeap.remove();

			minHeap.add(new BinaryTree(null, left.prob + right.prob, left,
					right));
		}
		assigHuffmanCode(minHeap.peek(), "");
	}

	public static void assigHuffmanCode(BinaryTree tree, String code) {
		if (tree != null) {
			if (tree.s != null) {
				tree.s.code = code;
			} else {
				assigHuffmanCode(tree.left, code + "0");
				assigHuffmanCode(tree.right, code + "1");
			}
		}
	}
}

package com.eop.java.programs.binarytree;

public class BinaryTree {

	public int data;
	public BinaryTree left;
	public BinaryTree right;

	public BinaryTree(BinaryTree left, BinaryTree right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public static int size(BinaryTree node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}
}

package com.eop.java.programs.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BTree {
	Integer data;
	BTree left;
	BTree right;

	BTree(Integer data, BTree left, BTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeFromPreOrderTraversal {

	private static int treeIndx = 0;

	public static void main(String[] args) {

		BTree H = new BTree(0, null, null);
		BTree B = new BTree(1, null, null);
		BTree F = new BTree(2, null, null);
		BTree E = new BTree(3, null, null);
		BTree A = new BTree(4, null, null);

		BTree C = new BTree(5, null, null);
		BTree D = new BTree(6, null, null);
		BTree G = new BTree(7, null, null);
		BTree I = new BTree(8, null, null);

		List<BTree> preOrderList = new ArrayList<BTree>(Arrays.asList(H, B, F,
				null, null, E, A, null, null, null, C, null, D, null, G, I,
				null, null, null));
		BTree result = findBinaryTree(preOrderList);
		System.out.println(result.data);
	}

	public static BTree findBinaryTree(List<BTree> preOrder) {
		return processListToBinaryTree(preOrder);
	}

	public static BTree processListToBinaryTree(List<BTree> preOrder) {

		BTree node = preOrder.get(treeIndx);
		treeIndx++;
		if (node == null) {
			return null;
		}
		BTree left = processListToBinaryTree(preOrder);
		BTree right = processListToBinaryTree(preOrder);

		return new BTree(node.data, left, right);
	}
}

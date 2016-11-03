package com.eop.java.programs.binarytree;

public class RootToLeafSum {

	public static void main(String[] args) {

		BinaryTree M = new BinaryTree(null, null, 1);
		BinaryTree L = new BinaryTree(null, M, 1);
		BinaryTree N = new BinaryTree(null, null, 0);
		BinaryTree K = new BinaryTree(L, N, 0);
		BinaryTree J = new BinaryTree(null, K, 0);
		BinaryTree P = new BinaryTree(null, null, 0);
		BinaryTree O = new BinaryTree(null, P, 0);
		BinaryTree I = new BinaryTree(J, O, 1);

		BinaryTree H = new BinaryTree(null, null, 0);
		BinaryTree G = new BinaryTree(H, null, 1);
		BinaryTree F = new BinaryTree(null, G, 1);
		BinaryTree E = new BinaryTree(null, null, 1);
		BinaryTree D = new BinaryTree(null, null, 0);
		BinaryTree C = new BinaryTree(D, E, 0);
		BinaryTree B = new BinaryTree(C, F, 0);

		BinaryTree A = new BinaryTree(B, I, 1);
		System.out.println(sumRootToLeaf(A));
	}

	public static int sumRootToLeaf(BinaryTree tree) {
		return pathSumCalculator(tree, 0);
	}

	public static int pathSumCalculator(BinaryTree tree, int pathSum) {

		if (tree == null) {
			return 0;
		}

		pathSum = pathSum * 2 + tree.data;
		if (tree.left == null && tree.right == null) {
			return pathSum;
		}

		return pathSumCalculator(tree.left, pathSum)
				+ pathSumCalculator(tree.right, pathSum);
	}
}

package com.eop.java.programs.binarytree;

public class RootToLeafPathSumCheck {

	public static void main(String[] args) {

		BinaryTree M = new BinaryTree(null, null, 641);
		BinaryTree L = new BinaryTree(null, M, 401);
		BinaryTree N = new BinaryTree(null, null, 257);
		BinaryTree K = new BinaryTree(L, N, 1);
		BinaryTree J = new BinaryTree(null, K, 2);
		BinaryTree P = new BinaryTree(null, null, 28);
		BinaryTree O = new BinaryTree(null, P, 271);
		BinaryTree I = new BinaryTree(J, O, 6);

		BinaryTree H = new BinaryTree(null, null, 17);
		BinaryTree G = new BinaryTree(H, null, 3);
		BinaryTree F = new BinaryTree(null, G, 561);
		BinaryTree E = new BinaryTree(null, null, 0);
		BinaryTree D = new BinaryTree(null, null, 28);
		BinaryTree C = new BinaryTree(D, E, 271);
		BinaryTree B = new BinaryTree(C, F, 6);

		BinaryTree A = new BinaryTree(B, I, 314);
		System.out.println(isPathSumHasRoot(A, 591));
	}

	public static boolean isPathSumHasRoot(BinaryTree tree, int targetSum) {
		return checkPathSumCalculator(tree, 0, targetSum);
	}

	public static boolean checkPathSumCalculator(BinaryTree tree, int pathSum,
			int targetSum) {

		if (tree == null) {
			return false;
		}

		pathSum += tree.data;
		if (tree.left == null && tree.right == null) {
			return pathSum == targetSum;
		}

		return checkPathSumCalculator(tree.left, pathSum, targetSum)
				|| checkPathSumCalculator(tree.right, pathSum, targetSum);
	}
}

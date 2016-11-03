package com.eop.java.programs.binarytree;

public class BalancedBinaryTree {

	public static class BalanceTreeFinder {
		private int height;
		private boolean isBalanced;

		public BalanceTreeFinder(int height, boolean isBalance) {
			this.height = height;
			this.isBalanced = isBalance;
		}
	}

	public static void main(String[] args) {

		BinaryTree M = new BinaryTree(null, null, 641);
		BinaryTree N = new BinaryTree(null, null, 257);
		BinaryTree L = new BinaryTree(M, N, 401);

		BinaryTree O = new BinaryTree(null, null, 271);

		BinaryTree K = new BinaryTree(L, O, 1);

		BinaryTree G = new BinaryTree(null, null, 3);
		BinaryTree F = new BinaryTree(null, null, 561);
		BinaryTree E = new BinaryTree(null, null, 0);
		BinaryTree D = new BinaryTree(E, F, 28);
		BinaryTree C = new BinaryTree(D, G, 271);

		BinaryTree I = new BinaryTree(null, null, 6);
		BinaryTree J = new BinaryTree(null, null, 2);
		BinaryTree H = new BinaryTree(I, J, 17);

		BinaryTree B = new BinaryTree(C, H, 6);

		BinaryTree A = new BinaryTree(B, K, 314);
		System.out.println(isBalanceTree(A));
	}

	public static boolean isBalanceTree(BinaryTree tree) {
		return findBalanceTree(tree).isBalanced;
	}

	public static BalanceTreeFinder findBalanceTree(BinaryTree node) {
		if (node == null) {
			return new BalanceTreeFinder(-1, true);
		}

		BalanceTreeFinder leftBalNode = findBalanceTree(node.left);
		if (!leftBalNode.isBalanced) {
			return leftBalNode;
		}
		BalanceTreeFinder rightBalNode = findBalanceTree(node.right);

		if (!rightBalNode.isBalanced) {
			return rightBalNode;
		}
		int height = Math.max(leftBalNode.height, rightBalNode.height) + 1;
		boolean isBalanced = Math.abs(leftBalNode.height - rightBalNode.height) <= 1;
		return new BalanceTreeFinder(height, isBalanced);
	}

}

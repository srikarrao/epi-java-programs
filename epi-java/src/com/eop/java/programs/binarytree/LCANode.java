package com.eop.java.programs.binarytree;

public class LCANode {
	public static class Status {
		private int height;
		private BinaryTree LCANode;

		public Status(int height, BinaryTree LCANode) {
			this.height = height;
			this.LCANode = LCANode;
		}
	}

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
		BinaryTree C = new BinaryTree(D, E, 2071);
		BinaryTree B = new BinaryTree(C, F, 600);

		BinaryTree A = new BinaryTree(B, I, 314);
		System.out.println(findLCA(A, D, F).LCANode.data);
	}

	public static BinaryTree LCA(BinaryTree tree, BinaryTree node1,
			BinaryTree node2) {
		return findLCA(tree, node1, node2).LCANode;
	}

	public static Status findLCA(BinaryTree tree, BinaryTree node1,
			BinaryTree node2) {

		if (tree == null) {
			return new Status(0, null);
		}

		Status res1 = findLCA(tree.left, node1, node2);
		if (res1.height == 2) {
			return res1;
		}

		Status res2 = findLCA(tree.right, node1, node2);
		if (res2.height == 2) {
			return res2;
		}

		int height = res1.height + res2.height + (tree == node1 ? 1 : 0)
				+ (tree == node2 ? 1 : 0);
		return new Status(height, height == 2 ? tree : null);
	}
}

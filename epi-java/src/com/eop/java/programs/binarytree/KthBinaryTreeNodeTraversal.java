package com.eop.java.programs.binarytree;

public class KthBinaryTreeNodeTraversal {

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
		System.out.println(findKthNodeBinaryTree(A, 12).data);
	}

	public static BinaryTree findKthNodeBinaryTree(BinaryTree tree, int k) {

		BinaryTree iter = tree;
		while (iter != null) {
			int leftSize = iter.left != null ? BinaryTree.size(iter.left) : 0;
			if (leftSize + 1 < k) {
				k -= (leftSize + 1);
				iter = iter.right;
			} else if (leftSize == k - 1) {
				return iter;
			} else {
				iter = iter.left;
			}
		}
		return null;
	}

}

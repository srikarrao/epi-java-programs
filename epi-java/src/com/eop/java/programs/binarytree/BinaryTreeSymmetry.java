package com.eop.java.programs.binarytree;

public class BinaryTreeSymmetry {

	public static void main(String[] args) {

		BinaryTree G = new BinaryTree(null, null, 3);
		BinaryTree F = new BinaryTree(G, null, 2);
		BinaryTree E = new BinaryTree(F, null, 6);

		BinaryTree D = new BinaryTree(null, null, 3);
		BinaryTree C = new BinaryTree(null, D, 2);
		BinaryTree B = new BinaryTree(null, C, 6);

		BinaryTree A = new BinaryTree(B, E, 314);
		System.out.println(isSymmetric(A));
	}

	public static boolean isSymmetric(BinaryTree tree) {
		return findSymmetry(tree.left, tree.right);
	}

	public static boolean findSymmetry(BinaryTree node1, BinaryTree node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 != null && node2 != null) {
			return node1.data == node2.data
					&& findSymmetry(node1.left, node2.right)
					&& findSymmetry(node2.left, node1.right);
		}
		return false;
	}
}

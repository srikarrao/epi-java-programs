package com.eop.java.programs.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLeavesToLinkedList {

	private static List<BinaryTree> leavesList = new LinkedList<BinaryTree>();

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
		List<BinaryTree> result = BTToList(A);
		for (BinaryTree res : result) {
			System.out.print(res.data + " ");
		}

		System.out.println();
		System.out.println("------------------------");
		BTToList2(A);
		for (BinaryTree res : leavesList) {
			System.out.print(res.data + " ");
		}
	}

	public static List<BinaryTree> BTToList(BinaryTree tree) {

		List<BinaryTree> leaves = new LinkedList<BinaryTree>();
		if (tree != null) {
			if (tree.left == null && tree.right == null) {
				leaves.add(tree);
			} else {
				leaves.addAll(BTToList(tree.left));
				leaves.addAll(BTToList(tree.right));
			}
		}
		return leaves;
	}

	public static void BTToList2(BinaryTree tree) {

		if (tree != null) {
			if (tree.left == null && tree.right == null) {
				leavesList.add(tree);
			} else {
				BTToList2(tree.left);
				BTToList2(tree.right);
			}
		}
	}

}

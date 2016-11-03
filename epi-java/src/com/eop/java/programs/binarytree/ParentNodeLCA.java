package com.eop.java.programs.binarytree;

public class ParentNodeLCA {
	private static BTree A, B, C, D, E, F, G, H,I;

	public static class BTree {
		private int data;
		private BTree left;
		private BTree right;
		private BTree parent;

		public BTree(BTree left, BTree right, int data, BTree parent) {
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.data = data;
		}
	}

	public static void main(String[] args) {

		H = new BTree(null, null, 170, null);
		G = new BTree(H, null, 300, null);
		F = new BTree(null, G, 561, null);

		I = new BTree(null, null, 70, null);
		E = new BTree(null, null, 208, null);
		D = new BTree(I, null, 100, null);
		C = new BTree(D, null, 271, null);
		B = new BTree(C, E, 600, null);
		A = new BTree(B, F, 1000, null);

		H.parent = G;
		G.parent = F;
		F.parent = A;

		I.parent = D;
		E.parent = B;
		D.parent = C;
		C.parent = B;
		B.parent = A;
		System.out.println(findLCAThroughParents(F,E).data);
	}

	public static BTree findLCAThroughParents(BTree node1, BTree node2) {

		int d1 = depth(node1);
		int d2 = depth(node2);

		int diff = Math.abs(d1 - d2);

		if (d1 > d2) {
			while (diff-- > 0) {
				node1 = node1.parent;
			}
		} else {
			while (diff-- > 0) {
				node2 = node2.parent;
			}
		}

		do {
			node1 = node1.parent;
			node2 = node2.parent;
		} while (node1 != node2);
		return node1;
	}

	public static int depth(BTree node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			++depth;
		}
		return depth;
	}
}

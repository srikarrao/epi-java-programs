package com.eop.java.programs.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LCAUsingHashSet {
	private static BTree A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P;

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
		M = new BTree(null, null, 641, L);
		L = new BTree(null, M, 401, K);
		N = new BTree(null, null, 257, K);
		K = new BTree(L, N, 1, J);
		J = new BTree(null, K, 2, I);
		P = new BTree(null, null, 28, O);
		O = new BTree(null, P, 271, I);
		I = new BTree(J, O, 6, A);
		H = new BTree(null, null, 17, G);
		G = new BTree(H, null, 3, F);
		F = new BTree(null, G, 561, B);
		E = new BTree(null, null, 0, C);
		D = new BTree(null, null, 28, C);
		C = new BTree(D, E, 271, B);
		B = new BTree(C, F, 6, A);
		A = new BTree(B, I, 314, null);

		K.parent = J;
		N.parent = K;
		L.parent = K;
		M.parent = L;
		J.parent = I;
		P.parent = O;
		O.parent = I;
		I.parent = A;
		H.parent = G;
		G.parent = F;
		F.parent = B;
		E.parent = C;
		D.parent = C;
		C.parent = B;
		B.parent = A;
		System.out.println(LCA(B,M).data);
	}

	private static BTree LCA(BTree node1, BTree node2) {
		Set<BTree> hash = new HashSet<BTree>();
		while (node1 != null || node2 != null) {
			if (node1 != null) {
				if (!hash.add(node1)) {
					return node1;
				}
				node1 = node1.parent;
			}

			if (node2 != null) {
				if (!hash.add(node2)) {
					return node2;
				}
				node2 = node2.parent;
			}
		}
		throw new IllegalArgumentException(
				"node1 and node2 are not in the same tree!!");
	}
}

package com.eop.java.programs.binarytree;

public class Succesor {
	private static BTree A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P;

	private static class BTree {
		private int data;
		private BTree left;
		private BTree right;
		private BTree parent;

		private BTree(BTree left, BTree right, int data, BTree parent) {
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
		J = new BTree(null, K, 200, I);
		P = new BTree(null, null, 2, O);
		O = new BTree(null, P, 271, I);
		I = new BTree(J, O, 6, A);
		H = new BTree(null, null, 17, G);
		G = new BTree(H, null, 3, F);
		F = new BTree(null, G, 561, B);
		E = new BTree(null, null, 0, C);
		D = new BTree(null, null, 28, C);
		C = new BTree(D, E, 21, B);
		B = new BTree(C, F, 6, A);
		A = new BTree(B, I, 2048, null);

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

		System.out.println(findSuccesor(O).data);
	}

	private static BTree findSuccesor(BTree tree) {

		BTree iter = tree;
		if (iter.right != null) {
			iter = iter.right;
			while (iter.left != null) {
				iter = iter.left;
			}
			return iter;
		}

		while (iter.parent != null && iter.parent.right == iter) {
			iter = iter.parent;
		}
		return iter.parent;
	}
}

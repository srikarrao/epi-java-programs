package com.eop.java.programs.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	private static BST A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P;
	public static class BST {
		private int data;
		private BST left;
		private BST right;
		private BST parent;

		public BST(BST left, BST right, int data, BST parent) {
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		M = new BST(null, null, 641, L);
		L = new BST(null, M, 401, K);
		N = new BST(null, null, 257, K);
		K = new BST(L, N, 1, J);
		J = new BST(null, K, 2, I);
		P = new BST(null, null, 28, O);
		O = new BST(null, P, 271, I);
		I = new BST(J, O, 6, A);
		H = new BST(null, null, 17, G);
		G = new BST(H, null, 3, F);
		F = new BST(null, G, 561, B);
		E = new BST(null, null, 0, C);
		D = new BST(null, null, 28, C);
		C = new BST(D, E, 271, B);
		B = new BST(C, F, 6, A);
		A = new BST(B, I, 314, null);
		
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
		System.out.println("In-Order Traversal!! --> " + inorderTraversal(A));
	}

	public static List<Integer> inorderTraversal(BST tree) {
		BST prev = null, curr = tree;
		List<Integer> result = new ArrayList<Integer>();
		while (curr != null) {
			BST next;
			if (curr.parent == prev) {
				if (curr.left != null) {
					next = curr.left;
				} else {
					result.add(curr.data);
					next = (curr.right != null ? curr.right : curr.parent);
				}
			} else if (curr.left == prev) {
				result.add(curr.data);
				next = (curr.right != null ? curr.right : curr.parent);
			} else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
		return result;
	}
}

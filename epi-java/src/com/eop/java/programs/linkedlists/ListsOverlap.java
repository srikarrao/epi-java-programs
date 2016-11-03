package com.eop.java.programs.linkedlists;

public class ListsOverlap {

	public static void main(String[] args) {

		NodeLL n7 = new NodeLL(7, null);
		NodeLL n6 = new NodeLL(6, n7);
		NodeLL n5 = new NodeLL(5, n6);
		NodeLL n4 = new NodeLL(4, n5);
		NodeLL n3 = new NodeLL(3, n4);
		NodeLL n2 = new NodeLL(2, n3);
		NodeLL n1 = new NodeLL(1, n2);

		NodeLL m2 = new NodeLL(12, n4);
		NodeLL m1 = new NodeLL(11, m2);

		NodeLL res = findOverlapp(n1, m1);
		System.out.println("List L merging A and B!!");
		if (res != null) {
			System.out.println("overlapp found at --> " + res.data);
		} else {
			System.out.println("has no overlapp!!");
		}
	}

	private static NodeLL findOverlapp(NodeLL A, NodeLL B) {		int Alen = findLen(A);
		int Blen = findLen(B);

		if (Alen > Blen) {
			A = forwardList(A, Alen - Blen);
		} else {
			B = forwardList(B, Blen - Alen);
		}

		while (A != null && B != null && A != B) {
			A = A.next;
			B = B.next;
		}
		return A;
	}

	private static NodeLL forwardList(NodeLL node, int k) {
		while (k-- > 0) {
			node = node.next;
		}
		return node;
	}

	private static int findLen(NodeLL node) {
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
}
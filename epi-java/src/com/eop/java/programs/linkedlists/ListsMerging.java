package com.eop.java.programs.linkedlists;

public class ListsMerging {

	public static void main(String[] args) {

		NodeLL n15 = new NodeLL(160, null);
		NodeLL n14 = new NodeLL(116, n15);
		NodeLL n13 = new NodeLL(104, n14);
		NodeLL n12 = new NodeLL(37, n13);
		NodeLL n11 = new NodeLL(36, n12);
		NodeLL n10 = new NodeLL(14, n11);
		NodeLL n9 = new NodeLL(7, n10);

		NodeLL n8 = new NodeLL(216, null);
		NodeLL n7 = new NodeLL(104, n8);
		NodeLL n6 = new NodeLL(57, n7);
		NodeLL n5 = new NodeLL(45, n6);
		NodeLL n4 = new NodeLL(27, n5);
		NodeLL n3 = new NodeLL(22, n4);
		NodeLL n2 = new NodeLL(13, n3);
		NodeLL n1 = new NodeLL(11, n2);

		System.out.println("List A");
		displayList(n1);
		System.out.println("List B");
		displayList(n9);

		NodeLL res = mergeLinkedList(n1, n9);
		System.out.println("List L merging A and B!!");
		displayList(res);
	}

	private static void displayList(NodeLL node) {
		while (node != null) {
			System.out.print(node.data + "-->");
			node = node.next;
		}
		System.out.println(node);
	}

	private static NodeLL mergeLinkedList(NodeLL A, NodeLL B) {
		NodeLL L = new NodeLL(0, null);
		NodeLL head = L;

		while (A != null && B != null) {
			if (A.data <= B.data) {
				L.next = A;
				L = A;
				A = A.next;
			} else {
				L.next = B;
				L = B;
				B = B.next;
			}
		}

		L.next = (A != null ? A : B);
		return head.next;
	}

}

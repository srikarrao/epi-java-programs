package com.eop.java.programs.linkedlists;

public class ListBasedIntegers {

	public static void main(String[] args) {

		NodeLL m3 = new NodeLL(1, null);
		NodeLL m2 = new NodeLL(0, m3);
		NodeLL M = new NodeLL(0, m2);

		NodeLL n3 = new NodeLL(9, null);
		NodeLL n2 = new NodeLL(0, n3);
		NodeLL N = new NodeLL(0, n2);
		System.out.println("Displaying Node N");
		displayList(N);
		System.out.println("Displaying Node M");
		displayList(M);
		NodeLL res = addListIntegers(N, M);
		System.out.println("Displaying result Node");
		displayList(res);
	}

	private static NodeLL addListIntegers(NodeLL A, NodeLL B) {
		NodeLL result = new NodeLL(0, null);
		NodeLL head = result;

		int sum = 0;
		while (A != null || B != null) {
			if (A != null) {
				sum += A.data;
				A = A.next;
			}
			if (B != null) {
				sum += B.data;
				B = B.next;
			}
			result.next = new NodeLL(sum % 10, null);
			sum = sum / 10;
			result = result.next;
		}
		if (sum > 0) {
			result.next = new NodeLL(sum, null);
		}
		return head.next;
	}

	private static void displayList(NodeLL node) {
		while (node != null) {
			System.out.print(node.data + "-->");
			node = node.next;
		}
		System.out.println(node);
	}
}

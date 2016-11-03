package com.eop.java.programs.linkedlists;

public class ReverseLinkedList {

	public static void main(String[] args) {

		NodeLL E = new NodeLL(5, null);
		NodeLL D = new NodeLL(4, E);
		NodeLL C = new NodeLL(3, D);
		NodeLL B = new NodeLL(2, C);
		NodeLL A = new NodeLL(1, B);
		NodeLL res = reverseLinkedList(A);
		while (res != null) {
			System.out.print(res.data + "-->");
			res = res.next;
		}
		System.out.print(res);
	}

	public static NodeLL reverseLinkedList(NodeLL head) {
		NodeLL prev = null, curr = head;
		while (curr != null) {
			NodeLL temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

}

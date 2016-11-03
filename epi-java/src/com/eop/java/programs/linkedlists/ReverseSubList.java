package com.eop.java.programs.linkedlists;

public class ReverseSubList {

	public static void main(String[] args) {
		NodeLL H = new NodeLL(8, null);
		NodeLL G = new NodeLL(7, H);
		NodeLL F = new NodeLL(6, G);
		NodeLL E = new NodeLL(5, F);
		NodeLL D = new NodeLL(4, E);
		NodeLL C = new NodeLL(3, D);
		NodeLL B = new NodeLL(2, C);
		NodeLL A = new NodeLL(1, B);

		System.out.println("Before Reversing");
		display(A);
		NodeLL res = reverseSubList(A, 2, 5);
		System.out.println("After Reversing");
		display(res);
	}

	private static void display(NodeLL A) {
		while (A != null) {
			System.out.print(A.data + "-->");
			A = A.next;
		}
		System.out.println(A);
	}

	private static NodeLL reverseSubList(NodeLL L, int start, int end) {

		if (start == end) {
			return L;
		}
		NodeLL head = new NodeLL(0, L);
		NodeLL sublistHead = head;
		int i = 1;
		while (i++ < start) {
			sublistHead = sublistHead.next;
		}
		NodeLL curr = sublistHead.next;
		while (start++ < end) {
			NodeLL temp = curr.next;
			curr.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		return head.next;
	}
}

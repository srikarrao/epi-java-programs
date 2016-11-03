package com.eop.java.programs.linkedlists;

public class RightShiftLinkedList {

	public static void main(String[] args) {
		NodeLL n9 = new NodeLL(9, null);
		NodeLL n8 = new NodeLL(8, n9);
		NodeLL n7 = new NodeLL(7, n8);
		NodeLL n6 = new NodeLL(6, n7);
		NodeLL n5 = new NodeLL(2, n6);
		NodeLL n4 = new NodeLL(3, n5);
		NodeLL n3 = new NodeLL(5, n4);
		NodeLL n2 = new NodeLL(3, n3);
		NodeLL n1 = new NodeLL(2, n2);

		System.out.println("Before right shifting the list!!");
		displaylist(n1);
		NodeLL res = rightShiftTheList(n1, 2);
		System.out.println("After right shifting the list!!");
		displaylist(res);
	}

	private static NodeLL rightShiftTheList(NodeLL head, int k) {
		int count = 1;
		NodeLL temp = head;
		while (temp.next != null) {
			temp = temp.next;
			count++;
		}

		k %= count;
		if (k == 0) {
			return head;
		}
		temp.next = head;

		int iterCount = count - k % count;
		while (iterCount > 0) {
			temp = temp.next;
			iterCount--;
		}
		NodeLL iterTemp = temp.next;
		temp.next = null;
		return iterTemp;
	}

	private static void displaylist(NodeLL L) {
		while (L != null) {
			System.out.print(L.data + "-->");
			L = L.next;
		}
		System.out.println(L);
	}
}

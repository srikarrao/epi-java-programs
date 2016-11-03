package com.eop.java.programs.linkedlists;

public class PivotList {

	public static void main(String[] args) {
		NodeLL n9 = new NodeLL(100, null);
		NodeLL n8 = new NodeLL(16, n9);
		NodeLL n7 = new NodeLL(14, n8);
		NodeLL n6 = new NodeLL(7, n7);
		NodeLL n5 = new NodeLL(15, n6);
		NodeLL n4 = new NodeLL(7, n5);
		NodeLL n3 = new NodeLL(22, n4);
		NodeLL n2 = new NodeLL(13, n3);
		NodeLL n1 = new NodeLL(11, n2);

		System.out.println("Before creating pivot list!!");
		displayPivotList(n1);
		NodeLL res = createPivotList(n1, 7);
		System.out.println("After creating pivot list!!");
		displayPivotList(res);
	}

	private static NodeLL createPivotList(NodeLL head, int k) {

		NodeLL less = new NodeLL(0, null);
		NodeLL lessHead = less;

		NodeLL equal = new NodeLL(0, null);
		NodeLL equalHead = equal;

		NodeLL more = new NodeLL(0, null);
		NodeLL moreHead = more;

		NodeLL tempHead = head;

		while (tempHead != null) {

			if (tempHead.data < k) {
				less.next = tempHead;
				less = tempHead;
			} else if (tempHead.data > k) {
				more.next = tempHead;
				more = tempHead;
			} else {
				equal.next = tempHead;
				equal = tempHead;
			}
			tempHead = tempHead.next;
		}

		less.next = equal.next = more.next = null;
		if (moreHead.next != null) {
			equal.next = moreHead.next;
		}
		if (equalHead.next != null) {
			less.next = equalHead.next;
		}
		return lessHead.next;
	}

	private static void displayPivotList(NodeLL LL) {
		while (LL != null) {
			System.out.print(LL.data + "-->");
			LL = LL.next;
		}
		System.out.println(LL);
	}
}

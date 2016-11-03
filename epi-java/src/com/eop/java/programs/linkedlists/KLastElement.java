package com.eop.java.programs.linkedlists;

public class KLastElement {

	public static void main(String[] args) {
		NodeLL n9 = new NodeLL(91, null);
		NodeLL n8 = new NodeLL(82, n9);
		NodeLL n7 = new NodeLL(73, n8);
		NodeLL n6 = new NodeLL(64, n7);
		NodeLL n5 = new NodeLL(56, n6);
		NodeLL n4 = new NodeLL(47, n5);
		NodeLL n3 = new NodeLL(38, n4);
		NodeLL n2 = new NodeLL(29, n3);
		NodeLL n1 = new NodeLL(10, n2);

		System.out.println("Before deleting k last element!!");
		displayPivotList(n1);
		NodeLL res = deleteKNode(n1, 8);
		System.out.println("After deleting k last element!!");
		displayPivotList(res);
	}

	private static NodeLL deleteKNode(NodeLL L, int kLast) {
		NodeLL fast = new NodeLL(0, L);
		NodeLL slow = new NodeLL(0, L);
		NodeLL head = slow;

		while (kLast-- > 0) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head.next;
	}

	private static void displayPivotList(NodeLL LL) {
		while (LL != null) {
			System.out.print(LL.data + "-->");
			LL = LL.next;
		}
		System.out.println(LL);
	}
}

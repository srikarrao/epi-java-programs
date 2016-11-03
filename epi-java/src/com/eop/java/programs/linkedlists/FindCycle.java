package com.eop.java.programs.linkedlists;

public class FindCycle {
	public static void main(String[] args) {
		NodeLL n9 = new NodeLL(8, null);
		NodeLL n8 = new NodeLL(7, n9);
		NodeLL n7 = new NodeLL(6, n8);
		NodeLL n6 = new NodeLL(5, n7);
		NodeLL n5 = new NodeLL(4, n6);
		NodeLL n4 = new NodeLL(3, n5);
		NodeLL n3 = new NodeLL(2, n4);
		NodeLL n2 = new NodeLL(1, n3);
		NodeLL n1 = new NodeLL(0, n2);
		n9.next = n3;

		NodeLL res = findCycle(n1);
		if (res != null) {
			System.out.println(res.data);
		} else {
			System.out.println("No cycle exists!!");
		}
	}

	private static NodeLL findCycle(NodeLL L) {
		NodeLL head = new NodeLL(0, L);
		NodeLL slow = head;
		NodeLL fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

}

package com.eop.java.programs.linkedlists;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		NodeLL n7 = new NodeLL(1, null);
		NodeLL n6 = new NodeLL(2, n7);
		NodeLL n5 = new NodeLL(0, n6);
		NodeLL n4 = new NodeLL(0, n5);
		NodeLL n3 = new NodeLL(0, n4);
		NodeLL n2 = new NodeLL(2, n3);
		NodeLL n1 = new NodeLL(1, n2);
		System.out.println(isListPalindrome(n1));
	}

	private static boolean isListPalindrome(NodeLL node) {
		if (node == null) {
			return true;
		}
		NodeLL head = new NodeLL(0, node);
		NodeLL slow = head;
		NodeLL fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow = ReverseLinkedList.reverseLinkedList(slow.next);
		while (slow != null && node != null) {
			if (slow.data != node.data) {
				return false;
			}
			slow = slow.next;
			node = node.next;
		}
		return true;
	}
}

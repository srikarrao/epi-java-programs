package com.eop.java.programs.linkedlists;

public class EvenOddMergeList {

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

		System.out.println("Before creating even-odd list!!");
		displayEvenOddList(n1);
		NodeLL res = createEvenOddlist(n1);
		System.out.println("After creating even-odd list!!");
		displayEvenOddList(res);
	}

	private static NodeLL createEvenOddlist(NodeLL L) {
		NodeLL evenHead = L;
		NodeLL evenIter = evenHead;
		NodeLL oddHead = L.next;
		NodeLL oddIter = oddHead;
		NodeLL evenOddList = null;
		while (oddIter != null && evenIter != null) {
			evenIter.next = oddIter.next;
			evenOddList = evenIter;
			evenIter = evenIter.next;
			if (evenIter != null) {
				oddIter.next = evenIter.next;
				oddIter = oddIter.next;
			}
		}

		if (evenIter != null) {
			evenIter.next = oddHead;
		} else {
			evenOddList.next = oddHead;
		}
		return evenHead;
	}

	private static void displayEvenOddList(NodeLL EO) {
		while (EO != null) {
			System.out.print(EO.data + "-->");
			EO = EO.next;
		}
		System.out.println(EO);
	}
}

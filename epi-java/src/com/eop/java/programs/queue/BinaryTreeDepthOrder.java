package com.eop.java.programs.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.eop.java.programs.binarytree.BinaryTree;

public class BinaryTreeDepthOrder {

	public static void main(String[] args) {
		BinaryTree M = new BinaryTree(null, null, 641);
		BinaryTree L = new BinaryTree(null, M, 401);
		BinaryTree N = new BinaryTree(null, null, 257);
		BinaryTree K = new BinaryTree(L, N, 1);
		BinaryTree J = new BinaryTree(null, K, 2);
		BinaryTree P = new BinaryTree(null, null, 28);
		BinaryTree O = new BinaryTree(null, P, 271);
		BinaryTree I = new BinaryTree(J, O, 6);

		BinaryTree H = new BinaryTree(null, null, 17);
		BinaryTree G = new BinaryTree(H, null, 3);
		BinaryTree F = new BinaryTree(null, G, 561);
		BinaryTree E = new BinaryTree(null, null, 0);
		BinaryTree D = new BinaryTree(null, null, 28);
		BinaryTree C = new BinaryTree(D, E, 271);
		BinaryTree B = new BinaryTree(C, F, 6);

		BinaryTree A = new BinaryTree(B, I, 314);

		List<List<Integer>> output = findDepthOrderList(A);
		for (List<Integer> opList : output) {
			System.out.println(opList);
		}
	}

	public static List<List<Integer>> findDepthOrderList(BinaryTree tree) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();

		Queue<BinaryTree> nodeQueue = new LinkedList<BinaryTree>();
		nodeQueue.add(tree);
		int nodeCount = nodeQueue.size();
		while (!nodeQueue.isEmpty()) {
			BinaryTree curr = nodeQueue.poll();
			nodeCount--;
			if (curr != null) {
				subList.add(curr.data);

				nodeQueue.add(curr.left);
				nodeQueue.add(curr.right);
			}

			if (nodeCount == 0) {
				nodeCount = nodeQueue.size();

				if (!subList.isEmpty()) {
					result.add(new ArrayList<Integer>(subList));
					subList.clear();
				}
			}

		}
		return result;
	}
}

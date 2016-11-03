package com.eop.java.programs.binarytree;

/**
 * JAVA Program to implement locking on Binary Tree nodes only if descendants
 * and ascendants are not locked
 * 
 * @author SrikarRao
 *
 */
public class BinaryTreeLocking {

	/**
	 * Inner JAVA Class to hold the Binary Tree data
	 *
	 */
	private static class BTree {

		// BTree instance variables for left, right, parent nodes
		BTree left, right, parent;
		// instance variable to hold the number of descendants
		int numOfDescendants;
		// instance variable to check if node is locked
		boolean locked;
		// instance variable to hold the name of the node
		String name;

		/**
		 * Constructor to initialize the Binary Tree instance variables
		 * 
		 * @param name
		 * @param left
		 * @param right
		 * @param parent
		 */
		public BTree(String name, BTree left, BTree right, BTree parent) {
			this.name = name;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.numOfDescendants = 0;
			this.locked = false;
		}

		/**
		 * method to check if the node is locked
		 * 
		 * @return true/false
		 */
		public boolean isLocked() {
			return locked;
		}

		/**
		 * method to lock the node if no descendants and ascendants locked
		 * 
		 * @return true/false
		 */
		public boolean lock() {

			/**
			 * return false if descendants are locked or the node is already
			 * locked
			 */
			if (numOfDescendants > 0 || locked) {
				return false;
			}

			/**
			 * return false if ascendants are locked
			 */
			for (BTree iter = parent; iter != null; iter = iter.parent) {
				if (iter.locked) {
					return false;
				}
			}

			locked = true; // set locked to true
			/**
			 * iterator the loop to add descendants to all parents
			 */
			for (BTree iter = parent; iter != null; iter = iter.parent) {
				++iter.numOfDescendants;
			}
			return true;
		}

		/**
		 * method to unlock the node
		 */
		public void unlock() {
			if (locked) { // check if locked
				locked = false; // set locked to false
				for (BTree iter = parent; iter != null; iter = iter.parent) {
					--iter.numOfDescendants; // remove the descendants
				}
			}
		}
	}

	/**
	 * main method to execute and test the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BTree H = new BTree("BTree-H", null, null, null);
		BTree G = new BTree("BTree-G", null, null, null);
		BTree F = new BTree("BTree-F", G, H, null);
		BTree D = new BTree("BTree-D", F, null, null);
		BTree E = new BTree("BTree-E", null, null, null);
		BTree B = new BTree("BTree-B", D, E, null);
		BTree I = new BTree("BTree-I", null, null, null);
		BTree C = new BTree("BTree-C", null, I, null);
		BTree A = new BTree("BTree-A", B, C, null);

		H.parent = F;
		G.parent = F;
		F.parent = D;
		D.parent = B;
		E.parent = B;

		B.parent = A;
		I.parent = C;
		C.parent = A;

		System.out.println("Is " + A.name + " Locked? " + A.isLocked());
		System.out.println("***** Locking " + A.name + " *************");
		A.lock();
		System.out.println("Is " + A.name + " Locked? " + A.isLocked());
		System.out.println("Is " + B.name + " Locked? " + B.isLocked());
		System.out.println("***** Locking " + B.name + " *************");
		B.lock();
		System.out.println("Is " + B.name + " Locked? " + B.isLocked());
		System.out.println("Is " + G.name + " Locked? " + G.isLocked());
		System.out.println("***** Locking " + G.name + " *************");
		G.lock();
		System.out.println("Is " + G.name + " Locked? " + G.isLocked());
		System.out.println("--------------------------");
		System.out.println("!!!!!!!!!!!!! Unlocking " + A.name
				+ " !!!!!!!!!!!!!");
		A.unlock();
		System.out.println("Is " + A.name + " Locked? " + A.isLocked());
		System.out.println("Is " + G.name + " Locked? " + G.isLocked());
		System.out.println("***** Locking " + G.name + " *************");
		G.lock();
		System.out.println("Is " + G.name + " Locked? " + G.isLocked());
		System.out.println("!!!!!!!!!!!!! Unlocking " + G.name
				+ " !!!!!!!!!!!!!");
		G.unlock();
		System.out.println("Is " + G.name + " Locked? " + G.isLocked());
	}
}
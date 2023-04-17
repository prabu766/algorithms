package com.algo.linked.list;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class LiknedList {

	private ListNode head;

	static class ListNode {
		private ListNode next;
		private int val;

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}

	public void add(int val) {
		ListNode ln = new ListNode();
		ln.setVal(val);
		ListNode lastNode = head;
		if (lastNode == null) {
			head = ln;
		} else {
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(ln);
		}
	}

	/**
	 * There can be 3 cases. 
	 * 1. Value is found at the head. -> Change the head 
	 * 2. Value is found in the middle or last -> Change the previous node's next reference to the new reference
	 * 3. Value is not found
	 * 
	 * @param val
	 */
	public void delete(int val) {
		ListNode currentNode = head;
		if (head.getVal() == val) {
			head = head.getNext();
		} else {
			ListNode prevNode = null;
			// find the current value by running a loop
			while (currentNode != null && currentNode.getVal() != val) {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			// if current value is found which means the value to be deleted is found
			if (currentNode != null) {
				prevNode.setNext(currentNode.getNext());
			} else {
				System.out.println(" Value " + val + " not found");
			}
		}
	}

	public void print() {
		ListNode currentNode = head;
		while (currentNode != null) {
			System.out.print(" " + currentNode.getVal());
			currentNode = currentNode.getNext();
		}
	}

	public static void main(String[] args) {
		LiknedList ll = new LiknedList();
		ll.add(2);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		System.out.println("Printing linked list");
		ll.print();
		System.out.println("\nDeleting value 1");
		ll.delete(1);
		System.out.println("Re-Printing after deleting");
		ll.print();

	}
}

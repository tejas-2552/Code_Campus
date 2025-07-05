package com.dsa.problems.v2;

/*
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5] Output: [5,4,3,2,1] Example 2:
 * 
 * 
 * Input: head = [1,2] Output: [2,1] Example 3:
 * 
 * Input: head = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000]. -5000 <= Node.val <=
 * 5000
 * 
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;

		for (int i = 2; i <= 5; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		ListNode printNode = head;
		while (printNode != null) {
			System.out.print(printNode.val + " -> ");
			printNode = printNode.next;
		}
		System.out.println();

		ListNode reverseNod = reverseList(head);

		while (reverseNod != null) {
			System.out.print(reverseNod.val + " -> ");
			reverseNod = reverseNod.next;
		}

	}

	public static ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		// 1->2->3->4->5
		// 5->4->3->2->1->null
		while (curr != null) {
			next = curr.next; // First get the next element
			curr.next = prev; // Delink the node and assign the prev node to it
			prev = curr; // now prev will point to curr
			curr = next; // curr will be next
		}
		return prev;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

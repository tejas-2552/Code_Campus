package com.dsa.problems.v2;

import com.dsa.problems.v2.ReverseLinkedList.ListNode;

/*
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6 Output: [1,2,3,4,5] Example 2:
 * 
 * Input: head = [], val = 1 Output: [] Example 3:
 * 
 * Input: head = [7,7,7,7], val = 7 Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 104]. 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveLinkedListElements {

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

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;

		for (int i = 2; i <= 10; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		ListNode printNode = head;

		while (printNode != null) {
			System.out.print(printNode.val + " -> ");
			printNode = printNode.next;
		}
		System.out.println();

		removeElements(head, 5);
		ListNode reverseNod = head;
		while (reverseNod != null) {
			System.out.print(reverseNod.val + " -> ");
			reverseNod = reverseNod.next;
		}

		ListNode updatedList = addElement(head, 11);
		System.out.println();
		System.out.println("updated list :: ");
		while (updatedList != null) {
			System.out.print(updatedList.val + " -> ");
			updatedList = updatedList.next;
		}
	}

	// 1->2->3->4->5
	public static ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;
		while (curr.next != null) {
			if (curr.next.val == val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return dummy.next;

	}

	public static ListNode addElement(ListNode head, int val) {
		ListNode insertNode = new ListNode(val);
		ListNode holdNode = head;
		while (holdNode != null) {
			if (holdNode.next == null) {
				holdNode.next = insertNode;
				break;
			} else {
				holdNode = holdNode.next;
			}
		}
		return head;
	}
}

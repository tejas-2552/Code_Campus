package com.dsa.ds;

public class SinglyLinkedList {

	private ListNode node;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String args[]) {
		SinglyLinkedList ssl = new SinglyLinkedList();

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		ssl.node = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ssl.printList(ssl.node);
		
	}

	public void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

package com.dsa.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * What is binary search tree?
 * - It is a type of binary tree where the data is organized in ordered manner which helps in faster insertion and search.
 * - The left subtree of node contains only nodes lesser than the node values.
 * - The right subtree of node contains only nodes grater than the node value.
 *  
 */
public class BinarySearchTree {

	private TreeNode root;

	public class TreeNode {

		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	public void insert(int val) {
		root = insert(root, val);
	}

	public TreeNode insert(TreeNode node, int val) {

		if (node == null) {
			node = new TreeNode(val);
			return node;
		}

		if (val < node.data) {
			node.left = insert(node.left, val);
		} else {
			node.right = insert(node.right, val);
		}

		return node;
	}

	public void preOrderTraversal(TreeNode root) {

		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				System.out.print(node.data + " ");
				q.offer(node.left);
				q.offer(node.right);
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);

		bst.preOrderTraversal(bst.root);
	}
}

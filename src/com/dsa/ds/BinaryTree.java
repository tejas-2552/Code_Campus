package com.dsa.ds;

import java.util.Stack;

/*
 * What is Binary Tree?
 * - A Tree is called a binary tree if its each node has zero or one or two child node;
 */
public class BinaryTree {

	private TreeNode node;

	public static class TreeNode {

		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

	}

	public void createBinaryTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node = node1;
		node.left = node2;
		node.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;

	}

	public static void main(String[] arsg) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		bt.recursicePreOrderTraversal(bt.node);
		System.out.println();
		bt.preOrderTraversal(bt.node);
	}

	// Recursion
	public void recursicePreOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		recursicePreOrderTraversal(root.left);
		recursicePreOrderTraversal(root.right);
	}
	
	public void preOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			System.out.print(node.data + " ");
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
	}

}

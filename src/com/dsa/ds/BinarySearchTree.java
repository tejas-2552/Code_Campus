package com.dsa.ds;

/*
 * What is binary search tree?
 * - It is a type of binary tree where the data is organized in ordered manner which helps in faster insertion and search.
 * - The left subtree of node contains only nodes lesser than the node values.
 * - The right subtree of node contains only nodes grater than the node value.
 *  
 */
public class BinarySearchTree {

	private TreeNode root;

	public static class TreeNode {

		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

	}
	
	public TreeNode insert(TreeNode node, int val) {
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hll");
	}
}

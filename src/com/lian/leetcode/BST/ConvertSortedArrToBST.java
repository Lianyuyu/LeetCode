package com.lian.leetcode.BST;

import com.lian.leetcode.util.TreeNode;

public class ConvertSortedArrToBST {

	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 */
	public static void main(String[] args) {
		// Convert Sorted Array to Balanced Binary Search Tree (BST)
		int[] test2 = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode node = ConvertSortedArrToBST.sortedArrayToBST(test2);
		System.out.println(node.val);
	}

	// Convert Sorted Array to Balanced Binary Search Tree (BST)
	public static TreeNode sortedArrayToBST(int[] num) {
		return convertToBST(num, 0, num.length - 1);
	}

	public static TreeNode convertToBST(int[] num, int left, int right) {
		// if (right == left) {
		// return new TreeNode(num[right]);
		// } else if (right - left == 1) {
		// TreeNode node = new TreeNode(num[right]);
		// node.left = convertToBST(num, left, right - 1);
		// return node;
		// } else if (right > left) {
		// int median = (left + right) / 2;
		// TreeNode medianNode = new TreeNode(num[median]);
		// medianNode.left = convertToBST(num, left, median - 1);
		// medianNode.right = convertToBST(num, median + 1, right);
		// return medianNode;
		// } else {
		// return null;
		// }
		if (left > right) {
			return null;
		}
		int median = (left + right) / 2;
		TreeNode medianNode = new TreeNode(num[median]);
		medianNode.left = convertToBST(num, left, median - 1);
		medianNode.right = convertToBST(num, median + 1, right);
		return medianNode;
	}

}

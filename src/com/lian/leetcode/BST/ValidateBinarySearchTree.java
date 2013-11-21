package com.lian.leetcode.BST;

import com.lian.leetcode.util.TreeNode;

public class ValidateBinarySearchTree {

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

		Assume a BST is defined as follows:
		
		The left subtree of a node contains only nodes with keys less than the node's key.
		The right subtree of a node contains only nodes with keys greater than the node's key.
		Both the left and right subtrees must also be binary search trees.
		confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
		
		
		OJ's Binary Tree Serialization:
		The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
		
		Here's an example:
		   1
		  / \
		 2   3
		    /
		   4
		    \
		     5
		The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode nodeL = root.left;
		TreeNode nodeR = root.right;
		if (nodeL != null) {
			if (nodeL.val >= root.val)
				return false;
			else {
				if (!isValidBSTHelper(nodeL, root, true))
					return false;
			}
		}
		if (nodeR != null) {
			if (nodeR.val <= root.val)
				return false;
			else {
				if (!isValidBSTHelper(nodeR, root, false))
					return false;
				;
			}
		}
		return true;
	}

	public static boolean isValidBSTHelper(TreeNode root, TreeNode origanlRoot,
			boolean left) {
		if (root == null) {
			return true;
		}
		TreeNode nodeL = root.left;
		TreeNode nodeR = root.right;
		if (nodeL != null) {
			if (nodeL.val >= root.val
					|| (!left && nodeL.val <= origanlRoot.val))
				return false;
			else {
				if (!isValidBSTHelper(nodeL, origanlRoot, left))
					return false;
			}
		}
		if (nodeR != null) {
			if (nodeR.val <= root.val || (left && nodeR.val >= origanlRoot.val))
				return false;
			else {
				if (!isValidBSTHelper(nodeR, origanlRoot, left))
					return false;
				;
			}
		}
		return true;
	}

	public static boolean isValidBST2(TreeNode root) {
		return isValidBST2Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValidBST2Helper(TreeNode root, int low, int high) {
		if (root == null) {
			return true;
		}
		if (root.val > low && root.val < high) {
			return isValidBST2Helper(root.left, low, root.val)
					&& isValidBST2Helper(root.right, root.val, high);
		} else {
			return false;
		}
	}

	public static boolean isValidBST3(TreeNode root) {
		return isValidBST3Helper(root, Integer.MIN_VALUE);
	}

	public static boolean isValidBST3Helper(TreeNode root, int prev) {
		if (root == null) {
			return true;
		}
		if (isValidBST3Helper(root.left, prev)) {
			if (root.val > prev) {
				prev = root.val;
				return isValidBST3Helper(root.right, prev);
			}else{
				return false;
			}
		} else {
			return false;
		}
	}
}

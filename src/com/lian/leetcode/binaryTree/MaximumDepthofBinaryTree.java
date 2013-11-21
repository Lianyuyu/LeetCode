package com.lian.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.lian.leetcode.util.TreeNode;

public class MaximumDepthofBinaryTree {

	/**
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		System.out.println(maxDepth2(node1));

	}

	// levelorder
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		currentLevel.add(root);
		int count = 0;
		while (!currentLevel.isEmpty()) {
			Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
			while (!currentLevel.isEmpty()) {
				TreeNode cur = currentLevel.poll();
				if (cur.left != null)
					nextLevel.add(cur.left);
				if (cur.right != null)
					nextLevel.add(cur.right);
			}
			currentLevel = nextLevel;
			count++;
		}
		return count;
	}

	// inorder
	@SuppressWarnings("null")
	public static int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		int max = 0;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null)
					stack.push(cur.left);
				else if (cur.right != null)
					stack.push(cur.right);
			} else if (cur.left == prev) {
				// go back is the signal means left node run out
				if (cur.right != null)
					stack.push(cur.right);
			} else {
				System.out.println(stack.pop().val);
			}
			prev = cur;
			if (stack.size() > max)
				max = stack.size();
		}
		return max;
	}

}

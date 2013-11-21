package com.lian.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

import com.lian.leetcode.util.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
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
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		
		ArrayList<ArrayList<Integer>> lists = levelOrder(node1);
		System.out.println();
	}

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> resultLists = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return resultLists;
		}
		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
			Stack<TreeNode> nextLevel = new Stack<TreeNode>();
			ArrayList<Integer> newList = new ArrayList<Integer>();
			Stack<TreeNode> helperStack = new Stack<TreeNode>();
			while(!currentLevel.isEmpty()){
				TreeNode node = currentLevel.pop();
				newList.add(node.val);
				helperStack.add(node);
			}
			while(!helperStack.isEmpty()){
				TreeNode node = helperStack.pop();
				if(node.right != null) nextLevel.add(node.right);
				if(node.left != null) nextLevel.add(node.left);
			}
			resultLists.add(newList);
			currentLevel = nextLevel;
		}
		return resultLists;
    }
}

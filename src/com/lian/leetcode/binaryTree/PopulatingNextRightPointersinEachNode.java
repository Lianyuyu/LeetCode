package com.lian.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.lian.leetcode.util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

		Initially, all next pointers are set to NULL.
		
		Note:
		
		You may only use constant extra space.
		You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
		For example,
		Given the following perfect binary tree,
		
		         1
		       /  \
		      2    3
		     / \  / \
		    4  5  6  7
		After calling your function, the tree should look like:
		
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \  / \
		    4->5->6->7 -> NULL
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);
		TreeLinkNode node9 = new TreeLinkNode(9);
		TreeLinkNode node10 = new TreeLinkNode(10);
		TreeLinkNode node11 = new TreeLinkNode(11);
		TreeLinkNode node12 = new TreeLinkNode(12);
		TreeLinkNode node13 = new TreeLinkNode(13);
		TreeLinkNode node14 = new TreeLinkNode(14);
		TreeLinkNode node15 = new TreeLinkNode(15);
		TreeLinkNode node16 = new TreeLinkNode(16);
		TreeLinkNode node17 = new TreeLinkNode(17);
		node1.left = node2;
		node1.right =node3;
		node2.left = node4;
		node2.right =node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right =node9;
		node5.left =node10;
		node5.right =node11;
		node6.left =node12;
		node6.right = node13;
		node7.left = node14;
		node7.right = node15;
		
		
		TreeLinkNode node = new TreeLinkNode(0);
		connect(node1);
		System.out.println();
	}
	
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		//connectHelper1(root);
		//connectHelper2(root);
		if (root.left != null) {
			root.left.next = root.right;
			connect(root.left);
			connect(root.right);
		}
		if (root.left != null &&root.right != null) {
			TreeLinkNode rootLeft = root.right.left;
			TreeLinkNode rootRight = root.left.right;
			while (rootLeft != null && rootRight != null) {
				rootRight.next = rootLeft;
				rootRight = rootRight.right;
				rootLeft = rootLeft.left;
			}
			connect(root.left);
			connect(root.right);
		}
	}
	
	public static void connectHelper1(TreeLinkNode root) { 
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			connectHelper1(root.left);
			connectHelper1(root.right);
		}
	}
	
	public static void connectHelper2(TreeLinkNode root){
		if (root == null) return;
		if (root.left != null &&root.right != null) {
			TreeLinkNode rootLeft = root.right.left;
			TreeLinkNode rootRight = root.left.right;
			while (rootLeft != null && rootRight != null) {
				rootRight.next = rootLeft;
				rootRight = rootRight.right;
				rootLeft = rootLeft.left;
			}
			connectHelper2(root.left);
			connectHelper2(root.right);
		}
	}
	
	//exceed time limited in large test set
	public static void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			connect2(root.left);
			connect2(root.right);
		}
//		if (root.left != null && root.left.right != null) {
//			root.left.right.next = root.right.left;
//			connect(root.left);
//			connect(root.right);
//		}
		if (root.left != null &&root.right != null) {
			TreeLinkNode rootLeft = root.right.left;
			TreeLinkNode rootRight = root.left.right;
			while (rootLeft != null && rootRight != null) {
				rootRight.next = rootLeft;
				rootRight = rootRight.right;
				rootLeft = rootLeft.left;
				connect2(root.left);
				connect2(root.right);
			}
		}
	}

	// not work for large test set, use O(N) extra space
	public void connect1(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> curLev = new LinkedList<TreeLinkNode>();
		curLev.add(root);
		while (!curLev.isEmpty()) {
			Queue<TreeLinkNode> nextLev = new LinkedList<TreeLinkNode>();
			while (!curLev.isEmpty()) {
				TreeLinkNode cur = curLev.poll();
				if (cur.left != null)
					nextLev.add(cur.left);
				if (cur.right != null)
					nextLev.add(cur.right);
				if (!curLev.isEmpty()) {
					TreeLinkNode curNext = curLev.peek();
					if (curNext.left != null)
						nextLev.add(cur.left);
					if (curNext.right != null)
						nextLev.add(cur.right);
					cur.next = curNext;
				}
			}
			curLev = nextLev;
		}
	}
	
	
}

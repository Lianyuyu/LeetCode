package com.lian.leetcode.BST;

import com.lian.leetcode.util.ListNode;
import com.lian.leetcode.util.TreeNode;

public class ConvertSortedListtoBalancedBST {

	/**
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node;
		ListNode preNode = null;
		ListNode head = null;
		for (int i = 1; i < 8; i++) {
			node = new ListNode(i);
			preNode = node;
			preNode.next = node;
			if (i == 1) {
				head = node;
			}
		}
		// int i =2;
		// while(i < 8){
		// ListNode node =new ListNode(i);
		// preNode.next = node;
		// }

		ListNode head1 = new ListNode(1);
		createList(head1, 2, 7);

		ListNode trav = head1;
		while (trav != null) {
			System.out.println(trav.val);
			trav = trav.next;
		}

		ListNode node10 = new ListNode(1);
		ListNode node11 = new ListNode(3);
		node10.next = node11;

		System.out.println(new ConvertSortedListtoBalancedBST()
				.sortedListToBST(node10).val);
	}

	// public TreeNode sortedListToBST(ListNode head) {
	// ListNode medianListNode = converToBST(head);
	// TreeNode treeNode = new TreeNode(medianListNode.val);
	// treeNode.left = new TreeNode(converToBST(head).val);
	// treeNode.right = new TreeNode(converToBST(medianListNode.next).val);
	// return treeNode;
	// }

	public TreeNode sortedListToBST(ListNode head) {
		TreeNode median;
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return new TreeNode(head.val);
		}
		// else if(head.next.next == null){
		// //ListNode next = head.next;
		// median = new TreeNode(head.next.val);
		// head.next = null;
		// median.left = sortedListToBST(head);
		// return median;
		// }

		ListNode step1 = head;
		ListNode step2 = head;
		ListNode preStep1 = head;

		int count = 0;
		while (step2 != null) {
			if (step2.next == null)
				break;
			if (count != 0) {
				// use to cut the next point to median node
				// System.out.println("~~"+head.val);
				preStep1 = preStep1.next;
			}
			step1 = step1.next;
			step2 = step2.next.next;
			count++;
		}
		preStep1.next = null;
		median = new TreeNode(step1.val);
		median.left = sortedListToBST(head);
		median.right = sortedListToBST(step1.next);
		return median;
	}

	public static void createList(ListNode node, int i, int max) {
		if (i <= max) {
			ListNode newNode = new ListNode(i);
			node.next = newNode;
			createList(newNode, i + 1, max);
		}
	}
}

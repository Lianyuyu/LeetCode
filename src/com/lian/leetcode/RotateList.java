package com.lian.leetcode;

import com.lian.leetcode.util.ListNode;

public class RotateList {

	/**
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode temp1 = node1;
		while (temp1 != null) {
			System.out.print(temp1.val);
			temp1 = temp1.next;
		}

		ListNode temp2 = rotateRight(node1, 2);
		while (temp2 != null) {
			System.out.print(temp2.val);
			temp2 = temp2.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return null;
		if (n == 0)
			return head;
		int length = 1;
		ListNode countLength = head;
		while (countLength.next != null) {
			length++;
			countLength = countLength.next;
		}
		if (n % length == 0)
			return head;
		int newHeadPos = length - (n % length);
		ListNode newTail = head;
		ListNode newHead = head;
		ListNode tail = head;
		int i = 0;
		while (i < newHeadPos && newHead.next != null) {
			newHead = newHead.next;
			i++;
		}
		i = 0;
		while (i < newHeadPos - 1 && newTail.next != null) {
			newTail = newTail.next;
			i++;
		}

		while (tail.next != null) {
			tail = tail.next;
		}

		tail.next = head;
		newTail.next = null;
		return newHead;
	}
}

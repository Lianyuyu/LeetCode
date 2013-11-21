package com.lian.leetcode;

import com.lian.leetcode.util.ListNode;

public class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		ListNode head = first;
		first.next = second;
		// second.next = third;
		// third.next = node4;
		// node4.next = node5;

		while (first != null) {
			System.out.print(first.val + "->");
			first = first.next;
		}

		System.out.println();
		head = swapPairs(head);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode newHead = null;
		boolean start = true;
		;

		ListNode first;
		ListNode second;
		ListNode thrid;
		ListNode last = null;
		while (head != null && head.next != null) {
			first = head;
			second = head.next;
			if (last != null) {
				last.next = second;
			}
			if (start) {
				newHead = second;
				start = false;
			}
			if (head.next.next != null) {
				thrid = head.next.next;
				first.next = thrid;
				second.next = first;
				head = thrid;
				if (head.next == null) {
					break;
				}
			} else {
				first.next = null;
				second.next = first;
				break;
			}
			last = first;
		}
		return newHead;
	}

	public static ListNode test(ListNode head) {
		ListNode first;
		ListNode second;
		ListNode thrid;

		first = head;
		second = head.next;
		thrid = head.next.next;
		first.next = thrid;
		second.next = first;
		return second;
	}
}

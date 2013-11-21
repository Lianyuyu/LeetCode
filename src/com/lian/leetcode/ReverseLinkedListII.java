package com.lian.leetcode;

import java.util.Currency;

import com.lian.leetcode.util.ListNode;

public class ReverseLinkedListII {

	/**
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ? m ? n ? length of
	 * list.
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode head = node1;
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
		ListNode newHead = reverseBetween(node1, 3, 4);
		while (newHead != null) {
			System.out.print(newHead.val);
			newHead = newHead.next;
		}

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode newHead = null;
		ListNode cur = null;
		if (m < n) {
			if (m > 1) {
				newHead = head;
				int i = 1;
				ListNode LastNodeOfbegin = head;
				cur = head.next;
				ListNode reverseTail = cur;
				while (cur.next != null && i < m - 1) {
					LastNodeOfbegin = LastNodeOfbegin.next;
					reverseTail = reverseTail.next;
					cur = cur.next;
					i++;
				}
				ListNode curNext = cur.next;

				ListNode newCur;
				ListNode newCurNext;
				i++;
				while (curNext != null && i < n) {
					newCurNext = curNext;
					newCur = cur;
					cur = curNext;
					curNext = curNext.next;
					newCurNext.next = newCur;
					i++;
				}

				// curNext = 5;
				// cur =4
				LastNodeOfbegin.next = cur;
				reverseTail.next = curNext;
			} else {
				// m =1
				ListNode reverseTail = head;
				ListNode newCur;
				ListNode newCurNext;
				cur = head;
				ListNode curNext = head.next;
				int i = 1;

				while (curNext != null && i < n) {
					newCurNext = curNext;
					newCur = cur;
					cur = curNext;
					curNext = curNext.next;
					newCurNext.next = newCur;
					i++;
				}
				newHead = cur;
				reverseTail.next = curNext;
				return newHead;
			}
		} else if (m == n) {
			return head;
		}

		return newHead;
	}
}

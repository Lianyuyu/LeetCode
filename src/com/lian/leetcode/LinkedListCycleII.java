package com.lian.leetcode;

import com.lian.leetcode.util.ListNode;

public class LinkedListCycleII {

	/**
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Follow up: Can you solve it without using extra space?
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
		node5.next = node3;

		System.out.println(detectCycle(node1).val);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return null;

		ListNode oneStep = head.next;
		ListNode twoStep = head.next.next;
		ListNode ecounterPoint = null;
		while (twoStep != null) {
			if (oneStep == twoStep) {
				ecounterPoint = oneStep;
				break;
			}
			if (twoStep.next == null || twoStep.next.next == null)
				return null;
			twoStep = twoStep.next.next;
			oneStep = oneStep.next;
		}

		ListNode startPoint = null;
		ListNode newHead = head;
		while (true) {
			if (ecounterPoint == newHead) {
				startPoint = ecounterPoint;
				break;
			}
			newHead = newHead.next;
			ecounterPoint = ecounterPoint.next;
		}
		return startPoint;
	}

}

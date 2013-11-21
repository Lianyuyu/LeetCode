package com.lian.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.lian.leetcode.util.ListNode;

public class MergekSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (lists == null || lists.isEmpty())
			return null;

		Comparator<ListNode> mycomparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val)
					return 1;
				else if (o1.val < o2.val)
					return -1;
				else
					return 0;
			}
		};

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), mycomparator);

		for (ListNode node : lists) {
			if (node != null)
				heap.add(node);
		}

		ListNode head = null, cur = null;
		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				cur = head;
			} else {
				cur.next = heap.poll();
				cur = cur.next;
			}
			if (cur.next != null)
				heap.add(cur.next);
		}
		return head;
	}

	public class MyComparater implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val > o2.val)
				return 1;
			else if (o1.val < o2.val)
				return -1;
			else
				return 0;
		}

	}

}

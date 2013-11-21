package com.lian.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSequence {

	/**
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */
	public static void main(String[] args) {
		int[] test = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(test));
	}

	public static int longestConsecutive(int[] num) {
		if (num.length == 0)
			return 0;
		// LongestConsecutiveSequence instance = new
		// LongestConsecutiveSequence();
		// Queue<Integer> queue = new
		// PriorityQueue<Integer>(num.length+1,instance.new MyComparator());
		Queue<Integer> queue = new PriorityQueue<Integer>();

		for (int i : num)
			queue.add(i);

		int maxLength = 1;
		int tempLength = 1;
		int prev = queue.poll();
		int i = 0;
		while (!queue.isEmpty()) {
			i = queue.poll();
			if (i == prev) {
				prev = i;
				continue;
			} else if (i == prev + 1) {
				tempLength++;
				maxLength = tempLength > maxLength ? tempLength : maxLength;
				prev = i;
			} else {
				tempLength = 1;
				prev = i;
			}	
		}
		return maxLength;
	}

	public class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2)
				return 1;
			else if (o1 < o2)
				return -1;
			else
				return 0;
		}

	}
}

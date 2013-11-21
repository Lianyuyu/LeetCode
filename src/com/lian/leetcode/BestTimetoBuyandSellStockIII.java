package com.lian.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BestTimetoBuyandSellStockIII {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
	public static void main(String[] args) {
		int[] prices = { 1, 4, 7, 2, 5, 9, 2, 2, 3, 12, 1, };
		int[] prices2 = { 3, 2, 6, 5, 0, 3 };
		int[] prices3 = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
		int[] prices4 = { 2, 1, 2, 0, 1 };
		System.out.println(maxProfit4(prices4));
	}

	// dont work
	public static int maxProfit(int[] prices) {
		BestTimetoBuyandSellStockIII main = new BestTimetoBuyandSellStockIII();
		Queue<Integer> profitQueue = new PriorityQueue<Integer>(1000,
				main.new OwnComparator());
		Stack<Integer> stack = new Stack<Integer>();
		int low = prices[0];
		int high = prices[0];
		int lowPos = 0;
		int highPos = 0;
		int max = 0;
		int tempLow = 0;
		stack.add(0);
		boolean continueSeq = false;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > high) {
				high = prices[i];
				if (high - low > max) {
					max = high - low;
					if (i + 1 < prices.length && prices[i + 1] < low) {
						profitQueue.add(stack.pop());
					} else if (continueSeq) {
						if (stack.peek() != null) {
							stack.pop();
							stack.add(max);
						} else {
							stack.add(max);
						}
					}
				}
			}
			if (prices[i] < low) {
				low = prices[i];
				high = 0;
				tempLow = low;
				// newSeq = true;
			}
		}

		if (max <= 0) {
			return 0;
		} else {
			max = profitQueue.poll();
			if (profitQueue.peek() != null)
				max += profitQueue.poll();
			return max;
		}
	}

	public class OwnComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2) {
				return -1;
			} else if (o1 < o2) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	// dont work
	public static int maxProfit2(int[] prices) {
		BestTimetoBuyandSellStockIII main = new BestTimetoBuyandSellStockIII();
		Queue<Integer> profitQueue = new PriorityQueue<Integer>(1000,
				main.new OwnComparator());
		Stack<Integer> stack = new Stack<Integer>();
		int lowPos = 0;
		int tempLowPos = 0;
		int highPos = 0;
		int max = 0;
		boolean continueSeq = false;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[lowPos]) {
				lowPos = i;
				tempLowPos = i;
			}
			int diff = prices[i] - prices[lowPos];
			if (diff > max) {
				max = diff;
				// highPos = i;
				if (continueSeq) {

				}
				if (i + 1 < prices.length && prices[i + 1] < prices[i]) {

				}
			}
		}

		if (max <= 0) {
			return 0;
		} else {
			max = profitQueue.poll();
			if (profitQueue.peek() != null)
				max += profitQueue.poll();
			return max;
		}
	}

	public static int maxProfit3(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, maxProfitSingle(prices, 0, i)
					+ maxProfitSingle(prices, i + 1, prices.length - 1));
		}
		return max;
	}

	public static int maxProfitSingle(int[] prices, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int max = 0;
		int low = prices[start];
		for (int i = start; i <= end; i++) {
			if (prices[i] < low)
				low = prices[i];
			int diff = prices[i] - low;
			if (diff > max) {
				max = diff;
			}
		}
		return max;
	}

	public static int maxProfit4(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int min = prices[0];
		int max = prices[prices.length - 1];
		left[0] = 0;
		right[prices.length - 1] = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			left[i] = prices[i] - min > left[i - 1] ? prices[i] - min
					: left[i - 1];
		}

		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > max)
				max = prices[i];
			right[i] = max - prices[i] > right[i + 1] ? max - prices[i]
					: right[i + 1];
		}

		int total = 0;
		for (int i = 0; i < prices.length; i++) {
			total = left[i] + right[i] > total ? left[i] + right[i] : total;
		}
		return total;
	}
}

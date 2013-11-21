package com.lian.leetcode;

public class BestTimetoBuyandSellStockII {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices2 = { 3, 2, 6, 5, 0, 3 };
		System.out.println(maxProfit(prices2));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int low = 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}
		return profit;
	}
}

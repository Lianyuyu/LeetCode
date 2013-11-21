package com.lian.leetcode;

public class BestTimetoBuyandSellStockPart1 {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 4, 7, 2, 5, 9, 2, 2, 3, 12, 1, };
		int[] prices2 = { 3, 2, 6, 5, 0, 3 };
		int[] prices3 = { 1, 2, 4 };
		System.out.println(maxProfit(prices3));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		if (prices.length == 1) {
			return 0;
		}
		int low = prices[0];
		int high = prices[0];
		int lowPos = 0;
		int highPos = 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > high) {
				high = prices[i];
				if (high - low > max) {
					max = high - low;
				}
			}
			if (prices[i] < low) {
				low = prices[i];
				high = 0;
			}
		}
		if (max <= 0) {
			return 0;
		}
		return max;
	}

	public static int maxProfit2(int[] prices) {
		int lowPos = 0;
		int highPos = 0;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[lowPos])
				lowPos = i;
			int diff = prices[i] - prices[lowPos];
			if (diff > max) {
				max = diff;
				// highPos = i;
			}
		}
		if (max <= 0) {
			return 0;
		} else {
			return max;
		}
	}
}

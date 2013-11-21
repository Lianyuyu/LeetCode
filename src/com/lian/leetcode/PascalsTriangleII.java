package com.lian.leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 */
	public static void main(String[] args) {
		getRow(5);
	}

	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] helper = new int[rowIndex + 1];
		helper[0] = 1;

		for (int i = 1; i < helper.length + 1; i++) {
			for (int j = i - 1; j > 0; j--) {
				helper[j] = helper[j - 1] + helper[j];
			}
		}

		for (int i = 0; i < helper.length; i++) {
			list.add(helper[i]);
		}

		return list;
	}
}

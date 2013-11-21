package com.lian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate
	 * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
	 * 0.
	 * 
	 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1 };
		fourSum(num, 1);
	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i <= num.length - 4; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j <= num.length - 3; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					continue;
				int l = j + 1;
				int r = num.length - 1;
				while (l < r) {
					int sum = num[i] + num[j] + num[l] + num[r] - target;
					if (sum > 0) {
						r--;
					} else if (sum < 0) {
						l++;
					} else {
						ArrayList<Integer> newList = new ArrayList<Integer>();
						newList.add(num[i]);
						newList.add(num[j]);
						newList.add(num[l]);
						newList.add(num[r]);
						result.add(newList);
						l++;
						r--;
						while (l < r && num[l] == num[l - 1]) {
							l++;
						}
						while (l < r && num[r] == num[r + 1]) {
							r--;
						}
					}
				}
			}
		}
		return result;
	}

}

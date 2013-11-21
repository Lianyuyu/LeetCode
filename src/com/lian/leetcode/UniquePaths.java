package com.lian.leetcode;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths2(10, 10));
		System.out.println("~");
		System.out.println(uniquePaths3(10, 10));
	}

	public static int uniquePaths(int m, int n) {
		if (m == 1 && n == 1) {
			return 1;
		}
		m--;
		n--;
		return countPath3(m - 1, n) + countPath3(m, n - 1);
	}

	public static int countPath3(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m == 0 && n != 0) {
			return 1;
		}
		if (n == 0 && m != 0) {
			return 1;
		}
		return countPath3(m - 1, n) + countPath3(m, n - 1);
	}

	// DP
	public static int uniquePaths2(int m, int n) {
		int[][] pathMatrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					pathMatrix[0][0] = 1;
				} else if (i == 0 && j != 0) {
					pathMatrix[i][j] = pathMatrix[i][j - 1];
				} else if (j == 0 && i != 0) {
					pathMatrix[i][j] = pathMatrix[i - 1][j];
				} else {
					pathMatrix[i][j] = pathMatrix[i - 1][j]
							+ pathMatrix[i][j - 1];
				}
			}
		}
		return pathMatrix[m - 1][n - 1];
	}

	public static int uniquePaths3(int m, int n) {
		m--;
		n--;
		double numerator = 1;
		double denominator1 = 1;
		double denominator2 = 1;
		int i = 1;
		while (true) {
			if (i <= m + n)
				numerator *= i;
			else
				break;
			i++;
		}
		i = 1;
		while (true) {
			if (i <= m)
				denominator1 *= i;
			else
				break;
			i++;
		}
		i = 1;
		while (true) {
			if (i <= n)
				denominator2 *= i;
			else
				break;
			i++;
		}
		double result = numerator / denominator1 / denominator2;
		return (int) result;
	}
}

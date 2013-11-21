package com.lian.leetcode;

public class Searcha2DMatrix {

	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		int[][] matrix2 = { { 1, 1 } };
		System.out.println(searchMatrix(matrix2, 2));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}

		int left = 0;
		int right = matrix.length - 1;
		int median = 0;
		while (right >= left) {
			median = (right - left) / 2 + left;
			if (target == matrix[median][0]) {
				return true;
			} else if (target < matrix[median][0]) {
				right = median - 1;
			} else {
				left = median + 1;
			}
		}
		if (matrix[0].length < 2 || right < 0) {
			return false;
		}

		int row = right;
		int leftCol = 0;
		int rightCol = matrix[0].length - 1;
		int medianCol = 0;
		while (rightCol >= leftCol) {
			medianCol = (rightCol - leftCol) / 2 + leftCol;
			if (target == matrix[row][medianCol]) {
				return true;
			} else if (target < matrix[row][medianCol]) {
				rightCol = medianCol - 1;
			} else {
				leftCol = medianCol + 1;
			}
		}
		return false;
	}

}

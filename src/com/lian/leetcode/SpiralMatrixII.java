package com.lian.leetcode;

import java.util.ArrayList;

public class SpiralMatrixII {

	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7,
	 * 6, 5 ] ]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = generateMatrix(0);
		System.out.println(matrix);
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix;
		if (n == 0)
			return new int[0][0];
		matrix = new int[n][n];
		int[][] matrixHelper = new int[matrix.length][matrix[0].length];
		int i = 0;
		int j = 0;
		int width = matrix[0].length;
		int length = matrix.length;
		int count = 1;
		while (i <= width / 2 && j <= length / 2) {
			count = spiralOrderHelper(matrix, i, j, matrixHelper, count);
			i++;
			j++;
		}
		return matrix;
	}

	public static int spiralOrderHelper(int[][] matrix, int x, int y,
			int[][] matrixHelper, int count) {
		// if(x > matrix[0].length/2 || y> matrix.length/2 ){
		// return newList;
		// }
		// top
		for (int i = x; i < matrix[0].length - x; i++) {
			if (matrixHelper[y][i] == 1)
				return count;
			matrix[y][i] = count;
			count++;
			matrixHelper[y][i] = 1;
		}
		// right
		for (int i = y + 1; i < matrix.length - y; i++) {
			if (matrixHelper[i][matrix[0].length - x - 1] == 1)
				return count;
			matrix[i][matrix[0].length - x - 1] = count;
			count++;
			matrixHelper[i][matrix[0].length - x - 1] = 1;
		}
		// bot
		for (int i = matrix[0].length - x - 1 - 1; i > x - 1; i--) {
			if (matrixHelper[matrix.length - y - 1][i] == 1)
				return count;
			matrix[matrix.length - y - 1][i] = count;
			count++;
			matrixHelper[matrix.length - y - 1][i] = 1;
		}
		// left
		for (int i = matrix.length - y - 1 - 1; i > y; i--) {
			if (matrixHelper[i][x] == 1)
				return count;
			matrix[i][x] = count;
			count++;
			matrixHelper[i][x] = 1;
		}
		return count;
	}
}

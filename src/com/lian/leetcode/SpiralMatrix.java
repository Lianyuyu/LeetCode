package com.lian.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {

	/**
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
	 * [1,2,3,6,9,8,7,4,5].
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 8, 7, 6, 5 }, { 12, 11, 10, 9 } };
		ArrayList<Integer> list = spiralOrder(matrix);
		System.out.println();
	}

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> allList = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return allList;
		if (matrix.length == 1 && matrix[0].length != 1) {
			for (int i = 0; i < matrix[0].length; i++)
				allList.add(matrix[0][i]);
			return allList;
		}
		if (matrix.length != 1 && matrix[0].length == 1) {
			for (int i = 0; i < matrix.length; i++)
				allList.add(matrix[i][0]);
			return allList;
		}
		int[][] matrixHelper = new int[matrix.length][matrix[0].length];
		int i = 0;
		int j = 0;
		int width = matrix[0].length;
		int length = matrix.length;
		while (i <= width / 2 && j <= length / 2) {
			allList.addAll(spiralOrderHelper(matrix, i, j, matrixHelper));
			i++;
			j++;
		}
		return allList;
	}

	public static ArrayList<Integer> spiralOrderHelper(int[][] matrix, int x,
			int y, int[][] matrixHelper) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		// if(x > matrix[0].length/2 || y> matrix.length/2 ){
		// return newList;
		// }
		// top
		for (int i = x; i < matrix[0].length - x; i++) {
			if (matrixHelper[y][i] == 1)
				return newList;
			newList.add(matrix[y][i]);
			matrixHelper[y][i] = 1;
		}
		// right
		for (int i = y + 1; i < matrix.length - y; i++) {
			if (matrixHelper[i][matrix[0].length - x - 1] == 1)
				return newList;
			newList.add(matrix[i][matrix[0].length - x - 1]);
			matrixHelper[i][matrix[0].length - x - 1] = 1;
		}
		// bot
		for (int i = matrix[0].length - x - 1 - 1; i > x - 1; i--) {
			if (matrixHelper[matrix.length - y - 1][i] == 1)
				return newList;
			newList.add(matrix[matrix.length - y - 1][i]);
			matrixHelper[matrix.length - y - 1][i] = 1;
		}
		// left
		for (int i = matrix.length - y - 1 - 1; i > y; i--) {
			if (matrixHelper[i][x] == 1)
				return newList;
			newList.add(matrix[i][x]);
			matrixHelper[i][x] = 1;
		}
		return newList;
	}

}

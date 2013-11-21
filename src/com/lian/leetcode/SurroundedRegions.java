package com.lian.leetcode;

public class SurroundedRegions {

	/**
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded
	 * by 'X'.
	 * 
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region .
	 * 
	 * For example,
	 * 
	 * X X X X X O O X X X O X X O X X After running your function, the board
	 * should be:
	 * 
	 * X X X X X X X X X X X X X O X X
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
		solve(board);
		System.out.println();
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		boolean[][] dp = new boolean[board.length][board[0].length];
		boolean[][] visited = new boolean[board.length][board[0].length];
		;
		int width = board[0].length;
		int length = board.length;
		// top
		for (int j = 0; j < width; j++)
			if (board[0][j] == 'O') {
				checkAdjacent(board, dp, visited, 1, j);
				dp[0][j] = true;
			}
		// right
		for (int i = 0; i < length; i++)
			if (board[i][width - 1] == 'O') {
				checkAdjacent(board, dp, visited, i, width - 2);
				dp[i][width - 1] = true;
			}
		// bot
		for (int j = 0; j < width; j++)
			if (board[length - 1][j] == 'O') {
				checkAdjacent(board, dp, visited, length - 2, j);
				dp[length - 1][j] = true;
			}
		// left
		for (int i = 0; i < length; i++)
			if (board[i][0] == 'O') {
				checkAdjacent(board, dp, visited, i, 1);
				dp[i][0] = true;
			}

		// convert the board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dp[i][j] == false)
					board[i][j] = 'X';
			}
		}
	}

	public static void checkAdjacent(char[][] board, boolean[][] dp,
			boolean[][] visited, int i, int j) {
		if (i <= 0 || i >= board.length - 1 || j <= 0
				|| j >= board[0].length - 1)
			return;
		if (visited[i][j] == true)
			return;
		if (board[i][j] == 'X')
			return;

		visited[i][j] = true;
		if (board[i][j] == 'O') {
			dp[i][j] = true;
			checkAdjacent(board, dp, visited, i + 1, j);
			checkAdjacent(board, dp, visited, i - 1, j);
			checkAdjacent(board, dp, visited, i, j + 1);
			checkAdjacent(board, dp, visited, i, j - 1);
		}
	}
}

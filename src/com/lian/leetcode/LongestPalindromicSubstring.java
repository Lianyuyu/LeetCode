package com.lian.leetcode;

public class LongestPalindromicSubstring {

	/**
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */
	public static void main(String[] args) {
		// Longest Palindromic Substring Part I
		String s = "adfsdaffadada";
		findLongestSubPalindramic(s);

		System.out.println(findLongestSubPalindramic2(s));
	}

	// Longest Palindromic Substring Part I-1
	public static void findLongestSubPalindramic(String s) {
		char[] arr = s.toCharArray();
		int begin = -1;
		int end;
		int temp_begin;
		int maxLength = -1;
		boolean[][] table = new boolean[1000][1000];

		for (int i = 0; i < table.length; i++) {
			table[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				table[i][i + 1] = true;
				begin = i;
				maxLength = 2;
			}
		}
		for (int len = 2; len < arr.length; len++) {
			for (int i = 0; i < arr.length - len + 1; i++) {
				int j = len + i - 1;
				if (table[i + 1][j - 1] && (arr[i] == arr[j])) {
					table[i][j] = true;
					if (j - i + 1 > maxLength) {
						begin = i;
						maxLength = maxLength + 2;
					}
				}
			}
		}
		System.out.println("begin:" + begin + ", length:" + maxLength);
	}

	// 2
	public static String findLongestSubPalindramic2(String s) {
		int maxLength = -1;
		String longestSub = "";
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			String sub1 = countLengthSubPali(s, i, i);
			String sub2 = countLengthSubPali(s, i, i + 1);
			String sub = sub1.length() > sub2.length() ? sub1 : sub2;
			if (sub.length() > maxLength) {
				maxLength = sub.length();
				longestSub = sub;
			}
		}
		return longestSub;
	}

	public static String countLengthSubPali(String s, int l, int r) {
		char[] arr = s.toCharArray();
		while (l >= 0 && r <= arr.length - 1) {
			if (arr[l] != arr[r])
				break;
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}
}

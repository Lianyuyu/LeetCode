package com.lian.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumWindowSubstring {

	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method\\
		String S = "ADOBECODEBANC";
		String T = "ABC";

		System.out.println(minWindow2("ab", "b"));
	}

	public static String minWindow(String S, String T) {
		boolean flagFound = false;
		int count = 0;
		int begin = 0;
		int end = 0;
		int tempBegin = 0;
		int minLength = Integer.MAX_VALUE;
		HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
		int i = 0;
		while (i < T.length()) {
			needToFind.put(T.substring(i, i + 1), 0);
			i++;
		}

		for (int j = 0; j < S.length(); j++) {
			if (needToFind.get(S.substring(j, j + 1)) != null
					&& needToFind.get(S.substring(j, j + 1)) == 0) {
				needToFind.put(S.substring(j, j + 1), 1);
				count += 1;
				if (count == T.length()) {
					flagFound = true;
					count = 0;
					if (j - tempBegin < minLength) {
						minLength = j - tempBegin;
						begin = tempBegin;
						end = j + 1;
						cleanNeedToFind(needToFind, T);
					}
					if (j + 1 < S.length()) {
						tempBegin = j + 1;
					}
				} else if (count == 1) {
					if (j + 1 < S.length()) {
						tempBegin = j;
					}
				}
			} else {
				if (tempBegin + 1 < S.length()) {
					tempBegin++;
				}
			}
		}

		if (flagFound) {
			return S.substring(begin, end);
		} else {
			return "";
		}
	}

	public static void cleanNeedToFind(HashMap<String, Integer> needToFind,
			String T) {
		int i = 0;
		while (i < T.length()) {
			needToFind.put(T.substring(i, i + 1), 0);
			i++;
		}
	}

	public static String minWindow2(String S, String T) {
		int[] hasFound = new int[256];
		Arrays.fill(hasFound, 0);
		int[] needToFind = new int[256];
		char[] Tarr = T.toCharArray();
		for (int i = 0; i < Tarr.length; i++) {
			needToFind[Tarr[i]] += 1;
		}
		char[] Sarr = S.toCharArray();
		int count = 0;
		int minBegin = 0;
		int minEnd = 0;
		int minLength = Integer.MAX_VALUE;
		boolean flag = false;
		for (int begin = 0, end = 0; end < Sarr.length; end++) {
			if (needToFind[Sarr[end]] == 0)
				continue;
			hasFound[Sarr[end]]++;
			if (hasFound[Sarr[end]] <= needToFind[Sarr[end]])
				count++;
			if (count == Tarr.length) {
				while (needToFind[Sarr[begin]] == 0
						|| hasFound[Sarr[begin]] > needToFind[Sarr[begin]]) {
					if (hasFound[Sarr[begin]] > needToFind[Sarr[begin]])
						hasFound[Sarr[begin]]--;
					begin++;
				}
				int TempWinLen = end - begin + 1;
				if (TempWinLen < minLength) {
					flag = true;
					minLength = TempWinLen;
					minBegin = begin;
					minEnd = end;
				}
			}
		}

		if (flag) {
			return S.substring(minBegin, minEnd + 1);
		} else {
			return "";
		}
	}
}

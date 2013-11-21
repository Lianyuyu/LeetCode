package com.lian.leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	public static void main(String[] args) {
		// Longest Substring Without Repeating Characters
		String s1 = "adsasdffgfdsgretrtr";
		String s2 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		String s3 = "adsasdf";
		System.out.println(findLongestSubWithoutRep(s3));
	}

	// Longest Substring Without Repeating Characters
	public static int findLongestSubWithoutRep(String s) {
		if (s.length() == 0) {
			return 0;
		}
		char[] arr = s.toCharArray();
		int i = 0;
		int maxlength = 1;
		int begin = 0;
		int tempLen = 0;
		int tempBegin = 0;
		HashSet<Character> hs = new HashSet<Character>();
		while (i < arr.length) {
			if (!hs.contains(arr[i])) {
				hs.add(arr[i]);
				tempLen += 1;
				if (tempLen > maxlength) {
					maxlength = tempLen;
					begin = tempBegin;
				}
			} else {
				hs.clear();
				tempBegin = i - tempLen + 1;
				i = i - tempLen + 1;
				hs.add(arr[i]);
				tempLen = 1;
			}
			i++;
		}
		return maxlength;
	}
}

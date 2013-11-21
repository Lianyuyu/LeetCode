package com.lian.leetcode;

public class DistinctSubsequences {

	/**
	 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "rabbbit";
		String s2 = "rabbit";
		System.out.println(numDistinct(s1, s2));
	}
	
    public static int numDistinct(String S, String T) {
        int[][] f = new int[S.length() + 1][T.length() + 1];
    	for (int k = 0; k < S.length(); k++)
    		f[k][0] = 1;
    	for (int i = 1; i <= S.length(); i++) {
    		for (int j = 1; j <= T.length(); j++) {
    			if (S.charAt(i - 1) == T.charAt(j - 1)) {
    				f[i][j] += f[i - 1][j] + f[i - 1][j - 1];
    			} else {
    				f[i][j] += f[i - 1][j];
    			}
    		}
    	}
    	return f[S.length()][T.length()];
    }
}

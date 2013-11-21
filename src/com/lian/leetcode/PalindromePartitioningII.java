package com.lian.leetcode;

import java.util.ArrayList;

public class PalindromePartitioningII {

	/**
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return 1 since the palindrome partitioning
	 * ["aa","b"] could be produced using 1 cut.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut4("aadd"));
		System.out.println();
	}

	public static int minCut(String s) {
		if(s.length() == 0)return 0;
		int length =s.length();
		int[] dp = new int[s.length()+1];
		boolean[][] palin = new boolean[s.length()][s.length()];
		
		for(int i =s.length(); i>=0;i--){
			dp[i] = length-i;
		}
		
		for(int i = length-1; i>=0;i--){
			for(int j = i; j < length ;j++){
				if(s.charAt(i) == s.charAt(j) && (j -i<2 || palin[i+1][j-1])){
					palin[i][j] = true;
					dp[i] = Math.min(dp[j], dp[i]);
				}
			}
		}
		return dp[0]-1;
	}
	
	// use partition 1 code,
	public static int minCut2(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.length() == 0)
			return 0;
		ArrayList<String> pt = new ArrayList<String>();
		findPartition(s, 0, pt, result);
		int min = Integer.MAX_VALUE;
		for (ArrayList<String> list : result) {
			min = list.size() < min ? list.size() : min;
		}
		return min - 1;
	}

	public static void findPartition(String s, int begin, ArrayList<String> pt,
			ArrayList<ArrayList<String>> result) {
		if (begin >= s.length()) {
			ArrayList<String> copy = new ArrayList<String>();
			for (int i = 0; i < pt.size(); i++) {
				copy.add(pt.get(i));
			}
			result.add(copy);
		}

		for (int i = begin; i < s.length(); i++) {
			if (isPalindrome(s, begin, i)) {
				pt.add(s.substring(begin, i + 1));
				findPartition(s, i + 1, pt, result);
				pt.remove(pt.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	//not work
	public static int minCut3(String s) {
		if (s.length() == 0)
			return 0;
		ArrayList<String> list = new ArrayList<String>();
		minCutHelper(s, 0, list);
		return list.size() - 1;
	}

	public static void minCutHelper(String s, int begin, ArrayList<String> list) {
		if (begin >= s.length())
			return;

		int longestPalinPos = 0;
		for (int i = begin; i < s.length(); i++) {
			if (!isPalindrome(s, begin, i)) {
				longestPalinPos = i - 1;
				break;
			} else {
				longestPalinPos = i;
			}
		}

		list.add(s.substring(begin, longestPalinPos + 1));
		minCutHelper(s, longestPalinPos + 1, list);
	}
	
    public static int minCut4(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        boolean[][] parlin = new boolean[length][length];
        
        for (int i = length; i >= 0; i--) {
            dp[i] = length - i;
        }
        
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || parlin[i + 1][j - 1])) {
                    parlin[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        
        return dp[0] - 1;
    }
}

package com.lian.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {

	/**
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 */
	public static void main(String[] args) {
		
		String s = "12";
		System.out.println(numDecodings(s));
	}

	public static int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		int[] helper = new int[1];
		helper[0] = 0;
		numDecodingsHelper(s, helper,"");
		return helper[0];
	}

	public static void numDecodingsHelper(String s, int[] helper, String last) {
		if (s.length() == 0)
			return;
		boolean flag = false;
		String newLast;
		if (s.length() >= 2) {
			if (Integer.parseInt(s.substring(1, 2)) == 0) {
				helper[0]++;
				numDecodingsHelper(s.substring(2), helper, s.substring(1, 2));
			} else if (Integer.parseInt(s.substring(0, 2)) > 26) {
				helper[0]++;
				numDecodingsHelper(s.substring(2), helper, s.substring(1, 2));
			} else {
				helper[0]++;
				helper[0]++;
				numDecodingsHelper(s.substring(2), helper,s.substring(1, 2));
			}
		}else if(s.length() >=1 && s.length() <2){
			if(s.substring(0, 1) != "0"){
				helper[0]++;
				numDecodingsHelper(s.substring(1), helper,s.substring(0, 1));
			}else{
				numDecodingsHelper(s.substring(1), helper,s.substring(0, 1));
			}
		}
	}

	//
//	public int numDecodings2(String s) {
//		if (s.length() == 0)
//			return 0;
//		List<ArrayList<String>> resutlLists = new ArrayList<ArrayList<String>>();
//		int[] helper = new int[1];
//		helper[0] = 0;
//		numDecodingsHelper(s, helper);
//		return helper[0];
//	}
//
//	public void numDecodingsHelper2(String s, List<ArrayList<String>> resutlLists, List<String> list) {
//		if (s.length() == 0)
//			return;
//		List<ArrayList<String>> resutlLists = new ArrayList<ArrayList<String>>();
//		if (s.length() >= 1) {
//			if (Integer.parseInt(s.substring(0, 1)) != 0) {
//				helper[0]++;
//				numDecodingsHelper(s.substring(1), helper);
//			} else {
//				numDecodingsHelper(s.substring(1), helper);
//			}
//		}
//		if (s.length() >= 2) {
//			if (Integer.parseInt(s.substring(0, 2)) == 20
//					&& Integer.parseInt(s.substring(0, 2)) == 10) {
//				helper[0]++;
//				numDecodingsHelper(s.substring(2), helper);
//			} else if (Integer.parseInt(s.substring(0, 2)) > 26) {
//				numDecodingsHelper(s.substring(1), helper);
//			} else {
//				helper[0]++;
//				numDecodingsHelper(s.substring(2), helper);
//			}
//		}
//		return;
//	}

}
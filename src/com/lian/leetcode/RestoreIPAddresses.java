package com.lian.leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {

	/**
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "010010";
		ArrayList<String> resultList = restoreIpAddresses(s);
		// System.out.println(s.substring(4));

		String s1 = s.substring(4);
		if (s1.length() == 0)
			System.out.println("aa");
	}

	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<ArrayList<String>> resultLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() == 0)
			return result;

		ArrayList<String> list = new ArrayList<String>();
		restoreIpAddressesHelper(s, list, resultLists);
		outerloop: while (resultLists.size() != 0) {
			if (resultLists.get(0).size() == 4) {
				StringBuilder sb = new StringBuilder();
				for (String str : resultLists.get(0)) {
					int i = Integer.parseInt(str);
					if (str.length() != String.valueOf(i).length()) {
						resultLists.remove(0);
						continue outerloop;
					}
					sb.append(str + ".");
				}
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
			}
			resultLists.remove(0);
		}
		return result;
	}

	public static void restoreIpAddressesHelper(String s,
			ArrayList<String> list, ArrayList<ArrayList<String>> resultLists) {
		if (s.length() > 12) {
			return;
		}
		if (s.length() == 0) {
			resultLists.add(list);
			return;
		}
		// less than
		if (s.length() >= 1) {
			ArrayList<String> newList = copyArrayList(list);
			newList.add(s.substring(0, 1));
			restoreIpAddressesHelper(s.substring(1), newList, resultLists);
		}
		if (s.length() >= 2) {
			ArrayList<String> newList = copyArrayList(list);
			newList.add(s.substring(0, 2));
			restoreIpAddressesHelper(s.substring(2), newList, resultLists);
		}
		if (s.length() >= 3 && Integer.parseInt(s.substring(0, 3)) <= 255) {
			ArrayList<String> newList = copyArrayList(list);
			newList.add(s.substring(0, 3));
			restoreIpAddressesHelper(s.substring(3), newList, resultLists);
		}
		return;
	}

	public static ArrayList<String> copyArrayList(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		return copy;
	}

}

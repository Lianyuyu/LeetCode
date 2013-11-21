package com.lian.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {

	/**
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ] Discuss
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		String s1 = "efe";
		ArrayList<ArrayList<String>> list = partition2("aabb");
		// ArrayList<ArrayList<String>> list1 = createListFromString("bbb");
		// ArrayList<ArrayList<String>> list2 = new
		// ArrayList<ArrayList<String>>();
		// ArrayList<ArrayList<String>> list3 =
		// createListFromSameLetterString("aaa",list2,"aaa".length());
		// test("asd");

		// ArrayList<String> l1 = new ArrayList<String>();
		// ArrayList<String> l2 = new ArrayList<String>();
		// String a = "a";
		// l1.add(a);
		// l2.add(a);

		System.out.println();
	}

	// github answer
	public static ArrayList<ArrayList<String>> partition2(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.length() == 0)
			return result;
		ArrayList<String> pt = new ArrayList<String>();
		findPartition(s, 0, pt, result);
		return result;
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

	// not work
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> allLists = new ArrayList<ArrayList<String>>();
		String pali;
		for (int i = 0; i < s.length(); i++) {
			String pali1 = getPalindrome(s, i, i);
			// just one word
			if (pali1.length() == 1)
				pali = pali1;
			else {
				i += pali1.length() / 2;
				pali = pali1;
				// handle pali;
				allLists = mergeLists(allLists, createListFromString(pali));
				continue;
			}
			String pali2 = getPalindrome(s, i, i + 1);
			if (pali2.length() == 0) {
				pali = pali1;
				// handle pali
				allLists = mergeLists(allLists, createListFromString(pali));
				continue;
			} else {
				i += pali2.length() / 2;
				pali = pali2;
				// handel pali
				allLists = mergeLists(allLists, createListFromString(pali));
			}
		}
		return allLists;
	}

	public static String getPalindrome(String s, int l, int r) {
		char[] arr = s.toCharArray();
		while (l >= 0 && r < arr.length) {
			if (arr[l] != arr[r])
				break;
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}

	public static ArrayList<ArrayList<String>> createListFromString(String s) {
		ArrayList<ArrayList<String>> newlists = new ArrayList<ArrayList<String>>();
		// special handle, s="aaaa"
		int length = 1;
		while (length < s.length()) {
			if (!s.substring(length - 1, length).equals(
					s.substring(length, length + 1))) {
				break;
			}
			length++;
		}
		if (length == s.length()) {
			// all letters are same
			ArrayList<ArrayList<String>> newlists1 = new ArrayList<ArrayList<String>>();
			newlists1 = createListFromSameLetterString(s, newlists, s.length());
			return newlists1;
		}

		// s="abba","ababa"
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			ArrayList<String> newList = new ArrayList<String>();
			if (newlists.size() != 0) {
				if (newlists.size() > 0) {
					int disL = start - 1;
					int disR = end + 1;
					while (disL > 0) {
						String lastEdge = newlists.get(newlists.size() - 1)
								.get(disL - 1);
						newList.add(lastEdge);
						disL--;
					}
					newList.add(s.substring(start - 1, start));
					newList.add(s.substring(start, end + 1));
					newList.add(s.substring(start - 1, start));
					disL = start - 1;
					while (disL > 0) {
						String lastEdge = newlists.get(newlists.size() - 1)
								.get(disL - 1);
						newList.add(lastEdge);
						disL--;
					}
					// while(disR < s.length()){
					// String lastEdge =
					// newlists.get(newlists.size()-1).get(disR+1);
					// newList.add(lastEdge);
					// disR++;
					// }
					newlists.add(newList);
				}
			} else {
				newList.add(s.substring(start, end + 1));
				newlists.add(newList);
			}
			start++;
			end--;
		}
		return newlists;
	}

	public static ArrayList<ArrayList<String>> createListFromSameLetterString(
			String s, ArrayList<ArrayList<String>> allLists, int length) {
		if (length == 0) {
			return new ArrayList<ArrayList<String>>();
		}
		String letter = s.substring(0, 1);
		allLists = createListFromSameLetterString(s, allLists, length - 1);
		ArrayList<ArrayList<String>> newlists = new ArrayList<ArrayList<String>>();
		int i = 0;
		// copy list
		// for(ArrayList<String> list: allLists){
		// newlists.add((ArrayList<String>)list.clone());
		// for(String element : list){
		//
		// }
		// }
		if (allLists.size() == 0) {
			ArrayList<String> newList = new ArrayList<String>();
			newList.add(letter);
			allLists.add(newList);
			return allLists;
		}
		i = 0;
		// if orianl is bb link bb,b
		while (i < allLists.size()) {
			ArrayList<String> list = allLists.get(i);
			ArrayList<String> newList = new ArrayList<String>();
			for (String element : list)
				newList.add(element);
			newList.add(letter);
			newlists.add(newList);
			i++;
		}
		i = 0;
		// if orianl is bb link bbb
		while (i < allLists.size()) {
			ArrayList<String> list = allLists.get(i);
			ArrayList<String> newList = new ArrayList<String>();
			for (int j = 0; j < list.size() - 1; j++) {
				// String element = list.get(j);
				newList.add(list.get(j));
			}
			if (list.size() > 0) {
				newList.add(list.get(list.size() - 1) + letter);
			}
			newlists.add(newList);
			i++;
		}

		return newlists;
	}

	public static ArrayList<ArrayList<String>> mergeLists(
			ArrayList<ArrayList<String>> allLists,
			ArrayList<ArrayList<String>> newLists) {
		ArrayList<ArrayList<String>> merged = new ArrayList<ArrayList<String>>();
		int i = 0;
		if (allLists.size() == 0) {
			while (i < newLists.size()) {
				ArrayList<String> list2 = newLists.get(i);
				ArrayList<String> MergedList = new ArrayList<String>();
				MergedList.addAll(list2);
				merged.add(MergedList);
				i++;
			}
		}
		i = 0;
		while (i < allLists.size()) {
			ArrayList<String> list1 = allLists.get(i);
			int j = 0;
			while (j < newLists.size()) {
				ArrayList<String> list2 = newLists.get(j);
				ArrayList<String> MergedList = new ArrayList<String>();
				MergedList.addAll(list1);
				MergedList.addAll(list2);
				merged.add(MergedList);
				j++;
			}
			i++;
		}
		return merged;
	}

	public static void test(String s) {
		String sub;
		for (int c = 0; c < s.length(); c++) {
			for (int i = 1; i <= s.length() - c; i++) {
				sub = s.substring(c, c + i);
				System.out.println(sub);
			}
		}
	}

}

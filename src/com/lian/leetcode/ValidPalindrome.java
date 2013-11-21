package com.lian.leetcode;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char a = 'R';
		char b = 'A';
		if (a == b)
			System.out.println("true");
		if (!('A' <= a || a <= 'C'))
			System.out.println("include");
		else
			System.out.println("not include");

		String s = "            ";
		System.out.println(allSpace(s));

		String test = "A man, a plan, a canal: Panama";
		String test2 = "race a car";
		System.out.println(isPalindrome2("1a2"));
	}

	// not work
	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.equals(""))
			return true;
		if (allSpace(s))
			return true;
		int begin = 0;
		int end = s.length() - 1;
		s = s.toUpperCase();
		char[] arr = s.toCharArray();
		char l = arr[begin];
		char r = arr[end];
		while (begin <= end) {
			while (!(0 <= l && l <= 9) && !('A' <= l && l <= 'Z')
					&& begin < s.length() - 1) {
				begin++;
				l = arr[begin];
			}
			while (!(0 <= r && r <= 9) && !('A' <= r && r <= 'Z') && end > 0) {
				end--;
				r = arr[end];
			}
			if (l != r)
				return false;
			begin++;
			end--;
			l = arr[begin];
			r = arr[end];
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		if (s == "")
			return true;
		if (s == null)
			return false;
		// if (s.length() == 1) return true;
		if (allSpace(s))
			return true;

		s = s.toUpperCase();
		// cut off symbol
		int begin = 0;
		StringBuilder sb = new StringBuilder();
		while (begin < s.length()) {
			if (isAtoZor1To10(s.substring(begin, begin + 1))) {
				sb.append(s.substring(begin, begin + 1));
			}
			begin++;
		}
		begin = 0;
		String newS = sb.toString();
		char[] arr = newS.toCharArray();
		if (arr.length == 0)
			return true;
		int end = newS.length() - 1;
		char l = arr[begin];
		char r = arr[end];
		while (begin <= end && begin < end && end > 0) {
			if (l != r)
				return false;
			begin++;
			end--;
			l = arr[begin];
			r = arr[end];
		}
		return true;
	}

	public static boolean isAtoZor1To10(String s) {
		char c = s.toCharArray()[0];
		if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z'))
			return true;
		else
			return false;
	}

	public static boolean allSpace(String s) {
		int begin = 0;
		int end = s.length();
		while (begin < s.length()) {
			if (!s.substring(begin, begin + 1).equals(" "))
				return false;
			begin++;
		}
		return true;
	}
}

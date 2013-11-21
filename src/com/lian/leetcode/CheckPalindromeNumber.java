package com.lian.leetcode;

public class CheckPalindromeNumber {

	/**
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 * 
	 * click to show spoilers.
	 * 
	 * Some hints: Could negative integers be palindromes? (ie, -1)
	 * 
	 * If you are thinking of converting the integer to string, note the
	 * restriction of using extra space.
	 * 
	 * You could also try reversing an integer. However, if you have solved the
	 * problem "Reverse Integer", you know that the reversed integer might
	 * overflow. How would you handle such case?
	 * 
	 * There is a more generic way of solving this problem.
	 */
	public static void main(String[] args) {
		// Palindrome Number
		int i = 1221;
		System.out.println(palidrameNum2(i));

		System.out.println(i);
		System.out.println(reverseNum(i));
	}

	// Palindrome Number
	// Determine whether an integer is a palindrome. Do this without extra
	// space.
	public static boolean palidrameNum(int x) {
		String s = Integer.toString(x);
		char[] arr = s.toCharArray();
		int j = arr.length - 1;
		for (int i = 0; i < (arr.length) / 2; i++) {
			if (arr[i] != arr[j])
				return false;
			j--;
		}
		return true;
	}

	public static boolean palidrameNum2(int x) {
		int d = 1;
		while (x / d >= 10) {
			d *= 10;
		}
		System.out.println(d);
		while (x != 0) {
			if (x / d != x % 10) {
				return false;
			}
			x = (x % d) / 10;
			d /= 100;
		}
		return true;
	}

	public static int reverseNum(int num) {
		int reverse = 0;
		while (num != 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return reverse;
	}
}

package com.lian.leetcode;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1, 1 };
		int length = removeElement(A, 1);
		System.out.println(length);
		System.out.println();
	}

	public static int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;

		int foundNum = 0;
		int i = 0;
		while (i < A.length && i <= A.length - 1 - foundNum) {
			if (A[i] == elem) {
				int j = A.length - 1 - foundNum;
				while (j > i) {
					if (A[j] == elem)
						foundNum++;
					else
						break;
					j--;
				}
				foundNum++;
				A[i] = A[j];
			}
			i++;
		}
		return A.length - foundNum;
	}

}

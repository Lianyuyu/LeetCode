package com.lian.leetcode;

public class MedianofTwoSortedArrays {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 */
	public static void main(String[] args) {
		// Median of Two Sorted Arrays
		int[] arrA = { 1, 2, 3, 4, 5 };
		int[] arrB = { 6, 7, 8, 9, 10 };
		System.out.println(findMedian(arrA, arrB));
	}

	// Median of Two Sorted Arrays
	public static double findMedian(int A[], int B[]) {
		if (A.length == 0 && B.length == 0) {
			return 0;
		}
		if (A.length == 0) {
			return getMedian(B);
		}
		if (B.length == 0) {
			return getMedian(A);
		}
		int[] arrC = new int[A.length + B.length];
		int i = 0, j = 0, c = 0;
		while (i < A.length && c < arrC.length && j < B.length) {
			if (A[i] <= B[j]) {
				arrC[c] = A[i];
				i++;
				c++;
			} else {
				arrC[c] = B[j];
				j++;
				c++;
			}
		}
		while (j < B.length && c < arrC.length) {
			arrC[c] = B[j];
			j++;
			c++;
		}
		while (i < A.length && c < arrC.length) {
			arrC[c] = A[i];
			i++;
			c++;
		}
		return getMedian(arrC);
	}

	public static double getMedian(int[] arr) {
		double median = Integer.MAX_VALUE;
		if (arr.length % 2 == 0) {
			median = ((double) arr[arr.length / 2] + (double) arr[arr.length / 2 - 1]) / 2;
		} else {
			median = arr[arr.length / 2];
		}
		return median;
	}
}

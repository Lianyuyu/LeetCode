package com.lian.leetcode;

public class SearchinRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1 = { 7, 8, 9, 12, 14, 16, 1, 2, 5, 6 };
		int[] A2 = { 1, 2, 4, 5, 6, 7, 8, 9, 12, 15, 20 };
		int[] A3 = { 14, 15, 2, 3, 5, 6, 7, 9, 11, 12 };
		int[] A4 = { 1 };

		System.out.println(search3(A3, 2));
	}

	// dont work
	public static int search(int[] A, int target) {
		if (A.length == 0)
			return -1;
		if (A.length == 1 && A[0] == target)
			return 0;
		else if (A.length == 1 && A[0] != target)
			return -1;
		int l = 0;
		int r = A.length - 1;
		int median;
		while (l <= r) {
			median = (l + r) / 2;
			if (target == A[median])
				return median;
			if (target == A[r]) {
				return r;
			} else if (target == A[r]) {
				return l;
			} else if (A[median] > A[l] && target >= A[l] && target < A[median]) {
				// left side sorted, target on left
				r = median - 1;
			} else if (A[median] > A[l] && target > A[median]) {
				// left side sorted, target on right
				l = median + 1;
			} else if (A[median] < A[r] && target >= A[median]
					&& target <= A[r]) {
				// right side sorted, target on right side
				l = median + 1;
			} else if (A[median] < A[r] && target < A[median]) {
				// right side sorted, target on left side
				r = median - 1;
			}
			// else if(A[median] > A[r] && target < A[l]){
			// //le
			// l = median +1;
			// }else if(A[median] < A[l] && target> A[r]){
			// //right side sorted,
			// r = median-1;
			// }
			else if (A[r] > A[l] && target < A[median]) {
				// list sorted, target on left
				r = median - 1;
			} else if (A[r] > A[l] && target > A[median]) {
				// list sorted, target on right
				l = median + 1;
			} else {
				System.out.println(l + "~~" + r);
				// return -1;
			}
		}
		return -1;
	}

	//
	public static int search2(int[] A, int target) {
		if (A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l <= r) {
			m = (l + r) / 2;
			if (target == A[m]) {
				return m;
			} else if (A[l] <= A[m] && A[m] >= A[r]) {
				// left sorted, right unsorted
				if (target < A[m] && target >= A[l]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				// right sorted, left unsorted
				if (target <= A[r] && target > A[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			// }else if(A[l] < A[r]){
			// //list sorted
			// if(target < A[m]) r =m -1;
			// else l = m +1;
			// }
		}
		return -1;
	}

	// work
	public static int search3(int[] A, int target) {
		if (A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;
		int m;
		while (l <= r) {
			m = (l + r) / 2;
			if (target == A[m]) {
				return m;
			} else if (A[l] <= A[m]) {
				// left sorted
				if (target < A[m] && target >= A[l]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				// right sorted
				if (target <= A[r] && target > A[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}
		return -1;
	}
}

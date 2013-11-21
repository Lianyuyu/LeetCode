package com.lian.leetcode;

public class NextPermutation {

	/**
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
	 * 1,2,3 1,1,5 → 1,5,1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 2, 3, 1 };
		// swap(num, 0, 1);
		// System.out.println(num[0] + "," + num[1]);
		nextPermutation(num);
		for (int i : num) {
			System.out.print(i + ",");
		}
	}

	public static void nextPermutation(int[] num) {
		if (num == null)
			return;
		if (num.length == 0)
			return;
		if (num.length == 1)
			return;
		if (checkOrder(num)) {
			reverse(num);
		} else {
			changeOrder(num);
		}
	}

	public static void swap(int[] num, int a, int b) {
		num[a] = num[b] - num[a];
		num[b] = num[b] - num[a];
		num[a] = num[b] + num[a];
	}

	public static boolean checkOrder(int[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void reverse(int[] num) {
		for (int i = 0; i < num.length / 2; i++) {
			swap(num, i, num.length - i - 1);
		}
	}

	public static void changeOrder(int[] num) {
		// int minPos = 0;
		// int secondMinPos = 0;
		// int secondMin = Integer.MAX_VALUE;
		// boolean flag = false;
		// for (int i = num.length - 1; i >= 0; i--) {
		// if (num[i] < secondMin) {
		// if (!flag) {
		// secondMin = num[i];
		// secondMinPos = i;
		// flag = true;
		// } else {
		// minPos = i;
		// break;
		// }
		// }
		// }
		int i = num.length - 1;
		while (i > 0 && num[i - 1] >= num[i]) {
			i--;
		}

		if (i == 0)
			return;

		int j = num.length - 1;
		while (num[j] <= num[i - 1])
			j--;

		swap(num, i - 1, j);

		j = num.length - 1;
		while (i < j) {
			swap(num, i, j);
			i++;
			j--;
		}
	}

	public static void changeOrder(int[] num, int minPos, int secondMinPos) {
		int temp = num[secondMinPos];
		for (int i = secondMinPos; i >= minPos && i > 0; i--) {
			num[i] = num[i - 1];
		}
		num[minPos] = temp;
	}

}

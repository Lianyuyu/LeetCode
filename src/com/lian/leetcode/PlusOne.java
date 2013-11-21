package com.lian.leetcode;

public class PlusOne {

	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 * not finish yet
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] digits = {9,8,7,6,5,4,3,2,1,0};
		int[] digits = new int[1];
		int[] result = PlusOne.plusOne(digits);
		if(result != null){
		for(int i:result){
		System.out.print(i);
		}
		}
	}
	
	public static int[] plusOne(int[] digits) {
			if(digits == null || digits.length == 0){
				return null;
			}
			StringBuilder numBuilder = new StringBuilder();
			for(int digit: digits){
				numBuilder.append(digit);
			}
			long num = Long.valueOf(numBuilder.toString());
			num += 1;
			int[] result = new int[String.valueOf(num).length()];
			String strResult = String.valueOf(num);
			for(int i=0;i<result.length;i++){
				System.out.println(strResult.charAt(i));
				result[i] = Character.getNumericValue((int)strResult.charAt(i));
			}
			return result;
		}
}

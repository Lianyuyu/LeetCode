package com.lian.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DivideTwoIntegers {

	/**
	 * Divide two integers without using multiplication, division and mod operator.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-10, 1));
	}

	public static int divide(int dividend, int divisor) {
		BigDecimal d1 = new BigDecimal(dividend);
		d1 = d1.abs();
		BigDecimal d2 = new BigDecimal(divisor);
		d2 = d2.abs();
		BigDecimal d3 = new BigDecimal(divisor);
		d3 = d3.abs();

		ArrayList<Integer> list = new ArrayList<Integer>();
		while (d1.compareTo(d2) == 1 || d1.compareTo(d2) == 0) {
			d3 = new BigDecimal(divisor);
			d3 = d3.abs();
			boolean start = true;
			while (d1.compareTo(d3) == 1 || d1.compareTo(d3) == 0) {
				if (start) {
					list.add(1);
					start = false;
				} else {
					int last = list.get(list.size()-1);
					list.add(last+last);					
				}
				d1 = d1.subtract(d3);
				d3 = d3.add(d3);
			}
		}
		
		int result = 0;
		for(int i:list){
			result += i;
		}	
		
		result = ((dividend > 0 && divisor >0) ||(dividend < 0&& divisor<0))?result:-result;
		
		return result;
	}
}

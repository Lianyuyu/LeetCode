package com.lian.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.

		For example, given numRows = 5,
		Return
		
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(1);
	}

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(numRows == 0) return result;
    	ArrayList<Integer> cur;
    	ArrayList<Integer> prev = new ArrayList<Integer>();
    	prev.add(1);
    	result.add(prev);
    	int i =1;
    	while(i < numRows){
    		cur = new ArrayList<Integer>();
    		cur.add(prev.get(0));
    		int j = 0;
        	while(j< i-1){
        		cur.add(prev.get(j)+prev.get(j+1));
        		j++;
        	}
        	cur.add(prev.get(j));
        	
        	result.add(cur);
        	prev = cur;
        	i++;
        }
    	return result;
    }
}

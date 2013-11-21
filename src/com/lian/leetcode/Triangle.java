package com.lian.leetcode;

import java.util.ArrayList;

public class Triangle {

	/**
	 * 
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1=  new ArrayList<Integer>();
		ArrayList<Integer> l2=  new ArrayList<Integer>();
		ArrayList<Integer> l3=  new ArrayList<Integer>();
		ArrayList<Integer> l4=  new ArrayList<Integer>();
		ArrayList<Integer> l5=  new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);
		System.out.println(minimumTotal(lists));
	}

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle == null) return 0;
    	int[] prev = new int[1];
    	prev[0] = triangle.get(0).get(0);
    	int min = prev[0];
    	int i =1;
        while(i< triangle.size()){
        	int[] cur = new int[triangle.get(i).size()];
        	cur[0] = prev[0] +  triangle.get(i).get(0);
        	min = cur[0];
        	for(int j = 0; j< prev.length-1; j++){
        		if(prev[j] < prev[j+1]){
        			cur[j+1] = triangle.get(i).get(j+1)+prev[j];
        		}
        		else{
        			cur[j+1] = triangle.get(i).get(j+1) + prev[j+1];
        		}
        		if( min > cur[j+1] ) min = cur[j+1];
        	}
        	cur[cur.length-1] = prev[prev.length-1]+ triangle.get(i).get(triangle.get(i).size()-1);
        	if(min > cur[cur.length-1]) min = cur[cur.length-1];
        	prev = cur;
        	i++;
        }
        return min;
    }
}

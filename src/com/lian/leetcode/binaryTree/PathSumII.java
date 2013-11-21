package com.lian.leetcode.binaryTree;

import java.util.ArrayList;

import com.lian.leetcode.util.TreeNode;

public class PathSumII {

	/**
	 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		TreeNode node10 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right =node8;
		node6.left = node10;
		node6.right = node9;
		
		TreeNode node11 = new TreeNode(1);
		System.out.println(pathSum(node1,22));

	}

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
    	if(root == null) return result;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	pathSumHelper(result, list, root, sum, 0);
    	return result;
    }
    
    public static void pathSumHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,TreeNode node, int sum, int tempSum) {
        if(node == null) return;
        tempSum += node.val;
        list.add(node.val);
        //copy the list
        ArrayList<Integer> newCopyListL = new ArrayList<Integer>();
        ArrayList<Integer> newCopyListR = new ArrayList<Integer>();
        for(int i = 0; i< list.size() ;i++){
        	newCopyListL.add(list.get(i));
        	newCopyListR.add(list.get(i));
        }
        
        if(node.left == null && node.right == null){
        	if(tempSum == sum){
        		result.add(list);
        		return;
        	}else{
        		return;
        	}
        }
//        if(node.left != null && node.right == null){
//        	pathSumHelper(result, newCopyListL, node.left, sum, tempSum);
//        	return ;
//        }
//        if(node.left == null&& node.right != null){
//        	pathSumHelper(result, newCopyListR, node.right, sum, tempSum);
//        }
//        if(node.left == null&& node.right == null){
//        	pathSumHelper(result, newCopyListL, node.left, sum, tempSum);
//        	pathSumHelper(result, newCopyListR, node.right, sum, tempSum);
//        }
        
    	pathSumHelper(result, newCopyListL, node.left, sum, tempSum);
    	pathSumHelper(result, newCopyListR, node.right, sum, tempSum);
    }
    
}

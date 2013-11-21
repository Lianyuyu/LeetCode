package com.lian.leetcode.binaryTree;

import java.util.ArrayList;

import com.lian.leetcode.util.TreeNode;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right =node8;
		node6.right = node9;
		
		TreeNode node10 = new TreeNode(1);
		System.out.println(hasPathSum(node1,22));
	}

	//solution1
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int temp = 0;
        hasPathSumHelper(root, sum, temp, list);
        if(!list.isEmpty()) return true;
        else return false;
    }
    
    public static void hasPathSumHelper(TreeNode node, int sum , int tempSum, ArrayList<Integer> list){
    	if(node == null) return ;
    	tempSum += node.val;
    	if(node.left == null && node.right == null){
    		if(tempSum == sum){
    			return ;
    		}else{
    			return ;
    		}
    	}
    	if(node.right != null){
    		hasPathSumHelper(node.right, sum, tempSum, list);
    	}
    	if(node.left != null){
    		hasPathSumHelper(node.left, sum, tempSum, list);
    	}
    }
    
    //sulotion2, better
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
        int temp = 0;
        return hasPathSumHelper2(root, sum, temp);
    }
    
    public static boolean hasPathSumHelper2(TreeNode node, int sum , int tempSum){
    	if(node == null) return false;
    	tempSum += node.val;
    	if(node.left == null && node.right == null){
    		if(tempSum == sum){
    			return true;
    		}else{
    			return false;
    		}
    	}
    	if(node.right != null && node.left == null){
    		return hasPathSumHelper2(node.right, sum, tempSum);
    	}
    	if(node.left != null && node.right == null){
    		return hasPathSumHelper2(node.left, sum, tempSum);
    	}
    	if(node.right != null && node.left != null){
//    		boolean left = hasPathSumHelper2(node.left, sum, tempSum);
//    		boolean right = hasPathSumHelper2(node.right, sum, tempSum);
    		return hasPathSumHelper2(node.left, sum, tempSum)||hasPathSumHelper2(node.right, sum, tempSum);
    	}
		return false;
    }
}

package com.lian.leetcode.binaryTree;

import com.lian.leetcode.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	/**
	 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(-3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(-2);
		TreeNode node7 = new TreeNode(-1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node4.left = node7;
		
		TreeNode node11 = new TreeNode(8);
		TreeNode node12 = new TreeNode(9);
		TreeNode node13 = new TreeNode(-6);
		TreeNode node14 = new TreeNode(5);
		TreeNode nod1e15 = new TreeNode(9);

		node11.left = node12;
		node11.right = node13;
		node13.left = node14;
		node13.right = nod1e15;
		
		TreeNode node111 = new TreeNode(1);
		TreeNode node112 = new TreeNode(-1);
		TreeNode node113 = new TreeNode(-9);
		TreeNode node114 = new TreeNode(-8);
		TreeNode node115 = new TreeNode(3);
		TreeNode node116 = new TreeNode(-2);
		
		node111.right = node112;
		node112.left = node113;
		node112.left = node114;
		node114.left = node115;
		node115.right = node116;
		
		System.out.println(maxPathSum(node111));
	}
	
    public static int maxPathSum2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        //helper[0] min, helper[1] leftMax, helper[2] rightMax
        int[] helper = new int[3];
        
        int max = 0;
        helper[0] = Integer.MIN_VALUE;
        helper[1] = Integer.MIN_VALUE;
        helper[2] = Integer.MIN_VALUE;
        int leftMax = maxPathSumHelper2(root.left, helper, true);
        int rightMax = maxPathSumHelper2(root.right,helper, false);
        max = Math.max((root.val+ leftMax+rightMax),Math.max(helper[1],helper[2]));
        if(max < helper[0]) max = helper[0];
    
        return max;
    }
    
    public static int maxPathSumHelper2(TreeNode node, int[] helper, boolean left) {
        if(node == null) return 0;
        
        //record max single node
    	if(left){
    		if(node.val > helper[1]) helper[1] = node.val;
    	}else{
    		if(node.val > helper[2]) helper[2] = node.val;;
    	}
    	
        if(node.left == null && node.right == null) {
        		if(node.val <0 ) {
        			helper[0] = helper[0] > node.val?helper[0]:node.val;
        			return 0;
        		}else{
        			return node.val;
        		}
        }
        int leftMax = maxPathSumHelper2(node.left, helper, left);
        int rightMax = maxPathSumHelper2(node.right, helper, left);
        
        int tempMax = Math.max(leftMax,rightMax) + node.val;
        //record max left tree + node+ right tree
        if(left){
        	if(leftMax + node.val+rightMax > helper[1]) helper[1]= leftMax + node.val+rightMax;
        }else{
        	if(leftMax +  + node.val+rightMax > helper[2]) helper[2]= leftMax +node.val+ rightMax;
        }
        
        if(tempMax <0)tempMax = 0;
        else{
        	 if(left){
             	if(tempMax > helper[1]){
             		helper[1] = tempMax;
             	}
             }else{
             	if(tempMax > helper[2]){
             		helper[2] = tempMax;
             	}
             }
        }

        return tempMax;
    }
    
    //not work
    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        //helper[0] min, helper[1] leftMax, helper[2] rightMax
        int[] helper = new int[3];
        
        int max = 0;
        helper[0] = Integer.MIN_VALUE;
        helper[1] = Integer.MIN_VALUE;
        helper[2] = Integer.MIN_VALUE;
        int leftMax = maxPathSumHelper(root.left, helper, true);
        int rightMax = maxPathSumHelper(root.right,helper, false);
//        if(root.val < 0) {
//            if(leftMax <=0 && rightMax <=0 ){
//        		if(root.val > helper[0]) max = root.val; 
//        		else max =helper[0];
//        	}
//        	else max =  leftMax> rightMax?leftMax:rightMax;
//        }else{
//        	max = Math.max(helper[2],Math.max(helper[1], (root.val +leftMax +rightMax)));
//        }
        max = Math.max((root.val+ leftMax+rightMax),Math.max(helper[1],helper[2]));
        if(max < helper[0]) max = helper[0];
    
        return max;
    }
    
    public static int maxPathSumHelper(TreeNode node, int[] helper, boolean left) {
        if(node == null) return 0;
        
    	if(left){
    		if(node.val > helper[1]) helper[1] = node.val;
    	}else{
    		if(node.val > helper[2]) helper[2] = node.val;;
    	}
    	
        if(node.left == null && node.right == null) {
        		if(node.val <0 ) {
        			helper[0] = helper[0] > node.val?helper[0]:node.val;
        			return 0;
        		}else{
        			return node.val;
        		}
        }
        int leftMax = maxPathSumHelper(node.left, helper, left);
        int rightMax = maxPathSumHelper(node.right, helper, left);
        
        int tempMax = Math.max(leftMax,rightMax) + node.val;
        
        if(left){
        	if(leftMax + rightMax > helper[1]) helper[1]= leftMax + rightMax;
        }else{
        	if(leftMax + rightMax > helper[2]) helper[2]= leftMax + rightMax;
        }
        if(tempMax <0)tempMax = 0;
        else{
        	 if(left){
             	if(tempMax > helper[1]){
             		helper[1] = tempMax;
             	}
             }else{
             	if(tempMax > helper[2]){
             		helper[2] = tempMax;
             	}
             }
        }

        return tempMax;
    }
}

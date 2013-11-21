package com.lian.leetcode.binaryTree;

import com.lian.leetcode.util.TreeNode;

public class MinimumDepthofBinaryTree {

	/**
	 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
		
		System.out.println(minDepth(node1));
		
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		node11.left = node12;
		System.out.println(minDepth(node11));
	}

    public static int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int leftMin = minDepth(root.left)+1;
        int rightMin = minDepth(root.right)+1;
    	if(root.left == null && root.right != null){
    		return rightMin;
    	}else if(root.right == null && root.left != null){
    		return leftMin;
    	}
        return leftMin<rightMin?leftMin:rightMin;
    }
    
    public static int minDepthHelper(TreeNode root) {
        if(root == null){
        	return 0;
        }
    	if(root.left == null && root.right == null){
    		return 1;
    	}
        int leftMin = minDepthHelper(root.left)+1;
        int rightMin = minDepthHelper(root.right)+1;
        return leftMin<rightMin?leftMin:rightMin;
    }
}

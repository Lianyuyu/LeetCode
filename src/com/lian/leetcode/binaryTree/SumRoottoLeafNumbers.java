package com.lian.leetcode.binaryTree;

import java.util.ArrayList;

import com.lian.leetcode.util.TreeNode;

public class SumRoottoLeafNumbers {

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
	 * path could represent a number.
	 * 
	 * An example is the root-to-leaf path 1->2->3 which represents the number
	 * 123.
	 * 
	 * Find the total sum of all root-to-leaf numbers.
	 * 
	 * For example,
	 *  1
   	 * / \
     *2   3
	 * The root-to-leaf path 1->2 represents the number 12. The
	 * root-to-leaf path 1->3 represents the number 13.
	 * 
	 * Return the sum = 12 + 13 = 25.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node3.left = node6;
		sumNumbers3(node1);
		

	}
	
	//
    public static int sumNumbers2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right ==null) return root.val;
        ArrayList<Integer> list = new ArrayList<Integer>();
        countLeft2(list, root.left, String.valueOf(root.val));
        countRight2(list, root.right, String.valueOf(root.val));
        int sum = 0;
		for(int num: list){
			sum += num;
		}
        return sum;
    }
    
    public static void countLeft2(ArrayList<Integer> list, TreeNode node, String s){
    	if(node == null	)  return;
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(s);
    	while(node != null){
    		sb.append(String.valueOf(node.val));
    		if(node.right == null && node.left == null){
    			list.add(Integer.parseInt(sb.toString()));
    		}
    		if(node.right != null){
    			countRight2(list, node.right, sb.toString());
    		}
			node = node.left;
    	}
    	
    }
    
    public static void countRight2(ArrayList<Integer> list, TreeNode node, String s){
    	if(node == null	) return;
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(s);
    	while(node != null){
    		sb.append(String.valueOf(node.val));
    		if(node.right == null && node.left == null){
    			list.add(Integer.parseInt(sb.toString()));
    		}
    		if(node.left != null){
    			countLeft2(list, node.left, sb.toString());
    		}
			node = node.right;
    	}
    }
	
    //simplify sumNumbers2
    public static int sumNumbers3(TreeNode root) {
        if(root == null) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        count(list, root, "");
        int sum = 0;
		for(int num: list){
			sum += num;
		}
        return sum;
    } 
    
    public static void count(ArrayList<Integer> list, TreeNode node, String s){
    	if(node == null) return ;
    	StringBuilder sb = new StringBuilder();
    	sb.append(s);
    	sb.append(String.valueOf(node.val));
    	if(node.left == null && node.right == null){
    		list.add(Integer.parseInt(sb.toString()));
    	}
    	count(list, node.left, sb.toString());
    	count(list, node.right, sb.toString());
    }
    //
    
	//wrong understand
    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right ==null) return root.val;
        ArrayList<Integer> list = new ArrayList<Integer>();
        countLeft(list, root.left, root.val);
        countRight(list, root.right, root.val);
        int sum = 0;
		for(int num: list){
			sum += num;
		}
        return sum;
    }

    public static void countLeft(ArrayList<Integer> list, TreeNode node, int lastVal){
    	if(node == null	) return;
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.valueOf(lastVal));
    	while(node != null ){
    		sb.append(node.val);
    		if(node.right != null) countRight(list, node.right, node.val);
    		node = node.left;
    	}
    	list.add(Integer.parseInt(sb.toString()));
    	
    }
    
    public static void countRight(ArrayList<Integer> list, TreeNode node, int lastVal){
    	if(node == null	) return;
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.valueOf(lastVal));
    	while(node != null ){
    		sb.append(node.val);
    		if(node.left != null) countLeft(list, node.left, node.val);
    		node = node.right;
    	}
    	list.add(Integer.parseInt(sb.toString()));
    }
}

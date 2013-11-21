package com.lian.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

import com.lian.leetcode.util.TreeNode;

class BinaryTreeInorderTraversal {

	/**
	 *Given a binary tree, return the inorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,3,2].
		
		Note: Recursive solution is trivial, could you do it iteratively?
		
		confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
		
		
		OJ's Binary Tree Serialization:
		The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
		
		Here's an example:
		   1
		  / \
		 2   3
		    /
		   4
		    \
		     5
		The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		ArrayList<Integer> list =inorderTraversal3(node1);
	}

	//recursive
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> list =new ArrayList<Integer>();
        if(root == null) return list;
        inorderTraversalHalper(root, list);
        return list;
    }
    
    public static void  inorderTraversalHalper(TreeNode node,ArrayList<Integer> list) {
    	if(node == null) return;
    	inorderTraversalHalper(node.left, list);
    	list.add(node.val);
    	inorderTraversalHalper(node.right, list);
    }
    
    //iterative not work
    public static ArrayList<Integer> inorderTraversal2(TreeNode root) {
    	ArrayList<Integer> list =new ArrayList<Integer>();
        if(root == null) return list;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
        	TreeNode cur = stack.peek();
        	if(prev == null || prev.left == cur || prev.right == cur){
        		if(cur.left != null) stack.push(cur.left);
        		else if(cur.right != null) stack.push(cur.right);
        	}else if(cur.left == prev){
        		if(cur.right != null) stack.push(cur.right);
        	}else{
        		list.add(stack.pop().val);
        	}
        	prev = cur;
        }
        return list;
    }
    
  //iterative 
    public static ArrayList<Integer> inorderTraversal3(TreeNode root) {
    	ArrayList<Integer> list =new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
        	stack.push(node);
        	node = node.left;
        }
        while(!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	list.add(cur.val);
        	if(cur.right != null){
        		cur = cur.right;
        		stack.push(cur);
        		while(cur.left != null){
        			cur = cur.left;
        			stack.push(cur);
        		}
        	}
        }
        return list;
    }
}

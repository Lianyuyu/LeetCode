package com.lian.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

import com.lian.leetcode.util.TreeNode;

public class BinaryTreePostorderTraversal {

	/**
	 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
	 */
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.right = node2;
		node2.left = node3;
		
		BinaryTreePostorderTraversal main = new BinaryTreePostorderTraversal();
		ArrayList<Integer> result = main.postorderTraversal(node1);
		
		for(int i: result){
			System.out.println(i);
		}

	}

	//recursive
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = 	new ArrayList<Integer>();
    	postorderTraversalIterative(list, root);
    	return list;
    }
    
    public void postorderTraversal(ArrayList<Integer> list, TreeNode node){
    	if(node == null) {
    		return;
    	}
    	
    	postorderTraversal(list, node.left);
    	postorderTraversal(list, node.right);
    	list.add(node.val);
    }
    
    //iterative
    public void postorderTraversalIterative(ArrayList<Integer> list, TreeNode node){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(true){
    		if(node != null){
    			if(node.right != null) stack.push(node.right);
    			stack.push(node);
    			node = node.left;
    			continue;
    		}
    		
    		if(stack.isEmpty()) return;
    			
    		node = stack.pop();
    		
    		if(node.right != null && !stack.isEmpty() && node.right == stack.peek()){
    			stack.pop();
    			stack.push(node);
    			node = node.right;
    		}else{
    			list.add(node.val);
    			node = null;
    		}
    	}
    }

}

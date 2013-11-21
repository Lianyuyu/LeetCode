package com.lian.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.lian.leetcode.util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	/**
	 * Given a binary tree, flatten it to a linked list in-place.

		For example,
		Given
		
		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		The flattened tree should look like:
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6
		click to show hints.
		
		Hints:
		If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
		node2.right = node6;
		node3.right = node5;
		
		flatten5(node1);
		System.out.println();
	}

	//level order, wrong answer for this question
    public static void flatten(TreeNode root) {
        if(root == null){
        	return ;
        }
        
    	Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
    	TreeNode newNode = new TreeNode(root.val);
    	TreeNode head = newNode;
    	TreeNode empty = new TreeNode(0);
        currentLevel.add(root);
        while(!currentLevel.isEmpty()){
        	Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        	while(!currentLevel.isEmpty()){
        		TreeNode node = currentLevel.poll();
        		if(newNode.right != null){
        			newNode = newNode.right;
        		}
        		newNode.left = null;
        		newNode.right  = node;
        		if(node.left != null) nextLevel.add(node.left);
        		if(node.right != null) nextLevel.add(node.right);
        	}
        	currentLevel = nextLevel;
        }
        root = head.right;
    }
    
    //order: root, left, right , dont work
    public static void flatten2(TreeNode root) {
    	if(root == null){
    		return ;
    	}
    	
    	TreeNode head = new TreeNode(root.val);
    	TreeNode point = new TreeNode(root.val);
    	head = point;
    	flatten2Helper(root,point);
    	root = head;
    	System.out.println();
    }
    
    public static void flatten2Helper(TreeNode currentNode, TreeNode point){
    	if(currentNode == null){
    		return ;
    	}
    	
    	if(currentNode.left != null) {
    		point.left = null;
    		point.right = new TreeNode(currentNode.left.val);
    		flatten2Helper(currentNode.left, point.right);
    	}
    	if(currentNode.right != null) {
    		point.left = null;
    		point.right = new TreeNode(currentNode.right.val);
    		flatten2Helper(currentNode.right, point.right);
    	}
    	return ;
    }
    
    //dont understand
    public static void flatten3(TreeNode root) {
    	if (root == null || (root.left == null && root.right == null)) return;
		if (root.left != null) {
			TreeNode tmp = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode rightMost = findRightMostNode(root.right);
			rightMost.right = tmp;
			flatten3(root.right);
		} else if (root.right != null) {
			flatten3(root.right);
		}
	}

	public static TreeNode findRightMostNode(TreeNode root) {
		if (root.right != null) {
			return findRightMostNode(root.right);
		} else {
			return root;
		}
	}
	
	//iterative answer
    public static void flatten4(TreeNode root) {
    	if(root == null ){
    		return;
    	}
    	
    	Stack<TreeNode> toVisit= new Stack<TreeNode>();
    	TreeNode prev = null;
    	toVisit.push(root);
    	while(!toVisit.isEmpty()){
    		TreeNode cur = toVisit.pop();
    		if(cur.right != null) toVisit.push(cur.right);
    		if(cur.left != null) toVisit.push(cur.left);
    		if(prev != null) {
    			prev.left = null;
    			prev.right = cur;
    		}
    		prev = cur;
    	}
	}
    
    //recursive
    public static void flatten5(TreeNode root){
    	if(root == null ) return;
    	if(root.left !=  null){
    		TreeNode rchild = root.right;
    		root.right = root.left;
    		root.left = null;
    		TreeNode mostRight = root.right;
    		while(mostRight.right != null){
    			mostRight = mostRight.right;
    		}
    		mostRight.right = rchild;
    	}
    	flatten5(root.right);
    }

}

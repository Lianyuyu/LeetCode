package com.lian.leetcode.binaryTree;

import com.lian.leetcode.util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNodeII {

	/**
	 *Follow up for problem "Populating Next Right Pointers in Each Node".

		What if the given tree could be any binary tree? Would your previous solution still work?
		
		Note:
		
		You may only use constant extra space.
		For example,
		Given the following binary tree,
		
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		After calling your function, the tree should look like:
		
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL
	 */
	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);
		TreeLinkNode node9 = new TreeLinkNode(9);
		TreeLinkNode node10 = new TreeLinkNode(10);
		TreeLinkNode node11 = new TreeLinkNode(11);
		TreeLinkNode node12 = new TreeLinkNode(12);
		TreeLinkNode node13 = new TreeLinkNode(13);
		TreeLinkNode node14 = new TreeLinkNode(14);
		TreeLinkNode node15 = new TreeLinkNode(15);
		TreeLinkNode node16 = new TreeLinkNode(16);
		TreeLinkNode node17 = new TreeLinkNode(17);
		node1.left = node2;
		node1.right =node3;
		node2.left = node4;
		node2.right =node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right =node9;
		node5.left =node10;
		node5.right =node11;
		node6.left =node12;
		node6.right = node13;
		node7.left = node14;
		node7.right = node15;

		connect(node1);
	}

    public static void connect(TreeLinkNode root) {
        if(root == null) return ;
        
        if(root.left != null){
        	if(root.right != null){
        		root.left.next = root.right;
        	}else{
        		TreeLinkNode temp = root.next;
        		while(temp != null && temp.right == null && temp.left == null){
        			temp = temp.next;
        		}
        		if(temp != null){
        			if(temp.left != null) root.left.next = temp.left;
        			else root.left.next = temp.right;
        		}
        	}
        }
        
        if(root.right != null){
        	TreeLinkNode temp = root.next;
    		while(temp != null && temp.right == null && temp.left == null){
    			temp = temp.next;
    		}
    		if(temp != null){
    			if(temp.left != null) root.right.next = temp.left;
    			else root.right.next = temp.right;
    		}
        }
        
        connect(root.right);
        connect(root.left);
    }
    
}

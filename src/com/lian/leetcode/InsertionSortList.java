package com.lian.leetcode;

import com.lian.leetcode.util.ListNode;

public class InsertionSortList {

	/**
	 * Sort a linked list using insertion sort.
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode head1 = node1;
		
		while(head1 != null){
			System.out.print(head1.val+"->");
			head1 = head1.next;
		}
		
		System.out.println();
		
		ListNode head = insertionSortList(node1);
		while(head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}
	
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode current = head;
    	ListNode previous = null;
    	ListNode next = current.next;
    	
    	if(next.val > current.val) {
        	previous = head;
    		current = next;
        	next = current.next;    		
    	}else{
    		ListNode temp = next.next;
    		next.next = current;
    		current.next = temp;
    		previous = next;
    		head = next;
    		next = current.next;
    	}
    	
        while(current != null){

        	previous.next = next;
        	
        	ListNode left = head;
        	ListNode leftPrevious = null;
        	while(left != next){
        		if(current.val <= left.val){
        			if(leftPrevious != null){
        				leftPrevious.next = current;
            			current.next = left;
        			}else{
        				head = current;
        				current.next = left;
        			}
        			break;
        		}
        		leftPrevious = (leftPrevious == null)?head:leftPrevious.next;
        		left = left.next;
        		
        		if(left == next){
        			if(leftPrevious != null){
        				leftPrevious.next = current;
            			current.next = left;
        			}else{
        				head = current;
        				current.next = left;
        			}
                	previous = current;
        			break;
        		}
        	}
        	

        	current = next;
        	if(current != null) next = next.next;
        	else break;
        }
        
        return head;
    }
}

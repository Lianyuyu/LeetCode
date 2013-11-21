package com.lian.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LRUCache {

	/**
	 * 
	 Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */

	private int capacity;
	private int currentElements;

	private HashMap<Integer, Element> hm ;

	private Element head;
	private Element tail;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(4));
//		System.out.println(cache.get(2));
//		cache.set(4, 2);
//		cache.set(4, 3);
//		System.out.println(cache.get(4));
//		cache.set(2, 2);
//		System.out.println(cache.get(2));
//		cache.set(5, 5);
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(2));
//		System.out.println(cache.get(4));
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.hm = new HashMap<Integer, Element>();
		this.head = new Element(100, 100);
		this.tail = new Element(200, 200);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (capacity < 1)
			return -1;

		if (hm.containsKey(key)) {
			Element element = hm.get(key);

			detach(element);
			attach(element);
			return element.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (capacity < 1)
			return;

		if (hm.containsKey(key)) {
			Element element = hm.get(key);
			element.value = value;
			hm.put(key, element);
			detach(element);
			attach(element);
		} else {
			Element newElement = new Element(key, value);
			if (currentElements >= capacity) {
				hm.put(key, newElement);
				hm.remove(tail.pre.key);
				detach(tail.pre);
				attach(newElement);
			} else {
				hm.put(key, newElement);
				attach(newElement);
				currentElements++;
			}
		}
	}

	private class Element {
		int value;
		int key;
		Element next;
		Element pre;

		public Element(int key, int value) {
			this.value = value;
			this.key = key;
			this.next = null;
			this.pre = null;
		}
	}

	public void detach(Element element) {

		element.pre.next = element.next;
		element.next.pre = element.pre;
	}

	public void attach(Element element) {
		element.next = head.next;
		head.next.pre = element;
		element.pre = head;
		head.next = element;
		
	}
}

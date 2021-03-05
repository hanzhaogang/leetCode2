package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _146_LRUCache {
	/*
	 * Design and implement a data structure for Least Recently Used (LRU) cache. 
	 * It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /capacity/ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


["LRUCache","put", "put","get","put","get","put","get","get","get"]
[[2],        [1,1],[2,2], [1],  [3,3],[2],  [4,4],[1],  [3],  [4]]

	 */
	int cap;
	int count;
	ListNode head;
	ListNode tail;
	Map<Integer,ListNode> map;
	public _146_LRUCache(int capacity) {
		head=new ListNode();
		tail=new ListNode();
		head.next=tail;
		tail.pre=head;
		
		cap=capacity;
		count=0;
		map=new HashMap<>();
    }

	private void moveToTail(ListNode node) {
		ListNode pre=node.pre;
		ListNode next=node.next;
		pre.next=next;
		next.pre=pre;
		
		ListNode last=tail.pre;
		last.next=node;
		tail.pre=node;
		node.pre=last;
		node.next=tail;
	}
	
	private void appendToTail(ListNode node) {
		ListNode last=tail.pre;
		last.next=node;
		tail.pre=node;
		node.pre=last;
		node.next=tail;
	}
	private int die() {
		ListNode deadNode=head.next;
		head.next=deadNode.next;
		deadNode.next.pre=head;
		return deadNode.key;
	}
    public int get(int key) {
    	if(map.containsKey(key)) {
    		ListNode node=map.get(key);
    		moveToTail(node);
    		return node.val;
    	}else {
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key)) {
    		ListNode node=map.get(key);
    		node.key=key;
    		node.val=value;
    		moveToTail(node);
    		map.put(key, node);
    	}else {
    		ListNode node=new ListNode();
    		node.key=key;
    		node.val=value;
    		appendToTail(node);
    		map.put(key, node);
    		count++;
    	}
    	
    	
    	if(cap<count) {
    		int deadKey=die();
    		map.remove(deadKey);
    		count--;//this line.
    	}
    }
}

class ListNode{
	int key;
	int val;
	ListNode pre;
	ListNode next;

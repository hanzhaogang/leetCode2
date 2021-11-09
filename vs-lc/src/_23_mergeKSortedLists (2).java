package leetcode;

import java.util.PriorityQueue;

public class _23_mergeKSortedLists {
/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

[
  1->4->5,
  1->3->4,
  5->6
]
Output: 1->1->2->3->4->4->5->6
 */
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq=new PriorityQueue<>((n1,n2)-> {
			return n1.val-n2.val;
//			Integer.compare(x, y);
		});
		for(ListNode n:lists) {
			if(n!=null)
				pq.offer(n);
		}
		
		ListNode dummyNode=new ListNode(-1);
		ListNode p=dummyNode;
		while(!pq.isEmpty()) {
			ListNode node=pq.poll();
			p.next=node;
			p=p.next;
			if(node.next!=null)
				pq.offer(node.next);
		}
		return dummyNode.next;
	}
}
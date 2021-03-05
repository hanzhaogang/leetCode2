package fb2020;
import java.util.PriorityQueue;

/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

 

Constraints:

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length won't exceed 10^4.
 */
public class _23_mergeKSortedList {//[[]]
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode dummyNode=new ListNode();
    	PriorityQueue<ListNode> pq=new PriorityQueue<>((l1,l2)->{
    		return Integer.compare(l1.val, l2.val);
    	});
    	for(ListNode list:lists) {
    		if(list!=null)
    			pq.offer(list);
    	}
    	
    	ListNode p=dummyNode;
    	while(!pq.isEmpty()) {
    		ListNode top=pq.poll();
    		p.next=top;
    		p=p.next;
    		if(top.next!=null)
    			pq.offer(top.next);
    		top.next=null;
    	}
    	
    	return dummyNode.next;
    }
}

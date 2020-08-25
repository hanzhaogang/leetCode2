package leetCode;
/*
 * Given a linked list, 
 * reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end 
should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, 
    only nodes itself may be changed.
 */
public class _25_reverseNodesInKGroup {
	public static void main(String[] args) {
		_25_reverseNodesInKGroup s=new _25_reverseNodesInKGroup();
		
		ListNode head=new ListNode(-1);
		ListNode p=head;
		for(int i=2;i<=5;i++) {
			p.next=new ListNode(i);
			p=p.next;
		}
		
		//s.reverse(head, 4);
		s.reverseKGroup(head, 2);
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode p=head;
		ListNode p4h=head;//the head of last part that need not to be reversed.
		int c=0;
		while(p!=null) {
			if(c%k==0) {
				p4h=p;
			}
			c++;
			p=p.next;
		}
		
		ListNode dummy=new ListNode(-1);
		ListNode q=dummy;
		p=head;
		c=0;
		while(!p.equals(p4h)) {
			if(c%k!=0){
				ListNode t=q.next;
				q.next=p;
				
				p=p.next;
				q.next.next=t;
				c++;
			}else {
				if(q!=dummy) {
					for(int i=0;i<k;i++) {
						q=q.next;
					}
				}
				q.next=p;
				p=p.next;
				c++;
			}
		}
		
		ListNode res=dummy.next;
		return dummy.next;
    }
}



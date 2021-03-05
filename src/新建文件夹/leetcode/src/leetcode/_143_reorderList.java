package leetcode;
/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class _143_reorderList {
	public static void main(String[] args) {
		_143_reorderList s=new _143_reorderList();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		s.reorderList(head);
	}
	public void reorderList(ListNode head) {
		int len=0;
		ListNode p=head;
		while(p!=null) {
			len++;
			p=p.next;
		}
		
		p=head;
		
		for(int i=0;i<len/2;i++) {
			p=p.next;
		}
		
		//p pointing to the head of the second half
		ListNode dummy=new ListNode();
		ListNode p2=dummy.next;
		while(p!=null) {
			dummy.next=p;
			p=p.next;
			dummy.next.next=p2;
			p2=dummy.next;
		}
		
		//dummy.next pointing to 5 4 3 ; 1 2
		p2=dummy.next;
		p=head;
		for(int i=0;i<len/2-1;i++) {
			p=p.next;
		}
		p.next=null;
		
		dummy.next=null;
		ListNode p3=dummy;
		while(p!=null&&p2!=null) {// dummy p3 1 4;p 2;   p2 3
			p3.next=p;
			p=p.next;
			p3=p3.next;
			p3.next=p2;
			p2=p2.next;
			p3=p3.next;
		}
		if(p!=null)
			p3.next=p;
    }
}

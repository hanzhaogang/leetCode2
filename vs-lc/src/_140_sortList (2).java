package leetcode;
/*
 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class _140_sortList {
	public static void main(String[] args) {
		_140_sortList s=new _140_sortList();
		int[] arr=new int[] {-1,5,3,4,0};
		ListNode dummy=new ListNode();
		ListNode p=dummy;
		for(int i=0;i<arr.length;i++) {
			p.next=new ListNode(arr[i]);
			p=p.next;
		}
		ListNode res=s.sortList(dummy.next);
		while(res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
			
	}
	public ListNode sortList(ListNode head) {//4,2,1,3//-1,5,3,4,0
		ListNode p=head;
		ListNode tail=null;
		while(p!=null) {
			tail=p;
			p=p.next;
		}
		return mergeSort(head,tail);
	}
	private ListNode mergeSort(ListNode lo,ListNode hi){//4,2,1,3//4,2,1//-1,5,3,4,0//-1,5,3; 4,0//-1,5;3,3
		System.out.println("mergeSort:"+ lo.val + ","+hi.val);
//		if(lo==null)
//			return null;
		if(lo.equals(hi))
			return lo;
		if(lo.next.equals(hi)) {
			return merge(mergeSort(lo,lo),mergeSort(hi,hi));
		}
		
		ListNode fast=lo;
		ListNode slow=lo;
		while(fast!=hi) {
			slow=slow.next;
			fast=fast.next;
			if(fast!=hi) {
				fast=fast.next;
			}else {
				break;
			}
		}
		
		return merge(mergeSort(lo,slow),mergeSort(slow.next,hi));
	}
	
	private ListNode merge(ListNode r1,ListNode r2) {//this fucntion params is wrong.
		System.out.println("merge"+r1.val+","+r2.val);
		ListNode dummy=new ListNode(-1);
		ListNode p1=r1;
		ListNode p2=r2;
		ListNode p=dummy;
		while(p1!=null||p2!=null) {
			if(p1==null) {
				p.next=p2;
				p2=p2.next;
			}else if(p2==null) {
				p.next=p1;
				p1=p1.next;
			}else {
				if(p1.val<p2.val) {
					p.next=p1;
					p1=p1.next;
				}else {
					p.next=p2;
					p2.next=p2;
				}
				
				p=p.next;
			}
		}
		System.out.println("merged:"+dummy.next.val);
		return dummy.next;
	}
}

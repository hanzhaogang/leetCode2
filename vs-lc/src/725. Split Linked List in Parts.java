public class 725. Split Linked List in Parts {
	
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/* Given the head of a singly linked list and an integer k, 
split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: 
no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

 

Example 1:


Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
Example 2:


Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, 
and earlier parts are a larger size than the later parts.
 

Constraints:

The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
越是思路上简单的题目，越要在coding细节上注意，就越要实际跑几个case。
链表的题目，一定要实际在纸上画一画才行。只靠脑子里面想，很容易出错。*/
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
	int len=0;
	ListNode p=head;
	while(p!=null){
		len++;
		p=p.next;
	}
	ListNode[] res=new ListNode[k];
	int[] counts=new int[k];
	for(int i=0;i<k;i++){
		counts[i]+=len/k;
	}
	for(int i=0;i<len%k;i++){
		counts[i]++;
	}
	p=head;
	ListNode q=p;
	int i=0,j=1;
	while(p!=null){
		if(j==counts[i]){
			res[i++]=q;
			j=1;
			ListNode t=p;
			q=p.next;
			p=p.next;
			t.next=null;
		}else{
			j++;
			p=p.next;
		}
	}
	while(i<k){
		res[i++]=null;
	}
	return res;
    }
}
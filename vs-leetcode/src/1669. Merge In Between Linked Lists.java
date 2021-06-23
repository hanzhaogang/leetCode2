public class 1669. Merge In Between Linked Lists {
	
}
/*
You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure incidate the result:


Build the result list and return its head.

 

Example 1:


Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
Example 2:


Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.
 

Constraints:

3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
注意是从0开始计数的。
遍历list1，用指针记录下第a-1个node（1《=a），以及第b+1个node（肯定不会为null）；
把第a-1个node的next置为null，
问题转换为把3个list按照顺序连接起来,注意，不用遍历，把首尾连起来就行了。
*/
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
	ListNode p=list1;
	ListNode list1Tail=null;
	ListNode list3=null;
	int counter=0;
	while(p!=null){
		if(counter==a-1)
			list1Tail=p;
		if(counter==b+1)
			list3=p;
		counter++;
		p=p.next;
	}

	ListNode list2Tail=null;
	p=list2;
	while(p!=null){
		list2Tail=p;
		p=p.next;
	}
	list1Tail.next=list2;
	list2Tail.next=list3;
	
	return list1;
    }
}	
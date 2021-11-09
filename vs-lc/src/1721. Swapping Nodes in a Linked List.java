public class 1721. Swapping Nodes in a Linked List {
	
}
/**You are given the head of a linked list, and an integer k.

Return the head of the linked list 
after swapping the values of the kth node from the beginning 
and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
遍历链表，找到链表长度n；
再次遍历，当找到第k个元素时，把value暂存；
当找到倒数第k个元素时，把value暂存，并更新；
第三次遍历，更新第K个元素值。

或者：
先遍历链表找到长度n；
双指针，快指针先跑到第n-2k位置，然后快慢指针同时往前走，当慢指针走到k位置时，
交换快慢指针的value。

还有一种思路是一次遍历就可以解决问题。
思路和心得：

1.快慢指针的经典用法

快慢指针用法挺多
1.n等分
2.检测有无环
3.从后数第几个
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

    }
}
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class 1609. Even Odd Tree {
	
}

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
	Queue<TreeNode> q=new LinkedList<>();
	q.offer(root);
	int lv=0;
	while(!q.isEmpty()){
		
		int size=q.size();
		TreeNode pre=null;
		for(int i=0;i<size;i++){
			TreeNode cur=q.poll();
			if(lv%2==0&&(cur.val%2==0||pre!=null&&cur.val<=pre.val) ||
					lv%2!=0&&(cur.val%2!=0||pre!=null&&pre.val<=cur.val) )
				return false;
			if(cur.left!=null)
				q.offer(cur);
			if(cur.right!=null)
				q.offer(cur);
			pre=cur;
		}
		lv++;
	}
	return true;
    }
}

/**A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, 
their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

 

Example 1:



Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing, 
and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
Example 2:



Input: root = [5,4,2,3,3,7]
Output: false
Explanation: The node values on each level are:
Level 0: [5]
Level 1: [4,2]
Level 2: [3,3,7]
Node values in the level 2 must be in strictly increasing order, so the tree is not Even-Odd.
Example 3:



Input: root = [5,9,1,3,5,7]
Output: false
Explanation: Node values in the level 1 should be even integers.
Example 4:

Input: root = [1]
Output: true
Example 5:

Input: root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 106

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/even-odd-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

总结：
要严格按照读题（不要先入为主，要正确理解题意）、设计、编码、测试的流程来。
不管怎么样，都要认真走一个test case。*/
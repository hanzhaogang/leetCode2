public class 面试题 04.08. First Common Ancestor LCCI {
	
}
/*Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

For example, Given the following tree: root = [3,5,1,6,2,0,8,null,null,7,4]

    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Input: 3
Explanation: The first common ancestor of node 5 and node 1 is node 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The first common ancestor of node 5 and node 4 is node 5.
Notes:

All node values are pairwise distinct.
p, q are different node and both can be found in the given tree.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
postorder遍历，后根遍历，也就是自底向上。
在自顶向上的遍历（递归）中，计算当前节点的这个值：以当前节点为根的树，包含了两个目标节点中的几个？
结果可能有0、1、2.
如果发现了2，看看是否找到了lca，如果没找到，那么就更新lca；如果找到了，就不更新。同时返回2
如果发现了1，那么就返回1
如果发现了0，就返回0.
发现了几个是这么计算的：
左子树发现的个数+右子树发现的个数+当前根节点发现的个数（是其中一个的话+1，否则0）*/
class Solution {
	TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	preorder(root,p,q);
	return lca;
    }

    private int preorder(TreeNode root,TreeNode p,TreeNode q){
	    if(root==null)
	    	return 0;

	int left=preorder(root.left,p,q);
	int right=preorder(root.right,p,q);

	int cur=(root.val==p.val||root.val==q.val)?1:0;

	int sum= left+right+cur;
	if(sum==2&&lca==null)
		lca=root;

	return sum;
    }
}
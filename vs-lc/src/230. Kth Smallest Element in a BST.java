public class 230. Kth Smallest Element in a BST {
	
}
/* Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: 
If the BST is modified often (i.e., we can do insert and delete operations) and 
you need to find the kth smallest frequently, how would you optimize?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路： 
中序遍历二叉搜索树，在遍历过程中维护一个全局的计数器。
当遍历到第k个节点时,记录该节点的值，返回。

The optimal runtime complexity is O(height of BST).*/
class Solution {
	public int c=0;
	public int kth=0;
    public int kthSmallest(TreeNode root, int k) {
	inorder(root,k);
	return kth;
    }
    private void inorder(TreeNode root,int k){
	if(root==null)
		return;

	inorder(root.left,k);
	c++;
	if(c==k){
		kth=root.val;
		return;
	}
	inorder(root.right,k);
    }
}
package leetcode;
/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.
 */
public class _104_MaximumDepthOfBinaryTree {
	public int maxLv;
	public int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		maxLv=1;
		preorder(root,1);
		return maxLv;
    }
	private void preorder(TreeNode root,int lv) {
		if(root==null)
			return;
		
		if(maxLv<lv)
			maxLv=lv;
		
		preorder(root.left,lv+1);
		preorder(root.right,lv+1);
	}
}

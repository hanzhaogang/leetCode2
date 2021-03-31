package leetcode;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class _98_validBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		
		int[] minMax=getMinMax(root);
		if(minMax==null)
			return false;
		return true;
    }
	/*
	 *    43
	 * 35    -77
	 *      40
	 */
	private int[] getMinMax(TreeNode root) {//1,2,3
		if(root.left==null&&root.right==null)
			return new int[] {root.val,root.val};
		
		if(root.left==null) {
			int[] right=getMinMax(root.right);
			if(right==null||right[0]<=root.val)
				return null;
			return new int[] {root.val,right[1]};
		}
		
		if(root.right==null) {
			int[] left=getMinMax(root.left);//40,40
			if(left==null||root.val<=left[1])
				return null;
			return new int[] {left[0],root.val};
		}
		
		int[] left=getMinMax(root.left);//35,35
		int[] right=getMinMax(root.right);//null
		
		if(left==null||right==null||root.val<=left[1]||right[0]<=root.val)
			return null;
		return new int[] {left[0],right[1]};
	}
}

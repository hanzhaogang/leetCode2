package fb2020;
/*
 * Given the root node of a binary search tree, 
 * return the sum of values of all nodes with value between L and R (inclusive). 
 * The binary search tree is guaranteed to have unique values. 
 * Example 1: 
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 
 * Output: 32.
 */
public class _938_RangeSumOfBST {
	public int rangeSum(TreeNode root, int L, int R) { 
		return helper(root,L,R);
	}
	
	private int helper(TreeNode root, int L, int R) {
		if(root==null) {
			return 0;
		}
		
		if(root.val<L) {
			return helper(root.right,L,R);
		}else if(root.val==L) {
			return root.val+helper(root.right,L,R);
		}else if(root.val<R) {
			return root.val+helper(root.left,L,R)+helper(root.right,L,R);
		}else if(root.val==R) {
			return root.val+helper(root.left,L,R);
		}else {
			return helper(root.left,L,R);
		}
	}
}

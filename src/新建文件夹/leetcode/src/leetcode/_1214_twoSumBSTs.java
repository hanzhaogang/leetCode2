package leetcode;
/*
 * Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.

Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false

 

Constraints:

    Each tree has at most 5000 nodes.
    -10^9 <= target, node.val <= 10^9

 */
public class _1214_twoSumBSTs {
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		if(root1==null)
			return false;
		
		if(find(root1,root2,target))
			return true;
		
		boolean leftFound=twoSumBSTs(root1.left,root2,target);
		if(leftFound)
			return true;
		boolean rightFound=twoSumBSTs(root2.right,root2,target);
		if(rightFound)
			return true;
		return false;
	}
	
	private boolean find(TreeNode n,TreeNode root,int target) {
		if(root==null)
			return false;
		
		if(root.val+n.val==target)
			return true;
		else if(root.val+n.val<target)
			return find(n,root.right,target);
		else
			return find(n,root.left,target);
	}
}

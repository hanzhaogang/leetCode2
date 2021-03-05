package leetcode;
/*
 * Given two binary trees original and cloned 
 * and given a reference to a node target in the original tree.

  The cloned tree is a copy of the original tree.

  Return a reference to the same node in the cloned tree.

  Note that you are not allowed to change any of the two trees 
or the target node 
and the answer must be a reference to a node in the cloned tree.

Follow up: Solve the problem if repeated values on the tree are allowed.
 */
public class _1379_findaACorrespondingNodeOfABinaryTreeInCloneOfThat {
	TreeNode res;
	public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, 
								TreeNode target) {
		inorder(original,cloned,target);
		return res;
	}
	
	private void inorder(TreeNode original,TreeNode cloned,TreeNode target) {
		if(original==null) {
			return;
		}
		
		inorder(original.left,cloned.left,target);
		
		if(original==target) {
			res=cloned;
			return;
		}
		
		inorder(original.right,cloned.right,target);
	}
}

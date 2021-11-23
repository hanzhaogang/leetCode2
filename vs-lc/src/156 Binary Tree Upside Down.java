public class LeetCode 156 Binary Tree Upside Down {
	public TreeNode f(TreeNode root){
		if(root==null)
		    return null;
		if(root.left==null)
			return root;
		TreeNode leftHead=f(root.left);
		
	}	
}
/* Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where 
the original right nodes turned into left leaf nodes. 
Return the new root. */

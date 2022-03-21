public class 653 {
	
}
/* 
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.


The number of nodes in the tree is in the range [1, 104]. 

遍历+二分查找*/
class Solution {
	boolean b;
    public boolean findTarget(TreeNode root, int k) {
	if(root==null)
	    return false;

	preorder(root,root,k);
	return b;
    }

    private void preorder(TreeNode root,TreeNode curNode,int k){
	    if(curNode==null)
	        return;
	    bs(root,curNode,k-curNode.val);
	    preorder(root,curNode.left,k);
	    preorder(root,curNode.right,k);
    }
    

    private boolean bs(TreeNode root,TreeNode curNode,int t){
	    if(root==null)
	    	return false;
	
	    
	    if(root.val==t)
	    	if(root!=curNode)
	    		return true;
		 
	    else if(root.val<t)
	        bs(root.right,curNode,t);
	    else 
	        bs(root.left,curNode,t);
    }
}
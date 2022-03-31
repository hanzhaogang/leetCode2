/*653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST 
such that their sum is equal to the given target.

Example 1: 
Input: 
5 
/ \ 
3 6 
/ \ \ 
2 4 7

Target = 9

Output: True 
Example 2: 
Input: 
5 
/ \ 
3 6 
/ \ \ 
2 4 7

Target = 28

Output: False*/

/*
 * 1. 
 * inorder traverse the bst, get a sorted array, then use two pointers to find the
 * answer.
 * TC: O(n+n)
 * 
 * 2?
 * 
 *     14
 * 9      18
 * 1 10  15  20
 */
public class LC0653_TwoSum4_InputIsABST {

}

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
	    if(curNode==null)
	    	return false;
	
	    
	    if(root.val==t && root!=curNode || root.left!=null && root.left.val==t || root.right!=null && root.right.val==t)
	    		return true;
	    if(root.val<t)
	        bs(root.right,curNode,t);
	    else 
	        bs(root.left,curNode,t);
	
	    return false;
    }
}

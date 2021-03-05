package leetcode;

/*
Given a binary search tree (See Definition) and a node in it, 
find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

It's guaranteed p is one node in the given tree. 
(You can directly compare the memory address to find p)

Example 1:

Input: {1,#,2}, node with value 1
Output: 2
Explanation:
  1
   \
    2

Example 2:

Input: {2,1,3}, node with value 1
Output: 2
Explanation: 
    2
   / \
  1   3


Challenge

O(h), where h is the height of the BST.


          18
    6           25
   / \
  5   13
4    7  16
  
  {4,1,6,#,#,5,7}
node with value 4


    4
  1   6
     5 7
     
     https://github.com/grandyang/leetcode/issues/285
 */
public class _285_inorderSuccessorInBST_448 {// this solution is SOOOOO cool.
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null)
			return null;
		
		if(root.val<=p.val) {
			return inorderSuccessor(root.right,p);
		}else {
			TreeNode res=inorderSuccessor(root.left,p);
			if(res==null)
				return root;
			else
				return res;
		}
	}
}
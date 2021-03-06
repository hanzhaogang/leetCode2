package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
	 * 99. Recover Binary Search Tree

	Two elements of a binary search tree (BST) are swapped by mistake.

	Recover the tree without changing its structure.

	Example 1:

	Input: [1,3,null,null,2]

	   1
	  /
	 3     (321)
	  \
	   2
	   
	   
	   1 2 3 4 5 6 
	   1 5 3 4 2 6
	   
	       1
	   2
	     3

	Output: [3,1,null,null,2]

	   3
	  /
	 1
	  \
	   2

	Example 2:

	Input: [3,1,4,null,null,2]

	  3
	 / \
	1   4 (1 3 2 4)
	   /
	  2

	Output: [2,1,4,null,null,3]

	  2
	 / \
	1   4
	   /
	  3

     2
   3   4
      1


	Follow up:

	    A solution using O(n) space is pretty straight forward.
	    Could you devise a constant space solution?
	 */
		/*
		 *inorder: 
		 *TreeNode leftMax=getMax(root.left);
		 *if(leftMax.val<root.val){
		 *	
		 *}
		*/

class TreeNode99 {
	public TreeNode99(int val) {
		this.val=val;
	}
	int val;
	TreeNode99 left;
	TreeNode99 right;
}
public class _99_recover_binarySearchTree {
	public static void main(String[] args) {
//		TreeNode99 root=new TreeNode99(3);
//		root.left=new TreeNode99(1);
//		root.right=new TreeNode99(4);
//		root.right.left=new TreeNode99(2);
		
		TreeNode99 root=new TreeNode99(1);
		root.left=new TreeNode99(3);
		root.left.right=new TreeNode99(2);

		_99_recover_binarySearchTree s=new _99_recover_binarySearchTree();
		s.recoverTree(root);
		
		Queue<TreeNode99> q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				TreeNode99 node=q.poll();
				System.out.print(node.val);
				if(node.left!=null)
					q.offer(node.left);
				if(node.right!=null)
					q.offer(node.right);
			}
			System.out.println();
		}
		
	}
	
	
		// 1 3 2 5 4 //1 3 2 4 // 3 2 1 //		1 5 3 4 2 6
	TreeNode99 x;
	TreeNode99 y;
	TreeNode99 pre;
	public void recoverTree(TreeNode99 root) {
		inorder(root);
		
		int temp=x.val;
		x.val=y.val;
		y.val=temp;
    }
	
	private void inorder(TreeNode99 root) {
		if(root==null)
			return;
		
		inorder(root.left);
		
		if(pre!=null&&root.val<pre.val) {
			if(x==null) {
				x=pre;
				y=root;
			}else {
				y=root;
			}
		}
		pre=root;
		inorder(root.right);
	}
	
	
	
	
	
	private TreeNode99[] postorder(TreeNode99 root) {
		if(root==null) {
			return new TreeNode99[] {new TreeNode99(Integer.MAX_VALUE),new TreeNode99(Integer.MIN_VALUE)};
		}
		
		if(root!=null&&root.left==null&&root.right==null) {
			return new TreeNode99[] {root,root};
		}
		TreeNode99[] leftMinMax=postorder(root.left);
		TreeNode99[] rightMinMax=postorder(root.right);
		
		if(leftMinMax[1].val>root.val){
		 	int temp=root.val;
		 	root.val=leftMinMax[1].val;
		 	leftMinMax[1].val=temp;
		}
		
		if(rightMinMax[0].val<root.val) {
			int temp=root.val;
			root.val=rightMinMax[0].val;
			rightMinMax[0].val=temp;
		}
		
		return new TreeNode99[] {leftMinMax[0],rightMinMax[1]};
	}
	
//	private TreeNode[] postOrder(TreeNode root) {
//		if(root==null)
//			return new TreeNode[] {null,null};
//		
//		if(root!=null) {
//			TreeNode[] leftMinMax=postOrder(root.left);
//			TreeNode[] rightMinMax=postOrder(root.right);
//		
//			if(leftNode!=null&&rightNode!=null) {
//				int temp=leftNode.val;
//				leftNode.val=rightNode.val;
//				rightNode.val=temp;
//			}else if(leftNode==null&&rightNode!=null) {
//				int temp=rightNode.val;
//				rightNode.val=root.val;
//				root.val=temp;
//			}else if(leftNode!=null&&rightNode==null) {
//				
//			}else 
//				return null;
//		}
//	}
}

package leetCode;
/*
*    4
*  1   6
*7  9 8 2
5

4,5,8

5,7,9,1,8,2,6,4
*/
public class _236_lowestCommonAncestor {
	TreeNode lcs;
	public TreeNode lowestCommonAncestor(TreeNode root, 
										TreeNode p, TreeNode q) {
		
		postOrder(root,p,q);
		return lcs;
	}
	
	private int postOrder(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null)
			return 0;
		
		int leftCount=postOrder(root.left,p,q);
		int rightCount=postOrder(root.right,p,q);
		
		int curCount=0;
		if(root.val==p.val||root.val==q.val) {
			curCount=leftCount+rightCount+1;
		}else {
			curCount=leftCount+rightCount;
		}
		if(curCount==2&&lcs==null) {
			lcs=root;
		}
		return curCount;
	}
}


package fb2020;
/*
 * post order traversal. 
 * 
 * return 0 if the root has no child that equals p or q.
 * 
 */
public class _236_lca {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		postorder(root,p,q);
		return lca;
	}
	
	TreeNode lca=null;
	boolean found=false;
	private int postorder(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null)
			return 0;
		
		int leftCount=postorder(root.left,p,q);
		int rightCount=postorder(root.right,p,q);
		int count=leftCount+rightCount+((root.equals(p)||root.equals(q))?1:0);
		if(count==2&&!found) {
			found=true;
			lca=root;
		}
		return count;
	}
}

package leetcode;

public class _572_subTreeOfAnotherTree2 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null&&t==null)
			return true;
		if(s!=null&&t==null)
			return true;
		if(s==null&&t!=null)
			return false;
		
		if(isSame(s,t))
			return true;
		if(isSubtree(s.left,t))
			return true;
		if(isSubtree(s.right,t))
			return true;
		return false;
	}
	
	private boolean isSame(TreeNode s,TreeNode t) {
		if(s==null&&t==null)
			return true;
		if(s==null&&t!=null||s!=null&&t==null)
			return false;
		
		if(s.val!=t.val)
			return false;
		
		return isSame(s.left,t.right)&&isSame(s.right,t.right);
	}
}

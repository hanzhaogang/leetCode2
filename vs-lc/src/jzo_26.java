public class jzo_26 {
	private boolean b=false;
	    public boolean isSubStructure(TreeNode A, TreeNode B) {

		preOrder(A,B);
		return b;
	}
	private void preOrder(TreeNode A,TreeNode B){
		if(A==null||B==null){
			return;
		}
		if(A.val==B.val){
			boolean isSub=judge(A,B);
			if(isSub){
				b=true;
				return;
			}
		}
		preOrder(A.left,B);
		preOrder(A.right,B);
	}	
	private boolean isSub(TreeNode A,TreeNode B){
		if(A==null&&B==null){
			return true;
		}
		if(A==null&&B!=null){
			return false;
		}
		if(A!=null&&B==null){
			return true;
		}
		if(A.val!=B.val){
			return false;
		}
		if(A.val==B.val){
			if(isSub(A.left,B.left)&&isSub(A.right,B.right)){
				return true;
			}else{
				return false;
			}
		}

	}
}

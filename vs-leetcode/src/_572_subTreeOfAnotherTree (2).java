package leetcode;

public class _572_subTreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s.left==null&&s.right==null&&t.left==null&&t.right==null)
			return s.val==t.val;

        StringBuilder sbs=new StringBuilder();
        StringBuilder sbt=new StringBuilder();
        inorder(s,sbs);
        inorder(t,sbt);
        return sbs.toString().contains(sbt.toString());
    }
    private void inorder(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("n,");//why? null
            return;
        }
            
        sb.append(node.val);
        sb.append(",");
        inorder(node.left,sb);
        inorder(node.right,sb);
    }
}

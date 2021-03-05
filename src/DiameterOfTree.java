
public class DiameterOfTree {

}


class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;
        if(root.left==null&&root.right!=null) return Math.max(diameterOfBinaryTree(root.right), depth(root.right)+1);
        if(root.left!=null&&root.right==null) return Math.max(diameterOfBinaryTree(root.left), depth(root.left)+1);
        return Math.max(Math.max(diameterOfBinaryTree(root.right),diameterOfBinaryTree(root.left)),depth(root.right)+depth(root.left)+2);
    }
    
    public int depth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;
        /*if(root.left!=null&&root.right==null) return depth(root.left)+1;
        if(root.left==null&&root.right!=null) return depth(root.right)+1;*/
        return Math.max(depth(root.left)+1,depth(root.right)+1);
    }
}
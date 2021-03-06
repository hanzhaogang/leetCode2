package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?

   1 
       2
     3
 */
public class _94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) 
        	return new ArrayList<Integer>();
            
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));
        /*
         *   1
         * 2    3
         * 
         * 1w
         * 
         * 3w 1g 2w
         */
        while(!stack.empty()){
            ColorNode cn = stack.pop();
            
            if(cn.color.equals("white")){
                if(cn.node.right != null) 
                	stack.push(new ColorNode(cn.node.right,"white"));
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.left != null)
                	stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }
        
        return res;
    }
}


class ColorNode {
    TreeNode node;
    String color;
    
    public ColorNode(TreeNode node,String color){
        this.node = node;
        this.color = color;
    }
}
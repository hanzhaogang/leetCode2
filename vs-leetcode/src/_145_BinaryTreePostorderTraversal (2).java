package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class _145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	Deque<Pair145> stack=new ArrayDeque<>();
        List<Integer> postorderList=new ArrayList<>();
        if(root==null)
            return postorderList;
    	stack.push(new Pair145(root,0));
    	
    	while(!stack.isEmpty()) {
    		Pair145 topPair=stack.peek();
    		if(topPair.seen==0) {
    			stack.pop();
    			stack.push(new Pair145(topPair.treeNode,1));
    			if(topPair.treeNode.right!=null) {
    				stack.push(new Pair145(topPair.treeNode.right,0));
    			}
    			if(topPair.treeNode.left!=null) {
    				stack.push(new Pair145(topPair.treeNode.left,0));
    			}
    			
    			
    		}else {
    			postorderList.add(stack.pop().treeNode.val);
    		}
    	}
    	
    	return postorderList;
    }
}


class Pair145{
	TreeNode treeNode;
	int seen;
	
	public Pair145(TreeNode treeNode,int seen) {
		this.treeNode=treeNode;
		this.seen=seen;
	}
}
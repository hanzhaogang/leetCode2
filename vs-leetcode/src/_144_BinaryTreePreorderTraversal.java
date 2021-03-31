package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> preorderList=new ArrayList<>();
    	if(root==null)
    		return preorderList;
    	
    	Deque<Pair144> s=new ArrayDeque<>();
    	s.push(new Pair144(root,0));
    	while(!s.isEmpty()) {
    		Pair144 poped=s.pop();
    		if(poped.seen==0) {
    			if(poped.node.right!=null)
    				s.push(new Pair144(poped.node.right,0));
    			if(poped.node.left!=null)
    				s.push(new Pair144(poped.node.left,0));
    			s.push(new Pair144(poped.node,1));
    		}else {
    			preorderList.add(poped.node.val);
    		}
    	}
    	return preorderList;
    }
}

class Pair144{
	TreeNode node;
	int seen;
	
	public Pair144(TreeNode node,int seen) {
		this.node=node;
		this.seen=seen;
	}
}
package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class _102_binaryTreeLevelTraversal {
/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    		
    	List<List<Integer>> res=new ArrayList<>();
    	if(root==null)
    		return res;
    	
    	Queue<TreeNode> q=new LinkedList<>();
    	q.offer(root);
    	while(!q.isEmpty()) {
    		int size=q.size();
    		List<Integer> curLevel=new ArrayList<>();
    		for(int i=0;i<size;i++) {
    			TreeNode node=q.poll();
    			curLevel.add(node.val);
    			if(node.left!=null)
    				q.offer(node.left);
    			if(node.right!=null)
    				q.offer(node.right);
    		}
    		res.add(curLevel);
    	}
    	
    	return res;
    }
}

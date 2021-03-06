package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Given a binary tree, 
 * imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class _199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
    	Queue<TreeNode> q=new LinkedList<>();
    	q.offer(root);
    	List<Integer> rightSideNodeList=new ArrayList<>();
    	if(root==null)
    		return  rightSideNodeList;
    	
    	while(!q.isEmpty()) {
    		int size=q.size();
    		for(int i=0;i<size;i++) {
    			TreeNode polledNode=q.poll();
    			if(i==size-1) {
    				rightSideNodeList.add(polledNode.val);
    			}
    			if(polledNode.left!=null)
    				q.offer(polledNode.left);
    			if(polledNode.right!=null)
    				q.offer(polledNode.right);
    		}
    	}
    	
    	return rightSideNodeList;
    }
    
    
    public List<Integer> leftSideView_recursion(TreeNode root){
    	
    }
    
    /*
     *     1
     *   2   3
     *     5   4
     */
    List<Integer> rightSideViewNodes=new ArrayList<>();
    Set<Integer> visitedLv=new HashSet<>();
    public List<Integer> rightSideView_recursion(TreeNode root){
    	dfs(root,0);
    	return rightSideViewNodes;
    }
    private void dfs(TreeNode root,int lv) { 
    	if(root==null)
    		return;
    	
    	if(!visitedLv.contains(lv)) {
    		rightSideViewNodes.add(root.val);
    		visitedLv.add(lv);
    	}
    	dfs(root.right,lv+1);
    	dfs(root.left,lv+1);
    }
}

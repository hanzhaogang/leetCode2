package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Return a list of all possible full binary trees with N nodes.  
Each element of the answer is the root node of one possible tree.

Each node of each tree in the answer must have node.val = 0.

You may return the final list of trees in any order.

 

Example 1:

Input: 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],
[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Explanation:

 

Note:

    1 <= N <= 20
 */
public class _894_AllPossibleFullBinaryTree {
    public List<TreeNode> allPossibleFBT(int N) {
    	if(N==1) {
    		TreeNode root=new TreeNode(0);
    		return Arrays.asList(root);
    	}
    	if(N%2==0) {
    		return new ArrayList<TreeNode>();
    	}
    	
    	List<TreeNode> res=new ArrayList<>();
    	N--;
    	int leftCount=1;
    	while(leftCount<N) {
    		int rightCount=N-leftCount;
    		
    		List<TreeNode> leftRoots=allPossibleFBT(leftCount);
    		List<TreeNode> rightRoots=allPossibleFBT(rightCount);
    		for(TreeNode leftRoot:leftRoots) {
    			for(TreeNode rightRoot:rightRoots) {
    				TreeNode root=new TreeNode(0);
    				root.left=leftRoot;
    				root.right=rightRoot;
    				res.add(root);
    			}
    		}
    		leftCount+=2;
    	}
    	return res;
    }
}

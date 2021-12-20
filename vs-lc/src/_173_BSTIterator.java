package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

 

Note:

    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, 
    there will be at least a next smallest number in the BST when next() is called.
 */

class TreeNode173{
	int val;
	TreeNode173 left;
	TreeNode173 right;
}
public class _173_BSTIterator {
	
	Deque<TreeNode173> stack;
	TreeNode173 p;
    public _173_BSTIterator(TreeNode173 root) {
    	stack=new ArrayDeque<>();
    	p=root;
    	while(p!=null) {
    		stack.push(p);
    		p=p.left;
    	}
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode173 node=stack.pop();
        
        p=node.right;
        while(p!=null) {
        	stack.push(p);
        	p=p.left;
        }
        
       	return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
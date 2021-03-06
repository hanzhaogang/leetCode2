package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, 
each group of children is separated by the null value (See examples).

 

Follow up:

Recursive solution is trivial, could you do it iteratively?

 

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

 

Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]

 */
public class _589_N_aryTreePreorderTraversal {
    public List<Integer> preorder(Node589 root) {
        List<Integer> preorderList=new ArrayList<>();
        if(root==null)
        	return preorderList;
        
        Deque<Pair589> s=new ArrayDeque<>();
        s.push(new Pair589(root,false));
        while(!s.isEmpty()) {
        	Pair589 popedPair=s.pop();
        	if(!popedPair.seen) {
        		for(int i=popedPair.node.children.size()-1;0<=i;i--) {
        			Node589 curChild=popedPair.node.children.get(i);
        			if(curChild!=null)
        				s.push(new Pair589(curChild,false));
        		}
        		s.push(new Pair589(popedPair.node,true));
        	}else {
        		preorderList.add(popedPair.node.val);
        	}
        }
        
        return preorderList;
    }
}

class Pair589 {
	Node589 node;
	boolean seen;
	public Pair589(Node589 node,boolean seen) {
		this.node=node;
		this.seen=seen;
	}
}

class Node589{
	int val;
	List<Node589> children;
	
	public Node589(int val,List<Node589> children) {
		this.val=val;
		this.children=children;
	}
}
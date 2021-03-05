import java.util.LinkedList;
import java.util.Queue;

/*
 * A complete binary tree is a binary tree in which every level, 
 * except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

    CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
    CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v 
    so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
    CBTInserter.get_root() will return the head node of the tree.

 

Example 1:

Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]

Example 2:

Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]

 

Note:

    The initial given tree is complete and contains between 1 and 1000 nodes.
    CBTInserter.insert is called at most 10000 times per test case.
    Every value of a given or inserted node is between 0 and 5000.
 */
public class _919_completeBinaryTreeInserter {
	TreeNode root;
	Queue<TreeNode[]> q;
	TreeNode p;
	
    public CBTInserter(TreeNode root) {
    	this.root=root;
    	this.q=new LinkedList<TreeNode[]>();
    	q.offer(new TreeNode[] {root,null});
    	while(!q.isEmpty()) {
    		TreeNode[] peeked=q.peek();
    		if(peeked[0].left!=null&&peeked[0].right!=null) {
    			q.offer(new TreeNode[] {peeked[0].left,peeked[0]});
    			q.offer(new TreeNode[] {peeked[0].right,peeked[0]});
    			q.poll();
    		}else {
    			p=peeked[0];
    			break;
    		}
    	}
    }
    
    public int insert(int v) {
    	if(p.left==null) {
    		p.left=new TreeNode(v);
    		return p.val;
    	}else {
    		p.right=new TreeNode(v);
    		TreeNode[] polled=q.poll();
    		q.offer(new TreeNode[] {p.left,polled[0]});
    		q.offer(new TreeNode[] {p.right,polled[0]});
    		p=q.peek()[0];
    		return polled[0].val;
    	}
    }
    
    public TreeNode get_root() {
    	return root;
    }
}
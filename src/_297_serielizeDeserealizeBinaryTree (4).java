package leetCode;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later 
 * in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree. 
You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

 */
//public class _297_serielizeDeserealizeBinaryTree {
//	
//	/*
//	 *        3
//	 *    2       1
//	 *  8   7       6
//	 *   5 4
//	 * 
//	 * 3,2,8,n,5,n,n,7,4,n,n,n,1,n,6,n,n
//	 */
//	public String serialize(TreeNode root){
//		StringBuilder sb=new StringBuilder();
//		preorder(sb,root);
//		return sb.toString();
//	}
//	private void preorder(StringBuilder sb,TreeNode root) {
//		if(root==null) {
//			sb.append("n");
//			sb.append(",");
//			return;
//		}
//			
//		sb.append(root.val);
//		sb.append(",");
//		preorder(sb,root.left);
//		preorder(sb,root.right);
//	}
//	
//	public TreeNode deserialize(String s) {
//		String[] values=s.split(",");
//		TreeNode root=new TreeNode();
//		root.val=Integer.parseInt(values[0]);
//		
//		Deque<Pair> stack=new LinkedList<>();
//		stack.push(new Pair(root,0));
//		
//		for(int i=1;i<s.length();i++) {
//			String str=values[i];
//			
//			while(stack.peek().count==2) {
//				stack.pop();
//			}
//				
//			if(!str.equals("n")) {
//				TreeNode node=new TreeNode();
//				node.val=Integer.parseInt(str);
//				Pair pair=stack.peek();
//				if(pair.count==0) {
//					pair.node.left=node;
//					pair.count=1;
//					stack.push(new Pair(node,0));
//				}else if(pair.count==1) {
//					pair.node.right=node;
//					pair.count=2;
//					stack.push(new Pair(node,0));
//				}
//			}else {
//				Pair pair=stack.peek();
//				if(pair.count==0) {
//					pair.node.left=null;
//					pair.count=1;
//				}else if(pair.count==1) {
//					pair.node.right=null;
//					pair.count=2;
//				}
//			}
//			
//		}
//		return root;
//	}
//	
//}
//
//class Pair{
//	public Pair(TreeNode node,int count) {
//		this.node=node;
//		this.count=count;
//	}
//	TreeNode node;
//	int count;
//}


public class _297_serielizeDeserealizeBinaryTree{//recursion_preorder
	public String serialize(TreeNode root){//1,2,#,#,3,4,#,#,5,#,#
		if(root==null)
			return "#";
		
		StringBuilder sb=new StringBuilder();
		sb.append(root.val+",");
		sb.append(serialize(root.left));
		sb.append(serialize(root.right));
		return sb.toString();
	}
	
	public TreeNode deserialize(String s) {
		Queue<String> q=new LinkedList<>();
		for(String str:s.split(",")) {
			q.offer(str);
		}
		
		return helper(q);
		
	}
	
	private TreeNode helper(Queue<String> q) {
		
		String curStr=q.poll();
		if(!curStr.equals("#")){
			TreeNode root=new TreeNode(Integer.parseInt(curStr));
			root.left=helper(q);
			root.right=helper(q);
			return root;
		}else {
			return null;
		}
	}
}



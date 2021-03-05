package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _297_serielizeDeserealizeBinaryTree {
	
	/*
	 *        3
	 *    2       1
	 *  8   7       6
	 *   5 4
	 * 
	 * 3,2,8,n,5,n,n,7,4,n,n,n,1,n,6,n,n
	 */
	public String serialize(TreeNode root){
		StringBuilder sb=new StringBuilder();
		preorder(sb,root);
		return sb.toString();
	}
	private void preorder(StringBuilder sb,TreeNode root) {
		if(root==null) {
			sb.append("n");
			sb.append(",");
			return;
		}
			
		sb.append(root.val);
		sb.append(",");
		preorder(sb,root.left);
		preorder(sb,root.right);
	}
	
	public TreeNode deserialize(String s) {
		String[] values=s.split(",");
		TreeNode root=new TreeNode();
		root.val=Integer.parseInt(values[0]);
		
		Deque<Pair> stack=new LinkedList<>();
		stack.push(new Pair(root,0));
		
		for(int i=1;i<s.length();i++) {
			String str=values[i];
			
			while(stack.peek().count==2) {
				stack.pop();
			}
				
			if(!str.equals("n")) {
				TreeNode node=new TreeNode();
				node.val=Integer.parseInt(str);
				Pair pair=stack.peek();
				if(pair.count==0) {
					pair.node.left=node;
					pair.count=1;
					stack.push(new Pair(node,0));
				}else if(pair.count==1) {
					pair.node.right=node;
					pair.count=2;
					stack.push(new Pair(node,0));
				}
			}else {
				Pair pair=stack.peek();
				if(pair.count==0) {
					pair.node.left=null;
					pair.count=1;
				}else if(pair.count==1) {
					pair.node.right=null;
					pair.count=2;
				}
			}
			
		}
		return root;
	}
	
}

class Pair{
	public Pair(TreeNode node,int count) {
		this.node=node;
		this.count=count;
	}
	TreeNode node;
	int count;
}


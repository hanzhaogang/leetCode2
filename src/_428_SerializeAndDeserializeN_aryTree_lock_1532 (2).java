package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _428_SerializeAndDeserializeN_aryTree_lock_1532 {

	public String serialize(ArrayList<DirectedGraphNode> nodes) {
		if(nodes==null)
			return "#,";

		StringBuilder sb=new StringBuilder();
		sb.append(nodes.get(0).val+",");
		for(DirectedGraphNode child:nodes.get(0).neighbors) {
			sb.append(serialize(child));
		}
		return sb.toString();
	}
	
	public DirectedGraphNode deserialize(String data) {

	}
	public String serialize(TreeNode428 root){//1,2,#,#,3,4,#,#,5,#,#
		if(root==null)
			return "#,";
	
		StringBuilder sb=new StringBuilder();
		sb.append(root.val+",");
		for(TreeNode428 child:root.children) {
			sb.append(serialize(child));
		}
		return sb.toString();
}

	public TreeNode428 deserialize(String s) {
		Queue<String> q=new LinkedList<>();
		for(String str:s.split(",")) {
			q.offer(str);
		}
	
		return helper(q);
	
	}

	private TreeNode428 helper(Queue<String> q) {
	
		String curStr=q.poll();
		if(!curStr.equals("#")){
			TreeNode428 root=new TreeNode428(Integer.parseInt(curStr));
			while(!q.isEmpty()) {
				root.children.add(helper(q));
			
			}
			
			return root;
		}else {
			return null;
		}
	}
}

class DirectedGraphNode{
	int val;
	List<DirectedGraphNode> neighbors;
	
	public DirectedGraphNode(int val) {
		this.val=val;
		neighbors=new ArrayList<DirectedGraphNode>();
	}
}
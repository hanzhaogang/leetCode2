import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _297_serializeDeserializeBinaryTree {
	
    // Encodes a tree to a single string.
    List<Integer> data;
	public List<Integer> serialize(TreeNode root) {
    	preorder(root);
    	return data;
    }
	private void preorder(TreeNode root) {
		if(root==null) {
			data.add(null);
			return;
		}
		
		data.add(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	
    // Decodes your encoded data to tree.
    public TreeNode deserialize(List<Integer> data) {//[1,2,N,N,3,N,N]
    	Queue<Integer> q=new LinkedList<>(data);
        TreeNode root=recursion(q);
        return root;
    }
    private TreeNode recursion(Queue<Integer> q) {
    	if(q.isEmpty()) {
    		return null;
    	}
    	
    	Integer val=q.poll();
    	if(val!=null) {
    		TreeNode root=new TreeNode(val);
    		root.left=recursion(q);
    		root.right=recursion(q);
    		
    		return root;
    	}else {
    		return null;
    	}
    }
}

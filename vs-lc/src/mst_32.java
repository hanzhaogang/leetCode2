import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class mst_32 {
	    public int[] levelOrder(TreeNode root) {
		    if(root==null)
		    	return new int[]{};
		List<Integer> list=new ArrayList<>();
		Queue<TreeNode> q=new ArrayDeque<>();
		q.offer(root);
		while(!q.isEmpty()){
			int n=q.size();
			for(int i=0;i<n;i++){
				TreeNode polled=q.poll();
				list.add(polled.val);
				if(polled.left!=null)
					q.offer(polled.left);
				if(polled.right!=null)
					q.offer(polled.right);
			}
		}
		int[] res=new int[list.size()];
		for(int i=0;i<list.size();i++){
			res[i]=list.get(i);
		}
		return res;
    }	
}

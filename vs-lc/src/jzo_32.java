import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;


public class jzo_32 {
	 public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		Queue<TreeNode> q=new ArrayDeque<>();
		if(root==null)
			return res;
		q.offer(root);
		int c=1;
		while(!q.isEmpty()){
			int n=q.size();
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++){
				TreeNode polled=q.poll();
				list.add(polled.val);
				if(polled.left!=null)
					q.offer(polled.left);
				if(polled.right!=null)
					q.offer(polled.right);
			}
			if(c%2==0){
				Collections.reverse(list);
			}
			c++;
			res.add(list);
		}
		return res;	
    }	
}

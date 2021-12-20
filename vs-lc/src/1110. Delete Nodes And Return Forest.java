import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class 1110. Delete Nodes And Return Forest {
	
}

/*Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
先根遍历（是不是就是递归？），
针对当前节点：
如果在待删除节点集合中，跳过、新递归的parent置为null；
如果不在，如果父节点为空，添加到结果中、新递归的parent为当前节点；如果父节点不为空，跳过、parent为当前节点；



上述思路，只保证了森林中树的root能被正确返回，却忘了更新树！*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	Set<Integer> del_set=new HashSet<>();// 3,5
	List<TreeNode> res=new ArrayList<>();
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		for(int i:to_delete)
		del_set.add(i);
		preorder(root,null);
		return res;
    }

    private void preorder(TreeNode root,TreeNode parent){
	    if(root==null)
	    	return;

	if(!del_set.contains(root.val) && parent==null){
		res.add(root);
		parent=root;
	}else	if(del_set.contains(root.val)){
		parent=null;
	}else if(!del_set.contains(root.val) && parent!=null){
		parent=root;
	}
	
	preorder(root.left,parent);
	preorder(root.right,parent);
    }
}
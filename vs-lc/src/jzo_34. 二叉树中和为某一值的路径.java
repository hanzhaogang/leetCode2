import java.util.List;

import javax.swing.tree.TreeNode;

public class 剑指 Offer 34. 二叉树中和为某一值的路径 {
	
}
/* 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 

提示：

节点总数 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：*/


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
	    List<List<Integer>> res=new ArrayList<>();
	    preorder(res,new ArrayList<Integer>(),root,target);
	    return res;
    }

    private void preorder(List<List<Integer>> res,List<Integer> list,TreeNode root,int target){
	    if(root==null)
		    return;
	
	    list.add(root.val);
	    if(root.left==null&&root.right==null&&root.val==target){
		    res.add(new ArrayList<Integer>(list));
	    }
	    preorder(res,list,root.left,target-root.val);
	    preorder(res,list,root.right,target-root.val);
	    list.remove(list.size()-1);
    }
}
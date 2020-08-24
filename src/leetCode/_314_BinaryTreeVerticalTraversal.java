package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class _314_BinaryTreeVerticalTraversal {
/*

Given a binary tree, return the vertical order traversal of its nodes' values. 
(ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example1

Inpurt:  {3,9,20,#,#,15,7}
Output: [[9],[3,15],[20],[7]]
Explanation:
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Example2

Input: {3,9,8,4,0,1,7}
Output: [[4],[9],[3,0,1],[8],[7]]
Explanation:
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

 */
	Map<Integer,Map<Integer,List<Integer>>> map;
	public List<List<Integer>> verticalOrder(TreeNode root) {
		map=new TreeMap<>();
		preorder(root,0,0);
		List<List<Integer>> res=new ArrayList<>();
		for(Map.Entry<Integer, Map<Integer,List<Integer>>> e:map.entrySet()) {
			List<Integer> list=new ArrayList<>();
			Map<Integer, List<Integer>> rowNodeMap=e.getValue();
			for(Map.Entry<Integer, List<Integer>> e2:rowNodeMap.entrySet()) {
				List<Integer> list2=e2.getValue();
				list.addAll(list2);
			}
			res.add(list);
		}
		return res;
    }
	private void preorder(TreeNode root,int col,int row) {
		if(root==null)
			return;
		
		Map<Integer,List<Integer>> rowNodeMap;
		if(map.containsKey(col)) {
			rowNodeMap=map.get(col);
		}else {
			rowNodeMap=new TreeMap<>();
		}
		
		List<Integer> list;
		if(rowNodeMap.containsKey(row)) {
			list=rowNodeMap.get(row);
		}else {
			list=new ArrayList<>();
		}
		list.add(root.val);
		rowNodeMap.put(row, list);
		map.put(col, rowNodeMap);
		
		preorder(root.left,col-1,row+1);
		preorder(root.right,col+1,row+1);
	}
	
	
}

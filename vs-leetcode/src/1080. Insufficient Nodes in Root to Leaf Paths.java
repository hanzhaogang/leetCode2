public class 1080. Insufficient Nodes in Root to Leaf Paths {
	
}
/*
Given the root of a binary tree, consider all root to leaf paths: 
paths from the root to any leaf.  (A leaf is a node with no children.)

A node is insufficient if every such root to leaf path intersecting this node 
has sum strictly less than limit.

Delete all insufficient nodes simultaneously, 
and return the root of the resulting binary tree.

 

Example 1:


Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1

Output: [1,2,3,4,null,null,7,8,9,null,14]
Example 2:


Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22

Output: [5,4,8,11,null,17,4,7,null,null,null,5]
 

Example 3:


Input: root = [1,2,-3,-5,null,4,null], limit = -1

Output: [1,null,-3,4]
 

Note:

The given tree will have between 1 and 5000 nodes.
-10^5 <= node.val <= 10^5
-10^9 <= limit <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
先自顶向下遍历，preorder遍历，参数中保存所有祖先节点的sum和，用limit减去sum，
得到的是当前节点左右子树的最大sum和的新的limit。


再自底向上，记录当前节点左右子树的最大sum和的值，与新的limit值比较。
需要一个node与新limit值的map，才能比较。


与 打印从根节点到特定叶子节点的路径 有相似之处。
对于每一个叶子节点，如果路径和小于limit，则从root到leaf的路径上所有节点都不是要找的节点。
preorder，找到这些节点。
再preorder一遍，这一次在参数中带着当前节点的parent node，
并在需要的时候把parent node的对应孩子置为null

Consider a DFS traversal of the tree. 
You can keep track of the current path sum from root to this node, 
and you can also use DFS to return the minimum value of any path from this node to the leaf. 
This will tell you if this node is insufficient.
*/
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {

    }
}
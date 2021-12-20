public class 1530. Number of Good Leaf Nodes Pairs {
	
}
/* Given the root of a binary tree and an integer distance. 
A pair of two different leaf nodes of a binary tree 
is said to be good 
if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.

 

Example 1:


Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
Example 2:


Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
Example 3:

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].
Example 4:

Input: root = [100], distance = 1
Output: 0
Example 5:

Input: root = [1,1,1], distance = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 2^10].
Each node's value is between [1, 100].
1 <= distance <= 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
先根遍历（递归）
针对当前根节点，count=左子树的count+右子树的count+
由左子树中一个叶子结点&右子树中一个叶子结点组成的pair（good）的个数（记为cur_count）。
cur_count的计算方法：
在遍历完左子树之后，已经记录下了左子树中每个叶子节点的lv_count,
那么在遍历到右子树的每一个叶子节点时，可以计算针对这个节点的pair_count.


*/
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
    public int countPairs(TreeNode root, int distance) {

    }

    private int preorder(TreeNode root){

    }
}


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
    private int res = 0;
    public int countPairs(TreeNode root, int distance) {
        recur(root, distance);
        return res;
    }

    private List<Integer> recur(TreeNode root, int distance) {//抽象为每个子节点到自己的距离
        if(root == null) 
		return new ArrayList<>(); 
        List<Integer> list = new ArrayList<>();
        if(root.left == null && root.right == null) {//leaf
            list.add(1);
            return list;
        }

        List<Integer> left = recur(root.left, distance);
        for(int item : left) {
            if(++item > distance) continue;
            list.add(item);
        }

        List<Integer> right = recur(root.right, distance);
        for(int item : right) {
            if(++item > distance) continue;
            list.add(item);
            
        }

        for(int item1: left) {
            for(int item2: right) {
                res += (item1 + item2) <= distance ? 1 : 0;
            }
        }

        return list;
    }
}
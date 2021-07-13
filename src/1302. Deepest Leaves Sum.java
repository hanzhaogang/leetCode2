public class 1302. Deepest Leaves Sum {
	
}
/* Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/deepest-leaves-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
*/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
	    if(root==null)
	    	return 0;

	int res=root.val;
	Queue<TreeNode> q=new LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		int size=q.size();
		int lvSum=0;
		for(int i=0;i<size;i++){
			TreeNode polled=q.poll();
			lvSum+=polled.val;
			if(polled.left!=null)
				q.offer(polled.left);
			if(polled.right!=null)
				q.offer(polled.right);
		}
		res=lvSum;
	}

	return res;
    }
}

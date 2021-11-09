import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class 437. Path Sum III {
	
}
/*Given the root of a binary tree and an integer targetSum, 
return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, 
but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
树相关问题的解法，一般是有遍历、递归（遍历也是递归，这里的递归）

有道常见题是从根节点到叶子节点的path路径和，本题中是部分路径和，跟数组的presum有类似之处。


需要注意的是， preSum可能有重复的，所以用hashSet不行，需要用hashMap

需要注意的是，set.add()的返回值是boolean，而不是更新后的set。
还需要注意的是，new LinkedHashSet<Integer>(0)不是给set添加一个为0的元素，而是定义了set的初始容量

corner case: 
单个节点？

       1
    -2  -3
*/


class Solution {
    int count=0;
    int t;
    public int pathSum(TreeNode root, int targetSum) {
        t=targetSum;//-1
        Map<Integer,Integer> preSum2count=new HashMap<Integer,Integer>();
        preSum2count.put(0,1);
        helper(root,0,preSum2count);
        return count;
    }

    private void helper(TreeNode curNode,int preSum,Map<Integer,Integer> preSum2count){
        if(curNode==null)
            return;

        
        
        int curSum=preSum+curNode.val;//1 -1
        if(preSum2count.containsKey(curSum-t)){
            //?
            count+=preSum2count.get(curSum-t);
        }
        preSum2count.put(curSum,preSum2count.getOrDefault(curSum, 0)+1);
        if(curNode.left!=null){
            helper(curNode.left,curSum,preSum2count);
           
        }
        
        if(curNode.right!=null){
            helper(curNode.right,curSum,preSum2count);
            
        }
        
        if(preSum2count.get(curSum)==1){
            preSum2count.remove(curSum);//直接删除该对象
        }else{
            preSum2count.put(curSum,preSum2count.get(curSum)-1);
        }
    }
}

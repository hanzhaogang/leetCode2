import java.util.Arrays;

public class 307 {
	
}
class NumArray {
	TreeNode root;
    public NumArray(int[] nums) {
	root=buildTree(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
	update(root,index,val);
    }
    
    public int sumRange(int left, int right) {
        // preorder(root);
	return sumRange(root,left,right);
    }

    private TreeNode buildTree(int[] nums,int l,int h){
	if(h<l){
		return null;
	}
	if(h==l){
		return new TreeNode(nums[l],l,l);
	}
	int mid=l+(h-l)/2;
	TreeNode leftNode=buildTree(nums,l,mid);
	TreeNode rightNode=buildTree(nums,mid+1,h);
	TreeNode root=new TreeNode(leftNode.sum+rightNode.sum,l,h);
    root.left=leftNode;
    root.right=rightNode;//常常忘记这两句。。
	return root;
    }

    private void update(TreeNode root,int index,int val){
	    if(root==null || (root.range[0]==root.range[1])&&(root.range[0]!=index))
	    	return;
        if((root.range[0]==root.range[1])&& (root.range[0]==index)){
            root.sum=val;

            return;
        }
	    	
	    int mid=root.range[0]+(root.range[1]-root.range[0])/2;
	    if(index<=mid){
		    update(root.left,index,val);
	    }else{
		    update(root.right,index,val);
	    }
	    root.sum=(root.left==null?0:root.left.sum)+(root.right==null?0:root.right.sum);
        
    }

    private void preorder(TreeNode root){
        if(root==null)
            return;
        // System.out.println(root.sum);
        preorder(root.left);
        preorder(root.right);
    }
    private int sumRange(TreeNode root,int left,int right){
	if(right<left)
		return 0;
	int mid=root.range[0]+(root.range[1]-root.range[0])/2;
	if(root.range[0]==left && root.range[1]==right){
		return root.sum;
	}else if(mid<left){
		return sumRange(root.right,left,right);
	}else if(right<=mid){
		return sumRange(root.left,left,right);
	}else{
		return sumRange(root.left,left,mid)+sumRange(root.right,mid+1,right);
	}
    }
}

class TreeNode{
	int sum;
	int[] range=new int[2];
	TreeNode left;
	TreeNode right;

	public TreeNode(int sum,int l,int h){
		this.sum=sum;
		this.range[0]=l;
		this.range[1]=h;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right); 
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right); 
 */

/* Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right 
aabinclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.
*/

/* lowbit含义
先上一段代码,可以看到lowbit只有一行操作,而且是位运算,执行效率非常高


private int lowbit(int x) {
    return x & (-x);
}
实际上其主要功能是: 找到x的二进制数的最后一个1所表示的二进制
比如x=6=00000110_2,-x=x_补=11111010_2,lowbit(x)=10_2=2x=6=00000110 
2
​
 ,−x=x 
补
​
 =11111010 
2
​
 ,lowbit(x)=10 
2
​
 =2
换句话说,就是lowbit(x)的值必然是2的幂次(最高位为1,其他位为0)

lowbit(x) = 2^{(k)}
lowbit(x)=2 
(k)
 

我们列出一下的表格

x	1	2	3	4	5	6	7	8	9
lowbit(x)	1	2	1	4	1	2	1	8	1
注意: x不能等于0, 否则会进入死循环, 所以树状数组通常使用的下标会执行+1操作

作者：hu-ge-8
链接：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/-by-hu-ge-8-t4rn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

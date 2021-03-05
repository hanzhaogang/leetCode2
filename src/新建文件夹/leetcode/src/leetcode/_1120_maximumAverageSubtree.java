package leetcode;
/*
 * Given the root of a binary tree, 
 * find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. 
The average value of a tree is the sum of its values, 
divided by the number of nodes.)

 

Example 1:

Input: [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.

 

Note:

    The number of nodes in the tree is between 1 and 5000.
    Each node will have a value between 0 and 100000.
    Answers will be accepted as correct if they are 
    within 10^-5 of the correct answer.
 */
public class _1120_maximumAverageSubtree {
	public double maximumAverageSubtree(TreeNode root) {
		SumCountPair rootPair=postOrder(root);
		return rootPair.sum;
	}
	private SumCountPair postOrder(TreeNode root) {
		if(root==null)
			return new SumCountPair(0,0);
		
		SumCountPair leftPair=postOrder(root.left);
		SumCountPair rightPair=postOrder(root.right);
		
		int count=leftPair.count+rightPair.count+1;
		double sum=(leftPair.sum+rightPair.sum+root.val)/(double)count;
		SumCountPair curPair=new SumCountPair(sum,count);
		
		return curPair;
	}
}

class SumCountPair{
	double sum;
	int count;
	public SumCountPair(double sum,int count) {
		this.sum=sum;
		this.count=count;
	}
}
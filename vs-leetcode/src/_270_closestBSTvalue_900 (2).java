package leetcode;
/*
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.

Example1

Input: root = {5,4,9,2,#,8,10} and target = 6.124780
Output: 5
Explanation：
Binary tree {5,4,9,2,#,8,10},  denote the following structure:
        5
       / \
     4    9
    /    / \
   2    8  10

Example2

Input: root = {3,2,4,1} and target = 4.142857
Output: 4
Explanation：
Binary tree {3,2,4,1},  denote the following structure:
     3
    / \
  2    4
 /
1

Notice

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST 
    that is closest to the target.


 */
public class _270_closestBSTvalue_900 {
    int res;
    double diff=Double.MAX_VALUE;

	public int closestValue(TreeNode270 root, double target) {
    	bs(root,target);
    	return res;
    }
	
	private void bs(TreeNode270 root,double target){
		if(root==null)
			return;
		
		double curDiff=Math.abs(target-root.val);
		if(curDiff<diff) {
			res=root.val;
			diff=curDiff;
		}
		if(root.val<target) {
			bs(root.right,target);
		}else {
			bs(root.left,target);
		}
	}
}

class TreeNode270{
	public int val;
	TreeNode270 left;
	TreeNode270 right;
}

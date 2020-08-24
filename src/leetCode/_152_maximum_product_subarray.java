package leetCode;

public class _152_maximum_product_subarray {
/*
 * Given an integer array nums, 
 * find the contiguous subarray within an array 
 * (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
	public int maxProduct(int[] nums) {
/*
 * 2,3,-2,4,5,-1
 * 2,6,-12,-48,-240,240
 * 
 * O(n^3)->O(n^2)
 */
		int[] maxs=new int[nums.length];
		int[] mins=new int[nums.length];
		
		maxs[0]=nums[0];
		mins[0]=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<0) {
				maxs[i]=Math.max(nums[i]*mins[i-1],nums[i]);
				mins[i]=Math.min(nums[i], nums[i]*maxs[i-1]);
			}else {
				maxs[i]=Math.max(nums[i], nums[i]*maxs[i-1]);
				mins[i]=Math.min(nums[i], mins[i-1]*nums[i]);
			}
		}
		
		int res=Integer.MIN_VALUE;
		for(int i=0;i<maxs.length;i++) {
			if(res<maxs[i])
				res=maxs[i];
		}
		return res;
    }
}

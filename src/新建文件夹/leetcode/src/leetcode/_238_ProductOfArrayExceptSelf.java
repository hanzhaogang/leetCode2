package leetcode;
/*
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class _238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if(nums.length==2) {
			return new int[] {nums[1],nums[0]};
		}
		
		int[] leftPreSum=new int[nums.length];
		int[] rightPreSum=new int[nums.length];
		leftPreSum[0]=nums[0];
		rightPreSum[nums.length-1]=nums[nums.length-1];
		for(int i=1;i<nums.length;i++) {
			leftPreSum[i]=leftPreSum[i-1]*nums[i];
		}
		for(int i=nums.length-2;0<=i;i--) {
			rightPreSum[i]=rightPreSum[i+1]*nums[i];
		}
		
		int[] res=new int[nums.length];
		res[0]=rightPreSum[1];
		res[nums.length-1]=leftPreSum[nums.length-2];
		for(int i=1;i<res.length-1;i++) {
			res[i]=leftPreSum[i-1]*rightPreSum[i+1];
		}
		return res;
    }
}

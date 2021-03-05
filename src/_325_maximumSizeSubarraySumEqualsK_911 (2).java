package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array nums and a target value k, 
 * find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.

Example1

Input:  nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation:
because the subarray [1, -1, 5, -2] sums to 3 and is the longest.

Example2

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation:
because the subarray [-1, 2] sums to 1 and is the longest.

Challenge

Can you do it in O(n) time?

Notice

The sum of the entire nums array is guaranteed to 
fit within the 32-bit signed integer range.

 */
public class _325_maximumSizeSubarraySumEqualsK_911 {
	public int maxSubArrayLen(int[] nums, int k) {
		if(nums.length==0)
			return 0;
		
		Map<Integer,Integer> val2index=new HashMap<>();
		int[] preSums=new int[nums.length];
		preSums[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			preSums[i]=preSums[i-1]+nums[i];
		}
		if(preSums[nums.length-1]==k)
			return nums.length; 
		
		for(int i=0;i<preSums.length;i++) {
			if(!val2index.containsKey(preSums[i])) {
				val2index.put(preSums[i],i);
			}
		}
		val2index.put(0, -1);
		
		int maxLen=0;
		for(int i=0;i<preSums.length;i++) {
			int target=preSums[i]-k;
			if(val2index.containsKey(target)) {
				int lo=val2index.get(target);
				int curLen=i-lo;
				if(maxLen<curLen) {
					maxLen=curLen;
				}
			}
		}
		return maxLen;
    }
}

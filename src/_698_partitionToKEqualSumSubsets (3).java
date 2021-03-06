package leetCode;

import java.util.Arrays;

/*
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

[4 4 4 3 3 3 1 1 1] sum=8

Note:

    1 <= k <= len(nums) <= 16.
    0 < nums[i] < 10000.
 */
public class _698_partitionToKEqualSumSubsets {
	public static void main(String[] args) {
		_698_partitionToKEqualSumSubsets s=
				new _698_partitionToKEqualSumSubsets();
		int[] nums=new int[] {4,3,2,3,5,2,1};
		int k=4;
		System.out.println(s.canPartitionKSubsets(nums, k));
	}
    public boolean canPartitionKSubsets(int[] nums, int k) {
    	int total=0;
    	for(int i:nums) {
    		total+=i;
    	}
    	if(total%k!=0)
    		return false;
    	
    	int target=total/k;
    	int[] status=new int[k];//length k, not nums.length
    	Arrays.sort(nums);
    	return helper(nums,nums.length-1,status,k,target);
    }
    
    private boolean helper(int[] nums,int hi,int[] status,int k,int target) {//[4, 3, 2, 3, 5, 2, 1]
    	if(hi==-1) {
    		for(int curStat:status) {
    			if(curStat!=target)
    				return false;
    		}
    		return true;
    	}
    	
    	int num=nums[hi];
    	
    	for(int i=0;i<status.length;i++){
    		int curStat=status[i];
    		if(curStat+num<=target) {
    			status[i]=curStat+num;
    			boolean canDo=helper(nums,hi-1,status,k,target);
    			if(canDo)
    				return true;
    			status[i]-=num;
    		}
    	}
    	
    	return false;
    }
}
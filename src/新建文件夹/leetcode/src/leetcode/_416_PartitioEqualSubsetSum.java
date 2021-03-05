/*
 * Given a non-empty array nums containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100
    
    
    1. sort,presum [1,3,6,11]
    [1,5,5,11]->[1,6,11,22]
    [1,5,7,11]
 */
public class _416_PartitioEqualSubsetSum {
	int[][] memo;
    public boolean canPartition(int[] nums) {
    	int sum=0;
    	for(int num:nums) {
    		sum+=num;
    	}
    	memo=new int[nums.length+1][sum+1];
    	return helper(nums,0,0,0);
    }
    
    private boolean helper(int[] nums,int p,int sum1,int sum2){
    	if(p==nums.length) {
    		return sum1==sum2;
    	}
    	
    	int curNum=nums[p];
    	boolean can1=memo[p+1][sum1+curNum]==0?helper(nums,p+1,sum1+curNum,sum2):memo[p+1][sum1+curNum]==1;
    	boolean can2=memo[p+1][sum1]==0?helper(nums,p+1,sum1,sum2+curNum):memo[p+1][sum1]==1;
    	
    	memo[p][sum1]=(can1||can2)?1:-1;
    	return memo[p][sum1]==1?true:false;
    }
}

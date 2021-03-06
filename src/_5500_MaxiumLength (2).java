package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 

Given an array of integers nums, 
find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.

 

Example 1:

Input: nums = [1,-2,-3,4]
Output: 4
Explanation: The array nums already has a positive product of 24.

Example 2:

Input: nums = [0,1,-2,-3,-4]
Output: 3
Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.

Example 3:

Input: nums = [-1,-2,-3,0,1]
Output: 2
Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].

Example 4:

Input: nums = [-1,2]
Output: 1

Example 5:

Input: nums = [1,2,3,5,-6,4,0,10]
Output: 4

 

Constraints:

    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9


 */
public class _5500_MaxiumLength {
    public int getMaxLen_dp(int[] nums) {
    	
    	/*
    	 * [1, 2,3,5,-6,4,0,10] 
    	 * 1,0;2,
    	 */
    	int maxLen=0;
    	int[] dpPositive=new int[nums.length];//answer ending at i
    	int[] dpNegative=new int[nums.length];
    	dpPositive[0]=nums[0]<=0?0:1;
    	dpNegative[0]=nums[0]<0?1:0;
    	
    	for(int i=1;i<nums.length;i++) {
    		if(nums[i]==0) {
    			dpPositive[i]=0;
    			dpNegative[i]=0;
    		}else if(nums[i]<0){
    			if(nums[i-1]==0) {
    				dpPositive[i]=0;
        			dpNegative[i]=1;
    			}else {
    				dpPositive[i]=dpNegative[i-1]==0?0:1+dpNegative[i-1];
    				dpNegative[i]=1+dpPositive[i-1];
    			}
    		}else {
    			if(nums[i-1]==0) {
    				dpPositive[i]=1;
    				dpNegative[i]=0;
    			}else {
    				dpPositive[i]=1+dpPositive[i-1];
    				dpNegative[i]=dpNegative[i-1]==0?0:1+dpNegative[i-1];
    			}
    		}
    	}
    	
    	for(int i=0;i<dpPositive.length;i++) {
    		maxLen=maxLen<dpPositive[i]?dpPositive[i]:maxLen;
    	}
    	return maxLen;
    }
    
    
    public int getMaxLen_greedy(int[] nums) {
    	List<List<Integer>> subArrsDivBy0=new ArrayList<>();
    	List<Integer> zeroIndexs=new ArrayList<>();
    	zeroIndexs.add(-1);
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==0) {
    			zeroIndexs.add(i);
    		}
    	}
    	zeroIndexs.add(nums.length);
    	for(int i=0;i<zeroIndexs.size()-1;i++) {
    		int loZero=zeroIndexs.get(i);
    		int hiZero=zeroIndexs.get(i+1);
    		List<Integer> subArrs=new ArrayList<>();
    		for(int j=loZero+1;j<hiZero;j++) {
    			subArrs.add(nums[j]);
    		}
    		subArrsDivBy0.add(subArrs);
    	}
    	
    	
    }
}

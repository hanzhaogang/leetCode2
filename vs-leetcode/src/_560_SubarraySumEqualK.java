package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays 
 * whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

 

Constraints:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] 
    and the range of the integer k is [-1e7, 1e7].
    
    
    常规解法： 
    先计算preSums数组；
    
*/
public class _560_SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {//[0,0],k=0
    	
    	int[] inc_preSums=new int[nums.length];
    	for(int i=0;i<inc_preSums.length;i++) {
    		if(i==0) 
    			inc_preSums[i]=nums[i];
    		else {
    			inc_preSums[i]=inc_preSums[i-1]+nums[i];
    		}
    	}
    	
    	int subarrCount=0;
    	Map<Integer,Integer> seenPreSum2count=new HashMap<>();//
    	for(int i=0;i<inc_preSums.length;i++) {
    		
    		//更新计数
    		int curPreSum=inc_preSums[i];
    		if(curPreSum==k) {
    			subarrCount++;
    		}
    		
    		int target=curPreSum-k;
    		if(seenPreSum2count.containsKey(target)) {
    			subarrCount+=seenPreSum2count.get(target);
    		}
    		
    		
    		//更新preSum的个数
    		if(seenPreSum2count.containsKey(curPreSum)) {
    			seenPreSum2count.put(curPreSum,
    					seenPreSum2count.get(curPreSum)+1);
    		}else {
    			seenPreSum2count.put(curPreSum, 1);
    		}
    	}
    	
    	return subarrCount;
    }
    
    /*
     * 所有都是正数，要求constant space
     * 
     * 你可以试一下用two pointer方法：
     * index i and index j指向sub array起始位置，
     * 通过当前subarray sum与k比较来判断应该i++还是j++.
(都是正数的用途是subarray sum的增减趋势完全靠控制i, j来决定了。这个在一般array是不成立的)

 k=8
     */
    
    public static void main(String[] args) {
    	_560_SubarraySumEqualK s=new _560_SubarraySumEqualK();
    	int[] nums=new int[] {1, 1, 6, 1, 1};
    	int k=8;
    	System.out.println(s.subarraySum_all_positive(nums, k));
    	
    	int[] nums2=new int[] {1, 1, 1, 1, 1};
    	int k2=1;
    	System.out.println(s.subarraySum_all_positive(nums2, k2));
    	
    	int[] nums23=new int[] {1, 1, 1, 1, 1};
    	int k23=6;
    	System.out.println(s.subarraySum_all_positive(nums23, k23));
    	
    	int[] nums234=new int[] {9, 2, 2, 2, 2};
    	int k234=6;
    	System.out.println(s.subarraySum_all_positive(nums234, k234));
    }
    public int subarraySum_all_positive(int[] nums, int k) {
    	if(nums==null||nums.length==0)
    		return 0;
    	
    	for(int i=0;i<nums.length;i++) {
    		if(i!=0) {
    			nums[i]+=nums[i-1];
    		}
    	}
    	
    	int count=0;
    	int hi=0;
    	int lo=0;
    	while(hi<nums.length) {
    		if(nums[hi]<k) {
    			hi++;
    		}else if(k==nums[hi]) {
    			count++;
    			hi++;
    		}else {
    			if(nums[hi]-nums[lo]==k) {
        			count++;
        			hi++;
        			lo++;
        		}else if(nums[hi]-nums[lo]<k) {
        			hi++;
        		}else {
        			lo++;
        		}
    		}
    		
    	}
    	return count;
    }
    
    
    public int subarraySum_3(int[] nums, int k) {
        int curSum = 0;
        int res = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            curSum += nums[j];
            if (curSum < k)
                continue;
            while (curSum >= k) {
                if (curSum == k)
                    res++;
                curSum -= nums[i++];
            }
        }
        return res;
    }
}




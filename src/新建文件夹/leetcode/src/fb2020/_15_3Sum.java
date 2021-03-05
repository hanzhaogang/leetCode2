package fb2020;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

 

Constraints:

    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105
    
    
    1. sort the array.
    2. for each number n, use two pointers one lo, the other hi, to find numbers sum up to 0-(n)
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	
    	Set<List<Integer>> set=new HashSet<>();
    	for(int i=0;i<nums.length-2;i++) {
    		if(0<nums[i]) {
    			break;
    		}
    		
    		if(i!=0&&nums[i]==nums[i-1]) {//to fast the solution.
    			continue;
    		}
    		int lo=i+1;
    		int hi=nums.length-1;
    		while(lo<hi) {
    			if(nums[lo]+nums[hi]==0-nums[i]) {
    				List<Integer> list=Arrays.asList(nums[i],nums[lo++],nums[hi--]);
    				set.add(list);
    			}else if(nums[lo]+nums[hi]<0-nums[i]) {
    				lo++;
    			}else {
    				hi--;
    			}
    		}
    	}
   		
   		List<List<Integer>> res=new ArrayList<>(set);
   		return res;
    }
}

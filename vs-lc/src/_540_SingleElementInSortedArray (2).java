package leetcode;

public class _540_SingleElementInSortedArray {
	/*You are given a sorted array consisting of only integers 
	 * where every element appears exactly twice, 
	 * except for one element which appears exactly once. 
	 * Find this single element that appears only once.

	 

	Example 1:

	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2

	Example 2:

	Input: [3,3,7,10,10,11,11] len=6
	Output: 10
	*/
    public int singleNonDuplicate(int[] nums) {
    	if(nums.length==1)
    		return nums[0];
    	return bs(nums,0,nums.length-1);//8
    }
    private int bs(int[] nums,int lo,int hi) {//1,1,2
    	if(hi<lo) {
    		return -1;
    	}
    	
    	int mid=lo+(hi-lo)/2;//2
    	if(mid==0&&nums[mid]!=nums[mid+1]||
    			(mid==nums.length-1)&&nums[mid-1]!=nums[mid]||
    			nums[mid-1]!=nums[mid]&&nums[mid]!=nums[mid+1]
    			) {
    		return nums[mid];
    	}
    	
    	if(nums[mid]==nums[mid-1])
    		if(mid%2==0)
    			return bs(nums,lo,mid-2);
    		else
    			return bs(nums,mid+1,hi);
    	if(nums[mid]==nums[mid+1])
    		if(mid%2==0)
    			return bs(nums,mid+2,hi);
    		else
    			return bs(nums,lo,mid-1);
    }
}


class Solution {
    
    public int singleNonDuplicate(int[] nums) {
        if(nums==null||nums.length==1||nums.length==2)
            return Integer.MIN_VALUE;
        return bs(nums,0,nums.length-1);
    }
    
    public int bs(int[] nums,int lo,int hi){
        
        int mid=(lo+(hi-lo)/2)/2*2;
        if(nums.length-1<mid+1||nums[mid]!=nums[mid+1]){
            if(mid-1<0||nums[mid-1]!=nums[mid])
                return nums[mid];
            else{
                return bs(nums,lo,mid-2);
            }
        }else{
            return bs(nums,mid+2,hi);
        }
        
        
    }
}

package leetCode;
/*
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 
 * that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

 

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 

Constraints:

    The length of the array won't exceed 10,000.
    You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

 */
public class _523_ContinousSubarraySum {
	public static void main(String[] args) {
		_523_ContinousSubarraySum s=new _523_ContinousSubarraySum();
		int[] nums=new int[] {23,2,4,6,7};
		int k=6;

		System.out.println(s.checkSubarraySum(nums, k));
	}
    public boolean checkSubarraySum(int[] nums, int k) {
//    	if(k<0)
//    		return false;
    	
    	long[] preSums=new long[nums.length];
    	for(int i=0;i<preSums.length;i++) {
    		if(i==0) {
    			preSums[i]=nums[i];
    		}else {
    			preSums[i]=preSums[i-1]+nums[i];
    		}
    		
    	}
    	
    	for(int lo=0;lo<=preSums.length-2;lo++) {
    		for(int hi=lo+1;hi<preSums.length;hi++) {
    			long curSum=lo==0?preSums[hi]:preSums[hi]-preSums[lo-1];
    			if(k==0) {
    				if (curSum==0)
    						return true;
    			}else {
    				if(curSum%(long)k==0) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
}

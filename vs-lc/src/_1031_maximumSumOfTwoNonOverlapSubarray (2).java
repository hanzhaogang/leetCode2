package leetcode;
/*
 * Given an array A of non-negative integers, 
 * return the maximum sum of elements in two non-overlapping (contiguous) subarrays, 
 * which have lengths L and M.  
 * 
 * (For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

    0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
    0 <= j < j + M - 1 < i < i + L - 1 < A.length.

 

Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
           [0,6,11,13,15,20,21,30,34]
           [-1,6,11,7,4,7,6,10,13]
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.

Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
           [2,3,8,14,14,23,28,0,31,39]
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
 */
public class _1031_maximumSumOfTwoNonOverlapSubarray {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    	int[] preSum=new int[A.length];
    	preSum[0]=A[0];
    	for(int i=1;i<A.length;i++) {
    		preSum[i]=preSum[i-1]+A[i];
    	}
    	
    	int maxSum=0;
    	
    	for(int lo_l=0;lo_l<=A.length-L;lo_l++) {
    		int sum_l=preSum[lo_l+(L-1)]-(lo_l==0?0:preSum[lo_l-1]);
    		if(M<=lo_l) {
    			for(int lo_m=0;lo_m<=lo_l-M;lo_m++) {
    				int sum_m=preSum[lo_m+(M-1)]-(lo_m==0?0:preSum[lo_m-1]);
    				int sum=sum_l+sum_m;
    				if(maxSum<sum)
    					maxSum=sum;
    			}
    		}
    		if(lo_l+(L-1)<=A.length-1-M) {
    			for(int lo_m=lo_l+(L-1)+1;lo_m<=A.length-M;lo_m++) {
    				int sum_m=preSum[lo_m+(M-1)]-(lo_m==0?0:preSum[lo_m-1]);
    				int sum=sum_l+sum_m;
    				if(maxSum<sum)
    					maxSum=sum;
    			}
    		}
    	}
    	return maxSum;
    }
}

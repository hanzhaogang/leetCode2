package leetcode;

import java.util.Arrays;

/*
 * In a given array nums of positive integers, 
 * find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, 
and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices 
representing the starting position of each interval (0-indexed). 
If there are multiple answers, return the lexicographically smallest one.

Example:

Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: 
Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], 
but an answer of [1, 3, 5] would be lexicographically larger.

 

Note:

    nums.length will be between 1 and 20000.
    nums[i] will be between 1 and 65535.
    k will be between 1 and floor(nums.length / 3).
 */
public class _689_MaximumSumOf3Non_overloppingSubarrays {
	public static void main(String[] args) {
		_689_MaximumSumOf3Non_overloppingSubarrays s=new _689_MaximumSumOf3Non_overloppingSubarrays();
//		int[] nums=new int[] {1,2,1,2,6,7,5,1};
//		int k=2;
		int[] nums=new int[] {1,2,1,2,1,2,1,2,1};
		int k=2;
		int[] res=s.maxSumOfThreeSubarrays(nums, k);
		for(int i:res)
			System.out.println(i);
	}
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    	int n=nums.length;//[1,2,1,2,6,7,5,1], 2;n=8
    	int[] kSum=new int[n-k+1];
    	for(int i=0;i<k;i++) {
    		kSum[0]+=nums[i];
    	}
    	for(int i=1;i<=n-k;i++) {
    		kSum[i]=kSum[i-1]-nums[i-1]+nums[i+k-1];
    	}//[3,3,3,8,13,12,6]
    	
    	int[][] maxSumLeft=new int[n][2];
    	for(int i=0;i<=n-3*k;i++) {
    		if(i==0) {
    			maxSumLeft[i]=new int[] {kSum[i],i};
    		}else if(kSum[i]<=maxSumLeft[i-1][0]) {
    			maxSumLeft[i]=Arrays.copyOf(maxSumLeft[i-1],2);
    		}else {
    			maxSumLeft[i]=new int[] {kSum[i],i};
    		}
    	}//[3,0; 3,1; 3,2; 8,3; 13,4; 13,4; 13,4]
    	int[][] maxSumRight=new int[n][2];
    	for(int i=n-k;2*k<=i;i--) {
    		if(i==n-k) {
    			maxSumRight[i]=new int[] {kSum[i],i};
    		}else if(kSum[i]<maxSumRight[i+1][0]) {
    			maxSumRight[i]=Arrays.copyOf(maxSumRight[i+1],2);
    		}else {
    			maxSumRight[i]=new int[] {kSum[i],i};
    		}
    	}//[]
    	
    	int maxSum=0;
    	int[] res=new int[] {n,n,n};
    	for(int midLo=k;midLo<=n-2*k;midLo++) {
    		int midSum=kSum[midLo];
    		int[] maxLSum=maxSumLeft[midLo-k];
    		int[] maxRSum=maxSumRight[midLo+k];
    		
    		int sum=midSum+maxLSum[0]+maxRSum[0];
    		if(maxSum<sum) {
    			maxSum=sum;
    			res=new int[] {maxLSum[1],midLo,maxRSum[1]};
    		}else if(maxSum==sum) {
    			String resStr=""+res[0]+res[1]+res[2];
    			String curStr=""+maxLSum[1]+midLo+maxRSum[1];
    			if(!(resStr.compareTo(curStr)<0)) {
    				res=new int[] {maxLSum[1],midLo,maxRSum[1]};
    			}
    		}
    	}
    	
    	return res;
    }
}

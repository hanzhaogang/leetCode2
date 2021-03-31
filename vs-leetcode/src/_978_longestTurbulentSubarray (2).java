package leetcode;
/*
 * 978. Longest Turbulent Subarray

A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent 
if and only if:

    For i <= k < j, A[k] > A[k+1] when k is odd, 
    and A[k] < A[k+1] when k is even;
    OR, for i <= k < j, A[k] > A[k+1] when k is even, 
    and A[k] < A[k+1] when k is odd.

That is, the subarray is turbulent 
if the comparison sign flips between each adjacent pair of elements 
in the subarray.

Return the length of a maximum size turbulent subarray of A.

 

Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

Example 2:

Input: [4,8,12,16]
Output: 2

Example 3:

Input: [100]
Output: 1

 

Note:

    1 <= A.length <= 40000
    0 <= A[i] <= 10^9
 */
public class _978_longestTurbulentSubarray {
	public static void main(String[] args) {
		int[] A=new int[] {9,4,2,10,7,8,8,1,9};
		_978_longestTurbulentSubarray s=new _978_longestTurbulentSubarray();
		System.out.println(s.maxTurbulenceSize(A));
	}
	public int maxTurbulenceSize(int[] A) {
		int[] dp=new int[A.length];//dp[i] is the longest subarray ending at i.
		
		for(int i=0;i<dp.length;i++) {
			if(i==0) {
				dp[i]=1;
			}else if(i==1) {
				if(A[i-1]==A[i])
					dp[i]=1;
				else
					dp[i]=2;
			}else {
				if(A[i-2]<A[i-1]&&A[i-1]>A[i]||
						A[i-2]>A[i-1]&&A[i-1]<A[i]) {
					dp[i]=dp[i-1]+1;
				}else if(A[i-1]==A[i]) 
					dp[i]=1;
				else
					dp[i]=2;
			}
		}
		
		
		int res=0;
		for(int i:dp) {
			if(res<i)
				res=i;
		}
		return res;
    }
}

package leetCode;
/*
 * Given an integer array arr, 
 * in one move you can select a palindromic subarray 
 * arr[i], arr[i+1], ..., arr[j] where i <= j, 
 * and remove that subarray from the given array. 
 * Note that after removing a subarray, 
 * the elements on the left and on the right of that subarray 
 * move to fill the gap left by the removal.

Return the minimum number of moves needed 
to remove all numbers from the array.

 

Example 1:

    Input: arr = [1,2]
    Output: 2

Example 2:

    Input: arr = [1,3,4,1,5]
    Output: 3
    Explanation: Remove [4] then remove [1,3,1] then remove [5].

 

Constraints:

    1 <= arr.length <= 100
    1 <= arr[i] <= 20
 */
public class _1246_PalindromeRemoval_lock_null {
    public int minimumMoves(int[] arr) {
    	
    }
}

class Solution {
    public int minimumMoves(int[] A) {
        int n=A.length;
        int[][] dp=new int[n][n];
        for(int k=0;k<n;k++){
            for(int i=0;i+k<n;i++){
                int j=i+k;
                dp[i][j]=999999999;
                if(A[i]==A[j]){
                    dp[i][j]=j-i<=1?1:dp[i+1][j-1];//最外层匹配,区间不分割。
                }
                for(int p=i;p<j;p++){
                   dp[i][j]=Math.min(dp[i][p]+dp[p+1][j],dp[i][j]);//区间分割
                }
            }
        }
        return dp[0][n-1];
    }
}

package leetcode;
/*
 * You are given coins of different denominations and 
 * a total amount of money amount. 
 * 
 * Write a function to compute the fewest number of coins 
 * that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, 
 * return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class _322_coinChange {
	
	public int coinChange(int[] coins, int amount) {
		int[] dp=new int[amount+1];
		dp[0]=0;
		for(int i=1;i<dp.length;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int coin:coins) {
				if(0<=i-coin&&dp[i-coin]!=Integer.MAX_VALUE) {
					int cur=1+dp[i-coin];
					if(cur<dp[i])
						dp[i]=cur;
				}
			}
		}
		return dp[dp.length-1]==Integer.MAX_VALUE?-1:dp[dp.length-1];
	}	
}

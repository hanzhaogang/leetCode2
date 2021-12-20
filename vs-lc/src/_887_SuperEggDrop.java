package leetCode;
/*
 * You are given K eggs, and you have access to a building with N floors from 1 to N. 

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N 
such that any egg dropped at a floor higher than F will break, 
and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) 
and drop it from any floor X (with 1 <= X <= N). 

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, 
regardless of the initial value of F?

 

Example 1:

Input: K = 1, N = 2
Output: 2
Explanation: 
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.

Example 2:

Input: K = 2, N = 6
Output: 3

Example 3:

Input: K = 3, N = 14
Output: 4

 

Note:

    1 <= K <= 100
    1 <= N <= 10000
 */
public class _887_SuperEggDrop {
	/*
	 * dp(K,N)=
	 */
    public int superEggDrop(int K, int N) {
    	int[][] dp=new int[K+1][N+1];
    	for(int i=0;i<=N;i++) {
    		dp[0][i]=0;
    	}
    	for(int i=0;i<=K;i++) {
    		dp[i][0]=0;
    	}
    	for(int i=1;i<=N;i++) {
    		dp[1][i]=i;
    	}
    	
    	for(int i=1;i<=K;i++) {
    		dp[i][1]=1;
    	}
    	
    	
    	for(int i=2;i<=K;i++) {
    		for(int j=2;j<=N;j++) {
//    			int res=Integer.MAX_VALUE;
//    			for(int l=1;l<=j;l++) {
//    				int curCount=Math.max(dp[i-1][l-1],dp[i][j-l])+1;
//    				if(curCount<res) {
//    					res=curCount;
//    				}
//    			}
    			
    			int lo=1;
    			int hi=j;
    			while(lo+1<hi) {
    				int mid=lo+(hi-lo)/2;
    				
    				if(dp[i-1][mid-1]<dp[i][j-mid]) {
    					lo=mid;
    				} else if(dp[i][j-mid]<dp[i-1][mid-1]) {
    					hi=mid;
    				}else {
    					hi=mid;
    					lo=mid;
    				}
    			}
    			
    			dp[i][j]=Math.min(Math.max(dp[i-1][lo-1],dp[i][j-lo]), 
    					Math.max(dp[i-1][hi-1],dp[i][j-hi]))+1;
    		}
    	}
    	
    	return dp[K][N];
    }
    
    public int dp(int K,int N) {
    	if(K==1) {
    		
    	}
    	
    	int res=Integer.MAX_VALUE;
    	for(int i=1;i<=N;i++) {
    		int curCount=Math.max(dp(K-1,i-1),dp(K,N-i))+1;
    		if(curCount<res)
    			res=curCount;
    	}
    	
    	return res;
    }
}

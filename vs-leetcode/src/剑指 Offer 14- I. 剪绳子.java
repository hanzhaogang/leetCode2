public class 剑指 Offer 14- I. 剪绳子 {
	
}
/* 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
先考虑第一段绳子的长度，可能为：1,2，。。。n
把长度为n的绳子分为m段的最大乘积f(n,m)=max（1*f(n-1,m-1),2*f(n-2,m-1),...(n-1)*f(1,m-1)）
(不能分成1段)

以上就是dp的状态转移方程。
因为方程中有两个变量，所以构造二维矩阵

（绳子长度）    0 1 2 。。m（分成的段数）  
            0  1 1 1.... 1           
            1  1 1 ?
            2  1 ? ?
            3  1
            。 1
            。 1
            n  1

时间复杂度O(n*n*n)	    */

class Solution {
    public int cuttingRope(int n) {//2
	int[][] dp=new int[n+1][n+1];
	for(int j=0;j<=n;j++){
		for(int i=0;i<=n;i++){
			if(j==0){
				dp[i][j]=1;
			}else if(i==0){
				dp[i][j]=1;
			}else{
				int max=1;
				for(int k=1;k<i;k++){
					int cur=(n-k)*dp[k][j-1];
					if(max<cur){
						max=cur;
					}
				}
				dp[i][j]=max;
			}
		}
	}

	return dp[n][n];
    }
    private int dp(int n,int m){

    }
}

class Solution {
    public int cuttingRope(int n) {//2
	int[][] dp=new int[n][n];
	for(int j=0;j<n;j++){
		for(int i=j;i<n;i++){
			if(j==0){
				dp[i][j]=i+1;
			}else {
				int max=1;
				for(int k=1;k<i;k++){
					int cur=k*dp[i-k][j-1];
					if(max<cur){
						max=cur;
					}
				}
				dp[i][j]=max;
			}
		}
	}
	int res=0;
	for(int j=1;j<n;j++){
		if(res<dp[n-1][j]){
			res=dp[n-1][j];
		}
	}
	return res;
    }
}
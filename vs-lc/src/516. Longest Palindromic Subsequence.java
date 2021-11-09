public class 516. Longest Palindromic Subsequence {
	
}
/* Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that 
can be derived from another sequence by deleting some or no elements 
without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
if 首字母末字母相等，
  f(a,b)=2+f(a+1,b-1);
else
  f(a,b)=max(f(a,b-1),f(a+1,b))

区间dp，二维dp数组，常量时间得到当前dp数组值。
  */
class Solution {
    public int longestPalindromeSubseq(String s) {
	int n=s.length();
	int[][] dp=new int[n][n];
	for(int i=n-1;0<=i;i--){
		for(int j=i;j<n;j++){
			if(i==j){
				dp[i][j]=1;
			} else if(s.charAt(i)==s.charAt(j)){
				dp[i][j]=2+dp[i+1][j-1];
			}else{
				dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
			}
		}
	}
	return dp[0][n-1];
    }
}
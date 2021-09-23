public class 673. Number of Longest Increasing Subsequence {
	
}
/* Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, 
and there are 5 subsequences' length is 1, so output 5.

 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
2000数量级，复杂度应该为平方级。
一维DP数组，存储以当前num结尾的LIS的长度。

这道题一开始提交出错了。原因是更新cur数组第cur[1]的时候，
不能直接置为1、或者+1，而是根据之前dp[j][1]的值更新。*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
	int[][] dp=new int[nums.length][2];
	for(int i=0;i<dp.length;i++){
		if(i==0){
			dp[i]=new int[]{1,1};
		}else{
			int[] cur=new int[]{1,1};
			for(int j=0;j<i;j++){
				if(nums[j]<nums[i]){
					if(cur[0]<dp[j][0]+1){
						cur=new int[]{dp[j][0]+1,dp[j][1]};//!
					}else if(cur[0]==dp[j][0]+1){
						cur[1]+=dp[j][1];//!
					}
				}
			}
			dp[i]=cur;
		}
	}
	int maxLen=1;
	for(int[] i:dp){
		if(maxLen<i[0])
			maxLen=i[0];
	}
	int res=0;
	for(int[] i:dp){
		if(maxLen==i[0])
			res+=i[1];
	}
	return res;
    }
}

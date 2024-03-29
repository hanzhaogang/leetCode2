import java.util.HashMap;
import java.util.Map;

public class 1218. Longest Arithmetic Subsequence of Given Difference {
	
}
/* Given an integer array arr and an integer difference, 
return the length of the longest subsequence in arr 
which is an arithmetic sequence 
such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr 
by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: [2,4,5,5,6,7,8,9,10,11] The longest arithmetic subsequence is [7,5,3,1].
 

Constraints:

1 <= arr.length <= 105
-104 <= arr[i], difference <= 104


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
subsequence问题，一般是DP。
dp[i]代表以arr[i]结尾的、最长subsequence的长度
dp[i]=Math.max(dp[0],dp[1],...dp[i-1])
最后，遍历一遍dp数组，取最大值就是res。
--
可是，看了下数据规模，发现可能会超时。
分析发现，在计算dp[i]的时候，不需要遍历之前的所有元素。
只需要二分查找dp[i]-differernce，找到的话，dp[i]=该元素dp值+1；找不到，dp[i]=1;

--
[3,0,-3,4,-4,7,6]
3
[-4,-3,0,3,4,6,7]
-- subsequence 问题为什么要排序！
-- 查找
不排序，如何找到t=当前元素arr[i]-difference所在的位置、对应的最长subsequence长度？
原来的想法是用hashmap，这样查找时间复杂度为常量，比二分查找还快。
但是t可能不止一个，继而想到可以在hashmap里面存储<t,MaxHeap<最长subsequence长度>>。
看了答案才知道有更优解法： 并不需要存储t对应的所有的最长subsequence的长度，只需要记录其中最长的就行了。
所以，最终还是需要一个hashmap，存储<t,最长的最长subsequence长度。
好像dp数组也不必要，因为在计算dp[i]的时候，只需要dp[t=arr[i]-difference],不需要其他dp值。
*/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
	int n=arr.length;
	Map<Integer,Integer> map=new HashMap<>();//arr中的数值、数值对应的最长的最长subsequence长度
	int res=1;
	for(int i=0;i<n;i++){//[3,0,-3,4,-4,7,6],3//arr = [1,5,7,8,5,3,4,2,1], difference = -2
		int max_len;
		if(i==0){
			max_len=1;
		}else{
			int t=arr[i]-difference;
			if(map.containsKey(t)){
				max_len=map.get(t)+1;
			}else{
				max_len=1;
			}
		} 
		map.put(arr[i],max_len);
		if(res<max_len){
			res=max_len;
		}
	}
	return res;
    }
}

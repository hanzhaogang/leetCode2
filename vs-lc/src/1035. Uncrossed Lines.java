/* We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

nums1[i] == nums2[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, 
because the line from nums1[1]=4 to nums2[2]=4 will intersect the line from nums1[2]=2 to nums2[1]=2.
Example 2:

Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
Output: 2
 

Note:

1 <= nums1.length <= 500
1 <= nums2.length <= 500
1 <= nums1[i], nums2[i] <= 2000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/uncrossed-lines
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
首先根据题意看不出思路，那么可以根据数据规模推算一下。
n^3的算法可以通过。

第一个元素，可能的匹配有n种可能。
第二个，n种可能
。。。

n^3感觉更像是动态规划的时间复杂度。。


Think dynamic programming. 
Given an oracle dp(i,j) that 
tells us how many lines A[i:], B[j:] [the sequence A[i], A[i+1], ... and B[j], B[j+1], ...] are uncrossed, 
can we write this as a recursion?


dp(i,j)
在最终的最优解总，对于A[i],有两种可能性：
A[i]贡献了一条线，或者没有贡献。
在这两种可能性中取max即可。
如果贡献了：
从B[i]开始往后遍历，找到第一个与A[i]相等的(假设index为k)。（不用再往后找了。） dp[i,j]=1+dp[i+1,k+1]。
如果没有贡献：
dp[i,j]=dp[i+1,j];


---------问题抽象
lcs最长公共子序列问题？
*/


class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

    }
}
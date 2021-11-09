public class 209 {
	
}

/*Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
首先计算preSum数组。O(n)时间复杂度

遍历preSum数组，
针对当前preSum，它之前的preSum数组是递增的（因为nums[i]为正整数），所以可以用二分查找法找到满足要求的、最小长度的subarray。
针对每个preSum，都可以找到一个针对它的解。
遍历过程中不断更新全局最优解，遍历完成后就可以得到最终答案。


---如果是O(n)的话，直觉上是用DP或者双指针。

滑动窗口是双指针的一种特殊形式。
初始状态下l、r都指向index为0的元素。
向右滑动r指针，直到subarray的sum大于或等于target。这个过程中舍弃的可能解都不满足要求。
此时向右滑动l指针，

*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

    }
}
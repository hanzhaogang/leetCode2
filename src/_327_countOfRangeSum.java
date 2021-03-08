/*Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n^2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 

Constraints:

0 <= nums.length <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-of-range-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：

理解题目： 因为range 的选择有n^2种，所以暴力解法的复杂度为n^2.

根据数据规模，需要至少nlogn的解法。

range sum的题目可以考虑利用preSum数组。
preSum=[-2,3,2], 但是这不能减少range的选择呀！ 


*/

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

    }
}
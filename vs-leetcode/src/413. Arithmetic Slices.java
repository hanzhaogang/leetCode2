public class 413. Arithmetic Slices {
	
}
/* An integer array is called arithmetic 
if it consists of at least three elements and 
if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-slices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路：
首先看数据规模：5000, 判断复杂度为n^2.
而如果采用暴力法，复杂度为立方级别。
如何减少复杂度？ 注意到只是求解的个数，而不是找出每一个解，直觉可以用DP来做。
这一直觉可以由复杂度、subarray、数组等这些特点印证。
但是，还需要逻辑上证明DP的正确性：
首先考虑状态转移方程：
num(hi)=num(hi-1)+helper（hi）以array[hi]作为array最后一个元素的、满足要求的array个数 (hi是闭区间的高位)

而helper（hi）的计算：
找到以array[hi]结尾的、相差一样的元素的个数，根据个数判断helper（hi）的值：
3-》1；
4-》2；
5-》3；
6-》4；
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
	int[] dp=new int[nums.length];//0000  [1,2,3,4]
	for(int i=2;i<nums.length;i++){//3
		int diff=nums[i]-nums[i-1];//1
		int count=2;
		for(int j=i-2;0<=j;j--){//0;1,0
			if(nums[j+1]-nums[j]==diff){
				count++;//3;4
			}else{
				break;
			}
		}
		dp[i]=count-2+dp[i-1];//1;2+dp[2]
	}

	return dp[nums.length-1];
    }
}

public class 1846. Maximum Element After Decreasing and Rearranging {
	
}
/* You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:

The value of the first element in arr must be 1.
The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
There are 2 types of operations that you can perform any number of times:

Decrease the value of any element of arr to a smaller positive integer.
Rearrange the elements of arr to be in any order.
Return the maximum possible value of an element in arr 
after performing the operations to satisfy the conditions.

 

Example 1:

Input: arr = [2,2,1,2,1]
Output: 2
Explanation: 
We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
The largest element in arr is 2.
Example 2:

Input: arr = [100,1,1000]
Output: 3
Explanation: 
One possible way to satisfy the conditions is by doing the following:
1. Rearrange arr so it becomes [1,100,1000].
2. Decrease the value of the second element to 2.
3. Decrease the value of the third element to 3.
Now arr = [1,2,3], which satisfies the conditions.
The largest element in arr is 3.
Example 3:

Input: arr = [1,2,3,4,5]
Output: 5
Explanation: The array already satisfies the conditions, and the largest element is 5.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

Sort the Array.
Decrement each element to the largest integer that satisfies the conditions.

思路：
假设arr的长度为n，
假如arr中的最大值小于n，那么res就是该最大值(???)；
[1,2,5,2222222]
1,2,2,2,2,2,2,2,2,5

如果arr中的最大值大于等于n，那么res就是n。*/
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
	int len=arr.length;
	int max=arr[0];
	for(int i:arr){
		if(max<i)
			max=i;
	}

	return len<=max?len:max;
    }
}
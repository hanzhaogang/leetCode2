public class 1646. Get Maximum in Generated Array {
	
}
/* 思路：
根据数据规模，n^3的复杂度可以通过。（100以内数据规模，应该是保证int数据类型不会溢出）
看题意，有明显的dp递推关系，可以先O(n)填表算出每一个元素，然后再遍历一遍取最大值。
*/
class Solution {
    public int getMaximumGenerated(int n) {
	int[] arr=new int[n+1];
	for(int i=0;i<=n;i++){
		if(i==0){
			arr[i]=0;
		}else if(i==1){
			arr[i]=1;
		}else if(i%2==0){
			arr[i]=arr[i/2];
		}else if(i%2!=0){
			arr[i]=arr[i/2]+arr[i/2+1];
		}
	}
	int res=0;
	for(int i=0;i<=n;i++){
		if(res<arr[i]){
			res=arr[i];
		}
	}
	return res;
    }
}

/* You are given an integer n. An array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​.

 

Example 1:

Input: n = 7
Output: 3
Explanation: According to the given rules:
  nums[0] = 0
  nums[1] = 1
  nums[(1 * 2) = 2] = nums[1] = 1
  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
  nums[(2 * 2) = 4] = nums[2] = 1
  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
  nums[(3 * 2) = 6] = nums[3] = 2
  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
Example 2:

Input: n = 2
Output: 1
Explanation: According to the given rules, 
the maximum between nums[0], nums[1], and nums[2] is 1.
Example 3:

Input: n = 3
Output: 2
Explanation: According to the given rules, 
the maximum between nums[0], nums[1], nums[2], and nums[3] is 2.
 

Constraints:

0 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */

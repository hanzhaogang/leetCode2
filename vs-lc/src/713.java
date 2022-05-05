public class 713 {
	
}

class Solution {// 10,5 2,6; 100
    public int numSubarrayProductLessThanK(int[] nums, int k) {
	int res=0;
	int lo=0;
	int hi=0;
	int p=nums[0];
	int n=nums.length;
	while(lo<n){
		if(p<k){
			if(hi<n-1){
				hi++;
				p*=nums[hi];
			} else{
				res+=hi-lo+1;
				p/=nums[lo];
				lo++;
			}

		}else{
			res+=hi-lo;
			p/=nums[lo];
			lo++;
		}
	}
	return res;
    }
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
	int res=0,lo=0,hi=0,p=1;
	while(hi<nums.length){
		p*=nums[hi];
		if(p<k){
			hi++;
		}else{
			
		}
	}
    }
}

/* Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */
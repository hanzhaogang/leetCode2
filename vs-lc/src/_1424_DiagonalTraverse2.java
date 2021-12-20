package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

 

Example 1:

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]

Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]

 

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i].length <= 10^5
    1 <= nums[i][j] <= 10^9
    There at most 10^5 elements in nums.

 */
public class _1424_DiagonalTraverse2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    	
		int numCount=0;
		for(List<Integer> list:nums) {
			for(Integer i:list) {
				numCount++;
			}
		}
		int[] res=new int[numCount];
		
		
		int[][] indexs=new int[numCount][2];
		int globalIndex=0;
		for(int i=0;i<nums.size();i++) {
			List<Integer> curList=nums.get(i);
			for(int j=0;j<curList.size();j++) {
				indexs[globalIndex++]=new int[] {i,j};
			}
		}
		Arrays.sort(indexs,(i1,i2)->{
			int sum1=i1[0]+i1[1];
			int sum2=i2[0]+i2[1];
			if(sum1!=sum2) {
				return Integer.compare(sum1, sum2);
			}else {
				return Integer.compare(i2[0], i1[0]);
			}
			
		});
		
		globalIndex=0;
		for(int[] index:indexs) {
			res[globalIndex++]=nums.get(index[0]).get(index[1]);
		}
		return res;
    }
}

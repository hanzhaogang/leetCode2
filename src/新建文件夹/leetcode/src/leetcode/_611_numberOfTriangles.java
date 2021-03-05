package leetcode;

import java.util.Arrays;

/*
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Note:

    The length of the given array won't exceed 1000.
    The integers in the given array are in the range of [0, 1000].
 */
public class _611_numberOfTriangles {
	public static void main(String[] args) {
		int[] nums=new int[] {48,66,61,46,94,75};
		_611_numberOfTriangles s=new _611_numberOfTriangles();
		System.out.println(s.triangleNumber(nums));
	}
	
    public int triangleNumber(int[] nums) {
    	if(nums==null||nums.length<=2)
    		return 0;
    	// 2,2,3,4
    	
    	Arrays.sort(nums);
    	int res=0;
    	int n=nums.length;//4
    	for(int i=0;i<n-2;i++) {//0,1
    		if(nums[i]==0)
    			continue;
    		int j=i+1;//1,2
    		int k=i+2;//2,3
    		while(j<n-1) {
    			while(k<n&&nums[k]<nums[i]+nums[j]) {
    				k++;
    			}
    			res+=k-(j+1);
    			j++;
    		}
    	}
    	
    	return res;
    }
}

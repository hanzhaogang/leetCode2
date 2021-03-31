package leetcode;
/*Given an array nums of n integers, 
 * are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
	public static void main(String[] args) {
		_15_3Sum s=new _15_3Sum();
		int[] a=new int[] {-1, 0, 1, 2, -1, -4};
		System.out.println(s.threeSum(a));
	}
	public List<List<Integer>> threeSum(int[] a){
		List<List<Integer>> res=new ArrayList<>();
		if(a.length<3)
			return res;
		
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			int x=a[i];
			if(0<x||0<i&&x==a[i-1])
				continue;
			
			int lo=i+1;
			int hi=a.length-1;
			while(lo<hi) {
				if(a[lo]+a[hi]+x==0) {
					res.add(Arrays.asList(a[i],a[lo],a[hi]));
					while(lo<hi-1&&a[hi-1]==a[hi]) {
						hi--;
					}
					hi--;
					while(lo+1<hi&&a[lo]==a[lo+1]) {
						lo++;
					}
					lo++;
				}else if(a[lo]+a[hi]+x<0) {
					lo++;
				}else {
					hi--;
				}
			}
		}
		
		return res;
	}
}
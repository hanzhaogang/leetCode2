package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class _78_subset {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res=new ArrayList<>();
    	backTrack(res,new ArrayList<Integer>(),nums,0,nums.length-1);
    	return res;
    }
    
    private void backTrack(List<List<Integer>> res,List<Integer> tempList,int[] nums,int lo,int hi) {
    	if(hi<lo) {
    		res.add(new ArrayList<Integer>(tempList));
    		//tempList.clear();
    		return;
    	}
    	
    	tempList.add(nums[lo]);
    	backTrack(res,tempList,nums,lo+1,hi);
    	tempList.remove(tempList.size()-1);
    	backTrack(res,tempList,nums,lo+1,hi);
    }
}

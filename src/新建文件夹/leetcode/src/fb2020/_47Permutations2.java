package fb2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class _47Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Set<List<Integer>> resSet=new HashSet<>();
    	boolean[] visited=new boolean[nums.length];
    	backtrack(resSet,new ArrayList<Integer>(),nums,visited);
    	return new ArrayList<List<Integer>>(resSet);
    }
    
    private void backtrack(Set<List<Integer>> resSet,List<Integer> tempList,int[] nums,boolean[] visited) {
    	if(tempList.size()==nums.length) {
    		List<Integer> list=new ArrayList<>(tempList);
    		resSet.add(list);
    	}
    	
    	for(int i=0;i<nums.length;i++) {
    		if(!visited[i]) {
    			tempList.add(nums[i]);
    			visited[i]=true;
    			backtrack(resSet,tempList,nums,visited);
    			tempList.remove(tempList.size()-1);
    			visited[i]=false;
    		}
    	}
    }
}

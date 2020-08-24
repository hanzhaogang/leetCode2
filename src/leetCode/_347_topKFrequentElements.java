package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_topKFrequentElements {

	/*
	 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
	 */
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> numCnts=new HashMap<>();
		for(int num:nums) {
			if(numCnts.containsKey(num)) {
				numCnts.put(num, numCnts.get(num)+1);
			}else {
				numCnts.put(num, 1);
			}
		}
		
		PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((Map.Entry<Integer, Integer> e1,Map.Entry<Integer, Integer> e2)-> {
			return e1.getValue()-e2.getValue();
		});
		
		List<Integer> res=new ArrayList<>();
		for(Map.Entry<Integer,Integer> e:numCnts.entrySet()) {
			if(pq.size()<k) {
				pq.offer(e);
			}else if(pq.size()==k){
				pq.offer(e);
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			res.add(0,pq.poll().getKey());//the largest one is in the bottom.
		}
		return res;
    }
}

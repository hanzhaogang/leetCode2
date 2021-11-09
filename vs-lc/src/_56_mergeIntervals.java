package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: 
Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: 
Intervals [1,4] and [4,5] are considered overlapping.

NOTE: 
input types have been changed on April 15, 2019. 
Please reset to default code definition to get new method signature.

 

Constraints:

    intervals[i][0] <= intervals[i][1]

 */
public class _56_mergeIntervals {
    public int[][] merge(int[][] intervals) {
    	if(intervals==null)
    		return null;
    	if(intervals.length==0||intervals[0].length==0)
    		return intervals;
    	
    	
    	Arrays.sort(intervals,(i1,i2)->{
    		return Integer.compare(i1[0], i2[0]);
    	});
    	
    	List<int[]> mergedList=new ArrayList<>();
    	mergedList.add(intervals[0]);
    	for(int i=1;i<intervals.length;i++) {
    		int[] lastMerged=mergedList.get(mergedList.size()-1);
    		int[] toMerge=intervals[i];
    		if(lastMerged[1]<toMerge[0]) {
    			mergedList.add(toMerge);
    		}else {
    			mergedList.remove(mergedList.size()-1);
    			mergedList.add(new int[] {lastMerged[0],
    					Math.max(lastMerged[1], toMerge[1])});
    		}
    	}
    	
    	return mergedList.toArray(new int[0][]);
    }
}

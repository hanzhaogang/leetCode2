package leetCode;
/*
 * Given a collection of intervals, 
 * find the minimum number of intervals you need to remove 
 * to make the rest of the intervals non-overlapping.

 

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

 

Note:

    You may assume the interval's end point is always bigger than its start point.
    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
import java.util.Arrays;

public class _435_non_overlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
    	if(intervals.length==0)
    		return 0;
    	Arrays.sort(intervals,(i1,i2)->{
    		return Integer.compare(i1[0], i2[0]);
    	});
    	
    	int non_verlap_count=1;
    	
    	int[] preInterval=intervals[0];
    	for(int i=1;i<intervals.length;i++) {
    		int[] curInterval=intervals[i];
    		if(preInterval[1]<=curInterval[0]) {
    			preInterval=curInterval;
    			non_verlap_count++;
    		}else {
    			if(curInterval[1]<preInterval[1]) {
    				preInterval=curInterval;
    			}
    		}
    	}
    	return intervals.length-non_verlap_count;
    }
}

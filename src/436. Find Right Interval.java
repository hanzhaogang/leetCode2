public class 436. Find Right Interval {
	
}
/* You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.

Return an array of right interval indices for each interval i. 
If no right interval exists for interval i, then put -1 at index i.

 

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 

Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start point of each interval is unique.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-right-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 

思路： 根据数据规模，以及题意中的有序、无序、interval等特征，可以判断出本题的时间复杂度是O(nlgn)，方法可以是排序。
具体来说，首先根据start对interval排序（start是unique的），然后针对每一个interval，使用二分查找找到第一个比该interval的end point大的interval。

corner case需要注意equal的情况，如果start end==ending point，也是right interval.

需要注意的是，排序后会破坏原来的index，所以可以给原来的array增加一个维度。*/

class Solution {//[[3,4],[2,3],[1,2]]
    public int[] findRightInterval(int[][] intervals) {
	int[][] newIntervals=new int[intervals.length][3];
	for(int i=0;i<intervals.length;i++){
		newIntervals[i][0]=intervals[i][0];
		newIntervals[i][1]=intervals[i][1];
		newIntervals[i][2]=i;
	}
	Arrays.sort(newIntervals,(i1,i2)->{
		return Integer.compare(i1[0],i2[0]);
	});

	int[] res=new int[intervals.length];
	for(int i=0;i<res.length;i++){
		res[0]=-1;
	}

	for(int i=0;i<intervals.length;i++){
		int endP=intervals[i][1];
		int lo=i+1;
		int hi=intervals.length-1;
		while(lo<=hi){
			if(lo==hi){
				if(endP<=newIntervals[lo][0]){
					res[i]=newIntervals[lo][2];
					
				}else{
					res[i]=-1;	
				}
				break;
			}
			int mid=lo+(hi-lo)/2;
			if(endP<=newIntervals[mid][0]){
				hi=mid;
			}else{
				lo=mid+1;
			}
		}
	}	
	return res;
    }
}


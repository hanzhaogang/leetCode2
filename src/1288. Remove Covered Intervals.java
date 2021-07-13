public class 1288. Remove Covered Intervals {
	
}
/* Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
Example 3:

Input: intervals = [[0,10],[5,12]]
Output: 2
Example 4:

Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2
Example 5:

Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-covered-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
interval的问题，需要格外注意两个interval关系的corner case：
i1， i2可能有三种关系：
i1 cover i2；
i2 cover i1；
i1 i2 谁也不cover谁。

*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
	Arrays.sort(intervals,(i1,i2)->{
		return i1[0]-i2[0];
	});

	Deque<int[]> s=new ArrayDeque<>();
	for(int[] interval:intervals){
		if(s.isEmpty()){
			s.push(interval);
		}else{
			int[] peek=s.peek();
			if(interval[1]<=peek[1]){
				continue;
			}else{
				if(interval[0]==peek[0]){
					s.pop();
					s.push(interval);
				}else{
					s.push(interval);
				}
			}
		}
	}

	return s.size();
    }
}

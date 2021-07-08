public class 1094. Car Pooling {
	
}
/* You are driving a vehicle that has capacity empty seats initially available for passengers.  
The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, 
trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: 
the number of passengers that must be picked up, and the locations to pick them up and drop them off.  
The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/car-pooling
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
类似meeting room。
用扫描线方法。
每个trip有起点和终点，起点用[trip[1],+trip[0]]表示，终点用[trip[2],-trip[0]]表示。
然后对每个位置进行排序，排序后用扫描线遍历每个位置。(相等是排序中最常见的corner case)
扫描到起点把cur_cap + trip[0], 扫描到终点把cur_cap - trip[0].在这个过程中记录max_cap。
最后根据max_cap返回res。

corner case: 多个trip在同一个点开始和结束？
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
	
	int[][] points=new int[trips.length*2][2];//0?1?
	for(int i=0;i<trips.length;i++){
		int[] trip=trips[i];
		points[2*i]=new int[]{trip[1],trip[0]};
		points[2*i+1]=new int[]{trip[2],0-trip[0]};
	}
	Arrays.sort(points,(p1,p2)->{
		if(p1[0]!=p2[0]){
			return Integer.compare(p1[0],p2[0]);
		}else{
			return Integer.compare(p1[1],p2[1]);
		}
	});
	int max_cap=0;
	int cur_cap=0;
	for(int[] point:points){
		cur_cap+=point[1];
		if(max_cap<cur_cap){
			max_cap=cur_cap;
		}
	}

	return capacity<max_cap?false:true;
    }
}
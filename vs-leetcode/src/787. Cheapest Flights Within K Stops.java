public class 787. Cheapest Flights Within K Stops {
	
}
/* There are n cities connected by some number of flights. 
You are given an array flights where flights[i] = [fromi, toi, pricei] 
indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, 
return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

 

Example 1:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, 
as marked red in the picture.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, 
as marked blue in the picture.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 


思路：
加权图中，特定起点到特定终点的最短路径问题。
最短路径问题有不同解法，最基础的有BFS或者DFS（回溯）。
如果使用BFS，无权图可以直接使用Queue，加权图需要使用preorityQueue。
不同的是，stop数不能超过K。

使用pq的bfs跟使用queue的bfs模板应该有不同。

(同时要准备一个visited标记，比如把每个访问过的元素放入visited set中)
首先把pair(src,dist)放入pq。(dist表示到src的距离，初始状态下为0)
stops=0
while pq不为空
    取出pq当前peak元素
    stops++    
    if k<stops
      return -1  
    if cur element == dst
      return cur dist
    for each neib of current element
      push pair into pq

*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    }
}
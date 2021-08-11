public class 743. Network Delay Time {
	
}
/* You are given a network of n nodes, labeled from 1 to n. 
You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, 
and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. 
Return the time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100（节点数）
1 <= times.length <= 6000（边数）
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
----排除了一个重要的corner case。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/network-delay-time
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

hint
We visit each node at some time, 
and if that time is better than the fastest time we've reached this node, 
we travel along outgoing edges in sorted order. 

Alternatively, we could use Dijkstra's algorithm.

同时要准备一个visited标记，比如把每个访问过的元素放入visited set中

*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
	// 建图 - 邻接表
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        for (int[] edg : times) {
            if (!mp.containsKey(edg[0]))
                mp.put(edg[0], new HashMap<>());
            mp.get(edg[0]).put(edg[1], edg[2]);
        }

    }
}
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 847. Shortest Path Visiting All Nodes {
	
}
class Solution {
    public int shortestPathLength(int[][] graph) {
	Queue<Integer> q=new LinkedList<>();
	int n=graph.length;
	for(int i=0;i<n;i++){
		q.offer(i);
	}

	int len=0;
	Set<Integer> visited=new HashSet<>();
	while(!q.isEmpty()){
		int size=q.size();
		for(int i=0;i<size;i++){
			int curNode=q.poll();//遍历顶点i
			visited.add(curNode);
			int[] nb=graph[curNode];
			for(int j=0;j<graph[curNode].length;j++){

			}
		}
		

		
	}
    }
}

/* You have an undirected, connected graph of n nodes labeled from 0 to n - 1. 
You are given an array graph where 
graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. 
You may start and stop at any node, 
you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:


Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:


Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Constraints:

n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


思路：
搜索的不是简单的图，而是要考虑图的状态。

用DFS不行的原因在于，如果成环，那么就会死循环。（剪枝可以解决状态爆炸，不能解决死循环）
BFS恰恰可以解决这个问题。
*/

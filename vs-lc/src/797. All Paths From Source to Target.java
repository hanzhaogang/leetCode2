import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 797. All Paths From Source to Target {
	
}
/* 797. All Paths From Source to Target
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: 
graph[i] is a list of all nodes you can visit from node i 
(i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.

思路：
起点到终点的所有路径。
感觉BFS或者DFS可以解决。
因为是要找到所有路径，所以在遍历的时候，需要记录当前路径。

因为是无权图，所以不用map，用二维数据就可以表示graph。（java中二维数据的每一列的列宽是可变的）

终点不一定没有到任意节点的边，但是一旦到达终点就不用再继续，因为不可能再次回到终点，因为是无环图。
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	List<List<Integer>> ans=new ArrayList<>();
	List<Integer> path=new ArrayList<Integer>();
	helper(ans,path,graph,0,graph.length-1);
	return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> path,int[][] graph,int curNode,int endNode){
	path.add(curNode);
	if(curNode==endNode){
		ans.add(new ArrayList<Integer>(path));
		path.remove(path.size()-1);
		return;
	}
	for(int nb:graph[curNode]){
		helper(ans,path,graph,nb,endNode);
	}
	path.remove(path.size()-1);
    }
}
